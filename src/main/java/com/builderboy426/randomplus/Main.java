package com.builderboy426.randomplus;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.builderboy426.randomplus.creativetabs.RandomPlusTab;
import com.builderboy426.randomplus.init.RegistryHandler;
import com.builderboy426.randomplus.proxy.CommonProxy;
import com.builderboy426.randomplus.utils.Reference;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.MCVERSION, dependencies = Reference.DEPENDENCIES)
public class Main {

    @Instance
    public static Main instance;
    
    public static final CreativeTabs RANDOM_PLUS = new RandomPlusTab("randomplustab");
    
    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy; 
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) { proxy.preInit(event); }

    @EventHandler
    public void init(FMLInitializationEvent event) { proxy.init(event); }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) { proxy.postInit(event); }
}