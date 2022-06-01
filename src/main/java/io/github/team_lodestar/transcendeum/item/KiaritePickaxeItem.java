
package io.github.team_lodestar.transcendeum.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

import io.github.team_lodestar.transcendeum.procedures.KiariteToolLivingEntityIsHitWithToolProcedure;
import io.github.team_lodestar.transcendeum.itemgroup.TranscendeumGearItemGroup;
import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class KiaritePickaxeItem extends TheTranscendeumModElements.ModElement {
	@ObjectHolder("the_transcendeum:kiarite_pickaxe")
	public static final Item block = null;

	public KiaritePickaxeItem(TheTranscendeumModElements instance) {
		super(instance, 138);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
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
		}, 1, -3f, new Item.Properties().group(TranscendeumGearItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
<<<<<<< HEAD
				list.add(new StringTextComponent("?8A tool empowered by the ancient dragons."));
=======
				list.add(new StringTextComponent("\u00A78A tool empowered by the ancient dragons."));
>>>>>>> branch 'master' of https://github.com/Team-Lodestar/TheTranscendeum.git
				list.add(new StringTextComponent(
<<<<<<< HEAD
						"?6Knocks up and deals extra 2 damage to the target, only if the target is a mob of the Transcendeum dimension."));
=======
						"\u00A76Knocks up and deals extra 2 damage to the target, only if the target is a mob of the Transcendeum dimension."));
>>>>>>> branch 'master' of https://github.com/Team-Lodestar/TheTranscendeum.git
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
		}.setRegistryName("kiarite_pickaxe"));
	}
}
