package technicman.studentdelight;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import technicman.studentdelight.register.ModItems;
import technicman.studentdelight.register.ModVillagerTrades;
import technicman.studentdelight.util.ModLootTableModifiers;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;

public class StudentsDelight implements ModInitializer {
	public static final String MOD_ID = "studentsdelight";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Student's (budget) Delights mod loaded successfully!");

		ModItems.initialize();
		ModVillagerTrades.registerTrades();
		ModLootTableModifiers.modifyLootTables();
	}
}