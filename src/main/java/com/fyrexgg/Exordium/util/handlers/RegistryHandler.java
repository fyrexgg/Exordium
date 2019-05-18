package com.fyrexgg.Exordium.util.handlers;

import com.fyrexgg.Exordium.init.ModBlocks;
import com.fyrexgg.Exordium.init.ModItems;
import com.fyrexgg.Exordium.util.Models;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for(Item item : ModItems.ITEMS){
            if(item instanceof Models){
                ((Models)item).registerModels();
            }
        }
        for(Block block : ModBlocks.BLOCKS){
            if(block instanceof Models){
                ((Models)block).registerModels();
            }
        }
    }

}
