package io.github.team_lodestar.transcendeum.item.mixcode.custom;

import io.github.team_lodestar.transcendeum.entity.mixcode.custom.PurifyPowderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class PurifyPowderItem extends Item {

    public PurifyPowderItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (!worldIn.isRemote){
            PurifyPowderEntity purifyPowderEntity = new PurifyPowderEntity(worldIn, playerIn);
            purifyPowderEntity.setItem(stack);
            purifyPowderEntity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0f, 1.5f, 1f);
            worldIn.addEntity(purifyPowderEntity);
        }
        return ActionResult.resultSuccess(stack);
    }
}
