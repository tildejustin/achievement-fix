package dev.tildejustin.achievement_fix.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.player.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin {
    @ModifyExpressionValue(method = "teleportToDimension", at = @At(value = "CONSTANT", args = "intValue=1", ordinal = 0), slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/ServerPlayerEntity;dimension:I", ordinal = 1)))
    private int modifyCurrentDimensionConstant(int original) {
        return 0;
    }

    @ModifyVariable(method = "teleportToDimension", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/ServerPlayerEntity;dimension:I", ordinal = 1), argsOnly = true)
    private int modifyNewDimensionConstant(int original) {
        // really need to modify the 0 constant this is being checked against to a 1,
        // however that compiled to an IFNE so this is the best I can do without expressions.
        return original - 1;
    }

    @ModifyVariable(method = "teleportToDimension", at = @At(value = "FIELD", target = "Lnet/minecraft/advancement/AchievementsAndCriterions;THE_END:Lnet/minecraft/advancement/Achievement;"), argsOnly = true)
    private int resetNewDimensionConstantInside(int original) {
        return original + 1;
    }

    @ModifyVariable(method = "teleportToDimension", at = @At(value = "FIELD", target = "Lnet/minecraft/advancement/AchievementsAndCriterions;PORTAL:Lnet/minecraft/advancement/Achievement;"), argsOnly = true)
    private int resetNewDimensionConstantOutside(int original) {
        return original + 1;
    }
}
