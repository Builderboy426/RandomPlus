package com.builderboy426.randomplus.init;

import java.util.ArrayList;
import java.util.List;

import com.builderboy426.randomplus.objects.armour.ArmorBase;
import com.builderboy426.randomplus.objects.items.ItemBase;
import com.builderboy426.randomplus.objects.items.artifacts.FireArtifact;
import com.builderboy426.randomplus.objects.items.artifacts.NightArtifact;
import com.builderboy426.randomplus.objects.items.artifacts.SpeedArtifact;
import com.builderboy426.randomplus.objects.items.artifacts.WarArtifact;
import com.builderboy426.randomplus.objects.items.artifacts.WaterArtifact;
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
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial TOOL_RUBY = EnumHelper.addToolMaterial("tool_ruby", 2, 350, 6.2f, 1.5f, 16);
	public static final ToolMaterial TOOL_SAPPHIRE = EnumHelper.addToolMaterial("tool_sapphire", 2, 340, 6.0f, 1.5f, 16);
	public static final ToolMaterial TOOL_AMETHYST = EnumHelper.addToolMaterial("tool_amethyst", 2, 325, 6.1f, 1.5f, 16);
	public static final ToolMaterial TOOL_EMERALD = EnumHelper.addToolMaterial("tool_emerald", 2, 365, 6.25f, 2.75f, 22);
	
	public static final ArmorMaterial ARMOUR_RUBY = EnumHelper.addArmorMaterial("armour_ruby", Reference.MODID+":ruby", 17, new int[]{3, 6, 5, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	public static final ArmorMaterial ARMOUR_SAPPHIRE = EnumHelper.addArmorMaterial("armour_sapphire", Reference.MODID+":sapphire", 17, new int[]{3, 6, 5, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	public static final ArmorMaterial ARMOUR_AMETHYST = EnumHelper.addArmorMaterial("armour_amethyst", Reference.MODID+":amethyst", 17, new int[]{3, 6, 5, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	public static final ArmorMaterial ARMOUR_EMERALD = EnumHelper.addArmorMaterial("armour_emerald", Reference.MODID+":emerald", 49, new int[]{4, 8, 9, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.25F);
	
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
	
	//Gems
	public static final Item RUBY = new ItemBase("ruby");
	public static final Item SAPPHIRE = new ItemBase("sapphire");
	public static final Item AMETHYST = new ItemBase("amethyst");
	public static final Item CHAOS = new ItemBase("chaos");
	public static final Item ANCIENT_SHARD = new ItemBase("shard_ancient");
	
	//Artifacts
	public static final Item WATER_ARTIFACT = new WaterArtifact("artifact_water");
	public static final Item FIRE_ARTIFACT = new FireArtifact("artifact_fire");
	public static final Item NIGHT_ARTIFACT = new NightArtifact("artifact_night");
	public static final Item WAR_ARTIFACT = new WarArtifact("artifact_war");
	public static final Item SPEED_ARTIFACT = new SpeedArtifact("artifact_speed");
	public static final Item UNKNOWN_ARTIFACT = new ItemBase("artifact_unknown");
	
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
}