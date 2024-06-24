package net.dreamcraftnetwork.feedingrebalanced.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.dreamcraftnetwork.feedingrebalanced.item.ItemBaggettueLeftovers;
import net.dreamcraftnetwork.feedingrebalanced.ElementsFeedingRebalanced;

@ElementsFeedingRebalanced.ModElement.Tag
public class ProcedureBaggettueSwitchLastStage extends ElementsFeedingRebalanced.ModElement {
	public ProcedureBaggettueSwitchLastStage(ElementsFeedingRebalanced instance) {
		super(instance, 6);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BaggettueSwitchLastStage!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemBaggettueLeftovers.block, (int) (1)).getItem(), -1, (int) 1, null);
	}
}
