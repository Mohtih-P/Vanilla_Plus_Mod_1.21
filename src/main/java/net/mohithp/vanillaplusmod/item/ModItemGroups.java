package net.mohithp.vanillaplusmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mohithp.vanillaplusmod.VanillaMod;

public class ModItemGroups {

    public static final ItemGroup HEARTS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(VanillaMod.MOD_ID, "hearts"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.HEART))
                    .displayName(Text.translatable("itemgroup.tutorialmod.hearts"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.HEART);
                        entries.add(ModItems.GOLDEN_HEART);
                        entries.add(ModItems.DIAMOND_HEART);
                    }).build());

    public static void registerItemGroups() {
        VanillaMod.LOGGER.info("Registering item groups for " + VanillaMod.MOD_ID);
    }
}
