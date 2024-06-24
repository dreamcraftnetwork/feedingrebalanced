
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

import net.dreamcraftnetwork.feedingrebalanced.procedure.ProcedureBaggettueSwitchedTo2ndStage;
import net.dreamcraftnetwork.feedingrebalanced.creativetab.TabFeedingRebalancedFood;
import net.dreamcraftnetwork.feedingrebalanced.ElementsFeedingRebalanced;

@ElementsFeedingRebalanced.ModElement.Tag
public class ItemBaggettue extends ElementsFeedingRebalanced.ModElement {
	@GameRegistry.ObjectHolder("feedingrebalanced:baggettue")
	public static final Item block = null;
	public ItemBaggettue(ElementsFeedingRebalanced instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("feedingrebalanced:baggettue", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(5, 6f, false);
			setUnlocalizedName("baggettue");
			setRegistryName("baggettue");
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
				ProcedureBaggettueSwitchedTo2ndStage.executeProcedure($_dependencies);
			}
		}
	}
}
