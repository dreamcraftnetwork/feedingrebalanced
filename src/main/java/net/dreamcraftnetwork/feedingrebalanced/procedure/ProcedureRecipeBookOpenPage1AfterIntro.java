package net.dreamcraftnetwork.feedingrebalanced.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.dreamcraftnetwork.feedingrebalanced.gui.GuiRecipeBookPage1AfterIntro;
import net.dreamcraftnetwork.feedingrebalanced.FeedingRebalanced;
import net.dreamcraftnetwork.feedingrebalanced.ElementsFeedingRebalanced;

@ElementsFeedingRebalanced.ModElement.Tag
public class ProcedureRecipeBookOpenPage1AfterIntro extends ElementsFeedingRebalanced.ModElement {
	public ProcedureRecipeBookOpenPage1AfterIntro(ElementsFeedingRebalanced instance) {
		super(instance, 14);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RecipeBookOpenPage1AfterIntro!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure RecipeBookOpenPage1AfterIntro!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure RecipeBookOpenPage1AfterIntro!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure RecipeBookOpenPage1AfterIntro!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure RecipeBookOpenPage1AfterIntro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).openGui(FeedingRebalanced.instance, GuiRecipeBookPage1AfterIntro.GUIID, world, x, y, z);
	}
}
