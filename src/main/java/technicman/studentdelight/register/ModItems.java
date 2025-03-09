package technicman.studentdelight.register;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import technicman.studentdelight.item.FoodComponents;
import technicman.studentdelight.StudentsDelight;
import technicman.studentdelight.item.YogurtBottleItem;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class ModItems {
    public static final RegistryKey<ItemGroup> ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(StudentsDelight.MOD_ID, "item_group"));
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.SALT_SOUP))
            .displayName(Text.translatable("item.studentsdelight.salt_soup"))
            .build();


    // Basic Meals
    public static final Item LOW_CALORIE_ALMOST_PIZZA = register("low_calorie_almost_pizza", new Item(new Item.Settings().maxCount(1)));
    public static final Item LOW_CALORIE_ALMOST_PIZZA_SLICE = register("low_calorie_almost_pizza_slice", new ConsumableItem(food(FoodComponents.LOW_CALORIE_ALMOST_PIZZA_SLICE)));
    public static final Item KAKTIS_TORTILLA = register("kaktis_tortilla", new ConsumableItem(food(FoodComponents.KAKTIS_TORTILLA)));
    public static final Item WATSUGS_TORTILLA = register("watsugs_tortilla", new ConsumableItem(food(FoodComponents.WATSUGS_TORTILLA)));
    public static final Item OVERBAKED_POTATO = register("overbaked_potato", new ConsumableItem(food(FoodComponents.OVERBAKED_POTATO)));
    public static final Item SPAGHETTI_SANDWICH = register("spaghetti_sandwich", new ConsumableItem(food(FoodComponents.SPAGHETTI_SANDWICH), true));
    public static final Item PREMIUM_SANDWICH = register("premium_sandwich", new ConsumableItem(food(FoodComponents.PREMIUM_SANDWICH)));

    // Plated and bowled meals
    public static final Item SHAKSHUKA = register("shakshuka", new ConsumableItem(bowlFood(FoodComponents.SHAKSHUKA), true));
    public static final Item SALT_SOUP = register("salt_soup", new ConsumableItem(bowlFood(FoodComponents.SALT_SOUP)));
    public static final Item BOLOGNESE_SAUCE = register("bolognese_sauce", new ConsumableItem(bowlFood(FoodComponents.BOLOGNESE_SAUCE), true));
    public static final Item PASTA_WITH_BOLOGNESE_SAUCE = register("pasta_with_bolognese_sauce", new ConsumableItem(bowlFood(FoodComponents.PASTA_WITH_BOLOGNESE_SAUCE), true));

    // Yogurt :>
    public static final Item YOGURT_BOTTLE = register("yogurt_bottle", new YogurtBottleItem(food(FoodComponents.YOGURT_BOTTLE)
            .recipeRemainder(Items.GLASS_BOTTLE).maxCount(16)
    ));

    public static Item.Settings food(FoodComponent foodComponent) {
        return new Item.Settings().food(foodComponent);
    }
    public static Item.Settings bowlFood(FoodComponent foodComponent) {
        return food(foodComponent).recipeRemainder(Items.BOWL).maxCount(16);
    }

    public static void initialize() {
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_KEY, ITEM_GROUP);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.LOW_CALORIE_ALMOST_PIZZA);
            itemGroup.add(ModItems.LOW_CALORIE_ALMOST_PIZZA_SLICE);
            itemGroup.add(ModItems.KAKTIS_TORTILLA);
            itemGroup.add(ModItems.WATSUGS_TORTILLA);
            itemGroup.add(ModItems.OVERBAKED_POTATO);
            itemGroup.add(ModItems.SPAGHETTI_SANDWICH);
            itemGroup.add(ModItems.PREMIUM_SANDWICH);
            itemGroup.add(ModItems.SHAKSHUKA);
            itemGroup.add(ModItems.SALT_SOUP);
            itemGroup.add(ModItems.BOLOGNESE_SAUCE);
            itemGroup.add(ModItems.PASTA_WITH_BOLOGNESE_SAUCE);
            itemGroup.add(ModItems.YOGURT_BOTTLE);
        });
    }


    public static Item register(String name, Item item) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(StudentsDelight.MOD_ID, name));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }
}
