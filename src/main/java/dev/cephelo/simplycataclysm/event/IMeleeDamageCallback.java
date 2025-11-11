package dev.cephelo.simplycataclysm.event;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public interface IMeleeDamageCallback {
    default float modifyDamageDealt(float baseDamage, DamageSource source, LivingEntity attacker, LivingEntity victim) {
        return baseDamage;
    }
}
