package com.builderboy426.randomplus.recipes;

import java.util.Map;
import java.util.Map.Entry;

import com.builderboy426.randomplus.init.ItemInit;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AlloyPressRecipes {
	
	private static final AlloyPressRecipes INSTANCE = new AlloyPressRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	private final Map<ItemStack, Integer> tempuratures = Maps.<ItemStack, Integer>newHashMap();
	
	public static AlloyPressRecipes getInstance() { return INSTANCE; }
	
	private AlloyPressRecipes() {
		//addSinteringRecipe(new ItemStack(Blocks.ACACIA_FENCE), new ItemStack(Blocks.ACACIA_FENCE_GATE), new ItemStack(BlockInit.COPPER_CHEST), 5.0F);
		addAlloyPressRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(Items.COAL), new ItemStack(ItemInit.STEEL_INGOT), 1510, 5.0F);
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