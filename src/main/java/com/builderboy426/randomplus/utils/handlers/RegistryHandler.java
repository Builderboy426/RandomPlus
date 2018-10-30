package com.builderboy426.randomplus.utils.handlers;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.init.BlockInit;

import com.builderboy426.randomplus.init.ItemInit;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityAncientGenerator;
import com.builderboy426.randomplus.objects.blocks.tileentity.TileEntityArtifactAnalyzer;
import com.builderboy426.randomplus.utils.Reference;
import com.builderboy426.randomplus.utils.interfaces.IHasModel;
import com.builderboy426.randomplus.world.gen.WorldGenCustomOres;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		//Register Tile Entities
		registerTileEntities();
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for (Item item : ItemInit.ITEMS) {
			if (item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		
		for (Block block : BlockInit.BLOCKS) {
			if (block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
	}
	
	public static void registerTileEntities() {
		//Ancient Machines
		GameRegistry.registerTileEntity(TileEntityAncientGenerator.class, new ResourceLocation(Reference.MODID+":ancient_generator"));
		GameRegistry.registerTileEntity(TileEntityArtifactAnalyzer.class, new ResourceLocation(Reference.MODID+":artifact_analyzer"));
		
		//Chaos Machines
		
		//Chests
	}
	
	public static void preInitRegistries() {
		LootTableHandler.init();
		
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
	}
	
	public static void initRegistries() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}
}
