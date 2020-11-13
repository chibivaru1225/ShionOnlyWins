package chibivaru.shiononlywins.common;

import chibivaru.shiononlywins.ShionOnlyWins;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CTab extends CreativeTabs
{

	public CTab(String label)
	{
		super(label);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return ShionOnlyWins.shionsClairvoyance;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "ShionOnlyWins";
	}
}
