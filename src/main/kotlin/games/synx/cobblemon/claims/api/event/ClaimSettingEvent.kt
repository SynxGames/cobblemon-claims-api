package games.synx.cobblemon.claims.api.event

import games.synx.cobblemon.claims.api.claim.ClaimSnapshot
import games.synx.cobblemon.claims.api.setting.Setting
import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory
import net.minecraft.server.level.ServerPlayer

/**
 * Allows for code modification of a claim setting being activated.
 * For example, if custom logic is needed for the [Settings.ENTER] setting, this event can be used.
 * Note: This event is called for all settings, not just the [Settings.ENTER] setting.
 * Note: This event does not override bypass permissions or the claim owner's permissions.
 */
fun interface ClaimSettingEvent {

    companion object {
        val EVENT: Event<ClaimSettingEvent> = EventFactory.createArrayBacked(ClaimSettingEvent::class.java) { listeners ->
            ClaimSettingEvent { player, claim, setting ->
                for (listener in listeners) {
                    if(!listener.onEvent(player, claim, setting)) {
                        return@ClaimSettingEvent false
                    }
                }
                return@ClaimSettingEvent true
            }
        }
    }

    fun onEvent(player: ServerPlayer, claim: ClaimSnapshot, setting: Setting): Boolean

}