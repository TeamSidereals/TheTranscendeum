package io.github.team_lodestar.transcendeum.procedures;

public class ViralgaRightClickedinAirProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
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
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure ViralgaRightClickedinAir!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");

		double raytrace_distance = 0;
		raytrace_distance = (double) 1;
		for (int index0 = 0; index0 < (int) (5); index0++) {
			raytrace_distance = (double) (raytrace_distance + 1);
			if ((((world.getBlockState(new BlockPos(
					(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
									entity.getLook(1f).z * raytrace_distance),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getX()),
					(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
									entity.getLook(1f).z * raytrace_distance),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getY()),
					(int) (entity.world
							.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
											entity.getLook(1f).z * raytrace_distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
							.getPos().getZ())))).getBlock() == Blocks.WATER)
					&& ((world
							.isAirBlock(
									new BlockPos(
											(int) (entity.world
													.rayTraceBlocks(
															new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x
																			* raytrace_distance, entity.getLook(1f).y * raytrace_distance,
																			entity.getLook(1f).z * raytrace_distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
													.getPos().getX()),
											(int) ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
															entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos()
													.getY()) + 1),
											(int) (entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x
																	* raytrace_distance, entity.getLook(1f).y * raytrace_distance,
																	entity.getLook(1f).z * raytrace_distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
													.getPos().getZ()))))
							&& (((!(BlockTags.getCollection()
									.getTagByID(new ResourceLocation(("forge:large_lilies").toLowerCase(java.util.Locale.ENGLISH)))
									.contains((world.getBlockState(new BlockPos(
											(int) ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
															entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getX()) + 1),
											(int) ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
															entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getY()) + 1),
											(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
															entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getZ()))))
															.getBlock())))
									&& (!(BlockTags.getCollection()
											.getTagByID(
													new ResourceLocation(("forge:large_lilies").toLowerCase(java.util.Locale.ENGLISH)))
											.contains(
													(world.getBlockState(new BlockPos(
															(int) ((entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
																					entity.getLook(1f).y * raytrace_distance,
																					entity.getLook(1f).z * raytrace_distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
																	.getPos().getX()) - 1),
															(int) ((entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
																					entity.getLook(1f).y * raytrace_distance,
																					entity.getLook(1f).z * raytrace_distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
																	.getPos().getY()) + 1),
															(int) (entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
																					entity.getLook(1f).y * raytrace_distance,
																					entity.getLook(1f).z * raytrace_distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
																	.getPos().getZ())))).getBlock()))))
									&& ((!(BlockTags.getCollection()
											.getTagByID(new ResourceLocation(("forge:large_lilies").toLowerCase(java.util.Locale.ENGLISH)))
											.contains(
													(world.getBlockState(
															new BlockPos((int) (entity.world
																	.rayTraceBlocks(new RayTraceContext(
																			entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(
																					entity.getLook(1f).x * raytrace_distance,
																					entity.getLook(1f).y * raytrace_distance,
																					entity.getLook(1f).z * raytrace_distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
																	.getPos().getX()),
																	(int) ((entity.world.rayTraceBlocks(new RayTraceContext(
																			entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
																					entity.getLook(1f).y * raytrace_distance,
																					entity.getLook(1f).z * raytrace_distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
																			.getPos().getY()) + 1),
																	(int) ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
																					entity.getLook(1f).y * raytrace_distance,
																					entity.getLook(1f).z * raytrace_distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
																			.getPos().getZ()) + 1)))).getBlock())))
											&& (!(BlockTags.getCollection()
													.getTagByID(new ResourceLocation(("forge:large_lilies").toLowerCase(java.util.Locale.ENGLISH)))
													.contains((world.getBlockState(new BlockPos((int) (entity.world.rayTraceBlocks(
															new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
																	.add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y
																			* raytrace_distance, entity.getLook(1f).z * raytrace_distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
															.getPos().getX()),
															(int) ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
																			entity.getLook(1f).y * raytrace_distance,
																			entity.getLook(1f).z * raytrace_distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
																	.getPos().getY()) + 1),
															(int) ((entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
																					entity.getLook(1f).y * raytrace_distance,
																					entity.getLook(1f).z * raytrace_distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity))
																	.getPos().getZ()) - 1)))).getBlock())))))))) {
				if ((!(world.isRemote()))) {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null,
								new BlockPos(
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
														entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getX()),
										(int) ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
														entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getY()) + 1),
										(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
														entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getZ())),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lily_pad.place")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
												entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getX()),
								((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
												entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getY()) + 1),
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance,
												entity.getLook(1f).y * raytrace_distance, entity.getLook(1f).z * raytrace_distance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getZ()),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lily_pad.place")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					world.setBlockState(new BlockPos(
							(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
											entity.getLook(1f).z * raytrace_distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getX()),
							(int) ((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
											entity.getLook(1f).z * raytrace_distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getY()) + 1),
							(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * raytrace_distance, entity.getLook(1f).y * raytrace_distance,
											entity.getLook(1f).z * raytrace_distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, entity)).getPos().getZ())),
							ViralgaBlockBlock.block.getDefaultState(), 3);
					if ((!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false))) {
						((itemstack)).shrink((int) 1);
					}
					if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == (itemstack)
							.getItem())) {
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
						}
					} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == (itemstack).getItem())) {
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
