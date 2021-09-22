
package io.github.team_lodestar.transcendeum.item;

@TheTranscendeumModElements.ModElement.Tag
public class BerthelPickaxeItem extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:berthel_pickaxe")
	public static final Item block = null;

	public BerthelPickaxeItem(TheTranscendeumModElements instance) {
		super(instance, 148);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1050;
			}

			public float getEfficiency() {
				return 11f;
			}

			public float getAttackDamage() {
				return 3f;
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
		}, 1, -2.8f, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {

		}.setRegistryName("berthel_pickaxe"));
	}

}
