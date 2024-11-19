package dev.tildejustin.achievement_fix.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.class_4349;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(class_4349.class)
public class HusbandryTabAdvancementGeneratorMixin {
    @ModifyExpressionValue(method = "accept(Ljava/util/function/Consumer;)V", at = @At(value = "CONSTANT", args = "intValue=-1"))
    private int fixDurabilityRequirement(int original) {
        return 0;
    }
}
