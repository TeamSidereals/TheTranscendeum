
package io.github.team_lodestar.transcendeum.keybind;

import io.github.team_lodestar.transcendeum.TheTranscendeumMod;

@TheTranscendeumModElements.ModElement.Tag
public class ArcedeonUpKeyBinding extends TheTranscendeumModElements.ModElement {

	@OnlyIn(Dist.CLIENT)
	private KeyBinding keys;

	private long lastpress = 0;

	public ArcedeonUpKeyBinding(TheTranscendeumModElements instance) {
		super(instance, 315);

		elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
				KeyBindingPressedMessage::handler);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		keys = new KeyBinding("key.the_transcendeum.arcedeon_up", GLFW.GLFW_KEY_SPACE, "key.categories.misc");
		ClientRegistry.registerKeyBinding(keys);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if (Minecraft.getInstance().currentScreen == null) {
			if (event.getKey() == keys.getKey().getKeyCode()) {
				if (event.getAction() == GLFW.GLFW_PRESS) {
					TheTranscendeumMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
					pressAction(Minecraft.getInstance().player, 0, 0);

					lastpress = System.currentTimeMillis();
				} else if (event.getAction() == GLFW.GLFW_RELEASE) {
					int dt = (int) (System.currentTimeMillis() - lastpress);
					TheTranscendeumMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(1, dt));
					pressAction(Minecraft.getInstance().player, 1, dt);
				}
			}
		}
	}

	public static class KeyBindingPressedMessage {

		int type, pressedms;

		public KeyBindingPressedMessage(int type, int pressedms) {
			this.type = type;
			this.pressedms = pressedms;
		}

		public KeyBindingPressedMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.pressedms = buffer.readInt();
		}

		public static void buffer(KeyBindingPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeInt(message.pressedms);
		}

		public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				pressAction(context.getSender(), message.type, message.pressedms);
			});
			context.setPacketHandled(true);
		}

	}

	private static void pressAction(PlayerEntity entity, int type, int pressedms) {
		World world = entity.world;
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();

		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;

		if (type == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ArcedeonAscendProcedure.executeProcedure($_dependencies);
			}
		}

		if (type == 1) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				ArcedeonKeyReleasedProcedure.executeProcedure($_dependencies);
			}
		}
	}

}
