
package io.github.team_lodestar.transcendeum.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import io.github.team_lodestar.transcendeum.item.BerthelShardItem;
import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class TranscendeumItemsItemGroup extends TheTranscendeumModElements.ModElement {
	public TranscendeumItemsItemGroup(TheTranscendeumModElements instance) {
		super(instance, 146);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtranscendeum_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BerthelShardItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
