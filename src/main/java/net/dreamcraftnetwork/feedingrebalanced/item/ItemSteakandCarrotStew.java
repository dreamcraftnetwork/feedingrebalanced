
package net.dreamcraftnetwork.feedingrebalanced.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.dreamcraftnetwork.feedingrebalanced.creativetab.TabFeedingRebalancedFood;
import net.dreamcraftnetwork.feedingrebalanced.ElementsFeedingRebalanced;

@ElementsFeedingRebalanced.ModElement.Tag
public class ItemSteakandCarrotStew extends ElementsFeedingRebalanced.ModElement {
	@GameRegistry.ObjectHolder("feedingrebalanced:steakandcarrotstew")
	public static final Item block = null;
	public ItemSteakandCarrotStew(ElementsFeedingRebalanced instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("feedingrebalanced:steakandcarrotstew", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(7, 7f, true);
			setUnlocalizedName("steakandcarrotstew");
			setRegistryName("steakandcarrotstew");
			setAlwaysEdible();
			setCreativeTab(TabFeedingRebalancedFood.tab);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}
	}
}
