
package net.dreamcraftnetwork.feedingrebalanced.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.dreamcraftnetwork.feedingrebalanced.item.ItemBaggettue;
import net.dreamcraftnetwork.feedingrebalanced.ElementsFeedingRebalanced;

@ElementsFeedingRebalanced.ModElement.Tag
public class TabFeedingRebalancedFood extends ElementsFeedingRebalanced.ModElement {
	public TabFeedingRebalancedFood(ElementsFeedingRebalanced instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabfeedingrebalancedfood") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemBaggettue.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
