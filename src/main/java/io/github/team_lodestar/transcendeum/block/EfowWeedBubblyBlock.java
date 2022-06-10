
package io.github.team_lodestar.transcendeum.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@TheTranscendeumModElements.ModElement.Tag
public class EfowWeedBubblyBlock extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:efow_weed_bubbly")
	public static final Block block = null;

	public EfowWeedBubblyBlock(TheTranscendeumModElements instance) {
		super(instance, 107);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(TranscendeumBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped());
	}

	public static class CustomBlock extends Block implements IWaterLoggable {

		public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

		public CustomBlock() {
			super(Block.Properties.create(Material.PLANTS).sound(SoundType.LILY_PADS).hardnessAndResistance(0.05f, 0f).setLightLevel(s -> 2)
					.doesNotBlockMovement().notSolid().setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true)
					.setOpaque((bs, br, bp) -> false));

			this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, false));

			setRegistryName("efow_weed_bubbly");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return state.getFluidState().isEmpty();
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {

			return VoxelShapes.or(makeCuboidShape(4, 0, 4, 12, 16, 12)

			)

			;
		}

		@Override
		public boolean isValidPosition(BlockState blockstate, IWorldReader worldIn, BlockPos pos) {
			if (worldIn instanceof IWorld) {
				IWorld world = (IWorld) worldIn;
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				return

				EfowIfCanPlaceProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			return super.isValidPosition(blockstate, worldIn, pos);
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			boolean flag = context.getWorld().getFluidState(context.getPos()).getFluid() == Fluids.WATER;
			return this.getDefaultState().with(WATERLOGGED, flag);
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(WATERLOGGED);
		}

		@Override
		public FluidState getFluidState(BlockState state) {
			return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
		}

		@Override
		public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos,
				BlockPos facingPos) {
			if (state.get(WATERLOGGED)) {
				world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
			}
			return !state.isValidPosition(world, currentPos)
					? Blocks.AIR.getDefaultState()
					: super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
		}

		@Override
		public void neighborChanged(BlockState blockstate, World world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
			super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (world.getRedstonePowerFromNeighbors(new BlockPos(x, y, z)) > 0) {
			} else {
			}

			EfowWeedBreakChangeProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public void animateTick(BlockState blockstate, World world, BlockPos pos, Random random) {
			super.animateTick(blockstate, world, pos, random);
			PlayerEntity entity = Minecraft.getInstance().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (true)
				for (int l = 0; l < 5; ++l) {
					double d0 = (x + random.nextFloat());
					double d1 = (y + random.nextFloat());
					double d2 = (z + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 0.1999999985098839D;
					double d4 = (random.nextFloat() - 0.5D) * 0.1999999985098839D;
					double d5 = (random.nextFloat() - 0.5D) * 0.1999999985098839D;
					world.addParticle(ParticleTypes.BUBBLE, d0, d1, d2, d3, d4, d5);
				}
		}

	}

}
