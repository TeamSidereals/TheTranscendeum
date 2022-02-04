package io.github.team_lodestar.transcendeum.item.mixcode.custom;

import io.github.team_lodestar.transcendeum.item.EnigmaGloveItem;
import io.github.team_lodestar.transcendeum.world.biome.TranscendentOceanBiome;
import io.github.team_lodestar.transcendeum.world.biome.TranscendentSeaBiome;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class StaffOfBiosphereItem extends Item {

    public StaffOfBiosphereItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        player.setActiveHand(hand);
        return ActionResult.resultPass(player.getHeldItem(hand));
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, LivingEntity entity, int timeLeft) {
        System.out.println("you just used the staff");
        if (entity instanceof PlayerEntity) {
            if (world.getBiome(entity.getPosition()).getRegistryName().equals(TranscendentOceanBiome.biome.getRegistryName())
            || world.getBiome(entity.getPosition()).getRegistryName().equals(TranscendentSeaBiome.biome.getRegistryName())){
                System.out.println("in ocean/sea biome");
            }
            if (!((PlayerEntity) entity).isCreative() && !entity.isSpectator()) {
                ((PlayerEntity) entity).getCooldownTracker().setCooldown(this, (int) 200);
                System.out.println("on cooldown");
            }
        }
    }
}
