package chibivaru.shiononlywins.items;

import java.util.List;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItsFourSword extends ItemSword
{
	public ItsFourSword(ToolMaterial material) {
		super(material);
		setMaxStackSize(1);
		setMaxDamage(0);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = Items.diamond_sword.getIconFromDamage(0);
	}
	
	@Override
	public void getSubItems(Item par1item, CreativeTabs par2tabs, List itemlist)
	{
		ItemStack is = new ItemStack(this, 1, 0);
		is.addEnchantment(Enchantment.unbreaking, 3);
		is.addEnchantment(Enchantment.knockback, 2);
		is.addEnchantment(Enchantment.sharpness, 4);
		is.addEnchantment(Enchantment.looting, 3);
		is.addEnchantment(Enchantment.fireAspect, 2);
		
		itemlist.add(is);
	}
}
