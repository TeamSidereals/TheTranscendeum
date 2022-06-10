package io.github.team_lodestar.transcendeum.procedures;

import net.minecraftforge.eventbus.api.Event;

public class KalaisicWaterEvaporationProcedure {

	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
			PlayerEntity entity = event.getPlayer();
			if (event.getHand() != entity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			BlockState state = world.getBlockState(event.getPos());
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("direction", event.getFace());
			dependencies.put("blockstate", state);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency world for procedure KalaisicWaterEvaporation!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency x for procedure KalaisicWaterEvaporation!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency y for procedure KalaisicWaterEvaporation!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency z for procedure KalaisicWaterEvaporation!");
			return;
		}
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency direction for procedure KalaisicWaterEvaporation!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TheTranscendeumMod.LOGGER.warn("Failed to load dependency entity for procedure KalaisicWaterEvaporation!");
			return;
		}

		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Direction direction = (Direction) dependencies.get("direction");
		Entity entity = (Entity) dependencies.get("entity");

		boolean flag = false;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!world.isRemote()) {
			if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))) != null
					&& world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
							.equals(new ResourceLocation("the_transcendeum:kalaisic_wastes"))
					&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.WATER_BUCKET
							|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
									.getItem() == Items.WATER_BUCKET)) {
				new Object() {

					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (direction == Direction.NORTH) {
							if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
									.getMaterial() == net.minecraft.block.material.Material.WATER
									&& world.canBlockSeeSky(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))) {
								{
									BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z - 1));
									BlockState _bs = Blocks.AIR.getDefaultState();

									world.setBlockState(_bp, _bs, 3);

								}
								if (world instanceof World && !world.isRemote()) {
									((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) (z - 1)),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("block.fire.extinguish")),
											SoundCategory.AMBIENT, (float) 1, (float) 1);
								} else {
									((World) world).playSound(x, y, (z - 1),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("block.fire.extinguish")),
											SoundCategory.AMBIENT, (float) 1, (float) 1, false);
								}
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, y, (z - 1), (int) 20, 0.2, 0.2, 0.2, 0);
								}
							}
						} else if (direction == Direction.SOUTH) {
							if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
									.getMaterial() == net.minecraft.block.material.Material.WATER
									&& world.canBlockSeeSky(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))) {
								{
									BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z + 1));
									BlockState _bs = Blocks.AIR.getDefaultState();

									world.setBlockState(_bp, _bs, 3);

								}
								if (world instanceof World && !world.isRemote()) {
									((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) (z + 1)),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("block.fire.extinguish")),
											SoundCategory.AMBIENT, (float) 1, (float) 1);
								} else {
									((World) world).playSound(x, y, (z + 1),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("block.fire.extinguish")),
											SoundCategory.AMBIENT, (float) 1, (float) 1, false);
								}
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, y, (z + 1), (int) 20, 0.2, 0.2, 0.2, 0);
								}
							}
						} else if (direction == Direction.WEST) {
							if ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)))
									.getMaterial() == net.minecraft.block.material.Material.WATER
									&& world.canBlockSeeSky(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))) {
								{
									BlockPos _bp = new BlockPos((int) (x - 1), (int) y, (int) z);
									BlockState _bs = Blocks.AIR.getDefaultState();

									world.setBlockState(_bp, _bs, 3);

								}
								if (world instanceof World && !world.isRemote()) {
									((World) world).playSound(null, new BlockPos((int) (x - 1), (int) y, (int) z),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("block.fire.extinguish")),
											SoundCategory.AMBIENT, (float) 1, (float) 1);
								} else {
									((World) world).playSound((x - 1), y, z,
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("block.fire.extinguish")),
											SoundCategory.AMBIENT, (float) 1, (float) 1, false);
								}
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (x - 1), y, z, (int) 20, 0.2, 0.2, 0.2, 0);
								}
							}
						} else if (direction == Direction.EAST) {
							if ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)))
									.getMaterial() == net.minecraft.block.material.Material.WATER
									&& world.canBlockSeeSky(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))) {
								{
									BlockPos _bp = new BlockPos((int) (x + 1), (int) y, (int) z);
									BlockState _bs = Blocks.AIR.getDefaultState();

									world.setBlockState(_bp, _bs, 3);

								}
								if (world instanceof World && !world.isRemote()) {
									((World) world).playSound(null, new BlockPos((int) (x + 1), (int) y, (int) z),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("block.fire.extinguish")),
											SoundCategory.AMBIENT, (float) 1, (float) 1);
								} else {
									((World) world).playSound((x + 1), y, z,
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("block.fire.extinguish")),
											SoundCategory.AMBIENT, (float) 1, (float) 1, false);
								}
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, (x + 1), y, z, (int) 20, 0.2, 0.2, 0.2, 0);
								}
							}
						} else if (direction == Direction.UP) {
							if ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
									.getMaterial() == net.minecraft.block.material.Material.WATER
									&& world.canBlockSeeSky(new BlockPos((int) x, (int) (y + 2), (int) z))) {
								{
									BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
									BlockState _bs = Blocks.AIR.getDefaultState();

									world.setBlockState(_bp, _bs, 3);

								}
								if (world instanceof World && !world.isRemote()) {
									((World) world).playSound(null, new BlockPos((int) x, (int) (y + 1), (int) z),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("block.fire.extinguish")),
											SoundCategory.AMBIENT, (float) 1, (float) 1);
								} else {
									((World) world).playSound(x, (y + 1), z,
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("block.fire.extinguish")),
											SoundCategory.AMBIENT, (float) 1, (float) 1, false);
								}
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y + 1), z, (int) 20, 0.2, 0.2, 0.2, 0);
								}
							}
						} else if (direction == Direction.DOWN) {
							if ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
									.getMaterial() == net.minecraft.block.material.Material.WATER
									&& world.canBlockSeeSky(new BlockPos((int) x, (int) y, (int) z))) {
								{
									BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
									BlockState _bs = Blocks.AIR.getDefaultState();

									world.setBlockState(_bp, _bs, 3);

								}
								if (world instanceof World && !world.isRemote()) {
									((World) world).playSound(null, new BlockPos((int) x, (int) (y - 1), (int) z),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("block.fire.extinguish")),
											SoundCategory.AMBIENT, (float) 1, (float) 1);
								} else {
									((World) world).playSound(x, (y - 1), z,
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("block.fire.extinguish")),
											SoundCategory.AMBIENT, (float) 1, (float) 1, false);
								}
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(ParticleTypes.SMOKE, x, (y - 1), z, (int) 20, 0.2, 0.2, 0.2, 0);
								}
							}
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}

				}.start(world, (int) 1);
			}
		}
	}

}
