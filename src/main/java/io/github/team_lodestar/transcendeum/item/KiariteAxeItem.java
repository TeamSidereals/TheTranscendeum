
package io.github.team_lodestar.transcendeum.item;

import net.minecraft.entity.ai.attributes.Attributes;

@TheTranscendeumModElements.ModElement.Tag
public class KiariteAxeItem extends TheTranscendeumModElements.ModElement {

	@ObjectHolder("the_transcendeum:kiarite_axe")
	public static final Item block = null;

	public KiariteAxeItem(TheTranscendeumModElements instance) {
		super(instance, 137);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2355;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 11.5f;
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
		}, 1, -3f, new Item.Properties().group(TranscendeumGearItemGroup.tab).isImmuneToFire()) {

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00EF\u00BF\u00BD8A tool empowered by the ancient dragons."));
				list.add(new StringTextComponent(
						"\u00EF\u00BF\u00BD6Knocks up and deals extra 4 damage to the target, only if the target is a mob of the Transcendeum dimension."));
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				KiariteToolLivingEntityIsHitWithToolProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("itemstack", itemstack))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

		}.setRegistryName("kiarite_axe"));
	}

}
