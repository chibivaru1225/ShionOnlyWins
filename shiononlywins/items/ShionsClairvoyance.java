package chibivaru.shiononlywins.items;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import chibivaru.shiononlywins.ShionOnlyWins;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ShionsClairvoyance extends Item
{
	public ShionsClairvoyance()
	{
		super();
		this.setMaxStackSize(64);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ShionOnlyWins.MODID + ":clairvoyance");
	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}
}
