
package net.dreamcraftnetwork.feedingrebalanced.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.dreamcraftnetwork.feedingrebalanced.procedure.ProcedurePlateofMuttonandPotatoesFoodEaten;
import net.dreamcraftnetwork.feedingrebalanced.creativetab.TabFeedingRebalancedFood;
import net.dreamcraftnetwork.feedingrebalanced.ElementsFeedingRebalanced;

@ElementsFeedingRebalanced.ModElement.Tag
public class ItemPlateofMuttonandPotatoes extends ElementsFeedingRebalanced.ModElement {
	@GameRegistry.ObjectHolder("feedingrebalanced:plateofmuttonandpotatoes")
	public static final Item block = null;
	public ItemPlateofMuttonandPotatoes(ElementsFeedingRebalanced instance) {
		super(instance, 20);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("feedingrebalanced:plateofmuttonandpotatoes", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(10, 10f, true);
			setUnlocalizedName("plateofmuttonandpotatoes");
			setRegistryName("plateofmuttonandpotatoes");
			setAlwaysEdible();
			setCreativeTab(TabFeedingRebalancedFood.tab);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}

		@Override
		protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity) {
			super.onFoodEaten(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedurePlateofMuttonandPotatoesFoodEaten.executeProcedure($_dependencies);
			}
		}
	}
}
