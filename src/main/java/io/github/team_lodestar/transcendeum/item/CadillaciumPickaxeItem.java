
package io.github.team_lodestar.transcendeum.item;

@TheTranscendeumModElements.ModElement.Tag
public class CadillaciumPickaxeItem extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:cadillacium_pickaxe")
	public static final Item block = null;

	public CadillaciumPickaxeItem(TheTranscendeumModElements instance) {
		super(instance, 204);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 916;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 6f;
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
		}, 1, -2.8f, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {

		}.setRegistryName("cadillacium_pickaxe"));
	}

}
