package games.synx.cobblemon.claims.api.event

import games.synx.cobblemon.claims.api.claim.ClaimSnapshot
import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory
import net.minecraft.server.level.ServerPlayer

fun interface ClaimLeaveEvent {

    companion object {
        val EVENT: Event<ClaimLeaveEvent> = EventFactory.createArrayBacked(ClaimLeaveEvent::class.java) { listeners ->
            ClaimLeaveEvent { player, claim ->
                for (listener in listeners) {
                    listener.onEvent(player, claim)
                }
            }
        }
    }

    fun onEvent(player: ServerPlayer, claim: ClaimSnapshot)

}