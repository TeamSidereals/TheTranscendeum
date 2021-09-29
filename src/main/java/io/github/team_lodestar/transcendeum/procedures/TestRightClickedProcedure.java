package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

import io.github.team_lodestar.transcendeum.item.EnigmaGlovePoweredItem;
import io.github.team_lodestar.transcendeum.item.EnigmaGloveItem;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class TestRightClickedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure TestRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			Entity _ent = entity;
			if (!_ent.world.isRemote()) {
				EnigmaGloveItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 0.6, (float) 5, (int) 1);
			}
		}
		if (entity instanceof LivingEntity) {
			Entity _ent = entity;
			if (!_ent.world.isRemote()) {
				EnigmaGlovePoweredItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 1, (float) 5, (int) 1);
			}
		}
		if (entity instanceof LivingEntity) {
			Entity _ent = entity;
			if (!_ent.world.isRemote()) {
				EnigmaGloveItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 1.2, (float) 5, (int) 1);
			}
		}
		if (entity instanceof LivingEntity) {
			Entity _ent = entity;
			if (!_ent.world.isRemote()) {
				EnigmaGlovePoweredItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 1.5, (float) 5, (int) 1);
			}
		}
		if (entity instanceof LivingEntity) {
			Entity _ent = entity;
			if (!_ent.world.isRemote()) {
				EnigmaGloveItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 0.8, (float) 5, (int) 1);
			}
		}
		if (entity instanceof LivingEntity) {
			Entity _ent = entity;
			if (!_ent.world.isRemote()) {
				EnigmaGlovePoweredItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 2, (float) 5, (int) 1);
			}
		}
		if (entity instanceof LivingEntity) {
			Entity _ent = entity;
			if (!_ent.world.isRemote()) {
				EnigmaGloveItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 1.8, (float) 5, (int) 1);
			}
		}
		if (entity instanceof LivingEntity) {
			Entity _ent = entity;
			if (!_ent.world.isRemote()) {
				EnigmaGloveItem.shoot(_ent.world, (LivingEntity) entity, new Random(), (float) 0.4, (float) 5, (int) 1);
			}
		}
	}
}
