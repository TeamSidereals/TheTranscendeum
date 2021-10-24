
package io.github.team_lodestar.transcendeum.item;

@TheTranscendeumModElements.ModElement.Tag
public class ExcerockAxeItem extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:excerock_axe")
	public static final Item block = null;

	public ExcerockAxeItem(TheTranscendeumModElements instance) {
		super(instance, 404);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 201;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return 6f;
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
		}, 1, -3.1f, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {

		}.setRegistryName("excerock_axe"));
	}

}
