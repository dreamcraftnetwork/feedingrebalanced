package net.dreamcraftnetwork.feedingrebalanced.procedure;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.dreamcraftnetwork.feedingrebalanced.item.ItemPlate;
import net.dreamcraftnetwork.feedingrebalanced.ElementsFeedingRebalanced;

@ElementsFeedingRebalanced.ModElement.Tag
public class ProcedurePlateofMuttonandPotatoesFoodEaten extends ElementsFeedingRebalanced.ModElement {
	public ProcedurePlateofMuttonandPotatoesFoodEaten(ElementsFeedingRebalanced instance) {
		super(instance, 22);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PlateofMuttonandPotatoesFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			ItemStack _setstack = new ItemStack(ItemPlate.block, (int) (1));
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
		}
	}
}
