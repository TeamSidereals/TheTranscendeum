
package io.github.team_lodestar.transcendeum.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@TheTranscendeumModElements.ModElement.Tag
public class PyrrhicBushNetBlock extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:pyrrhic_bush_net")
	public static final Block block = null;

	public PyrrhicBushNetBlock(TheTranscendeumModElements instance) {
		super(instance, 390);

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

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.WEB).sound(SoundType.VINE).hardnessAndResistance(1f, 1f).setLightLevel(s -> 0).harvestLevel(0)
					.harvestTool(ToolType.HOE).setRequiresTool().doesNotBlockMovement().speedFactor(0.7f).jumpFactor(0f).notSolid()
					.setOpaque((bs, br, bp) -> false));

			setRegistryName("pyrrhic_bush_net");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {

			return VoxelShapes.or(makeCuboidShape(0, 0, 0, 16, 1, 16)

			)

			;
		}

		@Override
		public boolean canProvidePower(BlockState state) {
			return true;
		}

		@Override
		public int getWeakPower(BlockState blockstate, IBlockReader blockAccess, BlockPos pos, Direction side) {
			return 1;
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 5;
		}

		@Override
		public PushReaction getPushReaction(BlockState state) {
			return PushReaction.DESTROY;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public void onEntityCollision(BlockState blockstate, World world, BlockPos pos, Entity entity) {
			super.onEntityCollision(blockstate, world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			PyrrhicBushNetSteppingProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}

	}

}
