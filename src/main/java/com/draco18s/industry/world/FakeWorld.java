package com.draco18s.industry.world;

import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;

public class FakeWorld extends World {
	//private ChunkProviderClient clientChunkProvider;

	public FakeWorld(WorldInfo info, Profiler profilerIn) {
		super(null, info, new WorldProviderVoid(), profilerIn, true);
		this.chunkProvider = this.createChunkProvider();
	}

	@Override
	protected IChunkProvider createChunkProvider() {
		return new VolatileChunkProvider(this);
		//clientChunkProvider = new ChunkProviderClient(this);
		//return clientChunkProvider;
	}

	@Override
	protected boolean isChunkLoaded(int x, int z, boolean allowEmpty) {
		return allowEmpty || !getChunkProvider().provideChunk(x, z).isEmpty();
	}
	
	/*public Chunk getChunkFromChunkCoords(int chunkX, int chunkZ)
    {
        return this.chunkProvider.provideChunk(chunkX, chunkZ);
    }*/
}
