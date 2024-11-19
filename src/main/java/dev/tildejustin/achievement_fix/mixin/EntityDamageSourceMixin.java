package dev.tildejustin.achievement_fix.mixin;

import dev.tildejustin.achievement_fix.EntityDamageSourceAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.EntityDamageSource;
import org.spongepowered.asm.mixin.*;

@Mixin(EntityDamageSource.class)
public abstract class EntityDamageSourceMixin implements EntityDamageSourceAccessor {
    @Shadow
    private Entity entity;

    @Override
    public Entity achievement_fix$getEntity() {
        return this.entity;
    }
}
