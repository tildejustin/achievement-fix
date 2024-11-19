package dev.tildejustin.achievement_fix.mixin.accessor;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(class_3197.class_3557.class)
public interface ItemDurabilityChangedCriterion$ConditionsAccessor {
    @Accessor("field_17378")
    void setDurability(class_3638.class_3642 durability);
}
