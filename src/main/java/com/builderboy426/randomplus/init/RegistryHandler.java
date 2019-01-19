package com.builderboy426.randomplus.init;

import java.util.HashSet;
import java.util.Set;

import com.builderboy426.randomplus.Main;
import com.builderboy426.randomplus.utils.Reference;
import com.builderboy426.randomplus.utils.compat.OreDictionaryCompat;
import com.builderboy426.randomplus.utils.handlers.GuiHandler;
import com.builderboy426.randomplus.utils.handlers.LootTableHandler;
import com.builderboy426.randomplus.world.gen.WorldGenCustomOres;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class RegistryHandler {
	
	@EventBusSubscriber(modid = Reference.MODID)
	public static class Blocks {
		public static final Set<Block> BLOCKS = new HashSet<>();
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			final IForgeRegistry<Block> reg = event.getRegistry();
			
			for (final Block block : BLOCKS) {
				reg.register(block);
			}
		}
		
		@SubscribeEvent
		public static void registerModels(final ModelRegistryEvent event) {
			BLOCKS.forEach(block -> Items.registerItemModels(Item.getItemFromBlock(block)));
		}
	}
	
	@EventBusSubscriber(modid = Reference.MODID)
	public static class Items {
		public static final Set<Item> ITEMS = new HashSet<>();
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Item> event) {
			for (Item item : ITEMS) {
				event.getRegistry().register(item);
			}
		}
		
		@SubscribeEvent
		public static void registerModels(final ModelRegistryEvent event) {
			ITEMS.forEach(Items::registerItemModels);
		}
		
		public static void registerItemModels(final Item item) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MODID+":"+item.getUnlocalizedName().substring(5), "inventory"));
		}
	}
	
	public static void preInit() {
		BlockInit.init();
		BlockInit.registerTileEntities();
		ItemInit.init();
		
		LootTableHandler.init();
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
	}
	
	public static void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
		OreDictionaryCompat.registerOres();
	}
	
	public static void postInit() {}
}