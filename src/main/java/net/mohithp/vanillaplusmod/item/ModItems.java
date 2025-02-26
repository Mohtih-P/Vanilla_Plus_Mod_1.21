package net.mohithp.vanillaplusmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mohithp.vanillaplusmod.VanillaMod;

public class ModItems {

    public static final Item HEART = registerItem("heart", new HeartItem(new Item.Settings().maxCount(16), 2.0, "You Feel The Energy!"));
    public static final Item GOLDEN_HEART = registerItem("golden_heart", new HeartItem(new Item.Settings().maxCount(16), 10.0, "Power Surges Through You!"));
    public static final Item DIAMOND_HEART = registerItem("diamond_heart",new HeartItem(new Item.Settings().maxCount(16), 20,"You are OP"));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(VanillaMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        VanillaMod.LOGGER.info("Registering mod items for " + VanillaMod.MOD_ID);
    }
}
