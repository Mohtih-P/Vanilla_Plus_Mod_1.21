package net.mohithp.vanillaplusmod;

import net.fabricmc.api.ModInitializer;

import net.mohithp.vanillaplusmod.item.ModItemGroups;
import net.mohithp.vanillaplusmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaMod implements ModInitializer {
	public static final String MOD_ID = "vanillaplusmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}