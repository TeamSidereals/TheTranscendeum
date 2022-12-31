package io.github.team_lodestar.transcendeum.event;

import com.google.common.collect.ImmutableList;
import io.github.team_lodestar.transcendeum.TheTranscendeumMod;
import io.github.team_lodestar.transcendeum.item.mixcode.MixCodeItemRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = TheTranscendeumMod.MODID)
public class MixCodeEvent {

    @SubscribeEvent
    public static void CelebrateEvent(EntityJoinWorldEvent event){
        World world = event.getWorld();
        if (!world.isRemote){
            Entity entity = event.getEntity();
            if (entity instanceof PlayerEntity){
                if(Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.MONTH) == Calendar.MARCH
                && Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.DAY_OF_MONTH) == 15){
                    entity.sendMessage(convertIntoRainbow("Happy 1 year anniversary of modding! Toma"), Util.DUMMY_UUID);
                    entity.sendMessage(convertIntoRainbow("Happy birthday! Aqu"), Util.DUMMY_UUID);
                }
                if(Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.MONTH) == Calendar.MARCH
                        && Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.DAY_OF_MONTH) == 20){
                    entity.sendMessage(convertIntoRainbow("Happy birthday! Lyof"), Util.DUMMY_UUID);
                }
                if(Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.MONTH) == Calendar.MARCH
                        && Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.DAY_OF_MONTH) == 23){
                    entity.sendMessage(convertIntoRainbow("Happy 1 year anniversary of modding! Ddx11"), Util.DUMMY_UUID);
                }
            }
        }
    }

    private static TextComponent convertIntoRainbow(String s) {
        StringTextComponent start = new StringTextComponent("");
        List<Style> styles = ImmutableList.of(Style.EMPTY.setColor(Color.fromInt(0xff0000)), Style.EMPTY.setColor(Color.fromInt(0xff8c00)), Style.EMPTY.setColor(Color.fromInt(0xffe600)), Style.EMPTY.setColor(Color.fromInt(0x0dff00)), Style.EMPTY.setColor(Color.fromInt(0x0077ff)), Style.EMPTY.setColor(Color.fromInt(0x6f00ff)), Style.EMPTY.setColor(Color.fromInt(0xff00ff)));

        for (int i = 0; i < s.length(); ++i) {
            start.append(new StringTextComponent(String.valueOf(s.charAt(i))).setStyle(styles.get(i % 7)));
        }

        return (TextComponent) start;
    }

    @SubscribeEvent
    public static void EventDrop(LivingDeathEvent event){
        World world = event.getEntity().world;
        if (!world.isRemote){
            if (Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.MONTH) == Calendar.MARCH
                    && (Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.DAY_OF_MONTH) >= 15
                        && Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.DAY_OF_MONTH) <= 17)) {
                Entity entity = event.getEntity();
                if (entity instanceof MobEntity
                && entity.world.getDimensionKey().getLocation().toString().equals("the_transcendeum:transcendeum")) {
                    Random roll = new Random();
                    if (roll.nextDouble() < 0.1D){
                        ItemEntity itemEntity;
                        if (roll.nextDouble() < 0.5D){
                            itemEntity = new ItemEntity(world, entity.getPosX(), entity.getPosY() + 1,
                                    entity.getPosZ(), MixCodeItemRegister.TOMA_CAKE.get().getDefaultInstance());
                        }
                        else{
                            itemEntity = new ItemEntity(world, entity.getPosX(), entity.getPosY() + 1,
                                    entity.getPosZ(), MixCodeItemRegister.AQU_CAKE.get().getDefaultInstance());
                        }
                        itemEntity.entityDropItem(itemEntity.getItem());
                    }
                }
            }
            if (Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.MONTH) == Calendar.MARCH
                    && (Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.DAY_OF_MONTH) >= 20
                    && Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.DAY_OF_MONTH) <= 22)) {
                Entity entity = event.getEntity();
                if (entity instanceof MobEntity
                        && entity.world.getDimensionKey().getLocation().toString().equals("the_transcendeum:transcendeum")) {
                    Random roll = new Random();
                    if (roll.nextDouble() < 0.1D){
                        ItemEntity itemEntity = new ItemEntity(world, entity.getPosX(), entity.getPosY() + 1,
                                entity.getPosZ(), MixCodeItemRegister.LYOF_CAKE.get().getDefaultInstance());
                        itemEntity.entityDropItem(itemEntity.getItem());
                    }
                }
            }
            if (Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.MONTH) == Calendar.MARCH
                    && (Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.DAY_OF_MONTH) >= 23
                    && Calendar.getInstance(Calendar.getInstance().getTimeZone()).get(Calendar.DAY_OF_MONTH) <= 25)) {
                Entity entity = event.getEntity();
                if (entity instanceof MobEntity
                        && entity.world.getDimensionKey().getLocation().toString().equals("the_transcendeum:transcendeum")) {
                    Random roll = new Random();
                    if (roll.nextDouble() < 0.1D){
                        ItemEntity itemEntity = new ItemEntity(world, entity.getPosX(), entity.getPosY() + 1,
                                entity.getPosZ(), MixCodeItemRegister.DDX_CAKE.get().getDefaultInstance());
                        itemEntity.entityDropItem(itemEntity.getItem());
                    }
                }
            }
            if (event.getEntity() instanceof ZombieEntity
            && event.getEntity().world.getDimensionKey().getLocation().toString().equals("minecraft:overworld")){
                Random roll = new Random();
                if (roll.nextDouble() < 0.1D){
                    ItemStack stack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("gaia:cherry_log")), 16);
                    ItemEntity itemEntity = new ItemEntity(world, event.getEntity().getPosX(), event.getEntity().getPosY() + 1,
                            event.getEntity().getPosZ(), stack);
                    itemEntity.entityDropItem(itemEntity.getItem());
                }
            }
        }
    }
}
