package io.github.team_lodestar.transcendeum.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import io.github.team_lodestar.transcendeum.TheTranscendeumModVariables;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class ExcerockDataManagementProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
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
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure ExcerockDataManagement!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.isInWater() || entity.isSneaking()
				|| !(ItemTags.getCollection().getTagByID(new ResourceLocation("forge:excerock_tools"))
						.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()))
						&& !(ItemTags.getCollection().getTagByID(new ResourceLocation("forge:excerock_tools")).contains(
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem()))) {
			if ((entity.getCapability(TheTranscendeumModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheTranscendeumModVariables.PlayerVariables())).DoExcerockAttack) {
				{
					boolean _setval = (false);
					entity.getCapability(TheTranscendeumModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DoExcerockAttack = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
