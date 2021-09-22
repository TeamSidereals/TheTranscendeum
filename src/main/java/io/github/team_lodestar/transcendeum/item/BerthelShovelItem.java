
package io.github.team_lodestar.transcendeum.item;

@TheTranscendeumModElements.ModElement.Tag
public class BerthelShovelItem extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:berthel_shovel")
	public static final Item block = null;

	public BerthelShovelItem(TheTranscendeumModElements instance) {
		super(instance, 149);
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
				return 2f;
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
		}, 1, -3.1f, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {

		}.setRegistryName("berthel_shovel"));
	}

}
