
package io.github.team_lodestar.transcendeum.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@TheTranscendeumModElements.ModElement.Tag
public class PolishedMorositeSlabBlock extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:polished_morosite_slab")
	public static final Block block = null;

	public PolishedMorositeSlabBlock(TheTranscendeumModElements instance) {
		super(instance, 175);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(TranscendeumBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends SlabBlock {

		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(0.9f, 0.9f).setLightLevel(s -> 0)
					.harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().tickRandomly());

			setRegistryName("polished_morosite_slab");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, state.get(TYPE) == SlabType.DOUBLE ? 2 : 1));
		}

	}

}
