
package io.github.team_lodestar.transcendeum.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.List;
import java.util.Collections;

import io.github.team_lodestar.transcendeum.procedures.SullcactusBlockValidPlacementConditionProcedure;
import io.github.team_lodestar.transcendeum.itemgroup.TranscendeumBlocksItemGroup;
import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

import com.google.common.collect.ImmutableMap;

@TheTranscendeumModElements.ModElement.Tag
public class SullcactusBlock extends TheTranscendeumModElements.ModElement {
	@ObjectHolder("the_transcendeum:sullcactus")
	public static final Block block = null;
	public SullcactusBlock(TheTranscendeumModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(TranscendeumBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.CACTUS).sound(SoundType.CLOTH).hardnessAndResistance(0.5f, 0.5f).setLightLevel(s -> 0)
					.tickRandomly());
			setRegistryName("sullcactus");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public boolean isValidPosition(BlockState blockstate, IWorldReader worldIn, BlockPos pos) {
			if (worldIn instanceof IWorld) {
				IWorld world = (IWorld) worldIn;
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				return SullcactusBlockValidPlacementConditionProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world));
			}
			return super.isValidPosition(blockstate, worldIn, pos);
		}

		@Override
		public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos,
				BlockPos facingPos) {
			return !state.isValidPosition(world, currentPos)
					? Blocks.AIR.getDefaultState()
					: super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
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
