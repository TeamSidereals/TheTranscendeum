package io.github.team_lodestar.transcendeum.item.mixcode.custom;

import io.github.team_lodestar.transcendeum.block.mixcode.MixCodeBlockRegister;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ViriclingerBlockItem extends BlockItem {

    public ViriclingerBlockItem(Block block, Properties builder) {
        super(block, builder);
    }

    @Nullable
    public BlockItemUseContext getBlockItemUseContext(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        World world = context.getWorld();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = this.getBlock();
        Direction direction= Direction.DOWN;
        if (!blockstate.isIn(block)) {
            return context;
        } else {
            BlockPos.Mutable blockpos$mutable = blockpos.toMutable().move(direction);
            while(world.getBlockState(blockpos$mutable).getBlock() == MixCodeBlockRegister.VIRICLINGER_ROPE.get()) {
                blockpos$mutable.move(direction);
            }
            if (world.getBlockState(blockpos$mutable).isReplaceable(context)) {
                return BlockItemUseContext.func_221536_a(context, blockpos$mutable, direction);
            }
            else {
                return null;
            }
        }
    }
}
