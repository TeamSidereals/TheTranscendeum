package io.github.team_lodestar.transcendeum.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.tags.BlockTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

import io.github.team_lodestar.transcendeum.block.ViralgaBlockBlock;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

public class ViralgaRightClickedinAirProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure ViralgaRightClickedinAir!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure ViralgaRightClickedinAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency itemstack for procedure ViralgaRightClickedinAir!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double raytrace_distance = 0;
		raytrace_distance = 1;
		for (int index0 = 0; index0 < (int) (5); index0++) {
			raytrace_distance = (raytrace_distance + 1);
			if ((world.getBlockState(new BlockPos(
					entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
									entity.getLook(1f).z * raytrace_distance),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getX(),
					entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
									entity.getLook(1f).z * raytrace_distance),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getY(),
					entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
									entity.getLook(1f).z * raytrace_distance),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getZ())))
					.getBlock() == Blocks.WATER
					&& world.isAirBlock(new BlockPos(
							entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
											entity.getLook(1f).z * raytrace_distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getX(),
							entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
											entity.getLook(1f).z * raytrace_distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getY() + 1,
							entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
											entity.getLook(1f).z * raytrace_distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getZ()))
					&& !BlockTags.getCollection().getTagByID(new ResourceLocation("forge:large_lilies"))
							.contains((world.getBlockState(new BlockPos(
									entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
													entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getX() + 1,
									entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
													entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getY() + 1,
									entity.world
											.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
															entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
											.getPos().getZ())))
									.getBlock())
					&& !BlockTags
							.getCollection().getTagByID(
									new ResourceLocation("forge:large_lilies"))
							.contains(
									(world.getBlockState(
											new BlockPos(
													entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
																			entity.getLook(1f).y * raytrace_distance,
																			entity.getLook(1f).z * raytrace_distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
															.getPos().getX() - 1,
													entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
																			entity.getLook(1f).y * raytrace_distance,
																			entity.getLook(1f).z * raytrace_distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
															.getPos().getY() + 1,
													entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f)
																			.add(entity.getLook(1f).x * raytrace_distance,
																					entity.getLook(1f).y * raytrace_distance,
																					entity.getLook(1f).z * raytrace_distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
															.getPos().getZ())))
											.getBlock())
					&& !BlockTags.getCollection().getTagByID(new ResourceLocation("forge:large_lilies"))
							.contains((world.getBlockState(new BlockPos(
									entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
													entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getX(),
									entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
													entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getY() + 1,
									entity.world
											.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
															entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
											.getPos().getZ() + 1)))
									.getBlock())
					&& !BlockTags.getCollection().getTagByID(new ResourceLocation("forge:large_lilies"))
							.contains((world.getBlockState(new BlockPos(
									entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
													entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getX(),
									entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
													entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getY() + 1,
									entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
													entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getZ() - 1)))
									.getBlock())) {
				if (!world.isRemote()) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null,
								new BlockPos(
										entity.world
												.rayTraceBlocks(
														new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
																		entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z
																				* raytrace_distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
												.getPos().getX(),
										entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
																entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
												.getPos().getY() + 1,
										entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
														entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getZ()),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lily_pad.place")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world)
								.playSound(
										(entity.world
												.rayTraceBlocks(
														new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
																.add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y
																		* raytrace_distance, entity.getLook(1f).z * raytrace_distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
												.getPos().getX()),
										(entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
																entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
												.getPos().getY() + 1),
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
														entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getZ()),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("block.lily_pad.place")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					world.setBlockState(new BlockPos(
							entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
											entity.getLook(1f).z * raytrace_distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getX(),
							entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
											entity.getLook(1f).z * raytrace_distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getY() + 1,
							entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
											entity.getLook(1f).z * raytrace_distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getZ()),
							ViralgaBlockBlock.block.getDefaultState(), 3);
					if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
						(itemstack).shrink((int) 1);
					}
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == itemstack
							.getItem()) {
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
						}
					} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == itemstack.getItem()) {
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).swing(Hand.OFF_HAND, true);
						}
					}
					break;
				}
			}
		}
	}
}
