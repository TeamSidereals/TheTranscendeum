
package io.github.team_lodestar.transcendeum.item;

@TheTranscendeumModElements.ModElement.Tag
public class KiariteShovelItem extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:kiarite_shovel")
	public static final Item block = null;

	public KiariteShovelItem(TheTranscendeumModElements instance) {
		super(instance, 274);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 2355;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 21;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(KiariteIngotItem.block));
			}
		}, 1, -3f, new Item.Properties().group(TranscendeumGearItemGroup.tab)) {

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();

					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);

					KiariteToolLivingEntityIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

		}.setRegistryName("kiarite_shovel"));
	}

}
