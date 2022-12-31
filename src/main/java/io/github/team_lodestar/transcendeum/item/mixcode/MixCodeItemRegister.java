package io.github.team_lodestar.transcendeum.item.mixcode;

import io.github.team_lodestar.transcendeum.TheTranscendeumMod;
import io.github.team_lodestar.transcendeum.block.mixcode.MixCodeBlockRegister;
import io.github.team_lodestar.transcendeum.item.mixcode.custom.*;
import io.github.team_lodestar.transcendeum.itemgroup.TranscendeumItemsItemGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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
                    new Item.Properties().group(TranscendeumItemsItemGroup.tab).maxStackSize(1)
            )
    );
    public static final RegistryObject<Item> VIRICLINGER_ROPE = ITEMS.register("viriclinger_rope", () ->
            new ViriclingerBlockItem(
                    MixCodeBlockRegister.VIRICLINGER_ROPE.get(),
                    new Item.Properties().group(TranscendeumItemsItemGroup.tab)
            )
    );
    public static final RegistryObject<Item> PURIFY_POWDER = ITEMS.register("purify_powder", () ->
            new PurifyPowderItem(
                    new Item.Properties().group(TranscendeumItemsItemGroup.tab)
            )
    );
    public static final RegistryObject<Item> TOMA_CAKE = ITEMS.register("toma_cake", () ->
            new TomaCakeItem(
                    new Item.Properties()
                            .group(TranscendeumItemsItemGroup.tab)
                            .food(new Food.Builder()
                                    .hunger(4)
                                    .saturation(1.5f)
                                    .effect(() -> new EffectInstance(Effects.STRENGTH,200,1),1.0f)
                                    .setAlwaysEdible()
                                    .build())
            )
    );
    public static final RegistryObject<Item> AQU_CAKE = ITEMS.register("aqu_cake", () ->
            new AquCakeItem(
                    new Item.Properties()
                            .group(TranscendeumItemsItemGroup.tab)
                            .food(new Food.Builder()
                                    .hunger(4)
                                    .saturation(1.5f)
                                    .effect(() -> new EffectInstance(Effects.HUNGER,200,1),1.0f)
                                    .effect(() -> new EffectInstance(Effects.SLOWNESS,200,2),1.0f)
                                    .effect(() -> new EffectInstance(Effects.NAUSEA,200,1),1.0f)
                                    .effect(() -> new EffectInstance(Effects.POISON,200,1),1.0f)
                                    .effect(() -> new EffectInstance(Effects.WEAKNESS,200,2),1.0f)
                                    .effect(() -> new EffectInstance(Effects.BLINDNESS,200,1),1.0f)
                                    .effect(() -> new EffectInstance(Effects.MINING_FATIGUE,200,2),1.0f)
                                    .effect(() -> new EffectInstance(Effects.WITHER,200,1),1.0f)
                                    .effect(() -> new EffectInstance(Effects.UNLUCK,200,1),1.0f)
                                    .setAlwaysEdible()
                                    .build())
            )
    );
    public static final RegistryObject<Item> LYOF_CAKE = ITEMS.register("lyof_cake", () ->
            new LyofCakeItem(
                    new Item.Properties()
                            .group(TranscendeumItemsItemGroup.tab)
                            .food(new Food.Builder()
                                    .hunger(4)
                                    .saturation(1.5f)
                                    .effect(() -> new EffectInstance(Effects.SPEED,200,1),1.0f)
                                    .setAlwaysEdible()
                                    .build())
            )
    );
    public static final RegistryObject<Item> DDX_CAKE = ITEMS.register("ddx_cake", () ->
            new DdxCakeItem(
                    new Item.Properties()
                            .group(TranscendeumItemsItemGroup.tab)
                            .food(new Food.Builder()
                                    .hunger(4)
                                    .saturation(1.5f)
                                    .effect(() -> new EffectInstance(Effects.ABSORPTION,200,3),1.0f)
                                    .setAlwaysEdible()
                                    .build())
            )
    );
}
