
package io.github.team_lodestar.transcendeum.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.potion.Potion;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArcedeonianBrewPotion {
	@ObjectHolder("the_transcendeum:arcedeonian_brew")
	public static final Potion potionType = null;
	@SubscribeEvent
	public static void registerPotion(RegistryEvent.Register<Potion> event) {
		event.getRegistry().register(new PotionCustom());
	}
	public static class PotionCustom extends Potion {
		public PotionCustom() {
			super(new EffectInstance(Effects.DOLPHINS_GRACE, 600, 0, true, true), new EffectInstance(Effects.WATER_BREATHING, 600, 0, true, true));
			setRegistryName("arcedeonian_brew");
		}
	}
}
