package io.github.team_lodestar.transcendeum.entity.mixcode;

import io.github.team_lodestar.transcendeum.TheTranscendeumMod;
import io.github.team_lodestar.transcendeum.entity.mixcode.custom.PurifyPowderEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MixCodeEntityType {

    public static final DeferredRegister<EntityType<?>> ENTITIE_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, TheTranscendeumMod.MODID);

    public static void init(IEventBus bus){
        ENTITIE_TYPES.register(bus);
    }

    public static final RegistryObject<EntityType<PurifyPowderEntity>> PURIFY_POWDER_PROJECTILE
            = ENTITIE_TYPES.register("purify_powder_projectile", () ->
            EntityType.Builder.<PurifyPowderEntity>create(PurifyPowderEntity::new, EntityClassification.MISC)
                    .size(0.1f,0.1f).build("purify_powder_projectile"));
}
