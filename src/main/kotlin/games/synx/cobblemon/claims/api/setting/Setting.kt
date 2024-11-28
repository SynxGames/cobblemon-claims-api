package games.synx.cobblemon.claims.api.setting

import net.kyori.adventure.key.Key
import net.minecraft.world.item.Item

interface Setting {

    /**
     * Get the ID of the Setting
     * This is used for storing the setting in the Database, so changing this at a later date will result in data loss.
     *
     * @return [net.kyori.adventure.key.Key]
     */
    fun id(): Key

    /**
     * Get the ID of the Setting as a String
     *
     * @return [String]
     */
    fun stringId(): String {
        return id().asString()
    }

    /**
     * Get the display name of the Setting
     * This is displayed in UIs to the player
     *
     * @return [String]
     */
    fun displayName(): String

    /**
     * Get the icon of the Setting
     * This is displayed in UIs to the player
     *
     * @return [net.minecraft.world.item.Item]
     */
    fun icon(): Item

    /**
     * Get the default setting for the Setting
     * This is used when a player first creates a claim
     *
     * @return [Boolean]
     */
    fun defaultSetting(): Boolean

    companion object {

        fun setting(id: Key, displayName: String, icon: Item, defaultSetting: Boolean): Setting {
            return SettingImpl(id, displayName, icon, defaultSetting)
        }

    }

}