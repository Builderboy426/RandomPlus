package com.builderboy426.randomplus.recipes;

import java.util.Map;
import java.util.Map.Entry;

import com.builderboy426.randomplus.init.BlockInit;
import com.builderboy426.randomplus.init.ItemInit;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockSpecial;
import net.minecraft.item.ItemStack;

public class AlloyPressRecipes {
	
	private static final AlloyPressRecipes INSTANCE = new AlloyPressRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	private final Map<ItemStack, Integer> tempuratures = Maps.<ItemStack, Integer>newHashMap();
	
	public static AlloyPressRecipes getInstance() { return INSTANCE; }
	
	private AlloyPressRecipes() {
		addAlloyPressRecipe(new ItemStack(Items.COAL), new ItemStack(Items.IRON_INGOT), new ItemStack(ItemInit.STEEL_INGOT), 1510, 5.0F);
		addAlloyPressRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(Items.COAL), new ItemStack(ItemInit.STEEL_INGOT), 1510, 5.0F);
		
		addAlloyPressRecipe(new ItemStack(ItemInit.STEEL_INGOT), new ItemStack(ItemInit.TITANIUM_INGOT), new ItemStack(ItemInit.REINFORCED_STEEL_INGOT), 2510, 5.0F);
		addAlloyPressRecipe(new ItemStack(ItemInit.TITANIUM_INGOT), new ItemStack(ItemInit.STEEL_INGOT), new ItemStack(ItemInit.REINFORCED_STEEL_INGOT), 2510, 5.0F);
		
		addAlloyPressRecipe(new ItemStack(ItemInit.COPPER_INGOT), new ItemStack(ItemInit.TIN_INGOT), new ItemStack(ItemInit.BRONZE_INGOT), 2562, 5.0F);
		addAlloyPressRecipe(new ItemStack(ItemInit.TIN_INGOT), new ItemStack(ItemInit.COPPER_INGOT), new ItemStack(ItemInit.BRONZE_INGOT), 2562, 5.0F);
		
		addAlloyPressRecipe(new ItemStack(new ItemBlock(Blocks.MAGMA)), new ItemStack(ItemInit.STEEL_INGOT), new ItemStack(ItemInit.MAGNITE_INGOT), 2627, 5.0F);
		addAlloyPressRecipe(new ItemStack(ItemInit.STEEL_INGOT), new ItemStack(new ItemBlock(Blocks.MAGMA)), new ItemStack(ItemInit.MAGNITE_INGOT), 2627, 5.0F);
		
		//Ores
		addAlloyPressRecipe(new ItemStack(new ItemBlock(Blocks.IRON_ORE)), new ItemStack(new ItemBlock(Blocks.IRON_ORE)), new ItemStack(Items.IRON_INGOT, 4), 750, 5.0F);
		addAlloyPressRecipe(new ItemStack(new ItemBlock(Blocks.GOLD_ORE)), new ItemStack(new ItemBlock(Blocks.GOLD_ORE)), new ItemStack(Items.GOLD_INGOT, 4), 750, 5.0F);
		addAlloyPressRecipe(new ItemStack(new ItemBlock(BlockInit.ORE_ALUMINIUM)), new ItemStack(new ItemBlock(BlockInit.ORE_ALUMINIUM)), new ItemStack(ItemInit.ALUMINIUM_INGOT, 4), 750, 5.0F);
		addAlloyPressRecipe(new ItemStack(new ItemBlock(BlockInit.ORE_COPPER)), new ItemStack(new ItemBlock(BlockInit.ORE_COPPER)), new ItemStack(ItemInit.COPPER_INGOT, 4), 750, 5.0F);
		addAlloyPressRecipe(new ItemStack(new ItemBlock(BlockInit.ORE_LITHIUM)), new ItemStack(new ItemBlock(BlockInit.ORE_LITHIUM)), new ItemStack(ItemInit.LITHIUM, 4), 750, 5.0F);
		addAlloyPressRecipe(new ItemStack(new ItemBlock(BlockInit.ORE_TIN)), new ItemStack(new ItemBlock(BlockInit.ORE_TIN)), new ItemStack(ItemInit.TIN_INGOT, 4), 750, 5.0F);
		addAlloyPressRecipe(new ItemStack(new ItemBlock(BlockInit.ORE_TITANIUM)), new ItemStack(new ItemBlock(BlockInit.ORE_TITANIUM)), new ItemStack(ItemInit.TITANIUM_INGOT, 4), 750, 5.0F);
	}

	
	public void addAlloyPressRecipe(ItemStack input1, ItemStack input2, ItemStack result, int temperature, float experience) {
		if(getAlloyPressResult(input1, input2) != ItemStack.EMPTY) return;
		this.smeltingList.put(input1, input2, result);
		this.experienceList.put(result, Float.valueOf(experience));
		this.tempuratures.put(result, temperature);
	}
	
	public ItemStack getAlloyPressResult(ItemStack input1, ItemStack input2) {
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) {
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) {
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) {
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2){
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() {
		return this.smeltingList;
	}
	
	public int getTemperature(ItemStack result) {
		if (this.tempuratures.containsKey(result)) { return tempuratures.get(result); }
		else { return 0; }
	}
	
	public float getSinteringExperience(ItemStack result){
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
			if(this.compareItemStacks(result, (ItemStack)entry.getKey())) {
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}