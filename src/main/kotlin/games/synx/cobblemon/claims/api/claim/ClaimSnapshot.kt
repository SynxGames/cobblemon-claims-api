package games.synx.cobblemon.claims.api.claim

import games.synx.cobblemon.claims.api.setting.Setting
import net.minecraft.server.level.ServerPlayer
import org.bson.types.ObjectId
import java.util.*

interface ClaimSnapshot {

    /**
     * Get the Claim ID as stored in the database
     *
     * @return [ObjectId]
     */
    fun getClaimId(): ObjectId

    /**
     * Get the UUID of the player who owns the claim
     *
     * @return [UUID]
     */
    fun getOwnerUUID(): UUID

    /**
     * Get the name of the player who owns the claim
     *
     * @return [String]
     */
    fun getOwnerName(): String

    /**
     * Get the name of the claim
     *
     * @return [String]
     */
    fun getName(): String

    /**
     * Get the time the claim was created as a UNIX Timestamp
     *
     * @return [Long]
     */
    fun getCreatedOn(): Long

    /**
     * Get the setting for a specific user in the claim.
     * For example, if they can break Blocks
     *
     * @param player [ServerPlayer]
     * @param setting [Setting]
     *
     * @return [Boolean] for if the setting will be allowed
     */
    fun setting(player: ServerPlayer, setting: Setting): Boolean

}