
package io.github.team_lodestar.transcendeum.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import io.github.team_lodestar.transcendeum.procedures.PoweredFlame5ConditionProcedure;
import io.github.team_lodestar.transcendeum.procedures.Flame4ConditionProcedure;
import io.github.team_lodestar.transcendeum.procedures.Flame3ConditionProcedure;
import io.github.team_lodestar.transcendeum.procedures.Flame2ConditionProcedure;
import io.github.team_lodestar.transcendeum.procedures.Flame1ConditionProcedure;
import io.github.team_lodestar.transcendeum.procedures.EnigmagloveoverlayDisplayOverlayIngameProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber
public class EnigmagloveoverlayOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (EnigmagloveoverlayDisplayOverlayIngameProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_transcendeum:textures/enigma_bar_empty.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -38, posY + -120, 0, 0, 16, 16, 16, 16);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_transcendeum:textures/enigma_bar_empty.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -23, posY + -120, 0, 0, 16, 16, 16, 16);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_transcendeum:textures/enigma_bar_empty.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -8, posY + -120, 0, 0, 16, 16, 16, 16);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_transcendeum:textures/enigma_bar_empty.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 7, posY + -120, 0, 0, 16, 16, 16, 16);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_transcendeum:textures/enigma_bar_empty.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 22, posY + -120, 0, 0, 16, 16, 16, 16);

				if (Flame1ConditionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_transcendeum:textures/enigma_bar_flame.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -38, posY + -120, 0, 0, 16, 16, 16, 16);
				}
				if (Flame2ConditionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_transcendeum:textures/enigma_bar_flame.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -23, posY + -120, 0, 0, 16, 16, 16, 16);
				}
				if (Flame3ConditionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_transcendeum:textures/enigma_bar_flame.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -8, posY + -120, 0, 0, 16, 16, 16, 16);
				}
				if (Flame4ConditionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_transcendeum:textures/enigma_bar_flame.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 7, posY + -120, 0, 0, 16, 16, 16, 16);
				}
				if (PoweredFlame5ConditionProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("the_transcendeum:textures/enigma_bar_powered.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 22, posY + -120, 0, 0, 16, 16, 16, 16);
				}
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
