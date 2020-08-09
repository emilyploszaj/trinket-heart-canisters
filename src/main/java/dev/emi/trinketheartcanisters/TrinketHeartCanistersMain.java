package dev.emi.trinketheartcanisters;

import dev.emi.trinketheartcanisters.items.HeartCanister;
import dev.emi.trinkets.api.TrinketSlots;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TrinketHeartCanistersMain implements ModInitializer {
	public static final	Item RED_HEART = registerItem("red_heart", new Item(new Item.Settings()
			.food(new FoodComponent.Builder().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 5), 1.0f).build())
			.group(ItemGroup.MISC).maxCount(16)));
	public static final	Item GREEN_HEART = registerItem("green_heart", new Item(new Item.Settings()
			.food(new FoodComponent.Builder().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 5), 1.0f).build())
			.group(ItemGroup.MISC).maxCount(16)));
	public static final	Item BLUE_HEART = registerItem("blue_heart", new Item(new Item.Settings()
			.food(new FoodComponent.Builder().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 5), 1.0f).build())
			.group(ItemGroup.MISC).maxCount(16)));
	public static final Item RED_HEART_CANISTER = registerItem("red_heart_canister", new HeartCanister(new Item.Settings().group(ItemGroup.MISC).maxCount(10), "redhearts"));
	public static final Item GREEN_HEART_CANISTER = registerItem("green_heart_canister", new HeartCanister(new Item.Settings().group(ItemGroup.MISC).maxCount(10), "greenhearts"));
	public static final Item BLUE_HEART_CANISTER = registerItem("blue_heart_canister", new HeartCanister(new Item.Settings().group(ItemGroup.MISC).maxCount(10), "bluehearts"));

	@Override
	public void onInitialize() {
		TrinketSlots.addSlotGroup("heartcanisters", "redhearts");
		TrinketSlots.addSlot("heartcanisters", "redhearts", new Identifier("trinkets", "textures/item/empty_trinket_slot_charm.png"));
		TrinketSlots.addSlot("heartcanisters", "greenhearts", new Identifier("trinkets", "textures/item/empty_trinket_slot_charm.png"));
		TrinketSlots.addSlot("heartcanisters", "bluehearts", new Identifier("trinkets", "textures/item/empty_trinket_slot_charm.png"));
	}

	private static <T extends Item> T registerItem(String name, T item){
		return Registry.register(Registry.ITEM, new Identifier("trinketheartcanisters", name), item);
	}
}
