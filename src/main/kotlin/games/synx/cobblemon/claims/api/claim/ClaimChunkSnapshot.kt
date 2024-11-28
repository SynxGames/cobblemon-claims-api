package games.synx.cobblemon.claims.api.claim

import java.util.Optional
import java.util.concurrent.CompletableFuture

interface ClaimChunkSnapshot {

    /**
     * Gets the claim at this claim chunk
     *
     * @return [CompletableFuture] containing the [Optional] [ClaimSnapshot]
     */
    fun getClaim(): CompletableFuture<Optional<ClaimSnapshot>>

}