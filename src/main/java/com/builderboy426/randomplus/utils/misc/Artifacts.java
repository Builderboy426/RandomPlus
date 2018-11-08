package com.builderboy426.randomplus.utils.misc;

import com.builderboy426.randomplus.objects.items.artifacts.FireArtifact;
import com.builderboy426.randomplus.objects.items.artifacts.NightArtifact;
import com.builderboy426.randomplus.objects.items.artifacts.WarArtifact;
import com.builderboy426.randomplus.objects.items.artifacts.WaterArtifact;

import net.minecraft.item.Item;

public class Artifacts {
	
	public static WaterArtifact getWaterArtifact(Item item) {
		try { return (WaterArtifact)item; } catch (ClassCastException e) { return null; }
	}
	
	public static FireArtifact getFireArtifact(Item item) {
		try { return (FireArtifact)item; } catch (ClassCastException e) { return null; }
	}
	
	public static NightArtifact getNightArtifact(Item item) {
		try { return (NightArtifact)item; } catch (ClassCastException e) { return null; }
	}
	
	public static WarArtifact getWarArtifact(Item item) {
		try { return (WarArtifact)item; } catch (ClassCastException e) { return null; }
	}
}