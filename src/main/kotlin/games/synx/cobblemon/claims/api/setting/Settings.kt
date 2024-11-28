package games.synx.cobblemon.claims.api.setting

import com.cobblemon.mod.common.CobblemonItems
import net.kyori.adventure.key.Key
import net.minecraft.world.item.Items
import net.kyori.adventure.key.Key.key

object Settings {

    val settings = mutableMapOf<Key, Setting>()

    val ENTER = register(key("necluda:enter"), "Enter claim", Items.BARRIER, true)
    val BREAK_BLOCKS = register(key("necluda:break_blocks"), "Break blocks", Items.COBBLESTONE, false)
    val PLACE_BLOCKS = register(key("necluda:place_blocks"), "Place blocks", Items.OAK_PLANKS, false)
    val ENDERPEARL = register(key("necluda:enderpearl"), "Enderpearl", Items.ENDER_PEARL, false)
    val HOSTILE_DAMAGE = register(key("necluda:hostile_damage"), "Damage hostile mobs", Items.ZOMBIE_HEAD, false)
    val FRIENDLY_DAMAGE = register(key("necluda:friendly_damage"), "Damage friendly mobs", Items.COW_SPAWN_EGG, false)
    val ARMOR_STAND_DAMAGE = register(key("necluda:armor_stand_damage"), "Damage armor stands", Items.ARMOR_STAND, false)
    val CRAFTING_TABLES = register(key("necluda:crafting_tables"), "Use crafting tables", Items.CRAFTING_TABLE, false)
    val DOORS = register(key("necluda:doors"), "Use doors", Items.OAK_DOOR, false)
    val GATES = register(key("necluda:gates"), "Use fence gates", Items.OAK_FENCE_GATE, false)
    val CHESTS = register(key("necluda:chests"), "Use chests", Items.CHEST, false)
    val ENCHANT_TABLE = register(key("necluda:enchant_table"), "Use enchantment tables", Items.ENCHANTING_TABLE, false)
    val REDSTONE = register(key("necluda:redstone"), "Use redstone", Items.REDSTONE, false)
    val SHEAR_SHEEP = register(key("necluda:shear_sheep"), "Shear sheep", Items.SHEARS, false)
    val DROP_ITEM = register(key("necluda:drop_item"), "Drop items", Items.DROPPER, false)
    val PICK_UP_ITEM = register(key("necluda:pick_up_item"), "Pick up items", Items.HOPPER, false)
    val PORTAL = register(key("necluda:portal"), "Use portals", Items.END_PORTAL_FRAME, false)
    val THROW_POKEBALL = register(key("necluda:throw_pokeball"), "Throw Pokeball", CobblemonItems.POKE_BALL, false)
    val SEND_POKEMON_OUT = register(key("necluda:send_pokemon_out"), "Send Out Pokemon", CobblemonItems.GENTLE_MINT, false)

    private fun register(key: Key, name: String, icon: net.minecraft.world.item.Item, defaultValue: Boolean): Setting {
        return register(Setting.setting(key, name, icon, defaultValue))
    }

    /**
     * Register a new Setting with the Plugin
     * This will be used to store the setting in the Database
     *
     * @param setting [Setting]
     * @return [Setting]
     */
    fun register(setting: Setting): Setting {
        settings[setting.id()] = setting
        return setting
    }

    /**
     * Fetch a Setting by its Key
     *
     * @param key [Key]
     * @return [Setting] or null if not found
     */
    fun setting(key: Key): Setting? {
        return settings[key]
    }

/**
     * Fetch all registered Settings
     *
     * @return [Map]<[Key], [Setting]>
     */
    fun values(): Map<Key, Setting> {
        return settings
    }
}