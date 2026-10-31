package dev.cephelo.simplycataclysm.item;

import dev.cephelo.simplycataclysm.SimplyCataclysm;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sweenus.simplyswords.config.Config;

import java.util.List;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimplyCataclysm.MODID);
    protected static final ChatFormatting[] traitformat = new ChatFormatting[]{ChatFormatting.RESET, ChatFormatting.WHITE};
    protected static final ChatFormatting[] descformat = new ChatFormatting[]{ChatFormatting.ITALIC, ChatFormatting.GRAY};

    // Tiers
    public static final Tier IGNITIUM_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(5, -1, 9F, 7F, 20,
                    BlockTags.create(new ResourceLocation(SimplyCataclysm.MODID, "needs_ignitium_tool")), () -> Ingredient.of(com.github.L_Ender.cataclysm.init.ModItems.IGNITIUM_INGOT.get())),
            new ResourceLocation(SimplyCataclysm.MODID, "ignitium"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier CURSIUM_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(5, -1, 9F, 6F, 20,
                    BlockTags.create(new ResourceLocation(SimplyCataclysm.MODID, "needs_cursium_tool")), () -> Ingredient.of(com.github.L_Ender.cataclysm.init.ModItems.CURSIUM_INGOT.get())),
            new ResourceLocation(SimplyCataclysm.MODID, "cursium"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier WITHERITE_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(5, -1, 7F, 6F, 18,
                    BlockTags.create(new ResourceLocation(SimplyCataclysm.MODID, "needs_witherite_tool")), () -> Ingredient.of(com.github.L_Ender.cataclysm.init.ModItems.WITHERITE_INGOT.get())),
            new ResourceLocation(SimplyCataclysm.MODID, "witherite"), List.of(Tiers.NETHERITE), List.of());

        // SIMPLYSWORDS WEAPON TYPE CONFIG MODIFIER VALUES
    private static int damage(String type) {
        switch (type) {
            case "longsword": return (int) Config.weaponAttribute.typeDamageModifier.longsword_damageModifier;
            case "twinblade": return (int) Config.weaponAttribute.typeDamageModifier.twinblade_damageModifier;
            case "rapier": return (int) Config.weaponAttribute.typeDamageModifier.rapier_damageModifier;
            case "katana": return (int) Config.weaponAttribute.typeDamageModifier.katana_damageModifier;
            case "sai": return (int) Config.weaponAttribute.typeDamageModifier.sai_damageModifier;
            case "spear": return (int) Config.weaponAttribute.typeDamageModifier.spear_damageModifier;
            case "glaive": return (int) Config.weaponAttribute.typeDamageModifier.glaive_damageModifier;
            case "warglaive": return (int) Config.weaponAttribute.typeDamageModifier.warglaive_damageModifier;
            case "cutlass": return (int) Config.weaponAttribute.typeDamageModifier.cutlass_damageModifier;
            case "claymore": return (int) Config.weaponAttribute.typeDamageModifier.claymore_damageModifier;
            case "greataxe": return (int) Config.weaponAttribute.typeDamageModifier.greataxe_damageModifier;
            case "greathammer": return (int) Config.weaponAttribute.typeDamageModifier.greathammer_damageModifier;
            case "chakram": return (int) Config.weaponAttribute.typeDamageModifier.chakram_damageModifier;
            case "scythe": return (int) Config.weaponAttribute.typeDamageModifier.scythe_damageModifier;
            case "halberd": return (int) Config.weaponAttribute.typeDamageModifier.halberd_damageModifier;
            default: return 0;
        }
    }

    private static float attackSpeed(String type) {
        switch (type) {
            case "longsword": return Config.weaponAttribute.typeAttackSpeed.longsword_attackSpeed;
            case "twinblade": return Config.weaponAttribute.typeAttackSpeed.twinblade_attackSpeed;
            case "rapier": return Config.weaponAttribute.typeAttackSpeed.rapier_attackSpeed;
            case "katana": return Config.weaponAttribute.typeAttackSpeed.katana_attackSpeed;
            case "sai": return Config.weaponAttribute.typeAttackSpeed.sai_attackSpeed;
            case "spear": return Config.weaponAttribute.typeAttackSpeed.spear_attackSpeed;
            case "glaive": return Config.weaponAttribute.typeAttackSpeed.glaive_attackSpeed;
            case "warglaive": return Config.weaponAttribute.typeAttackSpeed.warglaive_attackSpeed;
            case "cutlass": return Config.weaponAttribute.typeAttackSpeed.cutlass_attackSpeed;
            case "claymore": return Config.weaponAttribute.typeAttackSpeed.claymore_attackSpeed;
            case "greataxe": return Config.weaponAttribute.typeAttackSpeed.greataxe_attackSpeed;
            case "greathammer": return Config.weaponAttribute.typeAttackSpeed.greathammer_attackSpeed;
            case "chakram": return Config.weaponAttribute.typeAttackSpeed.chakram_attackSpeed;
            case "scythe": return Config.weaponAttribute.typeAttackSpeed.scythe_attackSpeed;
            case "halberd": return Config.weaponAttribute.typeAttackSpeed.halberd_attackSpeed;
            default: return 0.0F;
        }
    }
// ANCIENT METAL WEAPONS
    public static final RegistryObject<Item> ANCIENT_METAL_LONGSWORD = ITEMS.register("ancient_metal_longsword", () ->
            new AncientMetalSwordItem(damage("longsword"), attackSpeed("longsword")));
    public static final RegistryObject<Item> ANCIENT_METAL_TWINBLADE = ITEMS.register("ancient_metal_twinblade", () ->
            new AncientMetalSwordItem(damage("twinblade"), attackSpeed("twinblade")));
    public static final RegistryObject<Item> ANCIENT_METAL_RAPIER = ITEMS.register("ancient_metal_rapier", () ->
            new AncientMetalSwordItem(damage("rapier"), attackSpeed("rapier")));
    public static final RegistryObject<Item> ANCIENT_METAL_KATANA = ITEMS.register("ancient_metal_katana", () ->
            new AncientMetalSwordItem(damage("katana"), attackSpeed("katana")));
    public static final RegistryObject<Item> ANCIENT_METAL_SAI = ITEMS.register("ancient_metal_sai", () ->
            new AncientMetalSwordItem(damage("sai"), attackSpeed("sai")));
    public static final RegistryObject<Item> ANCIENT_METAL_SPEAR = ITEMS.register("ancient_metal_spear", () ->
            new AncientMetalSwordItem(damage("spear"), attackSpeed("spear")));
    public static final RegistryObject<Item> ANCIENT_METAL_GLAIVE = ITEMS.register("ancient_metal_glaive", () ->
            new AncientMetalSwordItem(damage("glaive"), attackSpeed("glaive")));
    public static final RegistryObject<Item> ANCIENT_METAL_WARGLAIVE = ITEMS.register("ancient_metal_warglaive", () ->
            new AncientMetalSwordItem(damage("warglaive"), attackSpeed("warglaive")));
    public static final RegistryObject<Item> ANCIENT_METAL_CUTLASS = ITEMS.register("ancient_metal_cutlass", () ->
            new AncientMetalSwordItem(damage("cutlass"), attackSpeed("cutlass")));
    public static final RegistryObject<Item> ANCIENT_METAL_CLAYMORE = ITEMS.register("ancient_metal_claymore", () ->
            new AncientMetalSwordItem(damage("claymore"), attackSpeed("claymore")));
    public static final RegistryObject<Item> ANCIENT_METAL_GREATHAMMER = ITEMS.register("ancient_metal_greathammer", () ->
            new AncientMetalSwordItem(damage("greathammer"), attackSpeed("greathammer")));
    public static final RegistryObject<Item> ANCIENT_METAL_GREATAXE = ITEMS.register("ancient_metal_greataxe", () ->
            new AncientMetalSwordItem(damage("greataxe"), attackSpeed("greataxe")));
    public static final RegistryObject<Item> ANCIENT_METAL_CHAKRAM = ITEMS.register("ancient_metal_chakram", () ->
            new AncientMetalSwordItem(damage("chakram"), attackSpeed("chakram")));
    public static final RegistryObject<Item> ANCIENT_METAL_SCYTHE = ITEMS.register("ancient_metal_scythe", () ->
            new AncientMetalSwordItem(damage("scythe"), attackSpeed("scythe")));
    public static final RegistryObject<Item> ANCIENT_METAL_HALBERD = ITEMS.register("ancient_metal_halberd", () ->
            new AncientMetalSwordItem(damage("halberd"), attackSpeed("halberd")));

    // BLACK STEEL WEAPONS
    public static final RegistryObject<Item> BLACK_STEEL_LONGSWORD = ITEMS.register("black_steel_longsword", () ->
            new BlackSteelSwordItem(damage("longsword"), attackSpeed("longsword")));
    public static final RegistryObject<Item> BLACK_STEEL_TWINBLADE = ITEMS.register("black_steel_twinblade", () ->
            new BlackSteelSwordItem(damage("twinblade"), attackSpeed("twinblade")));
    public static final RegistryObject<Item> BLACK_STEEL_RAPIER = ITEMS.register("black_steel_rapier", () ->
            new BlackSteelSwordItem(damage("rapier"), attackSpeed("rapier")));
    public static final RegistryObject<Item> BLACK_STEEL_KATANA = ITEMS.register("black_steel_katana", () ->
            new BlackSteelSwordItem(damage("katana"), attackSpeed("katana")));
    public static final RegistryObject<Item> BLACK_STEEL_SAI = ITEMS.register("black_steel_sai", () ->
            new BlackSteelSwordItem(damage("sai"), attackSpeed("sai")));
    public static final RegistryObject<Item> BLACK_STEEL_SPEAR = ITEMS.register("black_steel_spear", () ->
            new BlackSteelSwordItem(damage("spear"), attackSpeed("spear")));
    public static final RegistryObject<Item> BLACK_STEEL_GLAIVE = ITEMS.register("black_steel_glaive", () ->
            new BlackSteelSwordItem(damage("glaive"), attackSpeed("glaive")));
    public static final RegistryObject<Item> BLACK_STEEL_WARGLAIVE = ITEMS.register("black_steel_warglaive", () ->
            new BlackSteelSwordItem(damage("warglaive"), attackSpeed("warglaive")));
    public static final RegistryObject<Item> BLACK_STEEL_CUTLASS = ITEMS.register("black_steel_cutlass", () ->
            new BlackSteelSwordItem(damage("cutlass"), attackSpeed("cutlass")));
    public static final RegistryObject<Item> BLACK_STEEL_CLAYMORE = ITEMS.register("black_steel_claymore", () ->
            new BlackSteelSwordItem(damage("claymore"), attackSpeed("claymore")));
    public static final RegistryObject<Item> BLACK_STEEL_GREATHAMMER = ITEMS.register("black_steel_greathammer", () ->
            new BlackSteelSwordItem(damage("greathammer"), attackSpeed("greathammer")));
    public static final RegistryObject<Item> BLACK_STEEL_GREATAXE = ITEMS.register("black_steel_greataxe", () ->
            new BlackSteelSwordItem(damage("greataxe"), attackSpeed("greataxe")));
    public static final RegistryObject<Item> BLACK_STEEL_CHAKRAM = ITEMS.register("black_steel_chakram", () ->
            new BlackSteelSwordItem(damage("chakram"), attackSpeed("chakram")));
    public static final RegistryObject<Item> BLACK_STEEL_SCYTHE = ITEMS.register("black_steel_scythe", () ->
            new BlackSteelSwordItem(damage("scythe"), attackSpeed("scythe")));
    public static final RegistryObject<Item> BLACK_STEEL_HALBERD = ITEMS.register("black_steel_halberd", () ->
            new BlackSteelSwordItem(damage("halberd"), attackSpeed("halberd")));

    // CURSIUM WEAPONS
    public static final RegistryObject<Item> CURSIUM_LONGSWORD = ITEMS.register("cursium_longsword", () ->
            new CursiumSwordItem(damage("longsword"), attackSpeed("longsword")));
    public static final RegistryObject<Item> CURSIUM_TWINBLADE = ITEMS.register("cursium_twinblade", () ->
            new CursiumSwordItem(damage("twinblade"), attackSpeed("twinblade")));
    public static final RegistryObject<Item> CURSIUM_RAPIER = ITEMS.register("cursium_rapier", () ->
            new CursiumSwordItem(damage("rapier"), attackSpeed("rapier")));
    public static final RegistryObject<Item> CURSIUM_KATANA = ITEMS.register("cursium_katana", () ->
            new CursiumSwordItem(damage("katana"), attackSpeed("katana")));
    public static final RegistryObject<Item> CURSIUM_SAI = ITEMS.register("cursium_sai", () ->
            new CursiumSwordItem(damage("sai"), attackSpeed("sai")));
    public static final RegistryObject<Item> CURSIUM_SPEAR = ITEMS.register("cursium_spear", () ->
            new CursiumSwordItem(damage("spear"), attackSpeed("spear")));
    public static final RegistryObject<Item> CURSIUM_GLAIVE = ITEMS.register("cursium_glaive", () ->
            new CursiumSwordItem(damage("glaive"), attackSpeed("glaive")));
    public static final RegistryObject<Item> CURSIUM_WARGLAIVE = ITEMS.register("cursium_warglaive", () ->
            new CursiumSwordItem(damage("warglaive"), attackSpeed("warglaive")));
    public static final RegistryObject<Item> CURSIUM_CUTLASS = ITEMS.register("cursium_cutlass", () ->
            new CursiumSwordItem(damage("cutlass"), attackSpeed("cutlass")));
    public static final RegistryObject<Item> CURSIUM_CLAYMORE = ITEMS.register("cursium_claymore", () ->
            new CursiumSwordItem(damage("claymore"), attackSpeed("claymore")));
    public static final RegistryObject<Item> CURSIUM_GREATHAMMER = ITEMS.register("cursium_greathammer", () ->
            new CursiumSwordItem(damage("greathammer"), attackSpeed("greathammer")));
    public static final RegistryObject<Item> CURSIUM_GREATAXE = ITEMS.register("cursium_greataxe", () ->
            new CursiumSwordItem(damage("greataxe"), attackSpeed("greataxe")));
    public static final RegistryObject<Item> CURSIUM_CHAKRAM = ITEMS.register("cursium_chakram", () ->
            new CursiumSwordItem(damage("chakram"), attackSpeed("chakram")));
    public static final RegistryObject<Item> CURSIUM_SCYTHE = ITEMS.register("cursium_scythe", () ->
            new CursiumSwordItem(damage("scythe"), attackSpeed("scythe")));
    public static final RegistryObject<Item> CURSIUM_HALBERD = ITEMS.register("cursium_halberd", () ->
            new CursiumSwordItem(damage("halberd"), attackSpeed("halberd")));

    // IGNITIUM WEAPONS
    public static final RegistryObject<Item> IGNITIUM_LONGSWORD = ITEMS.register("ignitium_longsword", () ->
            new IgnitiumSwordItem(damage("longsword"), attackSpeed("longsword")));
    public static final RegistryObject<Item> IGNITIUM_TWINBLADE = ITEMS.register("ignitium_twinblade", () ->
            new IgnitiumSwordItem(damage("twinblade"), attackSpeed("twinblade")));
    public static final RegistryObject<Item> IGNITIUM_RAPIER = ITEMS.register("ignitium_rapier", () ->
            new IgnitiumSwordItem(damage("rapier"), attackSpeed("rapier")));
    public static final RegistryObject<Item> IGNITIUM_KATANA = ITEMS.register("ignitium_katana", () ->
            new IgnitiumSwordItem(damage("katana"), attackSpeed("katana")));
    public static final RegistryObject<Item> IGNITIUM_SAI = ITEMS.register("ignitium_sai", () ->
            new IgnitiumSwordItem(damage("sai"), attackSpeed("sai")));
    public static final RegistryObject<Item> IGNITIUM_SPEAR = ITEMS.register("ignitium_spear", () ->
            new IgnitiumSwordItem(damage("spear"), attackSpeed("spear")));
    public static final RegistryObject<Item> IGNITIUM_GLAIVE = ITEMS.register("ignitium_glaive", () ->
            new IgnitiumSwordItem(damage("glaive"), attackSpeed("glaive")));
    public static final RegistryObject<Item> IGNITIUM_WARGLAIVE = ITEMS.register("ignitium_warglaive", () ->
            new IgnitiumSwordItem(damage("warglaive"), attackSpeed("warglaive")));
    public static final RegistryObject<Item> IGNITIUM_CUTLASS = ITEMS.register("ignitium_cutlass", () ->
            new IgnitiumSwordItem(damage("cutlass"), attackSpeed("cutlass")));
    public static final RegistryObject<Item> IGNITIUM_CLAYMORE = ITEMS.register("ignitium_claymore", () ->
            new IgnitiumSwordItem(damage("claymore"), attackSpeed("claymore")));
    public static final RegistryObject<Item> IGNITIUM_GREATHAMMER = ITEMS.register("ignitium_greathammer", () ->
            new IgnitiumSwordItem(damage("greathammer"), attackSpeed("greathammer")));
    public static final RegistryObject<Item> IGNITIUM_GREATAXE = ITEMS.register("ignitium_greataxe", () ->
            new IgnitiumSwordItem(damage("greataxe"), attackSpeed("greataxe")));
    public static final RegistryObject<Item> IGNITIUM_CHAKRAM = ITEMS.register("ignitium_chakram", () ->
            new IgnitiumSwordItem(damage("chakram"), attackSpeed("chakram")));
    public static final RegistryObject<Item> IGNITIUM_SCYTHE = ITEMS.register("ignitium_scythe", () ->
            new IgnitiumSwordItem(damage("scythe"), attackSpeed("scythe")));
    public static final RegistryObject<Item> IGNITIUM_HALBERD = ITEMS.register("ignitium_halberd", () ->
            new IgnitiumSwordItem(damage("halberd"), attackSpeed("halberd")));

    // WITHERITE WEAPONS
    public static final RegistryObject<Item> WITHERITE_LONGSWORD = ITEMS.register("witherite_longsword", () ->
            new WitheriteSwordItem(damage("longsword"), attackSpeed("longsword")));
    public static final RegistryObject<Item> WITHERITE_TWINBLADE = ITEMS.register("witherite_twinblade", () ->
            new WitheriteSwordItem(damage("twinblade"), attackSpeed("twinblade")));
    public static final RegistryObject<Item> WITHERITE_RAPIER = ITEMS.register("witherite_rapier", () ->
            new WitheriteSwordItem(damage("rapier"), attackSpeed("rapier")));
    public static final RegistryObject<Item> WITHERITE_KATANA = ITEMS.register("witherite_katana", () ->
            new WitheriteSwordItem(damage("katana"), attackSpeed("katana")));
    public static final RegistryObject<Item> WITHERITE_SAI = ITEMS.register("witherite_sai", () ->
            new WitheriteSwordItem(damage("sai"), attackSpeed("sai")));
    public static final RegistryObject<Item> WITHERITE_SPEAR = ITEMS.register("witherite_spear", () ->
            new WitheriteSwordItem(damage("spear"), attackSpeed("spear")));
    public static final RegistryObject<Item> WITHERITE_GLAIVE = ITEMS.register("witherite_glaive", () ->
            new WitheriteSwordItem(damage("glaive"), attackSpeed("glaive")));
    public static final RegistryObject<Item> WITHERITE_WARGLAIVE = ITEMS.register("witherite_warglaive", () ->
            new WitheriteSwordItem(damage("warglaive"), attackSpeed("warglaive")));
    public static final RegistryObject<Item> WITHERITE_CUTLASS = ITEMS.register("witherite_cutlass", () ->
            new WitheriteSwordItem(damage("cutlass"), attackSpeed("cutlass")));
    public static final RegistryObject<Item> WITHERITE_CLAYMORE = ITEMS.register("witherite_claymore", () ->
            new WitheriteSwordItem(damage("claymore"), attackSpeed("claymore")));
    public static final RegistryObject<Item> WITHERITE_GREATHAMMER = ITEMS.register("witherite_greathammer", () ->
            new WitheriteSwordItem(damage("greathammer"), attackSpeed("greathammer")));
    public static final RegistryObject<Item> WITHERITE_GREATAXE = ITEMS.register("witherite_greataxe", () ->
            new WitheriteSwordItem(damage("greataxe"), attackSpeed("greataxe")));
    public static final RegistryObject<Item> WITHERITE_CHAKRAM = ITEMS.register("witherite_chakram", () ->
            new WitheriteSwordItem(damage("chakram"), attackSpeed("chakram")));
    public static final RegistryObject<Item> WITHERITE_SCYTHE = ITEMS.register("witherite_scythe", () ->
            new WitheriteSwordItem(damage("scythe"), attackSpeed("scythe")));
    public static final RegistryObject<Item> WITHERITE_HALBERD = ITEMS.register("witherite_halberd", () ->
            new WitheriteSwordItem(damage("halberd"), attackSpeed("halberd")));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
