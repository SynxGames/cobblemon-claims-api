package games.synx.cobblemon.claims.api

import games.synx.cobblemon.claims.api.claim.ClaimChunkSnapshot
import games.synx.cobblemon.claims.api.claim.ClaimSnapshot
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.level.ChunkPos
import java.util.Optional
import java.util.concurrent.CompletableFuture

interface ClaimsApi {

    /**
     * Get the ClaimChunkSnapshot at a specific BlockPosition in the world
     *
     * @param level [ServerLevel]
     * @param blockPos [BlockPos]
     *
     * @return [CompletableFuture] containing an Optional with a [ClaimChunkSnapshot], if found
     */
    fun getClaimChunkSnapshot(level: ServerLevel, blockPos: BlockPos): CompletableFuture<Optional<ClaimChunkSnapshot>> {
        return getClaimChunkSnapshot(level, blockPos.x shr 4, blockPos.z shr 4)
    }

    /**
     * Get the ClaimChunkSnapshot at a specific BlockPosition in the world
     *
     * @param level [ServerLevel]
     * @param chunkPos [ChunkPos]
     *
     * @return [CompletableFuture] containing an Optional with a [ClaimChunkSnapshot], if found
     */
    fun getClaimChunkSnapshot(level: ServerLevel, chunkPos: ChunkPos): CompletableFuture<Optional<ClaimChunkSnapshot>> {
        return getClaimChunkSnapshot(level, chunkPos.x, chunkPos.z)
    }

    /**
     * Get the ClaimChunkSnapshot at a specific BlockPosition in the world
     *
     * @param level [ServerLevel]
     * @param x [Int]
     * @param z [Int]
     *
     * @return [CompletableFuture] containing an Optional with a [ClaimChunkSnapshot], if found
     */
    fun getClaimChunkSnapshot(level: ServerLevel, x: Int, z: Int): CompletableFuture<Optional<ClaimChunkSnapshot>>

    /**
     * Get the ClaimSnapshot for a specific ClaimChunkSnapshot
     *
     * @param chunkSnapshot [ClaimChunkSnapshot]
     *
     * @return [CompletableFuture] containing an Optional with a [ClaimSnapshot], if found.
     */
    fun getClaim(chunkSnapshot: ClaimChunkSnapshot): CompletableFuture<Optional<ClaimSnapshot>>

}