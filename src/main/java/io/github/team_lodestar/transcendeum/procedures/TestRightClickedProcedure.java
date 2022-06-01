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
			LivingEntity _ent = (LivingEntity) entity;
			if (!_ent.world.isRemote()) {
				EnigmaGloveItem.shoot(_ent.world, _ent, new Random(), (float) 0.6, 5, 1);
			}
		}
		if (entity instanceof LivingEntity) {
			LivingEntity _ent = (LivingEntity) entity;
			if (!_ent.world.isRemote()) {
				EnigmaGlovePoweredItem.shoot(_ent.world, _ent, new Random(), 1, 5, 1);
			}
		}
		if (entity instanceof LivingEntity) {
			LivingEntity _ent = (LivingEntity) entity;
			if (!_ent.world.isRemote()) {
				EnigmaGloveItem.shoot(_ent.world, _ent, new Random(), (float) 1.2, 5, 1);
			}
		}
		if (entity instanceof LivingEntity) {
			LivingEntity _ent = (LivingEntity) entity;
			if (!_ent.world.isRemote()) {
				EnigmaGlovePoweredItem.shoot(_ent.world, _ent, new Random(), (float) 1.5, 5, 1);
			}
		}
		if (entity instanceof LivingEntity) {
			LivingEntity _ent = (LivingEntity) entity;
			if (!_ent.world.isRemote()) {
				EnigmaGloveItem.shoot(_ent.world, _ent, new Random(), (float) 0.8, 5, 1);
			}
		}
		if (entity instanceof LivingEntity) {
			LivingEntity _ent = (LivingEntity) entity;
			if (!_ent.world.isRemote()) {
				EnigmaGlovePoweredItem.shoot(_ent.world, _ent, new Random(), 2, 5, 1);
			}
		}
		if (entity instanceof LivingEntity) {
			LivingEntity _ent = (LivingEntity) entity;
			if (!_ent.world.isRemote()) {
				EnigmaGloveItem.shoot(_ent.world, _ent, new Random(), (float) 1.8, 5, 1);
			}
		}
		if (entity instanceof LivingEntity) {
			LivingEntity _ent = (LivingEntity) entity;
			if (!_ent.world.isRemote()) {
				EnigmaGloveItem.shoot(_ent.world, _ent, new Random(), (float) 0.4, 5, 1);
			}
		}
	}
}
