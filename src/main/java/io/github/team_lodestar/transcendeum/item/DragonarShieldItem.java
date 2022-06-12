
package io.github.team_lodestar.transcendeum.item;

import io.github.team_lodestar.transcendeum.itemgroup.TranscendeumGearItemGroup;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;

import java.util.List;

import io.github.team_lodestar.transcendeum.TheTranscendeumModElements;

@TheTranscendeumModElements.ModElement.Tag
public class DragonarShieldItem extends TheTranscendeumModElements.ModElement {
	@ObjectHolder("the_transcendeum:dragonar_shield")
	public static final Item block = null;
	public DragonarShieldItem(TheTranscendeumModElements instance) {
		super(instance, 403);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShieldItem(new Item.Properties().maxDamage(336 * 2).group(TranscendeumGearItemGroup.tab)) {
			@Override
			public String getTranslationKey(ItemStack stack) {
				return stack.getChildTag("BlockEntityTag") != null
						? this.getTranslationKey() + '.' + getColor(stack).getTranslationKey()
						: super.getTranslationKey(stack);
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A78A tool empowered by the ancient dragons."));
				list.add(new StringTextComponent(
						"\u00A76Knocks up and deals extra 4 damage to the target, only if the target is a mob of the Transcendeum dimension."));
			}
		}.setRegistryName("dragonar_shield"));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class RenderRegistry {
		@SubscribeEvent
		public static void registerModel(final FMLClientSetupEvent event) {
			ItemModelsProperties.registerProperty(block, new ResourceLocation("blocking"), (itemStack, clientWorld, entity) -> entity != null && entity.isHandActive() && entity.getActiveItemStack() == itemStack ? 1.0F : 0.0F);
		}
	}
}
