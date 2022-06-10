
package io.github.team_lodestar.transcendeum.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class TranscendeumMobsItemGroup extends TheTranscendeumModElements.ModElement {
	public TranscendeumMobsItemGroup(TheTranscendeumModElements instance) {
		super(instance, 147);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtranscendeum_mobs") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.TURTLE_EGG);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
