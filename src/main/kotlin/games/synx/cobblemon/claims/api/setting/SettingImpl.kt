package games.synx.cobblemon.claims.api.setting

import net.kyori.adventure.key.Key
import net.minecraft.world.item.Item
import org.jetbrains.annotations.ApiStatus.Internal

@Internal
open class SettingImpl internal constructor(
    private val id: Key,
    private val displayName: String,
    private val icon: Item,
    private val defaultSetting: Boolean
): Setting {

    override fun id(): Key {
        return this.id
    }

    override fun displayName(): String {
        return this.displayName
    }

    override fun icon(): Item {
        return this.icon
    }

    override fun defaultSetting(): Boolean {
        return this.defaultSetting
    }

}