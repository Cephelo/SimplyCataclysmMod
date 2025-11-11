package dev.cephelo.simplycataclysm.item;

import com.github.L_Ender.cataclysm.init.ModParticle;
import dev.cephelo.simplycataclysm.SimplyCataclysm;
import dev.cephelo.simplycataclysm.SCConfig;
import dev.cephelo.simplycataclysm.effects.ModEffects;
import dev.cephelo.simplycataclysm.event.IMeleeDamageCallback;
import dev.cephelo.simplycataclysm.sounds.SCModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import net.sweenus.simplyswords.util.HelperMethods;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CursiumSwordItem extends SwordItem implements IMeleeDamageCallback {
    protected static final ChatFormatting[] titleformat = new ChatFormatting[]{ChatFormatting.AQUA};

    public CursiumSwordItem(int attackDamage, float attackSpeed) {
        super(ModItems.CURSIUM_TIER, attackDamage + SCConfig.cursiumDamageModifier, attackSpeed + SCConfig.cursiumSpeedModifier, (new Item.Properties()).fireResistant().rarity(Rarity.EPIC));
    }

    public float modifyDamageDealt(float baseDamage, DamageSource source, LivingEntity attacker, LivingEntity victim) {
        float addedDamage = calculateRage(attacker, victim);
        baseDamage += addedDamage;
        return baseDamage;
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.level().isClientSide()) {
            HelperMethods.playHitSounds(attacker, target);
        }

        return super.hurtEnemy(stack, target, attacker);
    }

    private static float calculateRage(LivingEntity attacker, LivingEntity target) {
        if (attacker != null) {
            try {
                var rageEffect = ModEffects.ACCURSED_RAGE.get();
                if (SCConfig.useSpartanEffects && ModList.get().isLoaded("spartancataclysm"))
                    rageEffect = dev.cephelo.spartancataclysm.effects.SCEffects.ACCURSED_RAGE.get();

                var oldEffect = attacker.getEffect(rageEffect);
                int i = oldEffect == null ? 0 : Math.min(SCConfig.accursedRageMaximum, oldEffect.getAmplifier() + 1);
                boolean reachedMax = (i >= SCConfig.accursedRageMaximum && oldEffect.getAmplifier() == i - 1);

                // Targets hit with maximum Accursed Rage emit small cursed flame particles
                if (attacker.level() instanceof ServerLevel serverLevel && i >= SCConfig.accursedRageMaximum)
                    serverLevel.sendParticles(ModParticle.SMALL_CURSED_FLAME.get(), target.getX(), target.getY() + target.getEyeHeight() - 1.0, target.getZ(), 8, 0.4, 0.7, 0.4, 0.02);

                if (Math.random() <= SCConfig.accursedRageChance) {
                    attacker.addEffect(new MobEffectInstance(rageEffect, SCConfig.accursedRageDuration, i));

                    // Accursed Rage particles
                    if (attacker.level() instanceof ServerLevel serverLevel) {
                        if (reachedMax)
                            serverLevel.sendParticles(ModParticle.CURSED_FLAME.get(), attacker.getX(), attacker.getY() + 1, attacker.getZ(), 15, 0.3, 0.6, 0.3, 0.02);
                        else if (i < SCConfig.accursedRageMaximum)
                            serverLevel.sendParticles(ModParticle.SMALL_CURSED_FLAME.get(), attacker.getX(), attacker.getY() + 1, attacker.getZ(), 9, 0.3, 0.6, 0.3, 0.01);
                    }

                    // Play sound when attacker reaches maximum rage
                    if (SCConfig.customSounds && reachedMax) attacker.level().playSeededSound(null, attacker.getX(), attacker.getY(), attacker.getZ(),
                            SCModSounds.ACCURSED_RAGE_MAX.get(), SoundSource.PLAYERS, 1f, 1f, 0);
                }

                // Calculate extra damage
                var newEffect = attacker.getEffect(rageEffect);
                if (newEffect != null) {
                    if (SCConfig.customSounds) attacker.level().playSeededSound(null, target.getX(), target.getY(), target.getZ(),
                            SCModSounds.CURSIUM_HIT.get(), SoundSource.PLAYERS, 1f, SCConfig.getRandomPitch(), 0);
                    return (newEffect.getAmplifier() + 1) * (float)SCConfig.accursedRageExtraDamage;
                }

            } catch (Throwable e) {
                SimplyCataclysm.LOGGER.error(String.valueOf(e));
            }
        }

        return 0;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait_tooltip").withStyle(ModItems.traitformat)
                .append(Component.translatable("tooltip.simplycataclysm.trait.accursed_rage").withStyle(titleformat)));

        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait.accursed_rage.desc").withStyle(ModItems.descformat));
            tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.trait.fireproof_unbreakable").withStyle(ModItems.descformat));
        } else tooltipComponents.add(Component.translatable("tooltip.simplycataclysm.view_trait_tooltip").withStyle(ModItems.descformat));
    }
}
