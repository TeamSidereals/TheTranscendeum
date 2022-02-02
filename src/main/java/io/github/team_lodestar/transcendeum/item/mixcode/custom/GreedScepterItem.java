package io.github.team_lodestar.transcendeum.item.mixcode.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class GreedScepterItem extends Item {

    public GreedScepterItem(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("\u00A77Some ancient documents said it bring whealth to kingdoms.\u00A7r"));
        tooltip.add(new TranslationTextComponent("\u00A7bThis scepter once be called\u00A7r \u00A7eGold Scepter\u00A7r\u00A7b.\u00A7r"));
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        if (!world.isRemote){
            Random roll = new Random();
            Double rollNumber = roll.nextDouble();
            if (rollNumber < 0.5){
                PlayerEntity player = context.getPlayer();
                ItemStack stack = context.getItem();
                player.setHealth(player.getHealth()/2);
                stack.shrink(1);
            }
            else {
                BlockState clickedBlock = world.getBlockState(context.getPos());
                if (clickedBlock.getBlock() != Blocks.SPAWNER && clickedBlock.getBlock() != Blocks.BEDROCK){
                    world.setBlockState(context.getPos(), Blocks.GOLD_BLOCK.getDefaultState());
                }
            }
        }
        return super.onItemUse(context);
    }

}
