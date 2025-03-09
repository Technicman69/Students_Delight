package technicman.studentdelight.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static vectorwing.farmersdelight.common.FoodValues.BRIEF_DURATION;
import static vectorwing.farmersdelight.common.FoodValues.SHORT_DURATION;
import static vectorwing.farmersdelight.common.FoodValues.MEDIUM_DURATION;
import static vectorwing.farmersdelight.common.FoodValues.LONG_DURATION;

public class FoodComponents {
    public static final int LONGER_DURATION = 7200;    // 6 minutes

    public static final FoodComponent LOW_CALORIE_ALMOST_PIZZA_SLICE = new FoodComponent.Builder()
            .hunger(2).saturationModifier(1f).snack().build();
    public static final FoodComponent KAKTIS_TORTILLA = new FoodComponent.Builder()
            .hunger(12).saturationModifier(0.75f).build();
    public static final FoodComponent WATSUGS_TORTILLA = new FoodComponent.Builder()
            .hunger(10).saturationModifier(0.8f).build();
    public static final FoodComponent OVERBAKED_POTATO = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, BRIEF_DURATION, 0), 0.3F)
            .statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), BRIEF_DURATION, 0), 0.7F)
            .build();
    public static final FoodComponent SPAGHETTI_SANDWICH = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), BRIEF_DURATION, 0), 1.0F)
            .hunger(8).saturationModifier(0.8f).build();
    public static final FoodComponent PREMIUM_SANDWICH = new FoodComponent.Builder()
            .hunger(12).saturationModifier(0.8f).build();
    public static final FoodComponent SHAKSHUKA = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), LONGER_DURATION, 0), 1.0F)
            .hunger(14).saturationModifier(0.85f).build();
    public static final FoodComponent SALT_SOUP = new FoodComponent.Builder().build();
    public static final FoodComponent BOLOGNESE_SAUCE = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), SHORT_DURATION, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), SHORT_DURATION, 0), 1.0F)
            .hunger(12).saturationModifier(0.8f).build();
    public static final FoodComponent PASTA_WITH_BOLOGNESE_SAUCE = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            .hunger(14).saturationModifier(0.75f).build();
    public static final FoodComponent YOGURT_BOTTLE = new FoodComponent.Builder()
            .hunger(2).saturationModifier(2f).build();
}
