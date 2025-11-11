package dev.cephelo.simplycataclysm.item;

import dev.cephelo.simplycataclysm.SCConfig;
import dev.cephelo.simplycataclysm.SimplyCataclysm;
import dev.cephelo.simplycataclysm.effects.ModEffects;
import dev.cephelo.simplycataclysm.sounds.SCModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import net.sweenus.simplyswords.util.HelperMethods;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IgnitiumSwordItem extends SwordItem {
    protected static final ChatFormatting[] titleformat = new ChatFormatting[]{ChatFormatting.GOLD};

    public IgnitiumSwordItem(int attackDamage, float attackSpeed) {
        super(ModItems.IGNITIUM_TIER, attackDamage + SCConfig.ignitiumDamageModifier, attackSpeed + SCConfig.ignitiumSpeedModifier, (new Item.Properties()).fireResistant().rarity(Rarity.EPIC));
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.level().isClientSide()) {
            HelperMethods.playHitSounds(attacker, target);
        }
        calculateBlazingBrand(attacker, target);

        return super.hurtEnemy(stack, target, attacker);
    }

    private static void calculateBlazingBrand(LivingEntity attacker, LivingEntity victim) {
        if (attacker != null && victim != null && Math.random() <= SCConfig.blazingBrandChance) {
            float factor = (float) SCConfig.lifestealMultiplier;

            if (factor > 0.0f && attacker instanceof Player player) {
                float speed = (float) player.getAttributeValue(Attributes.ATTACK_SPEED);
                factor = factor / Mth.clamp(speed, 0.5f, 2);
            }

            stackBlazingBrand(attacker, victim, factor);
        }
    }

    private static void stackBlazingBrand(LivingEntity attacker, LivingEntity target, float factor) {
        try {
            var brandEffect = ModEffects.BLAZING_BRAND_CUSTOM.get();
            if (SCConfig.useSpartanEffects && ModList.get().isLoaded("spartancataclysm"))
                brandEffect = dev.cephelo.spartancataclysm.effects.SCEffects.BLAZING_BRAND_CUSTOM.get();

            var oldEffect = target.getEffect(brandEffect);
            int i = oldEffect == null ? 0 : Math.min(SCConfig.blazingBrandMaximum, oldEffect.getAmplifier() + 1);

            target.addEffect(new MobEffectInstance(brandEffect, SCConfig.blazingBrandDuration, i));

            // Lifesteal
            if (factor > 0.0f && Math.random() <= SCConfig.blazingBrandLifestealChance) {
                attacker.heal(factor * (float) (i + 1));
                // Particles for healing
                if (attacker.level() instanceof ServerLevel serverLevel)
                    serverLevel.sendParticles(ParticleTypes.SMALL_FLAME, attacker.getX(), attacker.getY() + 1, attacker.getZ(), 6, 0.3, 0.6, 0.3, 0.02);
            }

            // Blazing Brand particles on target
            if (attacker.level() instanceof ServerLevel serverLevel)
                serverLevel.sendParticles((i == SCConfig.blazingBrandMaximum ? ParticleTypes.SOUL_FIRE_FLAME : ParticleTypes.FLAME), target.getX(), target.getY() + target.getEyeHeight() - 1.0, target.getZ(), 10, 0.4, 0.7, 0.4, 0.02);

            // Custom hit sound
            if (SCConfig.customSounds) attacker.level().playSeededSound(null, target.getX(), target.getY(), target.getZ(),
                    SCModSounds.IGNITIUM_HIT.get(), SoundSource.PLAYERS, 1f, SCConfig.getRandomPitch(), 0);
        } catch (Throwable e) {
            SimplyCataclysm.LOGGER.error(String.valueOf(e));
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait_tooltip").withStyle(ModItems.traitformat)
                .append(Component.translatable("tooltip.simplycataclysm.trait.blazing_brand").withStyle(titleformat)));

        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait.blazing_brand.desc").withStyle(ModItems.descformat));
        } else tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.view_trait_tooltip").withStyle(ModItems.descformat));
    }
}
