package eu.builderscoffee.betterbrushes;

import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.math.Vector3;
import com.sk89q.worldedit.world.block.BlockState;
import com.thevoxelbox.voxelsniper.brush.property.BrushProperties;
import com.thevoxelbox.voxelsniper.brush.type.AbstractBrush;
import com.thevoxelbox.voxelsniper.sniper.snipe.Snipe;
import com.thevoxelbox.voxelsniper.sniper.snipe.message.SnipeMessageSender;
import org.bukkit.ChatColor;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import java.util.List;

public class WallSiderBrush /*extends AbstractBrush*/
{
    /*private static String[] orientationsNames;
    private static BlockFace[] orientations;
    private short orientationNum = 4;
    private short depth = 1;
    private double trueCircle = 0.0;
    private boolean replacingSelected;
    private boolean airIncluded;
    private boolean h;
    
    static {
        orientationsNames = new String[] { "north", "east", "south", "west", "relative to player" };
        orientations = new BlockFace[]{BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST};
    }
    
    private void a(final Snipe snipe, final boolean b) {
        final double n = (snipe.getToolkitProperties().getBrushSize() + this.trueCircle) * (snipe.getToolkitProperties().getBrushSize() + this.trueCircle);
        final BlockVector3 vector = getTargetBlock();
        final BlockVector3 clone = getTargetBlock();
        int c;
        if (this.orientationNum == 4) {
            double n2;
            if ((n2 = (snipe.getSniper().getPlayer().getLocation().getYaw() - 90.0f) % 360.0f) < 0.0) {
                n2 += 360.0;
            }
            c = ((0.0 >= n2 && n2 < 45.0) ? 2 : ((45.0 >= n2 && n2 < 135.0) ? 3 : ((135.0 >= n2 && n2 < 225.0) ? 0 : ((225.0 >= n2 && n2 < 315.0) ? 1 : ((315.0 >= n2 && n2 < 360.0) ? 2 : -1)))));
        }
        else {
            c = this.orientationNum;
        }
        int n3 = c;
        if (b) {
            n3 = (short)((n3 + 2) % 4);
        }
        int n4 = 98;
        if (n3 == 0 || n3 == 2) {
            n4 = 97;
        }
        for (int i = -snipe.getToolkitProperties().getBrushSize(); i <= snipe.getToolkitProperties().getBrushSize(); ++i) {
            if (n4 == 97) {
                clone.withX(vector.getX() + i);
            }
            else {
                clone.withZ(vector.getZ() + i);
            }
            for (int j = -snipe.getToolkitProperties().getBrushSize(); j <= snipe.getToolkitProperties().getBrushSize(); ++j) {
                clone.withY(vector.getY() + j);
                if (vector.distanceSq(clone) <= n) {
                    for (short n5 = 0; n5 < this.depth; ++n5) {
                        if (n4 == 97) {
                            clone.withZ(vector.getZ() + ((n3 == 2) ? n5 : (-n5)));
                        }
                        else {
                            clone.withX(vector.getX() + ((n3 == 1) ? n5 : (-n5)));
                        }
                        final BlockState block2 = getEditSession().getBlock(clone);
                        if()
                        if ((this.replacingSelected && block2.getTypeId() == snipe.getReplaceId()) || (!this.replacingSelected && (block2.getTypeId() != 0 || this.airIncluded))) {
                            getEditSession().getBlock()
                            block2.setTypeId(snipe.getVoxelId());
                        }
                    }
                    if (n4 == 97) {
                        clone.setZ(vector.getZ());
                    }
                    else {
                        clone.setX(vector.getX());
                    }
                }
            }
        }
    }
    
    private static short orientation(final Player player) {
        double n;
        if ((n = (player.getLocation().getYaw() - 90.0f) % 360.0f) < 0.0) {
            n += 360.0;
        }
        if (0.0 >= n && n < 45.0) {
            return 2;
        }
        if (45.0 >= n && n < 135.0) {
            return 3;
        }
        if (135.0 >= n && n < 225.0) {
            return 0;
        }
        if (225.0 >= n && n < 315.0) {
            return 1;
        }
        if (315.0 >= n && n < 360.0) {
            return 2;
        }
        return -1;
    }

    @Override
    public void handleCommand(String[] parameters, Snipe snipe) {
        final SnipeMessageSender sender = snipe.createMessageSender();
        for (int i = 1; i < parameters.length; ++i) {
            final String lowerCase;
            if ((lowerCase = parameters[i].toLowerCase()).startsWith("d")) {
                this.depth = (short)Integer.parseInt(lowerCase.replace("d", ""));
                sender.message(ChatColor.AQUA + "Depth set to " + this.depth + " blocks");
            }
            else if (lowerCase.startsWith("s")) {
                this.orientationNum = (short)Integer.parseInt(lowerCase.replace("s", ""));
                if (this.orientationNum > 4 || this.orientationNum < 0) {
                    this.orientationNum = 4;
                }
                sender.message(ChatColor.AQUA + "Orientation set to " + orientationsNames[this.orientationNum]);
            }
            else if (lowerCase.startsWith("true")) {
                this.trueCircle = 0.5;
                sender.message(ChatColor.AQUA + "True circle mode ON.");
            }
            else if (lowerCase.startsWith("false")) {
                this.trueCircle = 0.0;
                sender.message(ChatColor.AQUA + "True circle mode OFF.");
            }
            else if (lowerCase.startsWith("air")) {
                this.airIncluded = true;
                sender.message(ChatColor.AQUA + "Including air.");
            }
            else if (lowerCase.startsWith("mm")) {
                this.replacingSelected = true;
                sender.message(ChatColor.AQUA + "Replacing selected block.");
            }
        }
        sender.send();
    }

    @Override
    public List<String> handleCompletions(String[] parameters, Snipe snipe) {
        return super.handleCompletions(parameters, snipe);
    }

    public static BrushProperties properties(){
        return BrushProperties.builder()
                .name("WallSlider")
                .permission("voxelsniper.brush.*")
                .alias("sider")
                .creator(ErodeBlendBallBrush::new)
                .build();
    }

    @Override
    public void handleArrowAction(Snipe snipe) {

        this.a(snipe, false);
    }

    @Override
    public void handleGunpowderAction(Snipe snipe) {

        this.a(snipe, true);
    }

    @Override
    public void sendInfo(Snipe snipe) {
        final SnipeMessageSender sender = snipe.createMessageSender();
        sender.brushNameMessage();
        sender.brushSizeMessage();
        sender.blockTypeMessage();
        sender.message(ChatColor.BLUE + "Depth: " + this.depth);
        sender.message(ChatColor.BLUE + "Orientation: " + orientationsNames[this.orientationNum]);
        sender.message(ChatColor.BLUE + "True Circle: " + ((this.trueCircle == 0.0) ? "false" : "true"));
        sender.message(ChatColor.BLUE + "Air: " + (this.airIncluded ? "include" : "exclude"));
        sender.message(ChatColor.BLUE + "Replacing: " + (this.replacingSelected ? "selected" : "all"));
        sender.send();
    }*/
}
