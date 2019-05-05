package com.builderboy426.randomplus.init;

import com.builderboy426.randomplus.objects.armour.ArmorBase;
import com.builderboy426.randomplus.objects.items.ItemBase;
import com.builderboy426.randomplus.objects.items.artifacts.FireArtifact;
import com.builderboy426.randomplus.objects.items.artifacts.NightArtifact;
import com.builderboy426.randomplus.objects.items.artifacts.WarArtifact;
import com.builderboy426.randomplus.objects.items.artifacts.WaterArtifact;
import com.builderboy426.randomplus.objects.items.misc.ItemCircuit;
import com.builderboy426.randomplus.objects.items.tools.ToolAxe;
import com.builderboy426.randomplus.objects.items.tools.ToolHoe;
import com.builderboy426.randomplus.objects.items.tools.ToolPickaxe;
import com.builderboy426.randomplus.objects.items.tools.ToolShovel;
import com.builderboy426.randomplus.objects.items.tools.ToolSword;
import com.builderboy426.randomplus.utils.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {
	
	//Materials
	public static final ToolMaterial TOOL_RUBY = EnumHelper.addToolMaterial("tool_ruby", 2, 350, 6.2f, 1.5f, 16);
	public static final ToolMaterial TOOL_SAPPHIRE = EnumHelper.addToolMaterial("tool_sapphire", 2, 340, 6.0f, 1.5f, 16);
	public static final ToolMaterial TOOL_AMETHYST = EnumHelper.addToolMaterial("tool_amethyst", 2, 325, 6.1f, 1.5f, 16);
	public static final ToolMaterial TOOL_EMERALD = EnumHelper.addToolMaterial("tool_emerald", 2, 365, 6.25f, 2.75f, 22);
	public static final ToolMaterial TOOL_COPPER = EnumHelper.addToolMaterial("tool_copper", 2, 255, 5f, 2f, 12);
	public static final ToolMaterial TOOL_BRONZE = EnumHelper.addToolMaterial("tool_bronze", 2, 285, 5.75f, 2.25f, 14);
	public static final ToolMaterial TOOL_STEEL = EnumHelper.addToolMaterial("tool_steel", 2, 345, 6f, 2.5f, 10);
	
	public static final ArmorMaterial ARMOUR_RUBY = EnumHelper.addArmorMaterial("armour_ruby", Reference.MODID+":ruby", 17, new int[]{3, 6, 5, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	public static final ArmorMaterial ARMOUR_SAPPHIRE = EnumHelper.addArmorMaterial("armour_sapphire", Reference.MODID+":sapphire", 17, new int[]{3, 6, 5, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	public static final ArmorMaterial ARMOUR_AMETHYST = EnumHelper.addArmorMaterial("armour_amethyst", Reference.MODID+":amethyst", 17, new int[]{3, 6, 5, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	public static final ArmorMaterial ARMOUR_EMERALD = EnumHelper.addArmorMaterial("armour_emerald", Reference.MODID+":emerald", 49, new int[]{4, 8, 9, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.25F);
	public static final ArmorMaterial ARMOUR_COPPER = EnumHelper.addArmorMaterial("armour_copper", Reference.MODID+":copper", 49, new int[]{3, 5, 6, 3}, 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ArmorMaterial ARMOUR_BRONZE = EnumHelper.addArmorMaterial("armour_bronze", Reference.MODID+":bronze", 49, new int[]{4, 6, 7, 4}, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ArmorMaterial ARMOUR_STEEL = EnumHelper.addArmorMaterial("armour_steel", Reference.MODID+":steel", 49, new int[]{5, 7, 8, 5}, 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	
	//Items
	public static final Item STICK_STONE = new ItemBase("stick_stone");
	public static final Item STICK_IRON = new ItemBase("stick_iron");
	public static final Item STICK_GOLD = new ItemBase("stick_gold");
	public static final Item STICK_DIAMOND = new ItemBase("stick_diamond");
	public static final Item STICK_CHAOS = new ItemBase("stick_chaos");
	
	public static final Item STAR_STONE = new ItemBase("star_stone");
	public static final Item STAR_IRON = new ItemBase("star_iron");
	public static final Item STAR_GOLD = new ItemBase("star_gold");
	public static final Item STAR_DIAMOND = new ItemBase("star_diamond");
	public static final Item STAR_CHAOS = new ItemBase("star_chaos");
	
	public static final Item RESEARCH_KIT = new ItemBase("research_kit", 32);
	
	//Machine Parts
	public static final Item LITHIUM_BATTERY = new ItemBase("battery_lithium", 16);
	public static final Item MACHINE_CASING = new ItemBase("casing_machine", 1);
	public static final Item SCREEN = new ItemBase("screen", 16);
	public static final Item ENERGY_TRANSMITTER = new ItemBase("transmitter_energy", 1);
	public static final Item CIRCUIT = new ItemCircuit("circuit");
	
	//Gems and/or Materials
	public static final Item RUBY = new ItemBase("ruby");
	public static final Item SAPPHIRE = new ItemBase("sapphire");
	public static final Item AMETHYST = new ItemBase("amethyst");
	public static final Item CHAOS = new ItemBase("chaos");
	public static final Item ANCIENT_SHARD = new ItemBase("shard_ancient");
	public static final Item LITHIUM = new ItemBase("lithium");
	
	//Metals
	//Pure
	public static final Item COPPER_INGOT = new ItemBase("ingot_copper");
	public static final Item TIN_INGOT = new ItemBase("ingot_tin");
	public static final Item ALUMINIUM_INGOT = new ItemBase("ingot_aluminium");
	public static final Item TITANIUM_INGOT = new ItemBase("ingot_titanium");
	
	//Alloys
	public static final Item STEEL_INGOT = new ItemBase("ingot_steel");
	public static final Item BRONZE_INGOT = new ItemBase("ingot_bronze");
	public static final Item MAGNITE_INGOT = new ItemBase("ingot_magnite");
	public static final Item REINFORCED_STEEL_INGOT = new ItemBase("ingot_reinforced_steel");
	
	//Artifacts
	public static final Item WATER_ARTIFACT = new WaterArtifact("artifact_water");
	public static final Item FIRE_ARTIFACT = new FireArtifact("artifact_fire");
	public static final Item NIGHT_ARTIFACT = new NightArtifact("artifact_night");
	public static final Item WAR_ARTIFACT = new WarArtifact("artifact_war");
	public static final Item UNKNOWN_ARTIFACT = new ItemBase("artifact_unknown", 1);
	
	//Tools
	public static final Item AXE_RUBY = new ToolAxe("axe_ruby", TOOL_RUBY);
	public static final Item HOE_RUBY = new ToolHoe("hoe_ruby", TOOL_RUBY);
	public static final Item PICKAXE_RUBY = new ToolPickaxe("pickaxe_ruby", TOOL_RUBY);
	public static final Item SHOVEL_RUBY = new ToolShovel("shovel_ruby", TOOL_RUBY);
	public static final Item SWORD_RUBY = new ToolSword("sword_ruby", TOOL_RUBY);
	
	public static final Item AXE_SAPPHIRE = new ToolAxe("axe_sapphire", TOOL_SAPPHIRE);
	public static final Item HOE_SAPPHIRE = new ToolHoe("hoe_sapphire", TOOL_SAPPHIRE);
	public static final Item PICKAXE_SAPPHIRE = new ToolPickaxe("pickaxe_sapphire", TOOL_SAPPHIRE);
	public static final Item SHOVEL_SAPPHIRE = new ToolShovel("shovel_sapphire", TOOL_SAPPHIRE);
	public static final Item SWORD_SAPPHIRE = new ToolSword("sword_sapphire", TOOL_SAPPHIRE);
	
	public static final Item AXE_AMETHYST = new ToolAxe("axe_amethyst", TOOL_AMETHYST);
	public static final Item HOE_AMETHYST = new ToolHoe("hoe_amethyst", TOOL_AMETHYST);
	public static final Item PICKAXE_AMETHYST = new ToolPickaxe("pickaxe_amethyst", TOOL_AMETHYST);
	public static final Item SHOVEL_AMETHYST = new ToolShovel("shovel_amethyst", TOOL_AMETHYST);
	public static final Item SWORD_AMETHYST = new ToolSword("sword_amethyst", TOOL_AMETHYST);

	public static final Item AXE_EMERALD = new ToolAxe("axe_emerald", TOOL_EMERALD);
	public static final Item HOE_EMERALD = new ToolHoe("hoe_emerald", TOOL_EMERALD);
	public static final Item PICKAXE_EMERALD = new ToolPickaxe("pickaxe_emerald", TOOL_EMERALD);
	public static final Item SHOVEL_EMERALD = new ToolShovel("shovel_emerald", TOOL_EMERALD);
	public static final Item SWORD_EMERALD = new ToolSword("sword_emerald", TOOL_EMERALD);
	
	public static final Item AXE_COPPER = new ToolAxe("axe_copper", TOOL_COPPER);
	public static final Item HOE_COPPER = new ToolHoe("hoe_copper", TOOL_COPPER);
	public static final Item PICKAXE_COPPER = new ToolPickaxe("pickaxe_copper", TOOL_COPPER);
	public static final Item SHOVEL_COPPER = new ToolShovel("shovel_copper", TOOL_COPPER);
	public static final Item SWORD_COPPER = new ToolSword("sword_copper", TOOL_COPPER);
	
	public static final Item AXE_BRONZE = new ToolAxe("axe_bronze", TOOL_BRONZE);
	public static final Item HOE_BRONZE = new ToolHoe("hoe_bronze", TOOL_BRONZE);
	public static final Item PICKAXE_BRONZE = new ToolPickaxe("pickaxe_bronze", TOOL_BRONZE);
	public static final Item SHOVEL_BRONZE = new ToolShovel("shovel_bronze", TOOL_BRONZE);
	public static final Item SWORD_BRONZE = new ToolSword("sword_bronze", TOOL_BRONZE);
	
	public static final Item AXE_STEEL = new ToolAxe("axe_steel", TOOL_STEEL);
	public static final Item HOE_STEEL = new ToolHoe("hoe_steel", TOOL_STEEL);
	public static final Item PICKAXE_STEEL = new ToolPickaxe("pickaxe_steel", TOOL_STEEL);
	public static final Item SHOVEL_STEEL = new ToolShovel("shovel_steel", TOOL_STEEL);
	public static final Item SWORD_STEEL = new ToolSword("sword_steel", TOOL_STEEL);
	
	//Armour
	public static final Item HELMET_EMERALD = new ArmorBase("helmet_emerald", ARMOUR_EMERALD, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_EMERALD = new ArmorBase("chestplate_emerald", ARMOUR_EMERALD, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_EMERALD = new ArmorBase("leggings_emerald", ARMOUR_EMERALD, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_EMERALD = new ArmorBase("boots_emerald", ARMOUR_EMERALD, 1, EntityEquipmentSlot.FEET);
	
	public static final Item HELMET_RUBY = new ArmorBase("helmet_ruby", ARMOUR_RUBY, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_RUBY = new ArmorBase("chestplate_ruby", ARMOUR_RUBY, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_RUBY = new ArmorBase("leggings_ruby", ARMOUR_RUBY, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_RUBY = new ArmorBase("boots_ruby", ARMOUR_RUBY, 1, EntityEquipmentSlot.FEET);
	
	public static final Item HELMET_SAPPHIRE = new ArmorBase("helmet_sapphire", ARMOUR_SAPPHIRE, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_SAPPHIRE = new ArmorBase("chestplate_sapphire", ARMOUR_SAPPHIRE, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_SAPPHIRE = new ArmorBase("leggings_sapphire", ARMOUR_SAPPHIRE, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_SAPPHIRE = new ArmorBase("boots_sapphire", ARMOUR_SAPPHIRE, 1, EntityEquipmentSlot.FEET);
	
	public static final Item HELMET_AMETHYST = new ArmorBase("helmet_amethyst", ARMOUR_AMETHYST, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_AMETHYST = new ArmorBase("chestplate_amethyst", ARMOUR_AMETHYST, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_AMETHYST = new ArmorBase("leggings_amethyst", ARMOUR_AMETHYST, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_AMETHYST = new ArmorBase("boots_amethyst", ARMOUR_AMETHYST, 1, EntityEquipmentSlot.FEET);
	
	public static final Item HELMET_COPPER = new ArmorBase("helmet_copper", ARMOUR_COPPER, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_COPPER = new ArmorBase("chestplate_copper", ARMOUR_COPPER, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_COPPER = new ArmorBase("leggings_copper", ARMOUR_COPPER, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_COPPER = new ArmorBase("boots_copper", ARMOUR_COPPER, 1, EntityEquipmentSlot.FEET);
	
	public static final Item HELMET_BRONZE = new ArmorBase("helmet_bronze", ARMOUR_BRONZE, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_BRONZE = new ArmorBase("chestplate_bronze", ARMOUR_BRONZE, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_BRONZE = new ArmorBase("leggings_bronze", ARMOUR_BRONZE, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_BRONZE = new ArmorBase("boots_bronze", ARMOUR_BRONZE, 1, EntityEquipmentSlot.FEET);
	
	public static final Item HELMET_STEEL = new ArmorBase("helmet_steel", ARMOUR_STEEL, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_STEEL = new ArmorBase("chestplate_steel", ARMOUR_STEEL, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_STEEL = new ArmorBase("leggings_steel", ARMOUR_STEEL, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_STEEL = new ArmorBase("boots_steel", ARMOUR_STEEL, 1, EntityEquipmentSlot.FEET);
	
	public static void init() {
		//Items
		registerItems(STAR_CHAOS, STAR_DIAMOND, STAR_GOLD, STAR_IRON, STAR_STONE,
				  STICK_CHAOS, STICK_DIAMOND, STICK_GOLD, STICK_IRON, STICK_STONE,
				  RESEARCH_KIT);
		//Machine Parts
		registerItems(LITHIUM_BATTERY, MACHINE_CASING, SCREEN, ENERGY_TRANSMITTER, CIRCUIT);
		//Gems & Materials
		registerItems(ALUMINIUM_INGOT, AMETHYST, ANCIENT_SHARD, CHAOS, COPPER_INGOT,
				  LITHIUM, RUBY, SAPPHIRE, STEEL_INGOT, TIN_INGOT, TITANIUM_INGOT,
				  BRONZE_INGOT, MAGNITE_INGOT, REINFORCED_STEEL_INGOT);
		//Artifacts
		registerItems(FIRE_ARTIFACT, NIGHT_ARTIFACT, UNKNOWN_ARTIFACT, WAR_ARTIFACT, WATER_ARTIFACT);
		//Tools
		registerItems(AXE_AMETHYST, HOE_AMETHYST, PICKAXE_AMETHYST, SHOVEL_AMETHYST, SWORD_AMETHYST);
		registerItems(AXE_EMERALD, HOE_EMERALD, PICKAXE_EMERALD, SHOVEL_EMERALD, SWORD_EMERALD);
		registerItems(AXE_RUBY, HOE_RUBY, PICKAXE_RUBY, SHOVEL_RUBY, SWORD_RUBY);
		registerItems(AXE_SAPPHIRE, HOE_SAPPHIRE, PICKAXE_SAPPHIRE, SHOVEL_SAPPHIRE, SWORD_SAPPHIRE);
		registerItems(AXE_COPPER, HOE_COPPER, PICKAXE_COPPER, SHOVEL_COPPER, SWORD_COPPER);
		registerItems(AXE_BRONZE, HOE_BRONZE, PICKAXE_BRONZE, SHOVEL_BRONZE, SWORD_BRONZE);
		registerItems(AXE_STEEL, HOE_STEEL, PICKAXE_STEEL, SHOVEL_STEEL, SWORD_STEEL);
		//Armor
		registerItems(BOOTS_AMETHYST, CHESTPLATE_AMETHYST, HELMET_AMETHYST, LEGGINGS_AMETHYST);
		registerItems(BOOTS_EMERALD, CHESTPLATE_EMERALD, HELMET_EMERALD, LEGGINGS_EMERALD);
		registerItems(BOOTS_RUBY, CHESTPLATE_RUBY, HELMET_RUBY, LEGGINGS_RUBY);
		registerItems(BOOTS_SAPPHIRE, CHESTPLATE_SAPPHIRE, HELMET_SAPPHIRE, LEGGINGS_SAPPHIRE);
		registerItems(BOOTS_COPPER, CHESTPLATE_COPPER, HELMET_COPPER, LEGGINGS_COPPER);
		registerItems(BOOTS_BRONZE, CHESTPLATE_BRONZE, HELMET_BRONZE, LEGGINGS_BRONZE);
		registerItems(BOOTS_STEEL, CHESTPLATE_STEEL, HELMET_STEEL, LEGGINGS_STEEL);
	}
	
	public static void registerItems(Item... items) {
		for (Item item : items) {
			registerItem(item);
		}
	}

	public static void registerItem(Item item) {
		RegistryHandler.Items.ITEMS.add(item);
	}
}