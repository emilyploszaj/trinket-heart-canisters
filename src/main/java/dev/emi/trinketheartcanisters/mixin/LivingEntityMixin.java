package dev.emi.trinketheartcanisters.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.emi.trinketheartcanisters.TrinketHeartCanistersMain;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.EntityTypeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(at = @At(value = "TAIL"), method = "dropLoot")
	protected void dropLoot(DamageSource source, boolean causedByPlayer, CallbackInfo info) {
		if (EntityTypeTags.getTagGroup().getTag(new Identifier("trinketheartcanisters", "red_hearts")).contains(this.getType())) {
			dropStack(new ItemStack(TrinketHeartCanistersMain.RED_HEART));
		}
		if (EntityTypeTags.getTagGroup().getTag(new Identifier("trinketheartcanisters", "green_hearts")).contains(this.getType())) {
			dropStack(new ItemStack(TrinketHeartCanistersMain.GREEN_HEART));
		}
		if (EntityTypeTags.getTagGroup().getTag(new Identifier("trinketheartcanisters", "blue_hearts")).contains(this.getType())) {
			dropStack(new ItemStack(TrinketHeartCanistersMain.BLUE_HEART));
		}
	}
}