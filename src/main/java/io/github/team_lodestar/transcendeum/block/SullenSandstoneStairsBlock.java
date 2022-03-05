
package io.github.team_lodestar.transcendeum.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

import io.github.team_lodestar.transcendeum.itemgroup.TranscendeumBlocksItemGroup;
import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class SullenSandstoneStairsBlock extends TheTranscendeumModElements.ModElement {
	@ObjectHolder("the_transcendeum:sullen_sandstone_stairs")
	public static final Block block = null;

	public SullenSandstoneStairsBlock(TheTranscendeumModElements instance) {
		super(instance, 435);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(TranscendeumBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(() -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(0.9f, 0.9f)
					.setLightLevel(s -> 0).harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().tickRandomly()).getDefaultState(),
					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(0.9f, 0.9f).setLightLevel(s -> 0)
							.harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().tickRandomly());
			setRegistryName("sullen_sandstone_stairs");
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
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
