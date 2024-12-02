package games.synx.cobblemon.claims.api.claim

import net.minecraft.world.level.ChunkPos
import java.util.Optional
import java.util.concurrent.CompletableFuture

interface ClaimChunkSnapshot {

    /**
     * Gets the claim at this claim chunk
     *
     * @return [CompletableFuture] containing the [Optional] [ClaimSnapshot]
     */
    fun getClaim(): CompletableFuture<Optional<ClaimSnapshot>>

    fun getChunkPosition(): ChunkPos

}