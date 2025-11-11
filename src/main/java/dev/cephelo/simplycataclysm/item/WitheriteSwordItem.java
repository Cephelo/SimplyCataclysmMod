package dev.cephelo.simplycataclysm.item;

import com.github.L_Ender.cataclysm.init.ModEffect;
import com.github.L_Ender.cataclysm.init.ModParticle;
import dev.cephelo.simplycataclysm.SCConfig;
import dev.cephelo.simplycataclysm.SimplyCataclysm;
import dev.cephelo.simplycataclysm.effects.ModEffects;
import dev.cephelo.simplycataclysm.event.IMeleeDamageCallback;
import dev.cephelo.simplycataclysm.sounds.SCModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import net.sweenus.simplyswords.util.HelperMethods;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WitheriteSwordItem extends SwordItem implements IMeleeDamageCallback {
    protected static final ChatFormatting[] titleformat = new ChatFormatting[]{ChatFormatting.RED};

    public WitheriteSwordItem(int attackDamage, float attackSpeed) {
        super(ModItems.WITHERITE_TIER, attackDamage + SCConfig.witheriteDamageModifier, attackSpeed + SCConfig.witheriteSpeedModifier, (new Item.Properties()).fireResistant().rarity(Rarity.EPIC));
    }

    public float modifyDamageDealt(float baseDamage, DamageSource source, LivingEntity attacker, LivingEntity victim) {
        applyMechaEffects(victim, attacker);
        float addedDamage = chargeStunPulse(attacker, victim);
        baseDamage += addedDamage;
        return baseDamage;
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.level().isClientSide()) {
            HelperMethods.playHitSounds(attacker, target);
        }

        return super.hurtEnemy(stack, target, attacker);
    }

    private float chargeStunPulse(LivingEntity attacker, LivingEntity target) {
        if (attacker != null) {
            try {
                // Return if player has cooldown effect
                var cooldownEffect = ModEffects.PULSE_COOLDOWN.get();
                if (SCConfig.useSpartanEffects && ModList.get().isLoaded("spartancataclysm"))
                    cooldownEffect = dev.cephelo.spartancataclysm.effects.SCEffects.PULSE_COOLDOWN.get();

                var oldCooldownEffect = attacker.getEffect(cooldownEffect);
                if (oldCooldownEffect != null) return 0;

                var chargeEffect = ModEffects.PULSE_CHARGE.get();
                if (SCConfig.useSpartanEffects && ModList.get().isLoaded("spartancataclysm"))
                    chargeEffect = dev.cephelo.spartancataclysm.effects.SCEffects.PULSE_CHARGE.get();

                var oldChargeEffect = attacker.getEffect(chargeEffect);
                int i = oldChargeEffect == null ? 0 : Math.min(SCConfig.mechaPulseStunThreshold, oldChargeEffect.getAmplifier() + 1);
                boolean reachedMax = (i >= SCConfig.mechaPulseStunThreshold && oldChargeEffect.getAmplifier() == i - 1);

                if (Math.random() <= SCConfig.mechaPulseChargeChance) {
                    attacker.addEffect(new MobEffectInstance(chargeEffect, SCConfig.mechaPulseEffectDuration, i));

                    // Pulse Charge particles
                    if (attacker.level() instanceof ServerLevel serverLevel)
                        serverLevel.sendParticles(ParticleTypes.ANGRY_VILLAGER, attacker.getX(), attacker.getY() + 1.4, attacker.getZ(), 3, 0.4, 0.4, 0.4, 0);

                    // Shockwave logic
                    if (reachedMax) {
                        attacker.removeEffect(chargeEffect);
                        attacker.addEffect(new MobEffectInstance(cooldownEffect, SCConfig.mechaPulseCooldown, 0, false, false, true)); // no particles
                        target.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN.get(), SCConfig.mechaPulseStunDuration, 0));

                        // Shockwave particle
                        if (attacker.level() instanceof ServerLevel serverLevel)
                            serverLevel.sendParticles(ModParticle.EM_PULSE.get(), target.getX(), target.getY() + target.getEyeHeight() - 1.25, target.getZ(), 1, 0, 0, 0, 0);

                        if (SCConfig.customSounds) {
                            attacker.level().playSeededSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                                    SCModSounds.MECHA_PULSE_SHOCKWAVE.get(), SoundSource.PLAYERS, 1f, 1f, 0);
                            attacker.level().playSeededSound(null, target.getX(), target.getY(), target.getZ(),
                                    SCModSounds.WITHERITE_HIT.get(), SoundSource.PLAYERS, 2f, 1f, 0);
                        }

                        return (float)SCConfig.mechaPulseExtraDamage;
                    }
                }

            } catch (Throwable e) {
                SimplyCataclysm.LOGGER.error(String.valueOf(e));
            }
        }

        return 0;
    }
    
    private void applyMechaEffects(LivingEntity target, LivingEntity attacker) {
        if (attacker != null) {
            try {
                if (target != null && Math.random() <= SCConfig.mechaSmiteChance) {
                    if (SCConfig.mechaSmiteWitherDuration > 0) target.addEffect(new MobEffectInstance(MobEffects.WITHER, SCConfig.mechaSmiteWitherDuration, SCConfig.mechaSmiteWitherAmplifier));
                    if (SCConfig.mechaSmiteFireDuration > 0) target.setSecondsOnFire(SCConfig.mechaSmiteFireDuration);
                    if (SCConfig.customSounds) attacker.level().playSeededSound(null, target.getX(), target.getY(), target.getZ(),
                            SCModSounds.WITHERITE_HIT.get(), SoundSource.PLAYERS, 1f, SCConfig.getRandomPitch(), 0);
                }
                if (Math.random() <= SCConfig.mechaSmiteRegenChance
                        && attacker.getHealth() < (SCConfig.mechaSmiteRegenThresholdType ? (attacker.getMaxHealth() * SCConfig.mechaSmiteRegenThresholdPercent) : SCConfig.mechaSmiteRegenThreshold)) {
                    attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, SCConfig.mechaSmiteRegenDuration, SCConfig.mechaSmiteRegenAmplifier));
                }

            } catch (Throwable e) {
                SimplyCataclysm.LOGGER.error(String.valueOf(e));
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait_tooltip").withStyle(ModItems.traitformat)
                .append(Component.translatable("tooltip.simplycataclysm.trait.mecha_pulse").withStyle(titleformat)));

        if (Screen.hasShiftDown())
            tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait.mecha_pulse.desc").withStyle(ModItems.descformat));

        tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait_tooltip").withStyle(ModItems.traitformat)
                .append(Component.translatable("tooltip.simplycataclysm.trait.mecha_smite").withStyle(titleformat)));

        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait.mecha_smite.desc").withStyle(ModItems.descformat));
        } else tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.view_trait_tooltip").withStyle(ModItems.descformat));
    }
}
