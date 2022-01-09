package eu.builderscoffee.betterbrushes;

public class b
{
    /*
    private int a;
    
    public b() {
        this.a = 1;
        this.setName("Repopulate Chunks Brush");
    }
    
    public final void arrow(final SnipeData snipeData) {
        this.a();
    }
    
    public final void powder(final SnipeData snipeData) {
        this.a();
    }
    
    private void a() {
        final double n = (this.a + 0.5) * (this.a + 0.5);
        final World world = this.getWorld();
        new Random().setSeed(world.getSeed());
        final Chunk chunk;
        final int z = (chunk = this.getTargetBlock().getChunk()).getZ();
        final int x = chunk.getX();
        for (int i = this.a; i >= -this.a; --i) {
            for (int j = this.a; j >= -this.a; --j) {
                final int n2 = z - i;
                final int n3 = x - j;
                if ((n2 - z) * (n2 - z) + (n3 - x) * (n3 - x) <= n) {
                    a(((CraftChunk)world.getChunkAt(x - j, z - i)).getHandle());
                }
            }
        }
    }
    
    private static void a(final net.minecraft.server.v1_7_R2.Chunk chunk) {
        final ChunkProviderServer chunkProviderServer = (ChunkProviderServer)chunk.world.chunkProvider;
        chunkProviderServer.chunkProvider.getChunkAt((IChunkProvider)chunkProviderServer, chunk.locX, chunk.locZ);
        final net.minecraft.server.v1_7_R2.World world = chunk.world;
        final int locX = chunk.locX;
        final int locZ = chunk.locZ;
        BlockSand.instaFall = true;
        final Random random;
        (random = new Random()).setSeed(world.getSeed());
        random.setSeed(locX * ((random.nextLong() / 2L << 1) + 1L) + locZ * ((random.nextLong() / 2L << 1) + 1L) ^ world.getSeed());
        final CraftWorld world2;
        if ((world2 = world.getWorld()) != null) {
            world.populating = true;
            try {
                final Iterator iterator = ((World)world2).getPopulators().iterator();
                while (iterator.hasNext()) {
                    iterator.next().populate((World)world2, random, ((World)world2).getChunkAt(chunk.locX, chunk.locZ));
                }
            }
            finally {
                world.populating = false;
            }
            world.populating = false;
        }
        BlockSand.instaFall = false;
        world.getServer().getPluginManager().callEvent((Event)new ChunkPopulateEvent(chunk.bukkitChunk));
        chunk.e();
    }
    
    public final void parameters(final String[] array, final SnipeData snipeData) {
        for (int i = 1; i < array.length; ++i) {
            final String lowerCase;
            if ((lowerCase = array[i].toLowerCase()).startsWith("r")) {
                this.a = Integer.parseInt(lowerCase.replace("r", ""));
                if (this.a <= 0) {
                    this.a = 0;
                }
                snipeData.sendMessage(ChatColor.AQUA + "Radius set to " + this.a + " chunks");
            }
        }
    }
    
    public String getPermissionNode() {
        return "voxelsniper.brush.*";
    }
    
    public void info(final Message message) {
        message.brushName(this.getName());
        message.custom(ChatColor.GREEN + "Brush Size: " + ChatColor.DARK_RED + this.a);
        if (this.a < 4) {
            return;
        }
        message.custom(ChatColor.RED + "WARNING: Large brush size selected!");
    }
     */
}
