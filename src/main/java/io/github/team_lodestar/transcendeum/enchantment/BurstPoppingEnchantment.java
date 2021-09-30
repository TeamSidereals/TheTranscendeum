
package io.github.team_lodestar.transcendeum.enchantment;

@TheTranscendeumModElements.ModElement.Tag
public class BurstPoppingEnchantment extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:burst_popping")
	public static final Enchantment enchantment = null;

	public BurstPoppingEnchantment(TheTranscendeumModElements instance) {
		super(instance, 249);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("burst_popping"));
	}

	public static class CustomEnchantment extends Enchantment {

		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.COMMON, EnchantmentType.ARMOR_HEAD, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 3;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == BubbleBlock.block.asItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return false;
		}

		@Override
		public boolean canGenerateInLoot() {
			return false;
		}

		@Override
		public boolean canVillagerTrade() {
			return false;
		}

	}

}
