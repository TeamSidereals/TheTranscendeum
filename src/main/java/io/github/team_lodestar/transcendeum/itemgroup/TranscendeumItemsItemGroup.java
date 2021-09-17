
package io.github.team_lodestar.transcendeum.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class TranscendeumItemsItemGroup extends TheTranscendeumModElements.ModElement {
	public TranscendeumItemsItemGroup(TheTranscendeumModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtranscendeum_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.COAL);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
