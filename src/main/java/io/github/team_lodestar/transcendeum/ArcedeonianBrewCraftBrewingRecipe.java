
package io.github.team_lodestar.transcendeum;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.potion.PotionUtils;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

import io.github.team_lodestar.transcendeum.potion.ArcedeonianBrewPotion;
import io.github.team_lodestar.transcendeum.block.EfowWeedBubblyBlock;

@TheTranscendeumModElements.ModElement.Tag
public class ArcedeonianBrewCraftBrewingRecipe extends TheTranscendeumModElements.ModElement {
	public ArcedeonianBrewCraftBrewingRecipe(TheTranscendeumModElements instance) {
		super(instance, 249);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}

	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			return input.getItem() == Items.POTION;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == EfowWeedBubblyBlock.block.asItem();
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ArcedeonianBrewPotion.potionType);
			}
			return ItemStack.EMPTY;
		}
	}
}
