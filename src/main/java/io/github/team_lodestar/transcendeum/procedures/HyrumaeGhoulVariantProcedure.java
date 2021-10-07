package io.github.team_lodestar.transcendeum.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.Variant;

import java.util.Map;
import java.util.HashMap;

import io.github.team_lodestar.transcendeum.entity.HyrumaeGhoulEntity;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class HyrumaeGhoulVariantProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntitySpawned(EntityJoinWorldEvent event) {
			Entity entity = event.getEntity();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure HyrumaeGhoulVariant!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double Variant = 0;
		if ((entity instanceof HyrumaeGhoulEntity.CustomEntity)) {
			if ((((HyrumaeGhoulEntity.CustomEntity) entity).getVariant() == 0)) {
				Variant = (double) Math.ceil((2 * Math.random()));
				((HyrumaeGhoulEntity.CustomEntity) entity).setVariant((int) Variant);
			}
		}
	}
}
