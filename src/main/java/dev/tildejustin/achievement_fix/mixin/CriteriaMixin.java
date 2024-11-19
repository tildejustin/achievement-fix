package dev.tildejustin.achievement_fix.mixin;

import com.google.gson.JsonElement;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.tildejustin.achievement_fix.mixin.accessor.ItemDurabilityChangedCriterion$ConditionsAccessor;
import net.minecraft.advancement.criterion.*;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Map;

@Mixin(Criteria.class)
public class CriteriaMixin {
    @Unique
    private static final String TARGET_CRITERION = "broke_hoe";

    @ModifyExpressionValue(method = "readAllCriteria(Lcom/google/gson/JsonObject;Lcom/google/gson/JsonDeserializationContext;)Ljava/util/Map;", at = @At(value = "INVOKE", target = "Lnet/minecraft/advancement/criterion/Criteria;readCriteria(Lcom/google/gson/JsonObject;Lcom/google/gson/JsonDeserializationContext;)Lnet/minecraft/advancement/criterion/Criteria;"))
    private static Criteria fixCriterion(Criteria original, @Local Map.Entry<String, JsonElement> entry) {
        CriterionInstance criterion = original.method_14879();
        if (!(criterion instanceof class_3197.class_3557) || !entry.getKey().equals(TARGET_CRITERION)) {
            return original;
        }
        ((ItemDurabilityChangedCriterion$ConditionsAccessor) criterion).setDurability(class_3638.class_3642.method_16523(0));
        return original;
    }
}
