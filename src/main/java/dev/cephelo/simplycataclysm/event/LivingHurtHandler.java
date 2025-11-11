package dev.cephelo.simplycataclysm.event;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LivingHurtHandler {
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent ev) {
        DamageSource source = ev.getSource();
        float dmgDealt = ev.getAmount();
        LivingEntity target = ev.getEntity();
        if (dmgDealt != 0.0F && !source.is(DamageTypeTags.IS_PROJECTILE) && !source.is(DamageTypeTags.IS_FIRE) && !source.is(DamageTypeTags.IS_EXPLOSION) && (source.getMsgId().equals("player") || source.getMsgId().equals("mob"))) {
            if (source.getDirectEntity() == source.getEntity() && source.getEntity() instanceof LivingEntity && target != null) {
                LivingEntity attacker = (LivingEntity) source.getEntity();
                ItemStack attackerStack = attacker.getMainHandItem();
                if (!attackerStack.isEmpty()) {
                    Item attackerItem = attackerStack.getItem();

                    if (attackerItem instanceof IMeleeDamageCallback) {
                        dmgDealt = ((IMeleeDamageCallback) attackerItem).modifyDamageDealt(dmgDealt, source, attacker, target);
                        ev.setAmount(dmgDealt);
                    }
                }
            }
        }
    }
}
