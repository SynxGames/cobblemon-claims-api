package games.synx.cobblemon.claims.api.event

import games.synx.cobblemon.claims.api.claim.ClaimChunkSnapshot
import games.synx.cobblemon.claims.api.claim.ClaimSnapshot
import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory
import net.minecraft.server.level.ServerPlayer

fun interface ClaimChunkEvent {

    companion object {
        val EVENT: Event<ClaimChunkEvent> = EventFactory.createArrayBacked(ClaimChunkEvent::class.java) { listeners ->
            ClaimChunkEvent { player, claim, chunk ->
                for (listener in listeners) {
                    listener.onEvent(player, claim, chunk)
                }
            }
        }
    }

    fun onEvent(player: ServerPlayer, claim: ClaimSnapshot, chunkData: ClaimChunkSnapshot)

}