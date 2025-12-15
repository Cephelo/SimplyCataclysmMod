package dev.cephelo.simplycataclysm.item;

import com.github.L_Ender.cataclysm.items.Tooltier;
import dev.cephelo.simplycataclysm.SCConfig;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.sweenus.simplyswords.util.HelperMethods;

public class AncientMetalSwordItem extends SwordItem {
    public AncientMetalSwordItem(int attackDamage, float attackSpeed) {
        super(Tooltier.ANCIENT_METAL, new Item.Properties().attributes(SwordItem.createAttributes(Tooltier.ANCIENT_METAL, attackDamage + SCConfig.ANCIENT_METAL_DAMAGE.get(), attackSpeed + SCConfig.ANCIENT_METAL_SPEED.get())));
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.level().isClientSide()) {
            HelperMethods.playHitSounds(attacker, target);
        }

        return super.hurtEnemy(stack, target, attacker);
    }
}
