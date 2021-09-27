
package io.github.team_lodestar.transcendeum.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import io.github.team_lodestar.transcendeum.itemgroup.TranscendeumGearItemGroup;
import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class CadillaciumAxeItem extends TheTranscendeumModElements.ModElement {
	@ObjectHolder("the_transcendeum:cadillacium_axe")
	public static final Item block = null;
	public CadillaciumAxeItem(TheTranscendeumModElements instance) {
		super(instance, 203);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 916;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CadillaciumIngotItem.block));
			}
		}, 1, -3.1f, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {
		}.setRegistryName("cadillacium_axe"));
	}
}
