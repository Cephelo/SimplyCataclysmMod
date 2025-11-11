package dev.cephelo.simplycataclysm.item;

import dev.cephelo.simplycataclysm.SCConfig;
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

import java.util.List;

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

    // ANCIENT METAL WEAPONS
    public static final RegistryObject<Item> ANCIENT_METAL_LONGSWORD = ITEMS.register("ancient_metal_longsword", () ->
            new AncientMetalSwordItem((SCConfig.longsword_positive_modifier - SCConfig.longsword_negative_modifier), SCConfig.longsword_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_TWINBLADE = ITEMS.register("ancient_metal_twinblade", () ->
            new AncientMetalSwordItem((SCConfig.twinblade_positive_modifier - SCConfig.twinblade_negative_modifier), SCConfig.twinblade_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_RAPIER = ITEMS.register("ancient_metal_rapier", () ->
            new AncientMetalSwordItem((SCConfig.rapier_positive_modifier - SCConfig.rapier_negative_modifier), SCConfig.rapier_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_KATANA = ITEMS.register("ancient_metal_katana", () ->
            new AncientMetalSwordItem((SCConfig.katana_positive_modifier - SCConfig.katana_negative_modifier), SCConfig.katana_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_SAI = ITEMS.register("ancient_metal_sai", () ->
            new AncientMetalSwordItem((SCConfig.sai_positive_modifier - SCConfig.sai_negative_modifier), SCConfig.sai_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_SPEAR = ITEMS.register("ancient_metal_spear", () ->
            new AncientMetalSwordItem((SCConfig.spear_positive_modifier - SCConfig.spear_negative_modifier), SCConfig.spear_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_GLAIVE = ITEMS.register("ancient_metal_glaive", () ->
            new AncientMetalSwordItem((SCConfig.glaive_positive_modifier - SCConfig.glaive_negative_modifier), SCConfig.glaive_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_WARGLAIVE = ITEMS.register("ancient_metal_warglaive", () ->
            new AncientMetalSwordItem((SCConfig.warglaive_positive_modifier - SCConfig.warglaive_negative_modifier), SCConfig.warglaive_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_CUTLASS = ITEMS.register("ancient_metal_cutlass", () ->
            new AncientMetalSwordItem((SCConfig.cutlass_positive_modifier - SCConfig.cutlass_negative_modifier), SCConfig.cutlass_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_CLAYMORE = ITEMS.register("ancient_metal_claymore", () ->
            new AncientMetalSwordItem((SCConfig.claymore_positive_modifier - SCConfig.claymore_negative_modifier), SCConfig.claymore_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_GREATHAMMER = ITEMS.register("ancient_metal_greathammer", () ->
            new AncientMetalSwordItem((SCConfig.greathammer_positive_modifier - SCConfig.greathammer_negative_modifier), SCConfig.greathammer_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_GREATAXE = ITEMS.register("ancient_metal_greataxe", () ->
            new AncientMetalSwordItem((SCConfig.greataxe_positive_modifier - SCConfig.greataxe_negative_modifier), SCConfig.greataxe_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_CHAKRAM = ITEMS.register("ancient_metal_chakram", () ->
            new AncientMetalSwordItem((SCConfig.chakram_positive_modifier - SCConfig.chakram_negative_modifier), SCConfig.chakram_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_SCYTHE = ITEMS.register("ancient_metal_scythe", () ->
            new AncientMetalSwordItem((SCConfig.scythe_positive_modifier - SCConfig.scythe_negative_modifier), SCConfig.scythe_attackspeed));
    public static final RegistryObject<Item> ANCIENT_METAL_HALBERD = ITEMS.register("ancient_metal_halberd", () ->
            new AncientMetalSwordItem((SCConfig.halberd_positive_modifier - SCConfig.halberd_negative_modifier), SCConfig.halberd_attackspeed));

    // BLACK STEEL WEAPONS
    public static final RegistryObject<Item> BLACK_STEEL_LONGSWORD = ITEMS.register("black_steel_longsword", () ->
            new BlackSteelSwordItem((SCConfig.longsword_positive_modifier - SCConfig.longsword_negative_modifier), SCConfig.longsword_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_TWINBLADE = ITEMS.register("black_steel_twinblade", () ->
            new BlackSteelSwordItem((SCConfig.twinblade_positive_modifier - SCConfig.twinblade_negative_modifier), SCConfig.twinblade_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_RAPIER = ITEMS.register("black_steel_rapier", () ->
            new BlackSteelSwordItem((SCConfig.rapier_positive_modifier - SCConfig.rapier_negative_modifier), SCConfig.rapier_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_KATANA = ITEMS.register("black_steel_katana", () ->
            new BlackSteelSwordItem((SCConfig.katana_positive_modifier - SCConfig.katana_negative_modifier), SCConfig.katana_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_SAI = ITEMS.register("black_steel_sai", () ->
            new BlackSteelSwordItem((SCConfig.sai_positive_modifier - SCConfig.sai_negative_modifier), SCConfig.sai_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_SPEAR = ITEMS.register("black_steel_spear", () ->
            new BlackSteelSwordItem((SCConfig.spear_positive_modifier - SCConfig.spear_negative_modifier), SCConfig.spear_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_GLAIVE = ITEMS.register("black_steel_glaive", () ->
            new BlackSteelSwordItem((SCConfig.glaive_positive_modifier - SCConfig.glaive_negative_modifier), SCConfig.glaive_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_WARGLAIVE = ITEMS.register("black_steel_warglaive", () ->
            new BlackSteelSwordItem((SCConfig.warglaive_positive_modifier - SCConfig.warglaive_negative_modifier), SCConfig.warglaive_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_CUTLASS = ITEMS.register("black_steel_cutlass", () ->
            new BlackSteelSwordItem((SCConfig.cutlass_positive_modifier - SCConfig.cutlass_negative_modifier), SCConfig.cutlass_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_CLAYMORE = ITEMS.register("black_steel_claymore", () ->
            new BlackSteelSwordItem((SCConfig.claymore_positive_modifier - SCConfig.claymore_negative_modifier), SCConfig.claymore_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_GREATHAMMER = ITEMS.register("black_steel_greathammer", () ->
            new BlackSteelSwordItem((SCConfig.greathammer_positive_modifier - SCConfig.greathammer_negative_modifier), SCConfig.greathammer_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_GREATAXE = ITEMS.register("black_steel_greataxe", () ->
            new BlackSteelSwordItem((SCConfig.greataxe_positive_modifier - SCConfig.greataxe_negative_modifier), SCConfig.greataxe_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_CHAKRAM = ITEMS.register("black_steel_chakram", () ->
            new BlackSteelSwordItem((SCConfig.chakram_positive_modifier - SCConfig.chakram_negative_modifier), SCConfig.chakram_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_SCYTHE = ITEMS.register("black_steel_scythe", () ->
            new BlackSteelSwordItem((SCConfig.scythe_positive_modifier - SCConfig.scythe_negative_modifier), SCConfig.scythe_attackspeed));
    public static final RegistryObject<Item> BLACK_STEEL_HALBERD = ITEMS.register("black_steel_halberd", () ->
            new BlackSteelSwordItem((SCConfig.halberd_positive_modifier - SCConfig.halberd_negative_modifier), SCConfig.halberd_attackspeed));

    // CURSIUM WEAPONS
    public static final RegistryObject<Item> CURSIUM_LONGSWORD = ITEMS.register("cursium_longsword", () ->
            new CursiumSwordItem((SCConfig.longsword_positive_modifier - SCConfig.longsword_negative_modifier), SCConfig.longsword_attackspeed));
    public static final RegistryObject<Item> CURSIUM_TWINBLADE = ITEMS.register("cursium_twinblade", () ->
            new CursiumSwordItem((SCConfig.twinblade_positive_modifier - SCConfig.twinblade_negative_modifier), SCConfig.twinblade_attackspeed));
    public static final RegistryObject<Item> CURSIUM_RAPIER = ITEMS.register("cursium_rapier", () ->
            new CursiumSwordItem((SCConfig.rapier_positive_modifier - SCConfig.rapier_negative_modifier), SCConfig.rapier_attackspeed));
    public static final RegistryObject<Item> CURSIUM_KATANA = ITEMS.register("cursium_katana", () ->
            new CursiumSwordItem((SCConfig.katana_positive_modifier - SCConfig.katana_negative_modifier), SCConfig.katana_attackspeed));
    public static final RegistryObject<Item> CURSIUM_SAI = ITEMS.register("cursium_sai", () ->
            new CursiumSwordItem((SCConfig.sai_positive_modifier - SCConfig.sai_negative_modifier), SCConfig.sai_attackspeed));
    public static final RegistryObject<Item> CURSIUM_SPEAR = ITEMS.register("cursium_spear", () ->
            new CursiumSwordItem((SCConfig.spear_positive_modifier - SCConfig.spear_negative_modifier), SCConfig.spear_attackspeed));
    public static final RegistryObject<Item> CURSIUM_GLAIVE = ITEMS.register("cursium_glaive", () ->
            new CursiumSwordItem((SCConfig.glaive_positive_modifier - SCConfig.glaive_negative_modifier), SCConfig.glaive_attackspeed));
    public static final RegistryObject<Item> CURSIUM_WARGLAIVE = ITEMS.register("cursium_warglaive", () ->
            new CursiumSwordItem((SCConfig.warglaive_positive_modifier - SCConfig.warglaive_negative_modifier), SCConfig.warglaive_attackspeed));
    public static final RegistryObject<Item> CURSIUM_CUTLASS = ITEMS.register("cursium_cutlass", () ->
            new CursiumSwordItem((SCConfig.cutlass_positive_modifier - SCConfig.cutlass_negative_modifier), SCConfig.cutlass_attackspeed));
    public static final RegistryObject<Item> CURSIUM_CLAYMORE = ITEMS.register("cursium_claymore", () ->
            new CursiumSwordItem((SCConfig.claymore_positive_modifier - SCConfig.claymore_negative_modifier), SCConfig.claymore_attackspeed));
    public static final RegistryObject<Item> CURSIUM_GREATHAMMER = ITEMS.register("cursium_greathammer", () ->
            new CursiumSwordItem((SCConfig.greathammer_positive_modifier - SCConfig.greathammer_negative_modifier), SCConfig.greathammer_attackspeed));
    public static final RegistryObject<Item> CURSIUM_GREATAXE = ITEMS.register("cursium_greataxe", () ->
            new CursiumSwordItem((SCConfig.greataxe_positive_modifier - SCConfig.greataxe_negative_modifier), SCConfig.greataxe_attackspeed));
    public static final RegistryObject<Item> CURSIUM_CHAKRAM = ITEMS.register("cursium_chakram", () ->
            new CursiumSwordItem((SCConfig.chakram_positive_modifier - SCConfig.chakram_negative_modifier), SCConfig.chakram_attackspeed));
    public static final RegistryObject<Item> CURSIUM_SCYTHE = ITEMS.register("cursium_scythe", () ->
            new CursiumSwordItem((SCConfig.scythe_positive_modifier - SCConfig.scythe_negative_modifier), SCConfig.scythe_attackspeed));
    public static final RegistryObject<Item> CURSIUM_HALBERD = ITEMS.register("cursium_halberd", () ->
            new CursiumSwordItem((SCConfig.halberd_positive_modifier - SCConfig.halberd_negative_modifier), SCConfig.halberd_attackspeed));

    // IGNITIUM WEAPONS
    public static final RegistryObject<Item> IGNITIUM_LONGSWORD = ITEMS.register("ignitium_longsword", () ->
            new IgnitiumSwordItem((SCConfig.longsword_positive_modifier - SCConfig.longsword_negative_modifier), SCConfig.longsword_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_TWINBLADE = ITEMS.register("ignitium_twinblade", () ->
            new IgnitiumSwordItem((SCConfig.twinblade_positive_modifier - SCConfig.twinblade_negative_modifier), SCConfig.twinblade_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_RAPIER = ITEMS.register("ignitium_rapier", () ->
            new IgnitiumSwordItem((SCConfig.rapier_positive_modifier - SCConfig.rapier_negative_modifier), SCConfig.rapier_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_KATANA = ITEMS.register("ignitium_katana", () ->
            new IgnitiumSwordItem((SCConfig.katana_positive_modifier - SCConfig.katana_negative_modifier), SCConfig.katana_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_SAI = ITEMS.register("ignitium_sai", () ->
            new IgnitiumSwordItem((SCConfig.sai_positive_modifier - SCConfig.sai_negative_modifier), SCConfig.sai_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_SPEAR = ITEMS.register("ignitium_spear", () ->
            new IgnitiumSwordItem((SCConfig.spear_positive_modifier - SCConfig.spear_negative_modifier), SCConfig.spear_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_GLAIVE = ITEMS.register("ignitium_glaive", () ->
            new IgnitiumSwordItem((SCConfig.glaive_positive_modifier - SCConfig.glaive_negative_modifier), SCConfig.glaive_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_WARGLAIVE = ITEMS.register("ignitium_warglaive", () ->
            new IgnitiumSwordItem((SCConfig.warglaive_positive_modifier - SCConfig.warglaive_negative_modifier), SCConfig.warglaive_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_CUTLASS = ITEMS.register("ignitium_cutlass", () ->
            new IgnitiumSwordItem((SCConfig.cutlass_positive_modifier - SCConfig.cutlass_negative_modifier), SCConfig.cutlass_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_CLAYMORE = ITEMS.register("ignitium_claymore", () ->
            new IgnitiumSwordItem((SCConfig.claymore_positive_modifier - SCConfig.claymore_negative_modifier), SCConfig.claymore_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_GREATHAMMER = ITEMS.register("ignitium_greathammer", () ->
            new IgnitiumSwordItem((SCConfig.greathammer_positive_modifier - SCConfig.greathammer_negative_modifier), SCConfig.greathammer_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_GREATAXE = ITEMS.register("ignitium_greataxe", () ->
            new IgnitiumSwordItem((SCConfig.greataxe_positive_modifier - SCConfig.greataxe_negative_modifier), SCConfig.greataxe_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_CHAKRAM = ITEMS.register("ignitium_chakram", () ->
            new IgnitiumSwordItem((SCConfig.chakram_positive_modifier - SCConfig.chakram_negative_modifier), SCConfig.chakram_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_SCYTHE = ITEMS.register("ignitium_scythe", () ->
            new IgnitiumSwordItem((SCConfig.scythe_positive_modifier - SCConfig.scythe_negative_modifier), SCConfig.scythe_attackspeed));
    public static final RegistryObject<Item> IGNITIUM_HALBERD = ITEMS.register("ignitium_halberd", () ->
            new IgnitiumSwordItem((SCConfig.halberd_positive_modifier - SCConfig.halberd_negative_modifier), SCConfig.halberd_attackspeed));

    // WITHERITE WEAPONS
    public static final RegistryObject<Item> WITHERITE_LONGSWORD = ITEMS.register("witherite_longsword", () ->
            new WitheriteSwordItem((SCConfig.longsword_positive_modifier - SCConfig.longsword_negative_modifier), SCConfig.longsword_attackspeed));
    public static final RegistryObject<Item> WITHERITE_TWINBLADE = ITEMS.register("witherite_twinblade", () ->
            new WitheriteSwordItem((SCConfig.twinblade_positive_modifier - SCConfig.twinblade_negative_modifier), SCConfig.twinblade_attackspeed));
    public static final RegistryObject<Item> WITHERITE_RAPIER = ITEMS.register("witherite_rapier", () ->
            new WitheriteSwordItem((SCConfig.rapier_positive_modifier - SCConfig.rapier_negative_modifier), SCConfig.rapier_attackspeed));
    public static final RegistryObject<Item> WITHERITE_KATANA = ITEMS.register("witherite_katana", () ->
            new WitheriteSwordItem((SCConfig.katana_positive_modifier - SCConfig.katana_negative_modifier), SCConfig.katana_attackspeed));
    public static final RegistryObject<Item> WITHERITE_SAI = ITEMS.register("witherite_sai", () ->
            new WitheriteSwordItem((SCConfig.sai_positive_modifier - SCConfig.sai_negative_modifier), SCConfig.sai_attackspeed));
    public static final RegistryObject<Item> WITHERITE_SPEAR = ITEMS.register("witherite_spear", () ->
            new WitheriteSwordItem((SCConfig.spear_positive_modifier - SCConfig.spear_negative_modifier), SCConfig.spear_attackspeed));
    public static final RegistryObject<Item> WITHERITE_GLAIVE = ITEMS.register("witherite_glaive", () ->
            new WitheriteSwordItem((SCConfig.glaive_positive_modifier - SCConfig.glaive_negative_modifier), SCConfig.glaive_attackspeed));
    public static final RegistryObject<Item> WITHERITE_WARGLAIVE = ITEMS.register("witherite_warglaive", () ->
            new WitheriteSwordItem((SCConfig.warglaive_positive_modifier - SCConfig.warglaive_negative_modifier), SCConfig.warglaive_attackspeed));
    public static final RegistryObject<Item> WITHERITE_CUTLASS = ITEMS.register("witherite_cutlass", () ->
            new WitheriteSwordItem((SCConfig.cutlass_positive_modifier - SCConfig.cutlass_negative_modifier), SCConfig.cutlass_attackspeed));
    public static final RegistryObject<Item> WITHERITE_CLAYMORE = ITEMS.register("witherite_claymore", () ->
            new WitheriteSwordItem((SCConfig.claymore_positive_modifier - SCConfig.claymore_negative_modifier), SCConfig.claymore_attackspeed));
    public static final RegistryObject<Item> WITHERITE_GREATHAMMER = ITEMS.register("witherite_greathammer", () ->
            new WitheriteSwordItem((SCConfig.greathammer_positive_modifier - SCConfig.greathammer_negative_modifier), SCConfig.greathammer_attackspeed));
    public static final RegistryObject<Item> WITHERITE_GREATAXE = ITEMS.register("witherite_greataxe", () ->
            new WitheriteSwordItem((SCConfig.greataxe_positive_modifier - SCConfig.greataxe_negative_modifier), SCConfig.greataxe_attackspeed));
    public static final RegistryObject<Item> WITHERITE_CHAKRAM = ITEMS.register("witherite_chakram", () ->
            new WitheriteSwordItem((SCConfig.chakram_positive_modifier - SCConfig.chakram_negative_modifier), SCConfig.chakram_attackspeed));
    public static final RegistryObject<Item> WITHERITE_SCYTHE = ITEMS.register("witherite_scythe", () ->
            new WitheriteSwordItem((SCConfig.scythe_positive_modifier - SCConfig.scythe_negative_modifier), SCConfig.scythe_attackspeed));
    public static final RegistryObject<Item> WITHERITE_HALBERD = ITEMS.register("witherite_halberd", () ->
            new WitheriteSwordItem((SCConfig.halberd_positive_modifier - SCConfig.halberd_negative_modifier), SCConfig.halberd_attackspeed));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
