package com.natamus.cryingghasts.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.cryingghasts.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 1, max = 256) public static int maxDistanceToGhastBlocks = 32;
	@Entry(min = 1, max = 72000) public static int ghastTearDelayTicks = 1200;

	public static void initConfig() {
		configMetaData.put("maxDistanceToGhastBlocks", Arrays.asList(
			"The maximum distance in blocks the player can be away from the ghasts in order for them to start dropping tears periodically."
		));
		configMetaData.put("ghastTearDelayTicks", Arrays.asList(
			"The delay in between ghasts dropping a tear in ticks (1 second = 20 ticks)."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}