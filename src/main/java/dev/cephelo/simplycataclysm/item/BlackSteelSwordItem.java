package dev.cephelo.simplycataclysm.item;

import com.github.L_Ender.cataclysm.items.Tooltier;
import dev.cephelo.simplycataclysm.SCConfig;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.sweenus.simplyswords.util.HelperMethods;

public class BlackSteelSwordItem extends SwordItem {
    public BlackSteelSwordItem(int attackDamage, float attackSpeed) {
        super(Tooltier.BLACK_STEEL, attackDamage + SCConfig.blackSteelDamageModifier, attackSpeed + SCConfig.blackSteelSpeedModifier, (new Item.Properties()));
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.level().isClientSide()) {
            HelperMethods.playHitSounds(attacker, target);
        }

        return super.hurtEnemy(stack, target, attacker);
    }
}
