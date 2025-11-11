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
import net.sweenus.simplyswords.config.ConfigDefaultValues;

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
    static Supplier<Float> longsword_positive_modifier = () -> Config.getFloat("longsword_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.longsword_positiveDamageModifier);
    static Supplier<Float> twinblade_positive_modifier = () -> Config.getFloat("twinblade_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.twinblade_positiveDamageModifier);
    static Supplier<Float> rapier_positive_modifier = () -> Config.getFloat("rapier_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.rapier_positiveDamageModifier);
    static Supplier<Float> katana_positive_modifier = () -> Config.getFloat("katana_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.katana_positiveDamageModifier);
    static Supplier<Float> sai_positive_modifier = () -> Config.getFloat("sai_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.sai_positiveDamageModifier);
    static Supplier<Float> spear_positive_modifier = () -> Config.getFloat("spear_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.spear_positiveDamageModifier);
    static Supplier<Float> glaive_positive_modifier = () -> Config.getFloat("glaive_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.glaive_positiveDamageModifier);
    static Supplier<Float> warglaive_positive_modifier = () -> Config.getFloat("warglaive_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.warglaive_positiveDamageModifier);
    static Supplier<Float> cutlass_positive_modifier = () -> Config.getFloat("cutlass_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.cutlass_positiveDamageModifier);
    static Supplier<Float> claymore_positive_modifier = () -> Config.getFloat("claymore_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.claymore_positiveDamageModifier);
    static Supplier<Float> greataxe_positive_modifier = () -> Config.getFloat("greataxe_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.greataxe_positiveDamageModifier);
    static Supplier<Float> greathammer_positive_modifier = () -> Config.getFloat("greathammer_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.greathammer_positiveDamageModifier);
    static Supplier<Float> chakram_positive_modifier = () -> Config.getFloat("chakram_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.chakram_positiveDamageModifier);
    static Supplier<Float> scythe_positive_modifier = () -> Config.getFloat("scythe_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.scythe_positiveDamageModifier);
    static Supplier<Float> halberd_positive_modifier = () -> Config.getFloat("halberd_positiveDamageModifier", "WeaponAttributes", ConfigDefaultValues.halberd_positiveDamageModifier);
    static Supplier<Float> longsword_negative_modifier = () -> Config.getFloat("longsword_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.longsword_negativeDamageModifier);
    static Supplier<Float> twinblade_negative_modifier = () -> Config.getFloat("twinblade_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.twinblade_negativeDamageModifier);
    static Supplier<Float> rapier_negative_modifier = () -> Config.getFloat("rapier_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.rapier_negativeDamageModifier);
    static Supplier<Float> sai_negative_modifier = () -> Config.getFloat("sai_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.sai_negativeDamageModifier);
    static Supplier<Float> spear_negative_modifier = () -> Config.getFloat("spear_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.spear_negativeDamageModifier);
    static Supplier<Float> katana_negative_modifier = () -> Config.getFloat("katana_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.katana_negativeDamageModifier);
    static Supplier<Float> glaive_negative_modifier = () -> Config.getFloat("glaive_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.glaive_negativeDamageModifier);
    static Supplier<Float> warglaive_negative_modifier = () -> Config.getFloat("warglaive_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.warglaive_negativeDamageModifier);
    static Supplier<Float> cutlass_negative_modifier = () -> Config.getFloat("cutlass_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.cutlass_negativeDamageModifier);
    static Supplier<Float> claymore_negative_modifier = () -> Config.getFloat("claymore_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.claymore_negativeDamageModifier);
    static Supplier<Float> greataxe_negative_modifier = () -> Config.getFloat("greataxe_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.greataxe_negativeDamageModifier);
    static Supplier<Float> greathammer_negative_modifier = () -> Config.getFloat("greathammer_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.greathammer_negativeDamageModifier);
    static Supplier<Float> chakram_negative_modifier = () -> Config.getFloat("chakram_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.chakram_negativeDamageModifier);
    static Supplier<Float> scythe_negative_modifier = () -> Config.getFloat("scythe_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.scythe_negativeDamageModifier);
    static Supplier<Float> halberd_negative_modifier = () -> Config.getFloat("halberd_negativeDamageModifier", "WeaponAttributes", ConfigDefaultValues.halberd_negativeDamageModifier);
    static Supplier<Float> longsword_attackspeed = () -> Config.getFloat("longsword_attackSpeed", "WeaponAttributes", ConfigDefaultValues.longsword_attackSpeed);
    static Supplier<Float> twinblade_attackspeed = () -> Config.getFloat("twinblade_attackSpeed", "WeaponAttributes", ConfigDefaultValues.twinblade_attackSpeed);
    static Supplier<Float> rapier_attackspeed = () -> Config.getFloat("rapier_attackSpeed", "WeaponAttributes", ConfigDefaultValues.rapier_attackSpeed);
    static Supplier<Float> sai_attackspeed = () -> Config.getFloat("sai_attackSpeed", "WeaponAttributes", ConfigDefaultValues.sai_attackSpeed);
    static Supplier<Float> spear_attackspeed = () -> Config.getFloat("spear_attackSpeed", "WeaponAttributes", ConfigDefaultValues.spear_attackSpeed);
    static Supplier<Float> katana_attackspeed = () -> Config.getFloat("katana_attackSpeed", "WeaponAttributes", ConfigDefaultValues.katana_attackSpeed);
    static Supplier<Float> glaive_attackspeed = () -> Config.getFloat("glaive_attackSpeed", "WeaponAttributes", ConfigDefaultValues.glaive_attackSpeed);
    static Supplier<Float> warglaive_attackspeed = () -> Config.getFloat("warglaive_attackSpeed", "WeaponAttributes", ConfigDefaultValues.warglaive_attackSpeed);
    static Supplier<Float> cutlass_attackspeed = () -> Config.getFloat("cutlass_attackSpeed", "WeaponAttributes", ConfigDefaultValues.cutlass_attackSpeed);
    static Supplier<Float> claymore_attackspeed = () -> Config.getFloat("claymore_attackSpeed", "WeaponAttributes", ConfigDefaultValues.claymore_attackSpeed);
    static Supplier<Float> greataxe_attackspeed = () -> Config.getFloat("greataxe_attackSpeed", "WeaponAttributes", ConfigDefaultValues.greataxe_attackSpeed);
    static Supplier<Float> greathammer_attackspeed = () -> Config.getFloat("greathammer_attackSpeed", "WeaponAttributes", ConfigDefaultValues.greathammer_attackSpeed);
    static Supplier<Float> chakram_attackspeed = () -> Config.getFloat("chakram_attackSpeed", "WeaponAttributes", ConfigDefaultValues.chakram_attackSpeed);
    static Supplier<Float> scythe_attackspeed = () -> Config.getFloat("scythe_attackSpeed", "WeaponAttributes", ConfigDefaultValues.scythe_attackSpeed);
    static Supplier<Float> halberd_attackspeed = () -> Config.getFloat("halberd_attackSpeed", "WeaponAttributes", ConfigDefaultValues.halberd_attackSpeed);

    // ANCIENT METAL WEAPONS
    public static final RegistryObject<Item> ANCIENT_METAL_LONGSWORD = ITEMS.register("ancient_metal_longsword", () ->
            new AncientMetalSwordItem((int)(longsword_positive_modifier.get() - longsword_negative_modifier.get()), longsword_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_TWINBLADE = ITEMS.register("ancient_metal_twinblade", () ->
            new AncientMetalSwordItem((int)(twinblade_positive_modifier.get() - twinblade_negative_modifier.get()), twinblade_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_RAPIER = ITEMS.register("ancient_metal_rapier", () ->
            new AncientMetalSwordItem((int)(rapier_positive_modifier.get() - rapier_negative_modifier.get()), rapier_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_KATANA = ITEMS.register("ancient_metal_katana", () ->
            new AncientMetalSwordItem((int)(katana_positive_modifier.get() - katana_negative_modifier.get()), katana_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_SAI = ITEMS.register("ancient_metal_sai", () ->
            new AncientMetalSwordItem((int)(sai_positive_modifier.get() - sai_negative_modifier.get()), sai_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_SPEAR = ITEMS.register("ancient_metal_spear", () ->
            new AncientMetalSwordItem((int)(spear_positive_modifier.get() - spear_negative_modifier.get()), spear_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_GLAIVE = ITEMS.register("ancient_metal_glaive", () ->
            new AncientMetalSwordItem((int)(glaive_positive_modifier.get() - glaive_negative_modifier.get()), glaive_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_WARGLAIVE = ITEMS.register("ancient_metal_warglaive", () ->
            new AncientMetalSwordItem((int)(warglaive_positive_modifier.get() - warglaive_negative_modifier.get()), warglaive_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_CUTLASS = ITEMS.register("ancient_metal_cutlass", () ->
            new AncientMetalSwordItem((int)(cutlass_positive_modifier.get() - cutlass_negative_modifier.get()), cutlass_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_CLAYMORE = ITEMS.register("ancient_metal_claymore", () ->
            new AncientMetalSwordItem((int)(claymore_positive_modifier.get() - claymore_negative_modifier.get()), claymore_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_GREATHAMMER = ITEMS.register("ancient_metal_greathammer", () ->
            new AncientMetalSwordItem((int)(greathammer_positive_modifier.get() - greathammer_negative_modifier.get()), greathammer_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_GREATAXE = ITEMS.register("ancient_metal_greataxe", () ->
            new AncientMetalSwordItem((int)(greataxe_positive_modifier.get() - greataxe_negative_modifier.get()), greataxe_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_CHAKRAM = ITEMS.register("ancient_metal_chakram", () ->
            new AncientMetalSwordItem((int)(chakram_positive_modifier.get() - chakram_negative_modifier.get()), chakram_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_SCYTHE = ITEMS.register("ancient_metal_scythe", () ->
            new AncientMetalSwordItem((int)(scythe_positive_modifier.get() - scythe_negative_modifier.get()), scythe_attackspeed.get()));
    public static final RegistryObject<Item> ANCIENT_METAL_HALBERD = ITEMS.register("ancient_metal_halberd", () ->
            new AncientMetalSwordItem((int)(halberd_positive_modifier.get() - halberd_negative_modifier.get()), halberd_attackspeed.get()));

    // BLACK STEEL WEAPONS
    public static final RegistryObject<Item> BLACK_STEEL_LONGSWORD = ITEMS.register("black_steel_longsword", () ->
            new BlackSteelSwordItem((int)(longsword_positive_modifier.get() - longsword_negative_modifier.get()), longsword_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_TWINBLADE = ITEMS.register("black_steel_twinblade", () ->
            new BlackSteelSwordItem((int)(twinblade_positive_modifier.get() - twinblade_negative_modifier.get()), twinblade_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_RAPIER = ITEMS.register("black_steel_rapier", () ->
            new BlackSteelSwordItem((int)(rapier_positive_modifier.get() - rapier_negative_modifier.get()), rapier_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_KATANA = ITEMS.register("black_steel_katana", () ->
            new BlackSteelSwordItem((int)(katana_positive_modifier.get() - katana_negative_modifier.get()), katana_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_SAI = ITEMS.register("black_steel_sai", () ->
            new BlackSteelSwordItem((int)(sai_positive_modifier.get() - sai_negative_modifier.get()), sai_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_SPEAR = ITEMS.register("black_steel_spear", () ->
            new BlackSteelSwordItem((int)(spear_positive_modifier.get() - spear_negative_modifier.get()), spear_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_GLAIVE = ITEMS.register("black_steel_glaive", () ->
            new BlackSteelSwordItem((int)(glaive_positive_modifier.get() - glaive_negative_modifier.get()), glaive_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_WARGLAIVE = ITEMS.register("black_steel_warglaive", () ->
            new BlackSteelSwordItem((int)(warglaive_positive_modifier.get() - warglaive_negative_modifier.get()), warglaive_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_CUTLASS = ITEMS.register("black_steel_cutlass", () ->
            new BlackSteelSwordItem((int)(cutlass_positive_modifier.get() - cutlass_negative_modifier.get()), cutlass_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_CLAYMORE = ITEMS.register("black_steel_claymore", () ->
            new BlackSteelSwordItem((int)(claymore_positive_modifier.get() - claymore_negative_modifier.get()), claymore_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_GREATHAMMER = ITEMS.register("black_steel_greathammer", () ->
            new BlackSteelSwordItem((int)(greathammer_positive_modifier.get() - greathammer_negative_modifier.get()), greathammer_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_GREATAXE = ITEMS.register("black_steel_greataxe", () ->
            new BlackSteelSwordItem((int)(greataxe_positive_modifier.get() - greataxe_negative_modifier.get()), greataxe_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_CHAKRAM = ITEMS.register("black_steel_chakram", () ->
            new BlackSteelSwordItem((int)(chakram_positive_modifier.get() - chakram_negative_modifier.get()), chakram_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_SCYTHE = ITEMS.register("black_steel_scythe", () ->
            new BlackSteelSwordItem((int)(scythe_positive_modifier.get() - scythe_negative_modifier.get()), scythe_attackspeed.get()));
    public static final RegistryObject<Item> BLACK_STEEL_HALBERD = ITEMS.register("black_steel_halberd", () ->
            new BlackSteelSwordItem((int)(halberd_positive_modifier.get() - halberd_negative_modifier.get()), halberd_attackspeed.get()));

    // CURSIUM WEAPONS
    public static final RegistryObject<Item> CURSIUM_LONGSWORD = ITEMS.register("cursium_longsword", () ->
            new CursiumSwordItem((int)(longsword_positive_modifier.get() - longsword_negative_modifier.get()), longsword_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_TWINBLADE = ITEMS.register("cursium_twinblade", () ->
            new CursiumSwordItem((int)(twinblade_positive_modifier.get() - twinblade_negative_modifier.get()), twinblade_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_RAPIER = ITEMS.register("cursium_rapier", () ->
            new CursiumSwordItem((int)(rapier_positive_modifier.get() - rapier_negative_modifier.get()), rapier_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_KATANA = ITEMS.register("cursium_katana", () ->
            new CursiumSwordItem((int)(katana_positive_modifier.get() - katana_negative_modifier.get()), katana_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_SAI = ITEMS.register("cursium_sai", () ->
            new CursiumSwordItem((int)(sai_positive_modifier.get() - sai_negative_modifier.get()), sai_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_SPEAR = ITEMS.register("cursium_spear", () ->
            new CursiumSwordItem((int)(spear_positive_modifier.get() - spear_negative_modifier.get()), spear_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_GLAIVE = ITEMS.register("cursium_glaive", () ->
            new CursiumSwordItem((int)(glaive_positive_modifier.get() - glaive_negative_modifier.get()), glaive_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_WARGLAIVE = ITEMS.register("cursium_warglaive", () ->
            new CursiumSwordItem((int)(warglaive_positive_modifier.get() - warglaive_negative_modifier.get()), warglaive_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_CUTLASS = ITEMS.register("cursium_cutlass", () ->
            new CursiumSwordItem((int)(cutlass_positive_modifier.get() - cutlass_negative_modifier.get()), cutlass_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_CLAYMORE = ITEMS.register("cursium_claymore", () ->
            new CursiumSwordItem((int)(claymore_positive_modifier.get() - claymore_negative_modifier.get()), claymore_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_GREATHAMMER = ITEMS.register("cursium_greathammer", () ->
            new CursiumSwordItem((int)(greathammer_positive_modifier.get() - greathammer_negative_modifier.get()), greathammer_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_GREATAXE = ITEMS.register("cursium_greataxe", () ->
            new CursiumSwordItem((int)(greataxe_positive_modifier.get() - greataxe_negative_modifier.get()), greataxe_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_CHAKRAM = ITEMS.register("cursium_chakram", () ->
            new CursiumSwordItem((int)(chakram_positive_modifier.get() - chakram_negative_modifier.get()), chakram_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_SCYTHE = ITEMS.register("cursium_scythe", () ->
            new CursiumSwordItem((int)(scythe_positive_modifier.get() - scythe_negative_modifier.get()), scythe_attackspeed.get()));
    public static final RegistryObject<Item> CURSIUM_HALBERD = ITEMS.register("cursium_halberd", () ->
            new CursiumSwordItem((int)(halberd_positive_modifier.get() - halberd_negative_modifier.get()), halberd_attackspeed.get()));

    // IGNITIUM WEAPONS
    public static final RegistryObject<Item> IGNITIUM_LONGSWORD = ITEMS.register("ignitium_longsword", () ->
            new IgnitiumSwordItem((int)(longsword_positive_modifier.get() - longsword_negative_modifier.get()), longsword_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_TWINBLADE = ITEMS.register("ignitium_twinblade", () ->
            new IgnitiumSwordItem((int)(twinblade_positive_modifier.get() - twinblade_negative_modifier.get()), twinblade_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_RAPIER = ITEMS.register("ignitium_rapier", () ->
            new IgnitiumSwordItem((int)(rapier_positive_modifier.get() - rapier_negative_modifier.get()), rapier_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_KATANA = ITEMS.register("ignitium_katana", () ->
            new IgnitiumSwordItem((int)(katana_positive_modifier.get() - katana_negative_modifier.get()), katana_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_SAI = ITEMS.register("ignitium_sai", () ->
            new IgnitiumSwordItem((int)(sai_positive_modifier.get() - sai_negative_modifier.get()), sai_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_SPEAR = ITEMS.register("ignitium_spear", () ->
            new IgnitiumSwordItem((int)(spear_positive_modifier.get() - spear_negative_modifier.get()), spear_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_GLAIVE = ITEMS.register("ignitium_glaive", () ->
            new IgnitiumSwordItem((int)(glaive_positive_modifier.get() - glaive_negative_modifier.get()), glaive_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_WARGLAIVE = ITEMS.register("ignitium_warglaive", () ->
            new IgnitiumSwordItem((int)(warglaive_positive_modifier.get() - warglaive_negative_modifier.get()), warglaive_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_CUTLASS = ITEMS.register("ignitium_cutlass", () ->
            new IgnitiumSwordItem((int)(cutlass_positive_modifier.get() - cutlass_negative_modifier.get()), cutlass_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_CLAYMORE = ITEMS.register("ignitium_claymore", () ->
            new IgnitiumSwordItem((int)(claymore_positive_modifier.get() - claymore_negative_modifier.get()), claymore_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_GREATHAMMER = ITEMS.register("ignitium_greathammer", () ->
            new IgnitiumSwordItem((int)(greathammer_positive_modifier.get() - greathammer_negative_modifier.get()), greathammer_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_GREATAXE = ITEMS.register("ignitium_greataxe", () ->
            new IgnitiumSwordItem((int)(greataxe_positive_modifier.get() - greataxe_negative_modifier.get()), greataxe_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_CHAKRAM = ITEMS.register("ignitium_chakram", () ->
            new IgnitiumSwordItem((int)(chakram_positive_modifier.get() - chakram_negative_modifier.get()), chakram_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_SCYTHE = ITEMS.register("ignitium_scythe", () ->
            new IgnitiumSwordItem((int)(scythe_positive_modifier.get() - scythe_negative_modifier.get()), scythe_attackspeed.get()));
    public static final RegistryObject<Item> IGNITIUM_HALBERD = ITEMS.register("ignitium_halberd", () ->
            new IgnitiumSwordItem((int)(halberd_positive_modifier.get() - halberd_negative_modifier.get()), halberd_attackspeed.get()));

    // WITHERITE WEAPONS
    public static final RegistryObject<Item> WITHERITE_LONGSWORD = ITEMS.register("witherite_longsword", () ->
            new WitheriteSwordItem((int)(longsword_positive_modifier.get() - longsword_negative_modifier.get()), longsword_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_TWINBLADE = ITEMS.register("witherite_twinblade", () ->
            new WitheriteSwordItem((int)(twinblade_positive_modifier.get() - twinblade_negative_modifier.get()), twinblade_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_RAPIER = ITEMS.register("witherite_rapier", () ->
            new WitheriteSwordItem((int)(rapier_positive_modifier.get() - rapier_negative_modifier.get()), rapier_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_KATANA = ITEMS.register("witherite_katana", () ->
            new WitheriteSwordItem((int)(katana_positive_modifier.get() - katana_negative_modifier.get()), katana_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_SAI = ITEMS.register("witherite_sai", () ->
            new WitheriteSwordItem((int)(sai_positive_modifier.get() - sai_negative_modifier.get()), sai_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_SPEAR = ITEMS.register("witherite_spear", () ->
            new WitheriteSwordItem((int)(spear_positive_modifier.get() - spear_negative_modifier.get()), spear_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_GLAIVE = ITEMS.register("witherite_glaive", () ->
            new WitheriteSwordItem((int)(glaive_positive_modifier.get() - glaive_negative_modifier.get()), glaive_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_WARGLAIVE = ITEMS.register("witherite_warglaive", () ->
            new WitheriteSwordItem((int)(warglaive_positive_modifier.get() - warglaive_negative_modifier.get()), warglaive_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_CUTLASS = ITEMS.register("witherite_cutlass", () ->
            new WitheriteSwordItem((int)(cutlass_positive_modifier.get() - cutlass_negative_modifier.get()), cutlass_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_CLAYMORE = ITEMS.register("witherite_claymore", () ->
            new WitheriteSwordItem((int)(claymore_positive_modifier.get() - claymore_negative_modifier.get()), claymore_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_GREATHAMMER = ITEMS.register("witherite_greathammer", () ->
            new WitheriteSwordItem((int)(greathammer_positive_modifier.get() - greathammer_negative_modifier.get()), greathammer_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_GREATAXE = ITEMS.register("witherite_greataxe", () ->
            new WitheriteSwordItem((int)(greataxe_positive_modifier.get() - greataxe_negative_modifier.get()), greataxe_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_CHAKRAM = ITEMS.register("witherite_chakram", () ->
            new WitheriteSwordItem((int)(chakram_positive_modifier.get() - chakram_negative_modifier.get()), chakram_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_SCYTHE = ITEMS.register("witherite_scythe", () ->
            new WitheriteSwordItem((int)(scythe_positive_modifier.get() - scythe_negative_modifier.get()), scythe_attackspeed.get()));
    public static final RegistryObject<Item> WITHERITE_HALBERD = ITEMS.register("witherite_halberd", () ->
            new WitheriteSwordItem((int)(halberd_positive_modifier.get() - halberd_negative_modifier.get()), halberd_attackspeed.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
