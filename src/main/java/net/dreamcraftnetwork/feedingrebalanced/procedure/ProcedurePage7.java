package net.dreamcraftnetwork.feedingrebalanced.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.dreamcraftnetwork.feedingrebalanced.gui.GuiPage7Gui;
import net.dreamcraftnetwork.feedingrebalanced.FeedingRebalanced;
import net.dreamcraftnetwork.feedingrebalanced.ElementsFeedingRebalanced;

@ElementsFeedingRebalanced.ModElement.Tag
public class ProcedurePage7 extends ElementsFeedingRebalanced.ModElement {
	public ProcedurePage7(ElementsFeedingRebalanced instance) {
		super(instance, 35);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Page7!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Page7!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Page7!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Page7!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Page7!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).openGui(FeedingRebalanced.instance, GuiPage7Gui.GUIID, world, x, y, z);
	}
}
