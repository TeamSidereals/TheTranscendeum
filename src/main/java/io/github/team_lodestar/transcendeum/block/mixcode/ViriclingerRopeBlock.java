package io.github.team_lodestar.transcendeum.block.mixcode;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ViriclingerRopeBlock extends ScaffoldingBlock {

    public ViriclingerRopeBlock(Properties properties) {
        super(properties);
    }

    private static final VoxelShape TOP_SLAB_SHAPE;

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return checkSurroundBlock(worldIn, pos, state);
    }

    @Override
    public boolean isScaffolding(BlockState state, IWorldReader world, BlockPos pos, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, LivingEntity entity) {
        return true;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.fullCube();
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.empty();
    }

    public boolean checkSurroundBlock(IWorldReader world, BlockPos pos, BlockState state){
        boolean top = world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).isSolid();
        boolean surround1 = world.getBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ())).isSolid();
        boolean surround2 = world.getBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ())).isSolid();
        boolean surround3 = world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1)).isSolid();
        boolean surround4 = world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1)).isSolid();
        Block topblock = world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock();
        if (!top && !surround1 && !surround2 && !surround3 && !surround4 && topblock != MixCodeBlockRegister.VIRICLINGER_ROPE.get()) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!worldIn.isRemote){
            if (!checkSurroundBlock(worldIn,pos,state)){
                worldIn.destroyBlock(pos,true);
            }
        }
    }
    static {
        VoxelShape voxelshape = Block.makeCuboidShape(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D);
        VoxelShape voxelshape1 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 2.0D);
        VoxelShape voxelshape2 = Block.makeCuboidShape(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D);
        VoxelShape voxelshape3 = Block.makeCuboidShape(0.0D, 0.0D, 14.0D, 2.0D, 16.0D, 16.0D);
        VoxelShape voxelshape4 = Block.makeCuboidShape(14.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D);
        TOP_SLAB_SHAPE = VoxelShapes.or(voxelshape, voxelshape1, voxelshape2, voxelshape3, voxelshape4);
    }
}
