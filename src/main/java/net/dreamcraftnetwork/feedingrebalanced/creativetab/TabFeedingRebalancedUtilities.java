
package net.dreamcraftnetwork.feedingrebalanced.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.dreamcraftnetwork.feedingrebalanced.item.ItemPlate;
import net.dreamcraftnetwork.feedingrebalanced.ElementsFeedingRebalanced;

@ElementsFeedingRebalanced.ModElement.Tag
public class TabFeedingRebalancedUtilities extends ElementsFeedingRebalanced.ModElement {
	public TabFeedingRebalancedUtilities(ElementsFeedingRebalanced instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabfeedingrebalancedutilities") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemPlate.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
