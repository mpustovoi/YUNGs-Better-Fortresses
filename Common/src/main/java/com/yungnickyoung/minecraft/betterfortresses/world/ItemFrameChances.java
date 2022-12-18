package com.yungnickyoung.minecraft.betterfortresses.world;

import com.yungnickyoung.minecraft.yungsapi.api.world.randomize.ItemRandomizer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

/**
 * Singleton class holding ItemRandomizers for items in item frames.
 * The class is a singleton so that it may be synchronized with the JSON file as a single source of truth.
 * If no JSON exists, this class will be populated with the default values shown below
 * (and a JSON with the default values created)
 */
public class ItemFrameChances {
    /**
     * Singleton stuff
     **/

    public static ItemFrameChances instance; // This technically shouldn't be public, but it is necessary for loading data from JSON

    public static ItemFrameChances get() {
        if (instance == null) {
            instance = new ItemFrameChances();
        }
        return instance;
    }

    private ItemFrameChances() {
        weaponItems = new ItemRandomizer(Items.AIR)
                .addItem(Items.STONE_SWORD, .025f)
                .addItem(Items.IRON_SWORD, .025f)
                .addItem(Items.GOLDEN_SWORD, .05f)
                .addItem(Items.NETHERITE_SWORD, .005f)
                .addItem(Items.STONE_AXE, .025f)
                .addItem(Items.IRON_AXE, .025f)
                .addItem(Items.GOLDEN_AXE, .05f)
                .addItem(Items.SHIELD, .025f);

        lootItems = new ItemRandomizer(Items.AIR)
                .addItem(Items.GOLD_NUGGET, .05f)
                .addItem(Items.GOLD_INGOT, .05f)
                .addItem(Items.NETHER_WART, .05f)
                .addItem(Items.NETHERITE_SCRAP, .005f);
    }

    /**
     * Instance variables and methods
     **/

    private ItemRandomizer weaponItems;
    private ItemRandomizer lootItems;

    public Item getWeaponItem(RandomSource randomSource) {
        return weaponItems.get(randomSource);
    }

    public Item getLootItem(RandomSource randomSource) {
        return lootItems.get(randomSource);
    }
}