package com.builderboy426.randomplus.utils.handlers;

import com.builderboy426.randomplus.utils.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {	
	
	//public static final ResourceLocation RUINS = LootTableList.register(new ResourceLocation(Reference.MODID, "ruins"));
	
	public static void init() {
		//Structure LootTables
		LootTableList.register(new ResourceLocation(Reference.MODID, "chests/ruins"));
		LootTableList.register(new ResourceLocation(Reference.MODID, "chests/ice_temple"));
		LootTableList.register(new ResourceLocation(Reference.MODID, "chests/desert_shrine"));
		LootTableList.register(new ResourceLocation(Reference.MODID, "chests/abandoned_house"));
	}
}