package dev.tildejustin.achievement_fix.mixin.accessor;

import net.minecraft.advancement.criterion.ItemDurabilityChangedCriterion;
import net.minecraft.predicate.NumberRange;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemDurabilityChangedCriterion.Conditions.class)
public interface ItemDurabilityChangedCriterion$ConditionsAccessor {
    @Accessor("durability")
    void setDurability(NumberRange.IntRange durability);
}
