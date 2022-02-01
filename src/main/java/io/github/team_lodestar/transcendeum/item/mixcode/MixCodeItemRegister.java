package io.github.team_lodestar.transcendeum.item.mixcode;

import io.github.team_lodestar.transcendeum.TheTranscendeumMod;
import io.github.team_lodestar.transcendeum.item.mixcode.custom.StaffOfBiosphereItem;
import io.github.team_lodestar.transcendeum.itemgroup.TranscendeumItemsItemGroup;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MixCodeItemRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheTranscendeumMod.MODID);
    public static void init(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> MEDAL = ITEMS.register("medal", () ->
            new Item(
                    new Item.Properties().group(TranscendeumItemsItemGroup.tab)
            )
    );
    public static final RegistryObject<Item> STAFF_OF_BIOSPHERE = ITEMS.register("staff_of_biosphere", () ->
            new StaffOfBiosphereItem(
                    new Item.Properties().group(TranscendeumItemsItemGroup.tab)
            )
    );
}
