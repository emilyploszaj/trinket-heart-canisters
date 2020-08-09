package dev.emi.trinketheartcanisters.items;

import java.util.UUID;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HeartCanister extends TrinketItem {
	public String slot;

	public HeartCanister(Item.Settings settings, String slot) {
		super(settings);
		this.slot = slot;
	}

	@Override
	public boolean canWearInSlot(String group, String slot) {
		return group.equals("heartcanisters") && slot.equals(this.slot);
	}
	
	@Override
	public Multimap<EntityAttribute, EntityAttributeModifier> getTrinketModifiers(String group, String slot, UUID uuid, ItemStack stack) {
		Multimap<EntityAttribute, EntityAttributeModifier> map = HashMultimap.create();
		map.put(EntityAttributes.GENERIC_MAX_HEALTH, new EntityAttributeModifier(uuid, "Hearts", stack.getCount() * 2, EntityAttributeModifier.Operation.ADDITION));
		return map;
	}
}