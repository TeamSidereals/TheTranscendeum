package io.github.team_lodestar.transcendeum.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.AxeItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import io.github.team_lodestar.transcendeum.particle.KiariteExorcismParticle;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class KiariteToolLivingEntityIsHitWithToolProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure KiariteToolLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency itemstack for procedure KiariteToolLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure KiariteToolLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		if ((EntityTypeTags.getCollection().getTagByID(new ResourceLocation(("forge:transcendent_mobs").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(entity.getType()))) {
			entity.setMotion((entity.getMotion().getX()), 0.5, (entity.getMotion().getZ()));
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(KiariteExorcismParticle.particle, (entity.getPosX()), ((entity.getPosY()) + 1),
						(entity.getPosZ()), (int) 10, 0.2, 0.4, 0.2, 0.1);
			}
			if ((((itemstack).getItem() instanceof SwordItem) || ((itemstack).getItem() instanceof AxeItem))) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).attackEntityFrom(new DamageSource("empowered").setDamageBypassesArmor(), (float) 4);
				}
			} else {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).attackEntityFrom(new DamageSource("empowered").setDamageBypassesArmor(), (float) 2);
				}
			}
		}
	}
}
