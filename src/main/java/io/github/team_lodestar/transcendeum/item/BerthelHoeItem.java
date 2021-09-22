
package io.github.team_lodestar.transcendeum.item;

@TheTranscendeumModElements.ModElement.Tag
public class BerthelHoeItem extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:berthel_hoe")
	public static final Item block = null;

	public BerthelHoeItem(TheTranscendeumModElements instance) {
		super(instance, 150);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 1050;
			}

			public float getEfficiency() {
				return 11f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 11;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(BerthelShardItem.block));
			}
		}, 1, 1f, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {

		}.setRegistryName("berthel_hoe"));
	}

}
