package net.dreamcraftnetwork.feedingrebalanced.procedure;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.dreamcraftnetwork.feedingrebalanced.ElementsFeedingRebalanced;

@ElementsFeedingRebalanced.ModElement.Tag
public class ProcedureFarmersstorageguihelp extends ElementsFeedingRebalanced.ModElement {
	public ProcedureFarmersstorageguihelp(ElementsFeedingRebalanced instance) {
		super(instance, 33);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Farmersstorageguihelp!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Farmersstorageguihelp!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).closeScreen();
		if (entity instanceof EntityPlayer && !world.isRemote) {
			((EntityPlayer) entity).sendStatusMessage(new TextComponentString(
					"This is the Farmer's Storage Block! This block allows for a maximum of 36 stacks of items to be stored! This works similar to a chest; however this will be eventually changed over so that it will act like a Shulker Box. For now this block will drop all items stored within it if the block is broken."),
					(false));
		}
	}
}
