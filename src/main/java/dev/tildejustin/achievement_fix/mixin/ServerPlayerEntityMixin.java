package dev.tildejustin.achievement_fix.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin {
    @ModifyExpressionValue(method = "updateExploredBiomes", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/JsonSet;size()I"))
    private int modifySize(int original) {
        return Math.min(original, Biome.BIOMESET.size());
    }
}
