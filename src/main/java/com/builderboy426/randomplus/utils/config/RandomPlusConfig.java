package com.builderboy426.randomplus.utils.config;

import com.builderboy426.randomplus.utils.Reference;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MODID)
@Config.LangKey("config." + Reference.MODID + ".title")
@Mod.EventBusSubscriber(modid = Reference.MODID)
public class RandomPlusConfig
{
	private static final String PREFIX = "config." + Reference.MODID + ".";

	@Config.Name("Client")
	@Config.Comment("Client-only configs.")
	@Config.LangKey(PREFIX + "client")
	public static final Client CLIENT = new Client();
	
	public static class Client {
		
		@Config.Name("Artifacts")
		@Config.Comment("Artifact Mechanics")
		@Config.LangKey(PREFIX+"client.artifacts")
		public ArtifactConfig artifactConfig = new ArtifactConfig();
		
	}
	
	public static class ArtifactConfig {
		
		@Config.Name("Overlaping Effects")
		@Config.Comment("Effects don't overlap")
		@Config.LangKey(PREFIX+"client.artifact.overlap")
		public boolean restrictedArtifact = true;
		
		@Config.Name("Water Artifact")
		@Config.Comment("Artifact Mechanics")
		@Config.LangKey(PREFIX+"client.artifacts.waterartifact")
		public WaterArtifact waterArtifact = new WaterArtifact();
		
		@Config.Name("Fire Artifact")
		@Config.Comment("Artifact Mechanics")
		@Config.LangKey(PREFIX+"client.artifacts.fireartifact")
		public FireArtifact fireArtifact = new FireArtifact();
		
		@Config.Name("Night Artifact")
		@Config.Comment("Artifact Mechanics")
		@Config.LangKey(PREFIX+"client.artifacts.nightartifact")
		public NightArtifact nightArtifact = new NightArtifact();
		
		@Config.Name("War Artifact")
		@Config.Comment("Artifact Mechanics")
		@Config.LangKey(PREFIX+"client.artifacts.warartifact")
		public WarArtifact warArtifact = new WarArtifact();
		
	}
	
	public static class WaterArtifact {
		
		@Config.Name("Time")
		@Config.Comment("Effect Time")
		@Config.LangKey(PREFIX+"client.artifact.waterartifact.time")
		@Config.RangeDouble(min = 2.0, max = 10.0)
		public double time = 2.5;
		
	}
	
	public static class FireArtifact {
		
		@Config.Name("Time")
		@Config.Comment("Effect Time")
		@Config.LangKey(PREFIX+"client.artifact.fireartifact.time")
		@Config.RangeDouble(min = 2.0, max = 10.0)
		public double time = 2.5;
		
	}
	
	public static class NightArtifact {
		
		@Config.Name("Time")
		@Config.Comment("Effect Time")
		@Config.LangKey(PREFIX+"client.artifact.nightartifact.time")
		@Config.RangeDouble(min = 2.0, max = 10.0)
		public double time = 2.5;
		
	}
	
	public static class WarArtifact {
		
		@Config.Name("Time")
		@Config.Comment("Effect Time")
		@Config.LangKey(PREFIX+"client.artifact.warartifact.time")
		@Config.RangeDouble(min = 2.0, max = 10.0)
		public double time = 2.5;
		
	}
	
	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.getModID().equalsIgnoreCase(Reference.MODID))
		{
			ConfigManager.sync(Reference.MODID, Config.Type.INSTANCE);
		}
	}
}