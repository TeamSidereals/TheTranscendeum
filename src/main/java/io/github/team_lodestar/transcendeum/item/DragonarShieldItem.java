package io.github.team_lodestar.transcendeum.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import java.util.List;

import io.github.team_lodestar.transcendeum.itemgroup.TranscendeumGearItemGroup;
import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class DragonarShieldItem extends TheTranscendeumModElements.ModElement {
	@ObjectHolder("the_transcendeum:dragonar_shield")
	public static final Item block = null;
	public DragonarShieldItem(TheTranscendeumModElements instance) {
		super(instance, 388);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends ShieldItem {
		public ItemCustom() {
			super(new Item.Properties().group(TranscendeumGearItemGroup.tab).maxStackSize(64).isImmuneToFire().rarity(Rarity.COMMON));
			setRegistryName("dragonar_shield");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 150000;
		}

		@Override
		public boolean isShield(ItemStack stack, LivingEntity entity) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u00A78A tool empowered by the ancient dragons."));
			list.add(new StringTextComponent(
					"\u00A76Knocks up and deals extra 4 damage to the target, only if the target is a mob of the Transcendeum dimension."));
		}
	}
}
