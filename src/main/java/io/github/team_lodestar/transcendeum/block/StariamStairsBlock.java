
package io.github.team_lodestar.transcendeum.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@TheTranscendeumModElements.ModElement.Tag
public class StariamStairsBlock extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:stariam_stairs")
	public static final Block block = null;

	public StariamStairsBlock(TheTranscendeumModElements instance) {
		super(instance, 24);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(TranscendeumBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StairsBlock {

		public CustomBlock() {
			super(() -> new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3f, 2f).setLightLevel(s -> 0))
					.getDefaultState(),
					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3f, 2f).setLightLevel(s -> 0));

			setRegistryName("stariam_stairs");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 5;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
