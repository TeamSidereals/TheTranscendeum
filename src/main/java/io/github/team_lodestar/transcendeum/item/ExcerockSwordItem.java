
package io.github.team_lodestar.transcendeum.item;

@TheTranscendeumModElements.ModElement.Tag
public class ExcerockSwordItem extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:excerock_sword")
	public static final Item block = null;

	public ExcerockSwordItem(TheTranscendeumModElements instance) {
		super(instance, 399);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 201;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 9;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ExcerockBlock.block));
			}
		}, 3, -2.4f, new Item.Properties().group(TranscendeumItemsItemGroup.tab)) {

		}.setRegistryName("excerock_sword"));
	}

}
