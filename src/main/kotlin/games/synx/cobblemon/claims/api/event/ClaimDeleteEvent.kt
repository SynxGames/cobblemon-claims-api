package games.synx.cobblemon.claims.api.event

import games.synx.cobblemon.claims.api.claim.ClaimChunkSnapshot
import games.synx.cobblemon.claims.api.claim.ClaimSnapshot
import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory
import net.minecraft.server.level.ServerPlayer

fun interface ClaimDeleteEvent {

    companion object {
        val EVENT: Event<ClaimDeleteEvent> = EventFactory.createArrayBacked(ClaimDeleteEvent::class.java) { listeners ->
            ClaimDeleteEvent { player, claim ->
                for (listener in listeners) {
                    listener.onEvent(player, claim)
                }
            }
        }
    }

    fun onEvent(player: ServerPlayer, claim: ClaimSnapshot)

}