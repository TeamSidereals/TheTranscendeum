package io.github.team_lodestar.transcendeum.block.mixcode;

import io.github.team_lodestar.transcendeum.TheTranscendeumMod;
import io.github.team_lodestar.transcendeum.item.mixcode.MixCodeItemRegister;
import io.github.team_lodestar.transcendeum.itemgroup.TranscendeumItemsItemGroup;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class MixCodeBlockRegister {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TheTranscendeumMod.MODID);
    public static void init(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> returnBlock = BLOCKS.register(name, block);
        registerBlockItem(name, returnBlock);
        return returnBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        MixCodeItemRegister.ITEMS.register(name, () ->
                new BlockItem(block.get(),
                        new Item.Properties().group(TranscendeumItemsItemGroup.tab)));
    }

    public static final RegistryObject<Block> VIRICLINGER_ROPE = BLOCKS.register("viriclinger_rope", () ->
            new ViriclingerRopeBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .doesNotBlockMovement()
                    .zeroHardnessAndResistance()
                    .tickRandomly()
            )
    );
}
