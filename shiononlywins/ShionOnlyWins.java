package chibivaru.shiononlywins;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import chibivaru.shiononlywins.common.CTab;
import chibivaru.shiononlywins.common.ModInfo;
import chibivaru.shiononlywins.items.ItsFourSword;
import chibivaru.shiononlywins.items.ShionSuit;
import chibivaru.shiononlywins.items.ShionsClairvoyance;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

@Mod(modid = ShionOnlyWins.MODID, name = ShionOnlyWins.NAME, version = ShionOnlyWins.VERSION, dependencies = "after:additionalrecipe")
public class ShionOnlyWins
{
    public static final String MODID = "shiononlywins";
    public static final String NAME = "ShionOnlyWins";
    public static final String VERSION = "0.01";

    public static CreativeTabs CTabs = new CTab(NAME);

    @Metadata(MODID)
    public static ModMetadata meta;
    
    public static ToolMaterial WEAPON_SHION;
    public static ArmorMaterial ARMOR_SHION;
    
    public static Item itsFourSword;
    public static Item shionsClairvoyance;
    
    public static Item shionHat;
    public static Item shionCape;
    public static Item shionSkirt;
    public static Item shionLoafers;
     
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModInfo.loadInfo(meta);
        
    	WEAPON_SHION = EnumHelper.addToolMaterial("SHION", 2, 1, 8.0F, 3.0F, 10);
    	ARMOR_SHION = EnumHelper.addArmorMaterial("SHION", 40, new int[] {1, 3, 2, 1}, 200);
    	
    	shionsClairvoyance = new ShionsClairvoyance();
    	shionsClairvoyance.setUnlocalizedName("shionsclairvoyance");
    	shionsClairvoyance.setCreativeTab(CTabs);
    	GameRegistry.registerItem(shionsClairvoyance, "Shion's Clairvoyance");
    	
    	itsFourSword = new ItsFourSword(WEAPON_SHION);
    	itsFourSword.setUnlocalizedName("itsfoursword");
    	itsFourSword.setCreativeTab(CTabs);
    	GameRegistry.registerItem(itsFourSword, "It's Four Sword");
    	
    	
    	shionHat = new ShionSuit(ARMOR_SHION, 0, 0, "shion");
    	shionCape = new ShionSuit(ARMOR_SHION, 0, 1, "shion");
    	shionSkirt = new ShionSuit(ARMOR_SHION, 0, 2, "shion");
    	shionLoafers = new ShionSuit(ARMOR_SHION, 0, 3, "shion");
    	
    	shionHat.setUnlocalizedName("shionhat");
    	shionCape.setUnlocalizedName("shioncape");
    	shionSkirt.setUnlocalizedName("shionskirt");
    	shionLoafers.setUnlocalizedName("shionloafers");

    	shionHat.setCreativeTab(CTabs);
    	shionCape.setCreativeTab(CTabs);
    	shionSkirt.setCreativeTab(CTabs);
    	shionLoafers.setCreativeTab(CTabs);
    	
    	shionHat.setTextureName("shiononlywins:shionhat");
    	shionCape.setTextureName("shiononlywins:shioncape");
    	shionSkirt.setTextureName("shiononlywins:shionskirt");
    	shionLoafers.setTextureName("shiononlywins:shionloafers");
    	
    	GameRegistry.registerItem(shionHat, "Shion's Hat");
    	GameRegistry.registerItem(shionCape, "Shion's Cape");
    	GameRegistry.registerItem(shionSkirt, "Shion's Skirt");
    	GameRegistry.registerItem(shionLoafers, "Shion's Loafers");
    	
    	GameRegistry.addRecipe(new ShapedOreRecipe(shionsClairvoyance,
    			new Object[]{"ZYZ","YXY","ZYZ",
    					Character.valueOf('X'), Items.ender_eye,
    					Character.valueOf('Y'), Items.spider_eye,
    					Character.valueOf('Z'), new ItemStack(Items.dye, 1, 5)}));
    	
    	OreDictionary.registerOre("shionsClairvoyance", shionsClairvoyance);
    	
    	
    	ItemStack esword = new ItemStack(itsFourSword);
    	esword.addEnchantment(Enchantment.unbreaking, 3);
		esword.addEnchantment(Enchantment.knockback, 2);
		esword.addEnchantment(Enchantment.sharpness, 4);
		esword.addEnchantment(Enchantment.looting, 3);
		esword.addEnchantment(Enchantment.fireAspect, 2);
    	
    	GameRegistry.addRecipe(new ShapelessOreRecipe(esword, new Object[]{shionsClairvoyance, Items.diamond_sword}));
    	
    	GameRegistry.addRecipe(new ShapelessOreRecipe(shionHat, new Object[]{shionsClairvoyance, Items.leather_helmet}));
    	GameRegistry.addRecipe(new ShapelessOreRecipe(shionCape, new Object[]{shionsClairvoyance, Items.leather_chestplate}));
    	GameRegistry.addRecipe(new ShapelessOreRecipe(shionSkirt, new Object[]{shionsClairvoyance, Items.leather_leggings}));
    	GameRegistry.addRecipe(new ShapelessOreRecipe(shionLoafers, new Object[]{shionsClairvoyance, Items.leather_boots}));
    }
}
