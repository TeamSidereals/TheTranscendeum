package io.github.team_lodestar.transcendeum.item.mixcode.custom;

import io.github.team_lodestar.transcendeum.entity.mixcode.custom.PurifyPowderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class PurifyPowderItem extends Item {

    public PurifyPowderItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote){
            if (!playerIn.isCrouching()) {
                ArrayList<PurifyPowderEntity> purifyPowderEntity = new ArrayList<>();
                Random roll = new Random();
                purifyPowderEntity.add(new PurifyPowderEntity(worldIn, playerIn));
                purifyPowderEntity.get(0).func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw,
                        0f, 1.0f, 1f);
                purifyPowderEntity.add(new PurifyPowderEntity(worldIn, playerIn));
                purifyPowderEntity.get(1).func_234612_a_(playerIn, playerIn.rotationPitch + (float) ((roll.nextGaussian() - 0.5) * 3f), playerIn.rotationYaw + 10,
                        0f, 1.0f, 1f);
                purifyPowderEntity.add(new PurifyPowderEntity(worldIn, playerIn));
                purifyPowderEntity.get(2).func_234612_a_(playerIn, playerIn.rotationPitch + (float) ((roll.nextGaussian() - 0.5) * 3f), playerIn.rotationYaw - 10,
                        0f, 1.0f, 1f);
                purifyPowderEntity.add(new PurifyPowderEntity(worldIn, playerIn));
                purifyPowderEntity.get(3).func_234612_a_(playerIn, playerIn.rotationPitch + (float) ((roll.nextGaussian() - 0.5) * 3f), playerIn.rotationYaw + 20,
                        0f, 1.0f, 1f);
                purifyPowderEntity.add(new PurifyPowderEntity(worldIn, playerIn));
                purifyPowderEntity.get(4).func_234612_a_(playerIn, playerIn.rotationPitch + (float) ((roll.nextGaussian() - 0.5) * 3f), playerIn.rotationYaw - 20,
                        0f, 1.0f, 1f);
                for (PurifyPowderEntity purifyPowder : purifyPowderEntity) {
                    worldIn.addEntity(purifyPowder);
                }
            }
            else {
                PurifyPowderEntity purifyPowderEntity = new PurifyPowderEntity(worldIn, playerIn);
                purifyPowderEntity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw,
                        0f, 1.0f, 1f);
                worldIn.addEntity(purifyPowderEntity);
            }
        }
        stack.shrink(1);
        return ActionResult.resultSuccess(stack);
    }
}
