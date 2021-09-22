
package io.github.team_lodestar.transcendeum.item;

@TheTranscendeumModElements.ModElement.Tag
public class BerthelSwordItem extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:berthel_sword")
	public static final Item block = null;

	public BerthelSwordItem(TheTranscendeumModElements instance) {
		super(instance, 146);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1050;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 11;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(BerthelShardItem.block));
			}
		}, 3, -2.4f, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {

		}.setRegistryName("berthel_sword"));
	}

}
