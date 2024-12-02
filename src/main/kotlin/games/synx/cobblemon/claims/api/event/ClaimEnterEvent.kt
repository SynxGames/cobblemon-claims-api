package games.synx.cobblemon.claims.api.event

import games.synx.cobblemon.claims.api.claim.ClaimSnapshot
import net.fabricmc.fabric.api.event.Event
import net.fabricmc.fabric.api.event.EventFactory
import net.minecraft.server.level.ServerPlayer

interface ClaimEnterEvent {

    fun interface Pre {

        companion object {
            val EVENT: Event<Pre> = EventFactory.createArrayBacked(Pre::class.java) { listeners ->
                Pre { player, claim ->
                    for (listener in listeners) {
                        if(!listener.onEvent(player, claim)) {
                            return@Pre false
                        }
                    }
                    return@Pre true
                }
            }
        }

        fun onEvent(player: ServerPlayer, claim: ClaimSnapshot): Boolean

    }

    fun interface Post {

        companion object {
            val EVENT: Event<Post> = EventFactory.createArrayBacked(Post::class.java) { listeners ->
                Post { player, claim, allowed ->
                    for (listener in listeners) {
                        listener.onEvent(player, claim, allowed)
                    }
                }
            }
        }

        fun onEvent(player: ServerPlayer, claim: ClaimSnapshot, allowed: Boolean)

    }



}