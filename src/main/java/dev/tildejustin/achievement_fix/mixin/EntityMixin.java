package dev.tildejustin.achievement_fix.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow
    public int dimension;

    @Inject(method = "teleportToDimension", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;removeEntity(Lnet/minecraft/entity/Entity;)V"))
    private void resetDimension(int dimensionId, CallbackInfo ci, @Local(ordinal = 1) int dimension, @Local(ordinal = 1) LocalRef<ServerWorld> newWorld) {
        if (dimension == 1 && dimensionId == 1) {
            newWorld.set(MinecraftServer.getServer().getWorld(0));
            this.dimension = 0;
        }
    }
}
