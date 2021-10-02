
package io.github.team_lodestar.transcendeum.fuel;

@Mod.EventBusSubscriber
public class ViralgaFuelFuel {

	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == ViralgaItem.block)
			event.setBurnTime(20);
	}

}
