package technicman.studentdelight.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.mixin.loot.LootTableAccessor;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.registry.ModItems;

public class ModLootTableModifiers {
    private static final Identifier VILLAGE_SHEPHERD = new Identifier("minecraft", "chests/village/village_shepherd");
    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (id.equals(VILLAGE_SHEPHERD)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(0, 6))
                        .with(ItemEntry.builder(ModItems.MILK_BOTTLE.get()).weight(3))
                        .with(ItemEntry.builder(technicman.studentdelight.register.ModItems.YOGURT_BOTTLE));
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
