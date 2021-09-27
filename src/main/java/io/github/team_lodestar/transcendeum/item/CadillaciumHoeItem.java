
package io.github.team_lodestar.transcendeum.item;

@TheTranscendeumModElements.ModElement.Tag
public class CadillaciumHoeItem extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:cadillacium_hoe")
	public static final Item block = null;

	public CadillaciumHoeItem(TheTranscendeumModElements instance) {
		super(instance, 206);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 916;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CadillaciumIngotItem.block));
			}
		}, 0, 0f, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {

		}.setRegistryName("cadillacium_hoe"));
	}

}
