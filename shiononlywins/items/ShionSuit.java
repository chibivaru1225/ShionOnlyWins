package chibivaru.shiononlywins.items;

import java.util.List;

import chibivaru.shiononlywins.ShionOnlyWins;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ShionSuit extends ItemArmor
{
	private String texturePath = ShionOnlyWins.MODID + ":" + "textures/armor/";
	public ShionSuit(ArmorMaterial par1, int par2, int par3, String type)
	{
		super(par1, par2, par3);
		this.setTextureName(type, par3);
		setMaxDamage(0);
	}
	
	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type)
	{
		NBTTagCompound nbt = itemStack.getTagCompound();
		int visible;
		if(nbt == null)
		{
			nbt = new NBTTagCompound();
			itemStack.setTagCompound(nbt);
			visible = 0;
		}
		else
		{
			visible = nbt.getInteger("shion.visible");
		}
		
		if(visible == 0)
		{
			if (this.armorType == 2)
			{
				return "shiononlywins:textures/armor/shion_2.png";
			}
			else
			{
				return "shiononlywins:textures/armor/shion_1.png";
			}
		}
		else
		{
			return "shiononlywins:textures/armor/invisible.png";
		}
	}
	
	private void setTextureName(String type,int armorPart)
	{
		//head,body,boots
		if(armorType == 0 || armorType == 1 || armorType == 3)
		{
			this.texturePath += type + "_1.png";
		}
		//legs
		else
		{
			this.texturePath += type + "_2.png";
		}
	}
	

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		if(entityPlayer.isSneaking())
		{
			NBTTagCompound nbt = itemStack.getTagCompound();
			int visible;
			if(nbt == null)
			{
				nbt = new NBTTagCompound();
				itemStack.setTagCompound(nbt);
				visible = 0;
			}
			else
			{
				visible = nbt.getInteger("shion.visible");
			}
			
			if(visible == 0)
			{
				visible = 1;
			}
			else
			{
				visible = 0;
			}
			
			System.out.println(visible);
			nbt.setInteger("shion.visible", visible);
			entityPlayer.swingItem();
			entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "random.orb", 0.2F, 0.6F);
		}
		else
		{
			super.onItemRightClick(itemStack, world, entityPlayer);
		}
		return itemStack;
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		NBTTagCompound nbt = par1ItemStack.getTagCompound();
		int visible;
		if(nbt == null)
		{
			nbt = new NBTTagCompound();
			par1ItemStack.setTagCompound(nbt);
			visible = 0;
		}
		else
		{
			visible = nbt.getInteger("shion.visible");
		}
		
		if(visible == 0)
		{
			par3List.add((new StringBuilder()).append(EnumChatFormatting.YELLOW).append("Visible : ").append(EnumChatFormatting.LIGHT_PURPLE).append("true").toString());
		}
		else
		{
			par3List.add((new StringBuilder()).append(EnumChatFormatting.YELLOW).append("Visible : ").append(EnumChatFormatting.LIGHT_PURPLE).append("false").toString());
		}	
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcon(IIconRegister register)
	{
		this.itemIcon = register.registerIcon("additionalrecipe:" + this.getUnlocalizedName());
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		return this.texturePath;
	}
}
