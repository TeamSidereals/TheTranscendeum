
package io.github.team_lodestar.transcendeum.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import io.github.team_lodestar.transcendeum.itemgroup.TranscendeumItemsItemGroup;
import io.github.team_lodestar.transcendeum.block.ExcerockBlock;
import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class ExcerockSwordItem extends TheTranscendeumModElements.ModElement {
	@ObjectHolder("the_transcendeum:excerock_sword")
	public static final Item block = null;

	public ExcerockSwordItem(TheTranscendeumModElements instance) {
		super(instance, 399);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 201;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 9;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ExcerockBlock.block));
			}
		}, 3, -2.4f, new Item.Properties().group(TranscendeumItemsItemGroup.tab)) {
		}.setRegistryName("excerock_sword"));
	}
}
