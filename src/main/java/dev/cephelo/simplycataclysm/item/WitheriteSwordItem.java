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
import net.sweenus.simplyswords.util.HelperMethods;

import java.util.List;

public class WitheriteSwordItem extends SwordItem implements IMeleeDamageCallback {
    protected static final ChatFormatting[] titleformat = new ChatFormatting[]{ChatFormatting.RED};

    public WitheriteSwordItem(int attackDamage, float attackSpeed) {
        super(ModItems.WITHERITE_TIER, new Item.Properties().attributes(SwordItem.createAttributes(ModItems.WITHERITE_TIER, attackDamage + SCConfig.WITHERITE_DAMAGE.get(), attackSpeed + SCConfig.WITHERITE_SPEED.get())).fireResistant().rarity(Rarity.EPIC));
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

    private static float chargeStunPulse(LivingEntity attacker, LivingEntity target) {
        if (attacker != null) {
            try {
                // Return if player has cooldown effect
                var cooldownEffect = ModEffects.PULSE_COOLDOWN;
                //if (SCConfig.USE_SPARTAN_EFFECTS.get() && ModList.get().isLoaded("spartancataclysm"))
                //    cooldownEffect = dev.cephelo.spartancataclysm.effects.SCEffects.PULSE_COOLDOWN.get();

                var oldCooldownEffect = attacker.getEffect(cooldownEffect);
                if (oldCooldownEffect != null) return 0;

                var chargeEffect = ModEffects.PULSE_CHARGE;
                //if (SCConfig.USE_SPARTAN_EFFECTS.get() && ModList.get().isLoaded("spartancataclysm"))
                //    chargeEffect = dev.cephelo.spartancataclysm.effects.SCEffects.PULSE_CHARGE.get();

                var oldChargeEffect = attacker.getEffect(chargeEffect);
                int i = oldChargeEffect == null ? 0 : Math.min(SCConfig.MECHA_PULSE_STUN_THRESHOLD.get(), oldChargeEffect.getAmplifier() + 1);
                boolean reachedMax = (i >= SCConfig.MECHA_PULSE_STUN_THRESHOLD.get() && oldChargeEffect.getAmplifier() == i - 1);

                if (Math.random() <= SCConfig.MECHA_PULSE_CHARGE_CHANCE.get()) {
                    attacker.addEffect(new MobEffectInstance(chargeEffect, SCConfig.MECHA_PULSE_EFFECT_DURATION.get(), i));

                    // Pulse Charge particles
                    if (attacker.level() instanceof ServerLevel serverLevel)
                        serverLevel.sendParticles(ParticleTypes.ANGRY_VILLAGER, attacker.getX(), attacker.getY() + 1.4, attacker.getZ(), 3, 0.4, 0.4, 0.4, 0);

                    // Shockwave logic
                    if (reachedMax) {
                        attacker.removeEffect(chargeEffect);
                        attacker.addEffect(new MobEffectInstance(cooldownEffect, SCConfig.MECHA_PULSE_COOLDOWN.get(), 0, false, false, true)); // no particles
                        target.addEffect(new MobEffectInstance(ModEffect.EFFECTSTUN, SCConfig.MECHA_PULSE_STUN_DURATION.get(), 0));

                        // Shockwave particle
                        if (attacker.level() instanceof ServerLevel serverLevel)
                            serverLevel.sendParticles(ModParticle.EM_PULSE.get(), target.getX(), target.getY() + target.getEyeHeight() - 1.25, target.getZ(), 1, 0, 0, 0, 0);

                        if (SCConfig.CUSTOM_SOUNDS.get()) {
                            attacker.level().playSeededSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                                    SCModSounds.MECHA_PULSE_SHOCKWAVE.get(), SoundSource.PLAYERS, 1f, 1f, 0);
                            attacker.level().playSeededSound(null, target.getX(), target.getY(), target.getZ(),
                                    SCModSounds.WITHERITE_HIT.get(), SoundSource.PLAYERS, 2f, 1f, 0);
                        }

                        return SCConfig.MECHA_PULSE_EXTRA_DAMAGE.get().floatValue();
                    }
                }

            } catch (Throwable e) {
                SimplyCataclysm.LOGGER.error(String.valueOf(e));
            }
        }

        return 0;
    }
    
    private static void applyMechaEffects(LivingEntity target, LivingEntity attacker) {
        if (attacker != null) {
            try {
                if (target != null && Math.random() <= SCConfig.MECHA_SMITE_CHANCE.get()) {
                    if (SCConfig.MECHA_SMITE_WITHER_DURATION.get() > 0) target.addEffect(new MobEffectInstance(MobEffects.WITHER, SCConfig.MECHA_SMITE_WITHER_DURATION.get(), SCConfig.MECHA_SMITE_WITHER_AMP.get()));
                    if (SCConfig.MECHA_SMITE_FIRE_DURATION.get() > 0) target.igniteForTicks(SCConfig.MECHA_SMITE_FIRE_DURATION.get() * 20);
                    if (SCConfig.CUSTOM_SOUNDS.get()) attacker.level().playSeededSound(null, target.getX(), target.getY(), target.getZ(),
                            SCModSounds.WITHERITE_HIT.get(), SoundSource.PLAYERS, 1f, SCConfig.getRandomPitch(), 0);
                }
                if (Math.random() <= SCConfig.MECHA_SMITE_REGEN_CHANCE.get()
                        && attacker.getHealth() < (SCConfig.MECHA_SMITE_REGEN_THRESHOLD_TYPE.get() ? (attacker.getMaxHealth() * SCConfig.MECHA_SMITE_REGEN_THRESHOLD_PERCENT.get()) : SCConfig.MECHA_SMITE_REGEN_THRESHOLD.get())) {
                    attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, SCConfig.MECHA_SMITE_REGEN_DURATION.get(), SCConfig.MECHA_SMITE_REGEN_AMP.get()));
                }

            } catch (Throwable e) {
                SimplyCataclysm.LOGGER.error(String.valueOf(e));
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait_tooltip").withStyle(ModItems.traitformat)
                .append(Component.translatable("tooltip.simplycataclysm.trait.mecha_pulse").withStyle(titleformat)));

        if (Screen.hasShiftDown())
            tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait.mecha_pulse.desc").withStyle(ModItems.descformat));

        tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait_tooltip").withStyle(ModItems.traitformat)
                .append(Component.translatable("tooltip.simplycataclysm.trait.mecha_smite").withStyle(titleformat)));

        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait.mecha_smite.desc").withStyle(ModItems.descformat));
            tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait.fireproof_unbreakable").withStyle(ModItems.descformat));
        } else tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.view_trait_tooltip").withStyle(ModItems.descformat));
    }
}
