package eu.builderscoffee.betterbrushes;

import com.thevoxelbox.voxelsniper.brush.property.BrushProperties;
import com.thevoxelbox.voxelsniper.brush.type.AbstractBrush;
import com.thevoxelbox.voxelsniper.brush.type.ErodeBrush;
import com.thevoxelbox.voxelsniper.brush.type.blend.AbstractBlendBrush;
import com.thevoxelbox.voxelsniper.brush.type.blend.BlendBallBrush;
import com.thevoxelbox.voxelsniper.brush.type.performer.AbstractPerformerBrush;
import com.thevoxelbox.voxelsniper.sniper.snipe.Snipe;
import com.thevoxelbox.voxelsniper.sniper.toolkit.ToolAction;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ErodeBlendBallBrush extends AbstractBrush {
    private final ErodeBrush erodeBrush;
    private final BlendBallBrush blendBallBrush;
    private static Field editSessionField;

    static {
        try {
            editSessionField = AbstractBrush.class.getDeclaredField("editSession");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static BrushProperties properties(){
        return BrushProperties.builder()
                .name("Erode BlendBall")
                .permission("voxelsniper.brush.erode")
                .alias("eb")
                .alias("erodeblend")
                .creator(ErodeBlendBallBrush::new)
                .build();
    }

    public ErodeBlendBallBrush() {
        erodeBrush = new ErodeBrush();
        blendBallBrush = new BlendBallBrush();
    }

    @Override
    public void handleCommand(String[] parameters, Snipe snipe) {
        super.handleCommand(parameters, snipe);
    }

    @Override
    public List<String> handleCompletions(String[] parameters, Snipe snipe) {
        final List<String> completions = erodeBrush.handleCompletions(parameters, snipe);
        completions.addAll(blendBallBrush.handleCompletions(parameters, snipe));
        return completions;
    }

    @Override
    public void handleArrowAction(Snipe snipe) {
        //blendBallBrush.setTargetBlock(getTargetBlock());
        //blendBallBrush.blend(snipe);

        /*blendBallBrush.setAirExcluded(false);
        Reflections.setField(editSessionField, blendBallBrush, getEditSession());
        blendBallBrush.setTargetBlock(getTargetBlock());
        blendBallBrush.blend(snipe);*/


        erodeBrush.perform(snipe, ToolAction.ARROW, getEditSession(), getTargetBlock(), getLastBlock());
        blendBallBrush.perform(snipe, ToolAction.ARROW, getEditSession(), getTargetBlock(), getLastBlock());
    }

    @Override
    public void handleGunpowderAction(Snipe snipe) {
        erodeBrush.perform(snipe, ToolAction.GUNPOWDER, getEditSession(), getTargetBlock(), getLastBlock());
        blendBallBrush.perform(snipe, ToolAction.ARROW, getEditSession(), getTargetBlock(), getLastBlock());
    }

    @Override
    public void sendInfo(Snipe snipe) {
        erodeBrush.sendInfo(snipe);
        blendBallBrush.sendInfo(snipe);
    }
}
