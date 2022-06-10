
package io.github.team_lodestar.transcendeum.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import io.github.team_lodestar.transcendeum.itemgroup.TranscendeumItemsItemGroup;
import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class EfowFruitItem extends TheTranscendeumModElements.ModElement {
	@ObjectHolder("the_transcendeum:efow_fruit")
	public static final Item block = null;

	public EfowFruitItem(TheTranscendeumModElements instance) {
		super(instance, 441);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TranscendeumItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("efow_fruit");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 32;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
