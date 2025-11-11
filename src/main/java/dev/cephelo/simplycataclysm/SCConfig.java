package dev.cephelo.simplycataclysm;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = SimplyCataclysm.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SCConfig
{
    private static final ForgeConfigSpec.BooleanValue
            MECHA_SMITE_REGEN_THRESHOLD_TYPE,
            CUSTOM_SOUNDS,
            USE_SPARTAN_EFFECTS;

    private static final ForgeConfigSpec.DoubleValue
            ACCURSED_RAGE_CHANCE,
            ACCURSED_RAGE_EXTRA_DAMAGE,
            BLAZING_BRAND_CHANCE,
            BLAZING_BRAND_LIFESTEAL_CHANCE,
            BLAZING_BRAND_ARMOR_REDUCTION,
            BLAZING_BRAND_ARMOR_TOUGHNESS_REDUCTION,
            MECHA_SMITE_CHANCE,
            MECHA_SMITE_REGEN_CHANCE,
            LIFESTEAL_MULTIPLIER,
            MECHA_PULSE_CHARGE_CHANCE,
            MECHA_PULSE_EXTRA_DAMAGE,
            MECHA_SMITE_REGEN_THRESHOLD_PERCENT,
            PITCH_VARIATION;//,
//            CHAKRAM_SPEEDMOD,
//            CLAYMORE_SPEEDMOD,
//            CUTLASS_SPEEDMOD,
//            GLAIVE_SPEEDMOD,
//            GREATAXE_SPEEDMOD,
//            GREATHAMMER_SPEEDMOD,
//            HALBERD_SPEEDMOD,
//            KATANA_SPEEDMOD,
//            LONGSWORD_SPEEDMOD,
//            RAPIER_SPEEDMOD,
//            SAI_SPEEDMOD,
//            SCYTHE_SPEEDMOD,
//            SPEAR_SPEEDMOD,
//            TWINBLADE_SPEEDMOD,
//            WARGLAIVE_SPEEDMOD;

    private static final ForgeConfigSpec.IntValue
            ANCIENT_METAL_DAMAGE,
            BLACK_STEEL_DAMAGE,
            CURSIUM_DAMAGE,
            IGNITIUM_DAMAGE,
            WITHERITE_DAMAGE,
            ANCIENT_METAL_SPEED,
            BLACK_STEEL_SPEED,
            CURSIUM_SPEED,
            IGNITIUM_SPEED,
            WITHERITE_SPEED,
            ACCURSED_RAGE_DURATION,
            ACCURSED_RAGE_MAXIMUM,
            BLAZING_BRAND_DURATION,
            BLAZING_BRAND_MAXIMUM,
            MECHA_PULSE_EFFECT_DURATION,
            MECHA_PULSE_STUN_THRESHOLD,
            MECHA_PULSE_COOLDOWN,
            MECHA_PULSE_STUN_DURATION,
            MECHA_SMITE_FIRE_DURATION,
            MECHA_SMITE_WITHER_DURATION,
            MECHA_SMITE_WITHER_AMP,
            MECHA_SMITE_REGEN_THRESHOLD,
            MECHA_SMITE_REGEN_DURATION,
            MECHA_SMITE_REGEN_AMP;//,
//            CHAKRAM_NDMOD,
//            CLAYMORE_NDMOD,
//            CUTLASS_NDMOD,
//            GLAIVE_NDMOD,
//            GREATAXE_NDMOD,
//            GREATHAMMER_NDMOD,
//            HALBERD_NDMOD,
//            KATANA_NDMOD,
//            LONGSWORD_NDMOD,
//            RAPIER_NDMOD,
//            SAI_NDMOD,
//            SCYTHE_NDMOD,
//            SPEAR_NDMOD,
//            TWINBLADE_NDMOD,
//            WARGLAIVE_NDMOD,
//            CHAKRAM_PDMOD,
//            CLAYMORE_PDMOD,
//            CUTLASS_PDMOD,
//            GLAIVE_PDMOD,
//            GREATAXE_PDMOD,
//            GREATHAMMER_PDMOD,
//            HALBERD_PDMOD,
//            KATANA_PDMOD,
//            LONGSWORD_PDMOD,
//            RAPIER_PDMOD,
//            SAI_PDMOD,
//            SCYTHE_PDMOD,
//            SPEAR_PDMOD,
//            TWINBLADE_PDMOD,
//            WARGLAIVE_PDMOD;

    static final ForgeConfigSpec SPEC;

    static {
        final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

        BUILDER.comment(" SPARTAN CATACLYSM CONFIG\n");

        BUILDER.push("Material Modifiers");

        ANCIENT_METAL_DAMAGE = BUILDER
                .comment(" Attack Damage Modifier for Ancient Metal weapons.  Requires restart.")
                .defineInRange("ancientMetalDamageModifier", 0, -10000, 10000);

        ANCIENT_METAL_SPEED = BUILDER
                .comment(" Attack Speed Modifier for Ancient Metal weapons.  Requires restart.")
                .defineInRange("ancientMetalSpeedModifier", 0, -10000, 10000);

        BLACK_STEEL_DAMAGE = BUILDER
                .comment(" Attack Damage Modifier for Black Steel weapons.  Requires restart.")
                .defineInRange("blackSteelDamageModifier", 0, -10000, 10000);

        BLACK_STEEL_SPEED = BUILDER
                .comment(" Attack Speed Modifier for Black Steel weapons.  Requires restart.")
                .defineInRange("blackSteelSpeedModifier", 0, -10000, 10000);

        CURSIUM_DAMAGE = BUILDER
                .comment(" Attack Damage Modifier for Cursium weapons.  Requires restart.")
                .defineInRange("cursiumDamageModifier", 0, -10000, 10000);

        CURSIUM_SPEED = BUILDER
                .comment(" Attack Speed Modifier for Cursium weapons.  Requires restart.")
                .defineInRange("cursiumSpeedModifier", 0, -10000, 10000);

        IGNITIUM_DAMAGE = BUILDER
                .comment(" Attack Damage Modifier for Ignitium weapons.  Requires restart.")
                .defineInRange("ignitiumDamageModifier", 0, -10000, 10000);

        IGNITIUM_SPEED = BUILDER
                .comment(" Attack Speed Modifier for Ignitium weapons.  Requires restart.")
                .defineInRange("ignitiumSpeedModifier", 0, -10000, 10000);

        WITHERITE_DAMAGE = BUILDER
                .comment(" Attack Damage Modifier for Witherite weapons.  Requires restart.")
                .defineInRange("witheriteDamageModifier", 0, -10000, 10000);

        WITHERITE_SPEED = BUILDER
                .comment(" Attack Speed Modifier for Witherite weapons.  Requires restart.")
                .defineInRange("witheriteSpeedModifier", 0, -10000, 10000);

        BUILDER.pop();

        // ACCURSED RAGE OPTIONS
        BUILDER.push("Accursed Rage Options");

        ACCURSED_RAGE_CHANCE = BUILDER
                .comment(" Chance on hit for Cursium weapons to stack the Accursed Rage effect on the user.  Set to 0 to disable.")
                .defineInRange("accursedRageChance", 0.66, 0.0, 1.0);

        ACCURSED_RAGE_EXTRA_DAMAGE = BUILDER
                .comment(" Additional damage attackers do with Cursium weapons per level of Accursed Rage.")
                .defineInRange("accursedRageExtraDamage", 1.0, 0, Double.MAX_VALUE);

        ACCURSED_RAGE_DURATION = BUILDER
                .comment(" Duration (ticks) of the Accursed Rage effect granted by Cursium weapons.")
                .defineInRange("accursedRageDuration", 110, 0, Integer.MAX_VALUE);

        ACCURSED_RAGE_MAXIMUM = BUILDER
                .comment(" Maximum amplifier the Accursed Rage effect can reach using Cursium weapons.")
                .defineInRange("accursedRageMaxAmplifier", 4, 0, Integer.MAX_VALUE);

        BUILDER.pop();

        // BLAZING BRAND OPTIONS
        BUILDER.push("Blazing Brand Options");

        BLAZING_BRAND_CHANCE = BUILDER
                .comment(" Chance on hit for Ignitium weapons to stack the Blazing Brand effect onto attacked entities.  Set to 0 to disable.")
                .defineInRange("blazingBrandChance", 0.75, 0.0, 1.0);

        BLAZING_BRAND_LIFESTEAL_CHANCE = BUILDER
                .comment(" Chance on hit for Ignitium weapons to grant lifesteal to the user.  Blazing Brand trait must have hit successfully - for example, if blazingBrandChance is 0 then lifesteal will never be given.  Set to 0 to disable.")
                .defineInRange("blazingBrandLifestealChance", 1.0, 0.0, 1.0);

        LIFESTEAL_MULTIPLIER = BUILDER
                .comment(" Lifesteal multiplier for Ignitium weapons.  Lifesteal amount depends on attack speed, so rate should correlates with DPS.  Set to 0 to disable lifesteal.")
                .defineInRange("lifestealMultiplier", 1.25, 0.0, Double.MAX_VALUE);

        BLAZING_BRAND_DURATION = BUILDER
                .comment(" Duration (ticks) of the Blazing Brand effect inflicted by Ignitium weapons.  Default is identical to Ignis' abilities.")
                .defineInRange("blazingBrandDuration", 240, 0, Integer.MAX_VALUE);

        BLAZING_BRAND_MAXIMUM = BUILDER
                .comment(" Maximum amplifier the Blazing Brand effect can reach using Ignitium weapons.  Default is identical to Ignis' abilities.")
                .defineInRange("blazingBrandMaxAmplifier", 4, 0, Integer.MAX_VALUE);

        BLAZING_BRAND_ARMOR_REDUCTION = BUILDER
                .comment(" Multiplier (per amplifier) that entities afflicted with Brazing Brand will have its Armor attribute reduced by.  Default is identical to Ignis' abilities.  Requires restart.")
                .defineInRange("blazingBrandArmorMultiplier", 0.2, 0.0, 1.0);

        BLAZING_BRAND_ARMOR_TOUGHNESS_REDUCTION = BUILDER
                .comment(" Multiplier (per amplifier) that entities afflicted with Brazing Brand will have its Armor Toughness attribute reduced by.  Default is identical to Ignis' abilities.  Requires restart.")
                .defineInRange("blazingBrandArmorToughnessMultiplier", 0.2, 0.0, 1.0);

        BUILDER.pop();

        // MECHA PULSE OPTIONS
        BUILDER.push("Mecha Pulse Options");

        MECHA_PULSE_CHARGE_CHANCE = BUILDER
                .comment(" Chance on hit for Witherite weapons to stack the Pulse Charge effect on the user.  Set to 0 to disable.")
                .defineInRange("mechaPulseChargeChance", 0.75, 0.0, 1.0);

        MECHA_PULSE_EFFECT_DURATION = BUILDER
                .comment(" Duration (ticks) of the Pulse Charge effect granted by Witherite weapons.")
                .defineInRange("mechaPulseEffectDuration", 140, 0, Integer.MAX_VALUE);

        MECHA_PULSE_STUN_THRESHOLD = BUILDER
                .comment(" Amplifier of the Pulse Charge effect at which a shockwave is released, stunning the target.")
                .defineInRange("mechaPulseStunThreshold", 9, 0, Integer.MAX_VALUE);

        MECHA_PULSE_COOLDOWN = BUILDER
                .comment(" Duration (ticks) of the Pulse Cooldown effect inflicted upon Witherite weapons releasing a shockwave.  Pulse Charge cannot accumulate while this effect is active.")
                .defineInRange("mechaPulseCooldown", 800, 0, Integer.MAX_VALUE);

        MECHA_PULSE_STUN_DURATION = BUILDER
                .comment(" Stun duration (ticks) inflicted by Witherite weapons when a shockwave is released.")
                .defineInRange("mechaPulseStunDuration", 200, 0, Integer.MAX_VALUE);

        MECHA_PULSE_EXTRA_DAMAGE = BUILDER
                .comment(" Additional damage a shockwave does when released.")
                .defineInRange("mechaPulseStunDamage", 4.0, 0.0, Double.MAX_VALUE);

        BUILDER.pop();

        // MECHA SMITE OPTIONS
        BUILDER.push("Mecha Smite Options");

        MECHA_SMITE_CHANCE = BUILDER
                .comment(" Chance on hit for Witherite weapons to set the target on fire and apply Wither.  Set to 0 to disable.")
                .defineInRange("mechaSmiteHarmfulEffectsChance", 1.0, 0.0, 1.0);

        MECHA_SMITE_FIRE_DURATION = BUILDER
                .comment(" Duration (seconds) of the Fire applied by Witherite weapons.  Set to 0 to disable.")
                .defineInRange("mechaSmiteFireDuration", 5, 0, Integer.MAX_VALUE);

        MECHA_SMITE_WITHER_DURATION = BUILDER
                .comment(" Duration (ticks) of the Wither effect applied to the target by Witherite weapons.  Set to 0 to disable.")
                .defineInRange("mechaSmiteWitherDuration", 100, 0, Integer.MAX_VALUE);

        MECHA_SMITE_WITHER_AMP = BUILDER
                .comment(" Amplifier of the Wither effect applied to the target by Witherite weapons.")
                .defineInRange("mechaSmiteWitherAmplifier", 1, 0, Integer.MAX_VALUE);

        MECHA_SMITE_REGEN_CHANCE = BUILDER
                .comment(" Chance on hit for Witherite weapons apply regeneration to the user when under health threshold.  Set to 0 to disable.")
                .defineInRange("mechaSmiteRegenChance", 0.5, 0.0, Double.MAX_VALUE);

        MECHA_SMITE_REGEN_THRESHOLD_TYPE = BUILDER
                .comment(" Whether Witherite weapons should apply Regeneration to the user at a certain health percentage (true), or at a defined health amount (false).")
                .define("mechaSmiteRegenUsesPercentage", true);

        MECHA_SMITE_REGEN_THRESHOLD_PERCENT = BUILDER
                .comment(" If mechaSmiteRegenUsesPercentage is true, Witherite weapons will apply Regeneration to the user when under this percentage of health.  Set to 0 to disable.")
                .defineInRange("mechaSmiteRegenPercentage", 0.5, 0.0, Double.MAX_VALUE);

        MECHA_SMITE_REGEN_THRESHOLD = BUILDER
                .comment(" If mechaSmiteRegenUsesPercentage is false, Witherite weapons will apply Regeneration to the user when under this amount of health.  Set to 0 to disable.")
                .defineInRange("mechaSmiteRegenThreshold", 10, 0, Integer.MAX_VALUE);

        MECHA_SMITE_REGEN_DURATION = BUILDER
                .comment(" Duration (ticks) of the Regeneration effect applied to the user by Witherite weapons.")
                .defineInRange("mechaSmiteRegenDuration", 100, 0, Integer.MAX_VALUE);

        MECHA_SMITE_REGEN_AMP = BUILDER
                .comment(" Amplifier of the Regeneration effect applied to the user by Witherite weapons.")
                .defineInRange("mechaSmiteRegenAmplifier", 1, 0, Integer.MAX_VALUE);

        BUILDER.pop();

        // WEAPON TYPE MODIFIERS
//        BUILDER.push("SimplySwords Weapon Type Modifiers");
//
//        CHAKRAM_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Chakrams added by this mod.  Requires restart.")
//                .defineInRange("chakram_negativeDamageModifier", 1, 0, 10000);
//
//        CHAKRAM_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Chakrams added by this mod.  Requires restart.")
//                .defineInRange("chakram_positiveDamageModifier", 0, 0, 10000);
//
//        CHAKRAM_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Chakrams added by this mod.  Requires restart.")
//                .defineInRange("chakram_attackspeed", -3.0, -10000.0, 10000.0);
//
//        CLAYMORE_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Claymores added by this mod.  Requires restart.")
//                .defineInRange("claymore_negativeDamageModifier", 0, 0, 10000);
//
//        CLAYMORE_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Claymores added by this mod.  Requires restart.")
//                .defineInRange("claymore_positiveDamageModifier", 2, 0, 10000);
//
//        CLAYMORE_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Claymores added by this mod.  Requires restart.")
//                .defineInRange("claymore_attackspeed", -2.8, -10000.0, 10000.0);
//
//        CUTLASS_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Cutlasses added by this mod.  Requires restart.")
//                .defineInRange("cutlass_negativeDamageModifier", 0, 0, 10000);
//
//        CUTLASS_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Cutlasses added by this mod.  Requires restart.")
//                .defineInRange("cutlass_positiveDamageModifier", 0, 0, 10000);
//
//        CUTLASS_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Cutlasses added by this mod.  Requires restart.")
//                .defineInRange("cutlass_attackspeed", -2.0, -10000.0, 10000.0);
//
//        GLAIVE_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Glaives added by this mod.  Requires restart.")
//                .defineInRange("glaive_negativeDamageModifier", 0, 0, 10000);
//
//        GLAIVE_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Glaives added by this mod.  Requires restart.")
//                .defineInRange("glaive_positiveDamageModifier", 0, 0, 10000);
//
//        GLAIVE_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Glaives added by this mod.  Requires restart.")
//                .defineInRange("glaive_attackspeed", -2.6, -10000.0, 10000.0);
//
//        GREATAXE_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Greataxes added by this mod.  Requires restart.")
//                .defineInRange("greataxe_negativeDamageModifier", 0, 0, 10000);
//
//        GREATAXE_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Greataxes added by this mod.  Requires restart.")
//                .defineInRange("greataxe_positiveDamageModifier", 3, 0, 10000);
//
//        GREATAXE_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Greataxes added by this mod.  Requires restart.")
//                .defineInRange("greataxe_attackspeed", -3.1, -10000.0, 10000.0);
//
//        GREATHAMMER_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Greathammers added by this mod.  Requires restart.")
//                .defineInRange("greathammer_negativeDamageModifier", 0, 0, 10000);
//
//        GREATHAMMER_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Greathammers added by this mod.  Requires restart.")
//                .defineInRange("greathammer_positiveDamageModifier", 4, 0, 10000);
//
//        GREATHAMMER_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Greathammers added by this mod.  Requires restart.")
//                .defineInRange("greathammer_attackspeed", -3.2, -10000.0, 10000.0);
//
//        HALBERD_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Halberds added by this mod.  Requires restart.")
//                .defineInRange("halberd_negativeDamageModifier", 0, 0, 10000);
//
//        HALBERD_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Halberds added by this mod.  Requires restart.")
//                .defineInRange("halberd_positiveDamageModifier", 3, 0, 10000);
//
//        HALBERD_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Halberds added by this mod.  Requires restart.")
//                .defineInRange("halberd_attackspeed", -2.8, -10000.0, 10000.0);
//
//        KATANA_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Katanas added by this mod.  Requires restart.")
//                .defineInRange("katana_negativeDamageModifier", 0, 0, 10000);
//
//        KATANA_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Katanas added by this mod.  Requires restart.")
//                .defineInRange("katana_positiveDamageModifier", 0, 0, 10000);
//
//        KATANA_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Katanas added by this mod.  Requires restart.")
//                .defineInRange("katana_attackspeed", -2.0, -10000.0, 10000.0);
//
//        LONGSWORD_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Longswords added by this mod.  Requires restart.")
//                .defineInRange("longsword_negativeDamageModifier", 0, 0, 10000);
//
//        LONGSWORD_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Longswords added by this mod.  Requires restart.")
//                .defineInRange("longsword_positiveDamageModifier", 0, 0, 10000);
//
//        LONGSWORD_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Longswords added by this mod.  Requires restart.")
//                .defineInRange("longsword_attackspeed", -2.4, -10000.0, 10000.0);
//
//        RAPIER_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Rapiers added by this mod.  Requires restart.")
//                .defineInRange("rapier_negativeDamageModifier", 1, 0, 10000);
//
//        RAPIER_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Rapiers added by this mod.  Requires restart.")
//                .defineInRange("rapier_positiveDamageModifier", 0, 0, 10000);
//
//        RAPIER_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Rapiers added by this mod.  Requires restart.")
//                .defineInRange("rapier_attackspeed", -1.8, -10000.0, 10000.0);
//
//        SAI_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Sai added by this mod.  Requires restart.")
//                .defineInRange("sai_negativeDamageModifier", 3, 0, 10000);
//
//        SAI_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Sai added by this mod.  Requires restart.")
//                .defineInRange("sai_positiveDamageModifier", 0, 0, 10000);
//
//        SAI_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Sai added by this mod.  Requires restart.")
//                .defineInRange("sai_attackspeed", -1.5, -10000.0, 10000.0);
//
//        SCYTHE_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Scythes added by this mod.  Requires restart.")
//                .defineInRange("scythe_negativeDamageModifier", 0, 0, 10000);
//
//        SCYTHE_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Scythes added by this mod.  Requires restart.")
//                .defineInRange("scythe_positiveDamageModifier", 1, 0, 10000);
//
//        SCYTHE_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Scythes added by this mod.  Requires restart.")
//                .defineInRange("scythe_attackspeed", -2.7, -10000.0, 10000.0);
//
//        SPEAR_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Spears added by this mod.  Requires restart.")
//                .defineInRange("spear_negativeDamageModifier", 0, 0, 10000);
//
//        SPEAR_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Spears added by this mod.  Requires restart.")
//                .defineInRange("spear_positiveDamageModifier", 0, 0, 10000);
//
//        SPEAR_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Spears added by this mod.  Requires restart.")
//                .defineInRange("spear_attackspeed", -2.7, -10000.0, 10000.0);
//
//        TWINBLADE_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Twinblades added by this mod.  Requires restart.")
//                .defineInRange("twinblade_negativeDamageModifier", 0, 0, 10000);
//
//        TWINBLADE_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Twinblades added by this mod.  Requires restart.")
//                .defineInRange("twinblade_positiveDamageModifier", 0, 0, 10000);
//
//        TWINBLADE_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Twinblades added by this mod.  Requires restart.")
//                .defineInRange("twinblade_attackspeed", -2.0, -10000.0, 10000.0);
//
//        WARGLAIVE_NDMOD = BUILDER
//                .comment(" Negative Attack Damage Modifier for Warglaives added by this mod.  Requires restart.")
//                .defineInRange("warglaive_negativeDamageModifier", 0, 0, 10000);
//
//        WARGLAIVE_PDMOD = BUILDER
//                .comment(" Positive Attack Damage Modifier for Warglaives added by this mod.  Requires restart.")
//                .defineInRange("warglaive_positiveDamageModifier", 0, 0, 10000);
//
//        WARGLAIVE_SPEEDMOD = BUILDER
//                .comment(" Attack Speed Modifier for Warglaives added by this mod.  Requires restart.")
//                .defineInRange("warglaive_attackspeed", -2.2, -10000.0, 10000.0);
//
//        BUILDER.pop();

        // MISC OPTIONS
        BUILDER.push("Miscellaneous Options");

        CUSTOM_SOUNDS = BUILDER
                .comment(" Enable/Disable Ignitium, Cursium, and Witherite weapons making custom sounds when attacking.")
                .define("customWeaponSounds", true);

        PITCH_VARIATION = BUILDER
                .comment(" Pitch variation from 1.0 for custom weapon attack sounds.  For example: Set to 0.1, pitch will be random between 0.9 and 1.1.  Set to 0.0 for no variation.")
                .defineInRange("customWeaponSoundsPitchVariation", 0.1, 0.0, 1.0);

        USE_SPARTAN_EFFECTS = BUILDER
                .comment(" If Spartan Weaponry: Cataclysm is installed, use its effects instead to avoid double-stacking.  The Blazing Brand effect will use Spartan Cataclysm's armor reduction config values as a result.")
                .comment(" All other config values pertaining to effects will still be properly respected by both mods, allowing for different configurations.")
                .comment(" HIGHLY RECOMMENDED TO KEEP SET TO TRUE - If false, two of the same effect could be applied simultaneously by using weapons from both mods :/")
                .define("useSpartanCataclysmEffects", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public static int ancientMetalDamageModifier;
    public static int ancientMetalSpeedModifier;
    public static int blackSteelDamageModifier;
    public static int blackSteelSpeedModifier;
    public static int cursiumDamageModifier;
    public static int cursiumSpeedModifier;
    public static int ignitiumDamageModifier;
    public static int ignitiumSpeedModifier;
    public static int witheriteDamageModifier;
    public static int witheriteSpeedModifier;

    public static double accursedRageChance;
    public static double blazingBrandChance;
    public static double blazingBrandLifestealChance;
    public static double accursedRageExtraDamage;
    public static int accursedRageDuration;
    public static int accursedRageMaximum;
    public static double lifestealMultiplier;
    public static int blazingBrandDuration;
    public static int blazingBrandMaximum;
    public static double blazingBrandArmorReduction;
    public static double blazingBrandArmorToughnessReduction;

    public static double mechaPulseChargeChance;
    public static int mechaPulseStunThreshold;
    public static int mechaPulseCooldown;
    public static int mechaPulseStunDuration;
    public static int mechaPulseEffectDuration;
    public static double mechaPulseExtraDamage;

    public static double mechaSmiteChance;
    public static double mechaSmiteRegenChance;
    public static int mechaSmiteFireDuration;
    public static int mechaSmiteWitherDuration;
    public static int mechaSmiteWitherAmplifier;
    public static boolean mechaSmiteRegenThresholdType;
    public static double mechaSmiteRegenThresholdPercent;
    public static int mechaSmiteRegenThreshold;
    public static int mechaSmiteRegenDuration;
    public static int mechaSmiteRegenAmplifier;

//    public static float chakram_attackspeed;
//    public static int chakram_negative_modifier;
//    public static int chakram_positive_modifier;
//    public static float claymore_attackspeed;
//    public static int claymore_negative_modifier;
//    public static int claymore_positive_modifier;
//    public static float cutlass_attackspeed;
//    public static int cutlass_negative_modifier;
//    public static int cutlass_positive_modifier;
//    public static float glaive_attackspeed;
//    public static int glaive_negative_modifier;
//    public static int glaive_positive_modifier;
//    public static float greataxe_attackspeed;
//    public static int greataxe_negative_modifier;
//    public static int greataxe_positive_modifier;
//    public static float greathammer_attackspeed;
//    public static int greathammer_negative_modifier;
//    public static int greathammer_positive_modifier;
//    public static float halberd_attackspeed;
//    public static int halberd_negative_modifier;
//    public static int halberd_positive_modifier;
//    public static float katana_attackspeed;
//    public static int katana_negative_modifier;
//    public static int katana_positive_modifier;
//    public static float longsword_attackspeed;
//    public static int longsword_negative_modifier;
//    public static int longsword_positive_modifier;
//    public static float rapier_attackspeed;
//    public static int rapier_negative_modifier;
//    public static int rapier_positive_modifier;
//    public static float sai_attackspeed;
//    public static int sai_negative_modifier;
//    public static int sai_positive_modifier;
//    public static float scythe_attackspeed;
//    public static int scythe_negative_modifier;
//    public static int scythe_positive_modifier;
//    public static float spear_attackspeed;
//    public static int spear_negative_modifier;
//    public static int spear_positive_modifier;
//    public static float twinblade_attackspeed;
//    public static int twinblade_negative_modifier;
//    public static int twinblade_positive_modifier;
//    public static float warglaive_attackspeed;
//    public static int warglaive_negative_modifier;
//    public static int warglaive_positive_modifier;

    public static boolean customSounds;
    public static double pitchVariation;

    public static boolean useSpartanEffects;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        ancientMetalDamageModifier = ANCIENT_METAL_DAMAGE.get();
        ancientMetalSpeedModifier = ANCIENT_METAL_SPEED.get();
        blackSteelDamageModifier = BLACK_STEEL_DAMAGE.get();
        blackSteelSpeedModifier = BLACK_STEEL_SPEED.get();
        cursiumDamageModifier = CURSIUM_DAMAGE.get();
        cursiumSpeedModifier = CURSIUM_SPEED.get();
        ignitiumDamageModifier = IGNITIUM_DAMAGE.get();
        ignitiumSpeedModifier = IGNITIUM_SPEED.get();
        witheriteDamageModifier = WITHERITE_DAMAGE.get();
        witheriteSpeedModifier = WITHERITE_SPEED.get();

        accursedRageChance = ACCURSED_RAGE_CHANCE.get();
        blazingBrandChance = BLAZING_BRAND_CHANCE.get();
        blazingBrandLifestealChance = BLAZING_BRAND_LIFESTEAL_CHANCE.get();
        accursedRageExtraDamage = ACCURSED_RAGE_EXTRA_DAMAGE.get();
        accursedRageDuration = ACCURSED_RAGE_DURATION.get();
        accursedRageMaximum = ACCURSED_RAGE_MAXIMUM.get();
        lifestealMultiplier = LIFESTEAL_MULTIPLIER.get();
        blazingBrandDuration = BLAZING_BRAND_DURATION.get();
        blazingBrandMaximum = BLAZING_BRAND_MAXIMUM.get();
        blazingBrandArmorReduction = BLAZING_BRAND_ARMOR_REDUCTION.get();
        blazingBrandArmorToughnessReduction = BLAZING_BRAND_ARMOR_TOUGHNESS_REDUCTION.get();

        mechaPulseChargeChance = MECHA_PULSE_CHARGE_CHANCE.get();
        mechaPulseStunThreshold = MECHA_PULSE_STUN_THRESHOLD.get();
        mechaPulseCooldown = MECHA_PULSE_COOLDOWN.get();
        mechaPulseStunDuration = MECHA_PULSE_STUN_DURATION.get();
        mechaPulseEffectDuration = MECHA_PULSE_EFFECT_DURATION.get();
        mechaPulseExtraDamage = MECHA_PULSE_EXTRA_DAMAGE.get();

        mechaSmiteChance = MECHA_SMITE_CHANCE.get();
        mechaSmiteRegenChance = MECHA_SMITE_REGEN_CHANCE.get();
        mechaSmiteFireDuration = MECHA_SMITE_FIRE_DURATION.get();
        mechaSmiteWitherDuration = MECHA_SMITE_WITHER_DURATION.get();
        mechaSmiteWitherAmplifier = MECHA_SMITE_WITHER_AMP.get();
        mechaSmiteRegenThresholdType = MECHA_SMITE_REGEN_THRESHOLD_TYPE.get();
        mechaSmiteRegenThresholdPercent = MECHA_SMITE_REGEN_THRESHOLD_PERCENT.get();
        mechaSmiteRegenThreshold = MECHA_SMITE_REGEN_THRESHOLD.get();
        mechaSmiteRegenDuration = MECHA_SMITE_REGEN_DURATION.get();
        mechaSmiteRegenAmplifier = MECHA_SMITE_REGEN_AMP.get();

//        chakram_attackspeed = CHAKRAM_SPEEDMOD.get().floatValue();
//        chakram_negative_modifier = CHAKRAM_NDMOD.get();
//        chakram_positive_modifier = CHAKRAM_PDMOD.get();
//        claymore_attackspeed = CLAYMORE_SPEEDMOD.get().floatValue();
//        claymore_negative_modifier = CLAYMORE_NDMOD.get();
//        claymore_positive_modifier = CLAYMORE_PDMOD.get();
//        cutlass_attackspeed = CUTLASS_SPEEDMOD.get().floatValue();
//        cutlass_negative_modifier = CUTLASS_NDMOD.get();
//        cutlass_positive_modifier = CUTLASS_PDMOD.get();
//        glaive_attackspeed = GLAIVE_SPEEDMOD.get().floatValue();
//        glaive_negative_modifier = GLAIVE_NDMOD.get();
//        glaive_positive_modifier = GLAIVE_PDMOD.get();
//        greataxe_attackspeed = GREATAXE_SPEEDMOD.get().floatValue();
//        greataxe_negative_modifier = GREATAXE_NDMOD.get();
//        greataxe_positive_modifier = GREATAXE_PDMOD.get();
//        greathammer_attackspeed = GREATHAMMER_SPEEDMOD.get().floatValue();
//        greathammer_negative_modifier = GREATHAMMER_NDMOD.get();
//        greathammer_positive_modifier = GREATHAMMER_PDMOD.get();
//        halberd_attackspeed = HALBERD_SPEEDMOD.get().floatValue();
//        halberd_negative_modifier = HALBERD_NDMOD.get();
//        halberd_positive_modifier = HALBERD_PDMOD.get();
//        katana_attackspeed = KATANA_SPEEDMOD.get().floatValue();
//        katana_negative_modifier = KATANA_NDMOD.get();
//        katana_positive_modifier = KATANA_PDMOD.get();
//        longsword_attackspeed = LONGSWORD_SPEEDMOD.get().floatValue();
//        longsword_negative_modifier = LONGSWORD_NDMOD.get();
//        longsword_positive_modifier = LONGSWORD_PDMOD.get();
//        rapier_attackspeed = RAPIER_SPEEDMOD.get().floatValue();
//        rapier_negative_modifier = RAPIER_NDMOD.get();
//        rapier_positive_modifier = RAPIER_PDMOD.get();
//        sai_attackspeed = SAI_SPEEDMOD.get().floatValue();
//        sai_negative_modifier = SAI_NDMOD.get();
//        sai_positive_modifier = SAI_PDMOD.get();
//        scythe_attackspeed = SCYTHE_SPEEDMOD.get().floatValue();
//        scythe_negative_modifier = SCYTHE_NDMOD.get();
//        scythe_positive_modifier = SCYTHE_PDMOD.get();
//        spear_attackspeed = SPEAR_SPEEDMOD.get().floatValue();
//        spear_negative_modifier = SPEAR_NDMOD.get();
//        spear_positive_modifier = SPEAR_PDMOD.get();
//        twinblade_attackspeed = TWINBLADE_SPEEDMOD.get().floatValue();
//        twinblade_negative_modifier = TWINBLADE_NDMOD.get();
//        twinblade_positive_modifier = TWINBLADE_PDMOD.get();
//        warglaive_attackspeed = WARGLAIVE_SPEEDMOD.get().floatValue();
//        warglaive_negative_modifier = WARGLAIVE_NDMOD.get();
//        warglaive_positive_modifier = WARGLAIVE_PDMOD.get();

        customSounds = CUSTOM_SOUNDS.get();
        pitchVariation = PITCH_VARIATION.get();

        useSpartanEffects = USE_SPARTAN_EFFECTS.get();
    }

    public static float getRandomPitch() {
        return (float)((Math.random() * pitchVariation * 2.0) - pitchVariation + 1.0);
    }
}