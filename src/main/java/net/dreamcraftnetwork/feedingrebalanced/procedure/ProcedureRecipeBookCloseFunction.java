package net.dreamcraftnetwork.feedingrebalanced.procedure;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.dreamcraftnetwork.feedingrebalanced.ElementsFeedingRebalanced;

@ElementsFeedingRebalanced.ModElement.Tag
public class ProcedureRecipeBookCloseFunction extends ElementsFeedingRebalanced.ModElement {
	public ProcedureRecipeBookCloseFunction(ElementsFeedingRebalanced instance) {
		super(instance, 11);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RecipeBookCloseFunction!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).closeScreen();
	}
}
