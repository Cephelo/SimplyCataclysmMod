package dev.cephelo.simplycataclysm.effects;

import com.github.L_Ender.cataclysm.init.ModEffect;
import dev.cephelo.simplycataclysm.SCConfig;
import dev.cephelo.simplycataclysm.SimplyCataclysm;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SimplyCataclysm.MODID);

    public static final RegistryObject<MobEffect> ACCURSED_RAGE = MOB_EFFECTS.register("accursed_rage",
            () -> new AccursedMarkEffect(MobEffectCategory.BENEFICIAL, 0x39d2b2));
    public static final RegistryObject<MobEffect> BLAZING_BRAND_CUSTOM = MOB_EFFECTS.register("blazing_brand",
            () -> new BlazingBrandCustomEffect(MobEffectCategory.HARMFUL, 0xdc143c));
    public static final RegistryObject<MobEffect> PULSE_CHARGE = MOB_EFFECTS.register("pulse_charge",
            () -> new StunPulseChargeEffect(MobEffectCategory.BENEFICIAL, 0xae2334));
    public static final RegistryObject<MobEffect> PULSE_COOLDOWN = MOB_EFFECTS.register("pulse_cooldown",
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
        public BlazingBrandCustomEffect(MobEffectCategory category, int color) {
            super(category, color);
            this.addAttributeModifier(Attributes.ARMOR, "31f5a158-63cf-4201-a260-2dc9368fa4bb", -1.0D * SCConfig.blazingBrandArmorReduction, AttributeModifier.Operation.MULTIPLY_TOTAL);
            this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "e4e1dccc-6477-4e95-8303-e98a7c33f83f", -1.0D * SCConfig.blazingBrandArmorToughnessReduction, AttributeModifier.Operation.MULTIPLY_TOTAL);
        }

        @Override
        public void applyEffectTick(LivingEntity entity, int amplifier) {}

        @Override
        public boolean isDurationEffectTick(int duration, int amplifier) {
            return duration > 0;
        }

        @Override // Use Cataclysm's Blazing Brand name
        public String getDescriptionId() {
            return "effect.cataclysm.blazing_brand";
        }

        @Override // Use Cataclysm's Blazing Brand icon
        public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientMobEffectExtensions> consumer) {
            consumer.accept(new CustomIconMobEffectExtensions(ModEffect.EFFECTBLAZING_BRAND.get()));
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
        @Override
        public List<ItemStack> getCurativeItems() {
            return List.of(); // Cannot be removed with milk
        }
    }
}
