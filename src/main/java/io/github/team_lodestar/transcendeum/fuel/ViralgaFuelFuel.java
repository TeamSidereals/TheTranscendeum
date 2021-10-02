
package io.github.team_lodestar.transcendeum.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import io.github.team_lodestar.transcendeum.item.ViralgaItem;

@Mod.EventBusSubscriber
public class ViralgaFuelFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == ViralgaItem.block)
			event.setBurnTime(20);
	}
}
