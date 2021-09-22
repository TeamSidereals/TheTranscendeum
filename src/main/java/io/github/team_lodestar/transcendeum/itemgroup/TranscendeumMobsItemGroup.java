
package io.github.team_lodestar.transcendeum.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class TranscendeumMobsItemGroup extends TheTranscendeumModElements.ModElement {
	public TranscendeumMobsItemGroup(TheTranscendeumModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtranscendeum_mobs") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.DROWNED_SPAWN_EGG);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
