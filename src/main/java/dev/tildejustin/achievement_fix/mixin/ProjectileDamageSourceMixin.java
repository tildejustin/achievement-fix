package dev.tildejustin.achievement_fix.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.*;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ProjectileDamageSource.class)
public class ProjectileDamageSourceMixin extends EntityDamageSource {
    public ProjectileDamageSourceMixin(String name, Entity entity) {
        super(name, entity);
    }

    @Override
    public Entity getSource() {
        return this.achievement_fix$getEntity();
    }
}
