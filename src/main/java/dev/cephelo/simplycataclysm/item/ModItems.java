package dev.cephelo.simplycataclysm.item;

import dev.cephelo.simplycataclysm.SimplyCataclysm;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sweenus.simplyswords.config.Config;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, SimplyCataclysm.MODID);
    protected static final ChatFormatting[] traitformat = new ChatFormatting[]{ChatFormatting.RESET, ChatFormatting.WHITE};
    protected static final ChatFormatting[] descformat = new ChatFormatting[]{ChatFormatting.ITALIC, ChatFormatting.GRAY};

    // Tiers
    public static final Tier IGNITIUM_TIER = new SimpleTier(BlockTags.create(ResourceLocation.fromNamespaceAndPath(SimplyCataclysm.MODID, "needs_ignitium_tool")),
            -1, 9F, 7F, 20,
                    () -> Ingredient.of(com.github.L_Ender.cataclysm.init.ModItems.IGNITIUM_INGOT.get()));

    public static final Tier CURSIUM_TIER = new SimpleTier(BlockTags.create(ResourceLocation.fromNamespaceAndPath(SimplyCataclysm.MODID, "needs_cursium_tool")),
            -1, 9F, 6F, 20,
                    () -> Ingredient.of(com.github.L_Ender.cataclysm.init.ModItems.CURSIUM_INGOT.get()));

    public static final Tier WITHERITE_TIER = new SimpleTier(BlockTags.create(ResourceLocation.fromNamespaceAndPath(SimplyCataclysm.MODID, "needs_witherite_tool")),
            -1, 7F, 6F, 18,
                    () -> Ingredient.of(com.github.L_Ender.cataclysm.init.ModItems.WITHERITE_INGOT.get()));

    // SIMPLYSWORDS WEAPON TYPE CONFIG MODIFIER VALUES
    static Supplier<Float> longsword_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.longsword_damageModifier;
    static Supplier<Float> twinblade_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.twinblade_damageModifier;
    static Supplier<Float> rapier_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.rapier_damageModifier;
    static Supplier<Float> katana_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.katana_damageModifier;
    static Supplier<Float> sai_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.sai_damageModifier;
    static Supplier<Float> spear_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.spear_damageModifier;
    static Supplier<Float> glaive_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.glaive_damageModifier;
    static Supplier<Float> warglaive_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.warglaive_damageModifier;
    static Supplier<Float> cutlass_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.cutlass_damageModifier;
    static Supplier<Float> claymore_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.claymore_damageModifier;
    static Supplier<Float> greataxe_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.greataxe_damageModifier;
    static Supplier<Float> greathammer_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.greathammer_damageModifier;
    static Supplier<Float> chakram_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.chakram_damageModifier;
    static Supplier<Float> scythe_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.scythe_damageModifier;
    static Supplier<Float> halberd_damagemodifier = () -> Config.weaponAttribute.typeDamageModifier.halberd_damageModifier;
    static Supplier<Float> longsword_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.longsword_attackSpeed;
    static Supplier<Float> twinblade_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.twinblade_attackSpeed;
    static Supplier<Float> rapier_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.rapier_attackSpeed;
    static Supplier<Float> sai_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.sai_attackSpeed;
    static Supplier<Float> spear_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.spear_attackSpeed;
    static Supplier<Float> katana_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.katana_attackSpeed;
    static Supplier<Float> glaive_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.glaive_attackSpeed;
    static Supplier<Float> warglaive_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.warglaive_attackSpeed;
    static Supplier<Float> cutlass_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.cutlass_attackSpeed;
    static Supplier<Float> claymore_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.claymore_attackSpeed;
    static Supplier<Float> greataxe_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.greataxe_attackSpeed;
    static Supplier<Float> greathammer_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.greathammer_attackSpeed;
    static Supplier<Float> chakram_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.chakram_attackSpeed;
    static Supplier<Float> scythe_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.scythe_attackSpeed;
    static Supplier<Float> halberd_attackspeed = () -> Config.weaponAttribute.typeAttackSpeed.halberd_attackSpeed;

    // ANCIENT METAL WEAPONS
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_LONGSWORD = ITEMS.register("ancient_metal_longsword", () ->
            new AncientMetalSwordItem(longsword_damagemodifier.get().intValue(), longsword_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_TWINBLADE = ITEMS.register("ancient_metal_twinblade", () ->
            new AncientMetalSwordItem(twinblade_damagemodifier.get().intValue(), twinblade_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_RAPIER = ITEMS.register("ancient_metal_rapier", () ->
            new AncientMetalSwordItem(rapier_damagemodifier.get().intValue(), rapier_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_KATANA = ITEMS.register("ancient_metal_katana", () ->
            new AncientMetalSwordItem(katana_damagemodifier.get().intValue(), katana_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_SAI = ITEMS.register("ancient_metal_sai", () ->
            new AncientMetalSwordItem(sai_damagemodifier.get().intValue(), sai_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_SPEAR = ITEMS.register("ancient_metal_spear", () ->
            new AncientMetalSwordItem(spear_damagemodifier.get().intValue(), spear_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_GLAIVE = ITEMS.register("ancient_metal_glaive", () ->
            new AncientMetalSwordItem(glaive_damagemodifier.get().intValue(), glaive_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_WARGLAIVE = ITEMS.register("ancient_metal_warglaive", () ->
            new AncientMetalSwordItem(warglaive_damagemodifier.get().intValue(), warglaive_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_CUTLASS = ITEMS.register("ancient_metal_cutlass", () ->
            new AncientMetalSwordItem(cutlass_damagemodifier.get().intValue(), cutlass_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_CLAYMORE = ITEMS.register("ancient_metal_claymore", () ->
            new AncientMetalSwordItem(claymore_damagemodifier.get().intValue(), claymore_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_GREATHAMMER = ITEMS.register("ancient_metal_greathammer", () ->
            new AncientMetalSwordItem(greathammer_damagemodifier.get().intValue(), greathammer_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_GREATAXE = ITEMS.register("ancient_metal_greataxe", () ->
            new AncientMetalSwordItem(greataxe_damagemodifier.get().intValue(), greataxe_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_CHAKRAM = ITEMS.register("ancient_metal_chakram", () ->
            new AncientMetalSwordItem(chakram_damagemodifier.get().intValue(), chakram_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_SCYTHE = ITEMS.register("ancient_metal_scythe", () ->
            new AncientMetalSwordItem(scythe_damagemodifier.get().intValue(), scythe_attackspeed.get()));
    public static final DeferredHolder<Item, Item> ANCIENT_METAL_HALBERD = ITEMS.register("ancient_metal_halberd", () ->
            new AncientMetalSwordItem(halberd_damagemodifier.get().intValue(), halberd_attackspeed.get()));

    // BLACK STEEL WEAPONS
    public static final DeferredHolder<Item, Item> BLACK_STEEL_LONGSWORD = ITEMS.register("black_steel_longsword", () ->
            new BlackSteelSwordItem(longsword_damagemodifier.get().intValue(), longsword_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_TWINBLADE = ITEMS.register("black_steel_twinblade", () ->
            new BlackSteelSwordItem(twinblade_damagemodifier.get().intValue(), twinblade_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_RAPIER = ITEMS.register("black_steel_rapier", () ->
            new BlackSteelSwordItem(rapier_damagemodifier.get().intValue(), rapier_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_KATANA = ITEMS.register("black_steel_katana", () ->
            new BlackSteelSwordItem(katana_damagemodifier.get().intValue(), katana_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_SAI = ITEMS.register("black_steel_sai", () ->
            new BlackSteelSwordItem(sai_damagemodifier.get().intValue(), sai_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_SPEAR = ITEMS.register("black_steel_spear", () ->
            new BlackSteelSwordItem(spear_damagemodifier.get().intValue(), spear_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_GLAIVE = ITEMS.register("black_steel_glaive", () ->
            new BlackSteelSwordItem(glaive_damagemodifier.get().intValue(), glaive_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_WARGLAIVE = ITEMS.register("black_steel_warglaive", () ->
            new BlackSteelSwordItem(warglaive_damagemodifier.get().intValue(), warglaive_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_CUTLASS = ITEMS.register("black_steel_cutlass", () ->
            new BlackSteelSwordItem(cutlass_damagemodifier.get().intValue(), cutlass_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_CLAYMORE = ITEMS.register("black_steel_claymore", () ->
            new BlackSteelSwordItem(claymore_damagemodifier.get().intValue(), claymore_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_GREATHAMMER = ITEMS.register("black_steel_greathammer", () ->
            new BlackSteelSwordItem(greathammer_damagemodifier.get().intValue(), greathammer_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_GREATAXE = ITEMS.register("black_steel_greataxe", () ->
            new BlackSteelSwordItem(greataxe_damagemodifier.get().intValue(), greataxe_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_CHAKRAM = ITEMS.register("black_steel_chakram", () ->
            new BlackSteelSwordItem(chakram_damagemodifier.get().intValue(), chakram_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_SCYTHE = ITEMS.register("black_steel_scythe", () ->
            new BlackSteelSwordItem(scythe_damagemodifier.get().intValue(), scythe_attackspeed.get()));
    public static final DeferredHolder<Item, Item> BLACK_STEEL_HALBERD = ITEMS.register("black_steel_halberd", () ->
            new BlackSteelSwordItem(halberd_damagemodifier.get().intValue(), halberd_attackspeed.get()));

    // CURSIUM WEAPONS
    public static final DeferredHolder<Item, Item> CURSIUM_LONGSWORD = ITEMS.register("cursium_longsword", () ->
            new CursiumSwordItem(longsword_damagemodifier.get().intValue(), longsword_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_TWINBLADE = ITEMS.register("cursium_twinblade", () ->
            new CursiumSwordItem(twinblade_damagemodifier.get().intValue(), twinblade_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_RAPIER = ITEMS.register("cursium_rapier", () ->
            new CursiumSwordItem(rapier_damagemodifier.get().intValue(), rapier_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_KATANA = ITEMS.register("cursium_katana", () ->
            new CursiumSwordItem(katana_damagemodifier.get().intValue(), katana_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_SAI = ITEMS.register("cursium_sai", () ->
            new CursiumSwordItem(sai_damagemodifier.get().intValue(), sai_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_SPEAR = ITEMS.register("cursium_spear", () ->
            new CursiumSwordItem(spear_damagemodifier.get().intValue(), spear_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_GLAIVE = ITEMS.register("cursium_glaive", () ->
            new CursiumSwordItem(glaive_damagemodifier.get().intValue(), glaive_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_WARGLAIVE = ITEMS.register("cursium_warglaive", () ->
            new CursiumSwordItem(warglaive_damagemodifier.get().intValue(), warglaive_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_CUTLASS = ITEMS.register("cursium_cutlass", () ->
            new CursiumSwordItem(cutlass_damagemodifier.get().intValue(), cutlass_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_CLAYMORE = ITEMS.register("cursium_claymore", () ->
            new CursiumSwordItem(claymore_damagemodifier.get().intValue(), claymore_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_GREATHAMMER = ITEMS.register("cursium_greathammer", () ->
            new CursiumSwordItem(greathammer_damagemodifier.get().intValue(), greathammer_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_GREATAXE = ITEMS.register("cursium_greataxe", () ->
            new CursiumSwordItem(greataxe_damagemodifier.get().intValue(), greataxe_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_CHAKRAM = ITEMS.register("cursium_chakram", () ->
            new CursiumSwordItem(chakram_damagemodifier.get().intValue(), chakram_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_SCYTHE = ITEMS.register("cursium_scythe", () ->
            new CursiumSwordItem(scythe_damagemodifier.get().intValue(), scythe_attackspeed.get()));
    public static final DeferredHolder<Item, Item> CURSIUM_HALBERD = ITEMS.register("cursium_halberd", () ->
            new CursiumSwordItem(halberd_damagemodifier.get().intValue(), halberd_attackspeed.get()));

    // IGNITIUM WEAPONS
    public static final DeferredHolder<Item, Item> IGNITIUM_LONGSWORD = ITEMS.register("ignitium_longsword", () ->
            new IgnitiumSwordItem(longsword_damagemodifier.get().intValue(), longsword_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_TWINBLADE = ITEMS.register("ignitium_twinblade", () ->
            new IgnitiumSwordItem(twinblade_damagemodifier.get().intValue(), twinblade_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_RAPIER = ITEMS.register("ignitium_rapier", () ->
            new IgnitiumSwordItem(rapier_damagemodifier.get().intValue(), rapier_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_KATANA = ITEMS.register("ignitium_katana", () ->
            new IgnitiumSwordItem(katana_damagemodifier.get().intValue(), katana_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_SAI = ITEMS.register("ignitium_sai", () ->
            new IgnitiumSwordItem(sai_damagemodifier.get().intValue(), sai_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_SPEAR = ITEMS.register("ignitium_spear", () ->
            new IgnitiumSwordItem(spear_damagemodifier.get().intValue(), spear_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_GLAIVE = ITEMS.register("ignitium_glaive", () ->
            new IgnitiumSwordItem(glaive_damagemodifier.get().intValue(), glaive_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_WARGLAIVE = ITEMS.register("ignitium_warglaive", () ->
            new IgnitiumSwordItem(warglaive_damagemodifier.get().intValue(), warglaive_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_CUTLASS = ITEMS.register("ignitium_cutlass", () ->
            new IgnitiumSwordItem(cutlass_damagemodifier.get().intValue(), cutlass_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_CLAYMORE = ITEMS.register("ignitium_claymore", () ->
            new IgnitiumSwordItem(claymore_damagemodifier.get().intValue(), claymore_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_GREATHAMMER = ITEMS.register("ignitium_greathammer", () ->
            new IgnitiumSwordItem(greathammer_damagemodifier.get().intValue(), greathammer_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_GREATAXE = ITEMS.register("ignitium_greataxe", () ->
            new IgnitiumSwordItem(greataxe_damagemodifier.get().intValue(), greataxe_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_CHAKRAM = ITEMS.register("ignitium_chakram", () ->
            new IgnitiumSwordItem(chakram_damagemodifier.get().intValue(), chakram_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_SCYTHE = ITEMS.register("ignitium_scythe", () ->
            new IgnitiumSwordItem(scythe_damagemodifier.get().intValue(), scythe_attackspeed.get()));
    public static final DeferredHolder<Item, Item> IGNITIUM_HALBERD = ITEMS.register("ignitium_halberd", () ->
            new IgnitiumSwordItem(halberd_damagemodifier.get().intValue(), halberd_attackspeed.get()));

    // WITHERITE WEAPONS
    public static final DeferredHolder<Item, Item> WITHERITE_LONGSWORD = ITEMS.register("witherite_longsword", () ->
            new WitheriteSwordItem(longsword_damagemodifier.get().intValue(), longsword_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_TWINBLADE = ITEMS.register("witherite_twinblade", () ->
            new WitheriteSwordItem(twinblade_damagemodifier.get().intValue(), twinblade_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_RAPIER = ITEMS.register("witherite_rapier", () ->
            new WitheriteSwordItem(rapier_damagemodifier.get().intValue(), rapier_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_KATANA = ITEMS.register("witherite_katana", () ->
            new WitheriteSwordItem(katana_damagemodifier.get().intValue(), katana_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_SAI = ITEMS.register("witherite_sai", () ->
            new WitheriteSwordItem(sai_damagemodifier.get().intValue(), sai_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_SPEAR = ITEMS.register("witherite_spear", () ->
            new WitheriteSwordItem(spear_damagemodifier.get().intValue(), spear_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_GLAIVE = ITEMS.register("witherite_glaive", () ->
            new WitheriteSwordItem(glaive_damagemodifier.get().intValue(), glaive_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_WARGLAIVE = ITEMS.register("witherite_warglaive", () ->
            new WitheriteSwordItem(warglaive_damagemodifier.get().intValue(), warglaive_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_CUTLASS = ITEMS.register("witherite_cutlass", () ->
            new WitheriteSwordItem(cutlass_damagemodifier.get().intValue(), cutlass_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_CLAYMORE = ITEMS.register("witherite_claymore", () ->
            new WitheriteSwordItem(claymore_damagemodifier.get().intValue(), claymore_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_GREATHAMMER = ITEMS.register("witherite_greathammer", () ->
            new WitheriteSwordItem(greathammer_damagemodifier.get().intValue(), greathammer_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_GREATAXE = ITEMS.register("witherite_greataxe", () ->
            new WitheriteSwordItem(greataxe_damagemodifier.get().intValue(), greataxe_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_CHAKRAM = ITEMS.register("witherite_chakram", () ->
            new WitheriteSwordItem(chakram_damagemodifier.get().intValue(), chakram_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_SCYTHE = ITEMS.register("witherite_scythe", () ->
            new WitheriteSwordItem(scythe_damagemodifier.get().intValue(), scythe_attackspeed.get()));
    public static final DeferredHolder<Item, Item> WITHERITE_HALBERD = ITEMS.register("witherite_halberd", () ->
            new WitheriteSwordItem(halberd_damagemodifier.get().intValue(), halberd_attackspeed.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
