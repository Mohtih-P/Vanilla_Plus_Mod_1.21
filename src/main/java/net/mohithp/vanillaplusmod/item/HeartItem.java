package net.mohithp.vanillaplusmod.item;

import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.SubtitleS2CPacket;
import net.minecraft.network.packet.s2c.play.TitleFadeS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HeartItem extends Item {
    private final double healthIncrease;
    private final String message;

    public HeartItem(Settings settings, double healthIncrease, String message) {
        super(settings);
        this.healthIncrease = healthIncrease;
        this.message = message;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient) {
            EntityAttributeInstance attribute = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
            if (attribute != null) {
                attribute.setBaseValue(attribute.getBaseValue() + healthIncrease);
                player.setHealth(player.getMaxHealth());

                if (player instanceof ServerPlayerEntity serverPlayer) {

                    serverPlayer.networkHandler.sendPacket(new SubtitleS2CPacket(Text.literal(message).formatted(Formatting.GOLD, Formatting.BOLD)));
                    serverPlayer.networkHandler.sendPacket(new TitleFadeS2CPacket(10, 40, 10));

                    stack.decrement(1);
                    return new TypedActionResult<>(ActionResult.SUCCESS, stack);
                }
            }
        }
        return new TypedActionResult<>(ActionResult.PASS, stack);
    }
}
