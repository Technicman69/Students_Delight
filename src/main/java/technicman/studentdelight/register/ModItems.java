package technicman.studentdelight.register;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import technicman.studentdelight.item.FoodComponents;
import technicman.studentdelight.StudentsDelight;
import technicman.studentdelight.item.YogurtBottleItem;

public class ModItems {

    public static final Item YOGURT_BOTTLE = register("yogurt_bottle", new YogurtBottleItem(food(FoodComponents.YOGURT_BOTTLE)
            .recipeRemainder(Items.GLASS_BOTTLE).maxCount(16)
    ));

    public static Item.Settings food(FoodComponent foodComponent) {
        return new Item.Settings().food(foodComponent);
    }

    public static void initialize() {}


    public static Item register(String name, Item item) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(StudentsDelight.MOD_ID, name));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }
}
