package technicman.studentdelight.register;


import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.impl.object.builder.TradeOfferInternals;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

public class ModVillagerTrades {
    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 5, factories -> {
            factories.add( (entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.YOGURT_BOTTLE, 1),
                    random.nextBetween(1, 3), 30, 0.1f));
        });
        //TradeOffers.Factory[] level1Trades = TradeOffers.PROFESSION_TO_LEVELED_TRADE.get(VillagerProfession.SHEPHERD).get(1);
        //level1Trades
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 1, factories -> {
            factories.add( (entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(vectorwing.farmersdelight.common.registry.ModItems.MILK_BOTTLE.get(), 4),
                    16, 2, 0.02f));
        });
    }
}
