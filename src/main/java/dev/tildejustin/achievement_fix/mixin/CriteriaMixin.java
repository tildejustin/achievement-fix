package dev.tildejustin.achievement_fix.mixin;

import com.google.gson.JsonElement;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.tildejustin.achievement_fix.mixin.accessor.ItemDurabilityChangedCriterion$ConditionsAccessor;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.criterion.*;
import net.minecraft.predicate.NumberRange;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Map;

@Mixin(AdvancementCriterion.class)
public class CriteriaMixin {
    @Unique
    private static final String TARGET_CRITERION = "broke_hoe";

    @ModifyExpressionValue(method = "fromJson(Lcom/google/gson/JsonObject;Lcom/google/gson/JsonDeserializationContext;)Ljava/util/Map;", at = @At(value = "INVOKE", target = "Lnet/minecraft/advancement/AdvancementCriterion;deserialize(Lcom/google/gson/JsonObject;Lcom/google/gson/JsonDeserializationContext;)Lnet/minecraft/advancement/AdvancementCriterion;"))
    private static AdvancementCriterion fixCriterion(AdvancementCriterion original, @Local Map.Entry<String, JsonElement> entry) {
        CriterionConditions criterion = original.getConditions();
        if (!(criterion instanceof ItemDurabilityChangedCriterion.Conditions) || !entry.getKey().equals(TARGET_CRITERION)) {
            return original;
        }
        ((ItemDurabilityChangedCriterion$ConditionsAccessor) criterion).setDurability(NumberRange.IntRange.exactly(0));
        return original;
    }
}
