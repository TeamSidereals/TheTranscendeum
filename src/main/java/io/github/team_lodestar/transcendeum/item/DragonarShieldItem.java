
package io.github.team_lodestar.transcendeum.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.UseAction;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;

import java.util.List;

import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class DragonarShieldItem extends TheTranscendeumModElements.ModElement {
	@ObjectHolder("the_transcendeum:dragonar_shield")
	public static final Item block = null;
	public DragonarShieldItem(TheTranscendeumModElements instance) {
		super(instance, 403);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShieldItem(new Item.Properties()) {
			@Override
			public String getTranslationKey(ItemStack stack) {
				return stack.getChildTag("BlockEntityTag") != null
						? this.getTranslationKey() + '.' + getColor(stack).getTranslationKey()
						: super.getTranslationKey(stack);
			}

			@Override
			public UseAction getUseAction(ItemStack stack) {
				return UseAction.BLOCK;
			}

			@Override
			public int getUseDuration(ItemStack stack) {
				return 10;
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
				ItemStack itemstack = playerIn.getHeldItem(handIn);
				playerIn.setActiveHand(handIn);
				return ActionResult.resultConsume(itemstack);
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A78A tool empowered by the ancient dragons."));
				list.add(new StringTextComponent(
						"\u00A76Knocks up and deals extra 4 damage to the target, only if the target is a mob of the Transcendeum dimension."));
			}
		}.setRegistryName("dragonar_shield"));
	}
}
