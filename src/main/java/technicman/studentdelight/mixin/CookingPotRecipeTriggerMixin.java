package technicman.studentdelight.mixin;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.advancement.criterion.RecipeCraftedCriterion;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.datafixer.fix.FurnaceRecipesFix;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeUnlocker;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Nameable;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;
import vectorwing.farmersdelight.common.block.entity.HeatableBlockEntity;
import vectorwing.farmersdelight.common.block.entity.SyncedBlockEntity;
import vectorwing.farmersdelight.common.block.entity.container.CookingPotResultSlot;
import vectorwing.farmersdelight.common.mixin.SoupItemMixin;

import java.util.List;

@Mixin(CookingPotBlockEntity.class)
public abstract class CookingPotRecipeTriggerMixin extends SyncedBlockEntity implements NamedScreenHandlerFactory, HeatableBlockEntity, RecipeUnlocker {
	public CookingPotRecipeTriggerMixin(BlockEntityType<?> tileEntityTypeIn, BlockPos pos, BlockState state) {
		super(tileEntityTypeIn, pos, state);
	}

	@Shadow
	private Identifier lastRecipeID;

	@Inject(at = @At("HEAD"), method = "unlockLastRecipe")
	private void injectMethod(PlayerEntity player, List<ItemStack> items, CallbackInfo info) {
		Criteria.RECIPE_CRAFTED.trigger((ServerPlayerEntity) player, lastRecipeID, items);
	}
}