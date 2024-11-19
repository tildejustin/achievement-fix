package dev.tildejustin.achievement_fix;

import net.minecraft.entity.Entity;

public interface EntityDamageSourceAccessor {
    default Entity achievement_fix$getEntity() {
        return null;
    }
}
