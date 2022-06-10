
package io.github.team_lodestar.transcendeum.item;

import net.minecraft.entity.ai.attributes.Attributes;

@TheTranscendeumModElements.ModElement.Tag
public class LargeVirililyItem extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:large_virilily")
	public static final Item block = null;

	public LargeVirililyItem(TheTranscendeumModElements instance) {
		super(instance, 63);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(TranscendeumBlocksItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("large_virilily");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			LargeVirililyRightClickedInAirProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity),
							new AbstractMap.SimpleEntry<>("itemstack", itemstack))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return ar;
		}

	}

}
