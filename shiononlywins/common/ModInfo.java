package chibivaru.shiononlywins.common;

import chibivaru.shiononlywins.ShionOnlyWins;
import cpw.mods.fml.common.ModMetadata;

public class ModInfo {

	public static void loadInfo(ModMetadata meta)
	{
		meta.modId = ShionOnlyWins.MODID;
		meta.name = ShionOnlyWins.NAME;
		meta.description ="This mod adds Murasaki Shion (Shion ch.) Items for Minecraft.";
		meta.version = ShionOnlyWins.VERSION ;
		meta.url = "http://chaostcg31.blog.fc2.com/";
		meta.authorList.add("chibivaru");
		meta.credits = "shion ch,schr0,defeatedcrow,a1lic";
		//meta.logoFile ="assets/aluminiummod/logo.png";
		meta.logoFile = "";
		meta.autogenerated = false;
	}

}