package com.example.rodtricks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.world.entity.EntityTypes;

public class RodTricks implements ModInitializer {
    public static final String MODID = "rodtricks";

    @Override
    public void onInitialize() {
        // Silverfish sin IA = no se mueven ni atacan (huevo, /summon y bloques infestados).
        ServerEntityEvents.ENTITY_LOAD.register((entity, level) -> {
            if (entity.getType() == EntityTypes.SILVERFISH && entity instanceof net.minecraft.world.entity.Mob mob) {
                mob.setNoAi(true);
            }
        });
    }
}
