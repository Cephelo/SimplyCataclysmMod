package dev.cephelo.simplycataclysm.effects;

import com.github.L_Ender.cataclysm.init.ModEffect;
import dev.cephelo.simplycataclysm.SCConfig;
import dev.cephelo.simplycataclysm.SimplyCataclysm;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.neoforge.common.EffectCure;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;
import java.util.function.Consumer;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, SimplyCataclysm.MODID);

    public static final DeferredHolder<MobEffect, MobEffect> ACCURSED_RAGE = MOB_EFFECTS.register("accursed_rage",
            () -> new AccursedMarkEffect(MobEffectCategory.BENEFICIAL, 0x39d2b2));
    public static final DeferredHolder<MobEffect, MobEffect> BLAZING_BRAND_CUSTOM = MOB_EFFECTS.register("blazing_brand",
            () -> new BlazingBrandCustomEffect(MobEffectCategory.HARMFUL, 0xdc143c));
    public static final DeferredHolder<MobEffect, MobEffect> PULSE_CHARGE = MOB_EFFECTS.register("pulse_charge",
            () -> new StunPulseChargeEffect(MobEffectCategory.BENEFICIAL, 0xae2334));
    public static final DeferredHolder<MobEffect, MobEffect> PULSE_COOLDOWN = MOB_EFFECTS.register("pulse_cooldown",
            () -> new StunPulseCooldownEffect(MobEffectCategory.NEUTRAL, 0x575757));

    public static void register(IEventBus bus) {
        MOB_EFFECTS.register(bus);
    }

    // Effect does nothing, everything is inside item/CursiumSwordItem
    public static class AccursedMarkEffect extends MobEffect {
        public AccursedMarkEffect(MobEffectCategory category, int color) {
            super(category, color);
        }
    }

    public static class BlazingBrandCustomEffect extends MobEffect {
        private static final ResourceLocation ARMOR_DOWN_ID =  ResourceLocation.fromNamespaceAndPath(SimplyCataclysm.MODID,"blazing_brand_armor");
        private static final ResourceLocation ARMOR_TOUGHNESS_DOWN_ID =  ResourceLocation.fromNamespaceAndPath(SimplyCataclysm.MODID,"blazing_brand_armor_toughness");

        public BlazingBrandCustomEffect(MobEffectCategory category, int color) {
            super(category, color);
            this.addAttributeModifier(Attributes.ARMOR, ARMOR_DOWN_ID, -1.0D * SCConfig.BLAZING_BRAND_ARMOR_REDUCTION.get(), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
            this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, ARMOR_TOUGHNESS_DOWN_ID, -1.0D * SCConfig.BLAZING_BRAND_ARMOR_TOUGHNESS_REDUCTION.get(), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        }

        // @Override
        // public void applyEffectTick(LivingEntity entity, int amplifier) {}

        @Override // isDurationEffectTick
        public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
            return duration > 0;
        }

        @Override // Use Cataclysm's Blazing Brand name
        public String getDescriptionId() {
            return "effect.cataclysm.blazing_brand";
        }

        @SuppressWarnings("removal")
        @Override // Use Cataclysm's Blazing Brand icon
        public void initializeClient(Consumer<IClientMobEffectExtensions> consumer) {
            consumer.accept(new CustomIconMobEffectExtensions(ModEffect.EFFECTBLAZING_BRAND));
        }

    }

    // Effect does nothing, everything is inside item/WitheriteSwordItem
    public static class StunPulseChargeEffect extends MobEffect {
        public StunPulseChargeEffect(MobEffectCategory category, int color) {
            super(category, color);
        }
    }

    // Effect does nothing, everything is inside item/WitheriteSwordItem
    public static class StunPulseCooldownEffect extends MobEffect {
        public StunPulseCooldownEffect(MobEffectCategory category, int color) {
            super(category, color);
        }
        @Override // getCurativeItems
        public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
            // Cannot be removed with milk
        }
    }
}
