
package io.github.team_lodestar.transcendeum.command;

@Mod.EventBusSubscriber
public class InstantPortalCommandCommand {

	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		event.getDispatcher().register(LiteralArgumentBuilder.<CommandSource>literal("instantportal")

				.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(InstantPortalCommandCommand::execute))
				.executes(InstantPortalCommandCommand::execute));
	}

	private static int execute(CommandContext<CommandSource> ctx) {
		ServerWorld world = ctx.getSource().getWorld();

		double x = ctx.getSource().getPos().getX();
		double y = ctx.getSource().getPos().getY();
		double z = ctx.getSource().getPos().getZ();

		Entity entity = ctx.getSource().getEntity();
		if (entity == null)
			entity = FakePlayerFactory.getMinecraft(world);

		HashMap<String, String> cmdparams = new HashMap<>();
		int[] index = {-1};
		Arrays.stream(ctx.getInput().split("\\s+")).forEach(param -> {
			if (index[0] >= 0)
				cmdparams.put(Integer.toString(index[0]), param);
			index[0]++;
		});

		{
			Map<String, Object> $_dependencies = new HashMap<>();

			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);

			InstantPortalSpawnProcedure.executeProcedure($_dependencies);
		}

		return 0;
	}

}
