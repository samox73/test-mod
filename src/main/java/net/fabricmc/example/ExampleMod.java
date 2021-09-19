package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.BlockItems.CompactedWeedItem;
import net.fabricmc.example.Blocks.CompactedWeed;
import net.fabricmc.example.Items.WeedIngotItem;
import net.fabricmc.example.Items.WeedItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExampleMod implements ModInitializer {

	public static final ItemGroup DRUGS_GROUP = FabricItemGroupBuilder.build(
			new Identifier("drugs", "general"),
			() -> new ItemStack(Blocks.VINE)
	);

	// Items
	public static final WeedItem WEED_ITEM = new WeedItem(new FabricItemSettings().group(DRUGS_GROUP));
	public static final WeedIngotItem WEED_INGOT_ITEM = new WeedIngotItem(new FabricItemSettings().group(DRUGS_GROUP));

	// Blocks
	public static final CompactedWeed COMPACTED_WEED = new CompactedWeed(FabricBlockSettings.of(Material.LEAVES));

	// Block-Items
	public static final CompactedWeedItem COMPACTED_WEED_ITEM =
			new CompactedWeedItem(COMPACTED_WEED, new FabricItemSettings().group(DRUGS_GROUP));


	@Override
	public void onInitialize() {
		// Items
		Registry.register(Registry.ITEM, new Identifier("drugs", "weed"), WEED_ITEM);
		Registry.register(Registry.ITEM, new Identifier("drugs", "weed_ingot"), WEED_INGOT_ITEM);

		// Blocks
		Registry.register(Registry.BLOCK, new Identifier("drugs", "compacted_weed"), COMPACTED_WEED);

		// Block-Items
		Registry.register(Registry.ITEM, new Identifier("drugs", "compacted_weed"), COMPACTED_WEED_ITEM);
	}
}