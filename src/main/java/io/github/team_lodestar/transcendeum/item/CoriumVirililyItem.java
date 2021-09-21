
package io.github.team_lodestar.transcendeum.item;

@TheTranscendeumModElements.ModElement.Tag
public class CoriumVirililyItem extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:corium_virilily")
	public static final Item block = null;

	public CoriumVirililyItem(TheTranscendeumModElements instance) {
		super(instance, 131);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(TranscendeumBlocksItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("corium_virilily");
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

			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);

				CoriumVirililyRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}

	}

}
