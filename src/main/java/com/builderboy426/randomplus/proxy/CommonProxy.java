package com.builderboy426.randomplus.proxy;

import com.builderboy426.randomplus.init.RegistryHandler;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) { RegistryHandler.preInit(); }
	public void init(FMLInitializationEvent event) { RegistryHandler.init(); }
	public void postInit(FMLPostInitializationEvent event) { /*RegistryHandler.postInit();*/ }
}