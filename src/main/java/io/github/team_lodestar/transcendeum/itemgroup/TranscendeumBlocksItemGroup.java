
package io.github.team_lodestar.transcendeum.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import io.github.team_lodestar.transcendeum.block.SomberstoneBlock;
import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class TranscendeumBlocksItemGroup extends TheTranscendeumModElements.ModElement {
	public TranscendeumBlocksItemGroup(TheTranscendeumModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtranscendeum_blocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SomberstoneBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
