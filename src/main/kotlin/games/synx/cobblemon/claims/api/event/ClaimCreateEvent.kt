package games.synx.cobblemon.claims.api.event

import games.synx.cobblemon.claims.api.claim.ClaimSnapshot
import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory
import net.minecraft.server.level.ServerPlayer

fun interface ClaimCreateEvent {

    companion object {
        val EVENT: Event<ClaimCreateEvent> = EventFactory.createArrayBacked(ClaimCreateEvent::class.java) { listeners ->
            ClaimCreateEvent { player, claim ->
                for (listener in listeners) {
                    listener.onEvent(player, claim)
                }
            }
        }
    }

    fun onEvent(player: ServerPlayer, claim: ClaimSnapshot)

}