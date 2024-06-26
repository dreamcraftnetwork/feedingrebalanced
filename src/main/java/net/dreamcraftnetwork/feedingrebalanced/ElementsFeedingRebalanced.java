/*
 *    MCreator note:
 *
 *    This file is autogenerated to connect all MCreator mod elements together.
 *
 */
package net.dreamcraftnetwork.feedingrebalanced;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Potion;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;

import net.dreamcraftnetwork.feedingrebalanced.gui.GuiPage8Gui;
import net.dreamcraftnetwork.feedingrebalanced.gui.GuiPage7Gui;
import net.dreamcraftnetwork.feedingrebalanced.gui.GuiPage6Gui;
import net.dreamcraftnetwork.feedingrebalanced.gui.GuiPage5Gui;
import net.dreamcraftnetwork.feedingrebalanced.gui.GuiPage4Gui;
import net.dreamcraftnetwork.feedingrebalanced.gui.GuiPage3Gui;
import net.dreamcraftnetwork.feedingrebalanced.gui.GuiPage2Gui;
import net.dreamcraftnetwork.feedingrebalanced.gui.GuiPage1Gui;
import net.dreamcraftnetwork.feedingrebalanced.gui.GuiFarmersStorageGui;

import java.util.function.Supplier;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public class ElementsFeedingRebalanced implements IFuelHandler, IWorldGenerator {
	public final List<ModElement> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<Biome>> biomes = new ArrayList<>();
	public final List<Supplier<EntityEntry>> entities = new ArrayList<>();
	public final List<Supplier<Potion>> potions = new ArrayList<>();
	public static Map<ResourceLocation, net.minecraft.util.SoundEvent> sounds = new HashMap<>();
	public ElementsFeedingRebalanced() {
	}

	public void preInit(FMLPreInitializationEvent event) {
		try {
			for (ASMDataTable.ASMData asmData : event.getAsmData().getAll(ModElement.Tag.class.getName())) {
				Class<?> clazz = Class.forName(asmData.getClassName());
				if (clazz.getSuperclass() == ElementsFeedingRebalanced.ModElement.class)
					elements.add((ElementsFeedingRebalanced.ModElement) clazz.getConstructor(this.getClass()).newInstance(this));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(elements);
		elements.forEach(ElementsFeedingRebalanced.ModElement::initElements);
		this.addNetworkMessage(FeedingRebalancedVariables.WorldSavedDataSyncMessageHandler.class,
				FeedingRebalancedVariables.WorldSavedDataSyncMessage.class, Side.SERVER, Side.CLIENT);
	}

	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
		for (Map.Entry<ResourceLocation, net.minecraft.util.SoundEvent> sound : sounds.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator cg, IChunkProvider cp) {
		elements.forEach(element -> element.generateWorld(random, chunkX * 16, chunkZ * 16, world, world.provider.getDimension(), cg, cp));
	}

	@Override
	public int getBurnTime(ItemStack fuel) {
		for (ModElement element : elements) {
			int ret = element.addFuel(fuel);
			if (ret != 0)
				return ret;
		}
		return 0;
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.player.world.isRemote) {
			WorldSavedData mapdata = FeedingRebalancedVariables.MapVariables.get(event.player.world);
			WorldSavedData worlddata = FeedingRebalancedVariables.WorldVariables.get(event.player.world);
			if (mapdata != null)
				FeedingRebalanced.PACKET_HANDLER.sendTo(new FeedingRebalancedVariables.WorldSavedDataSyncMessage(0, mapdata),
						(EntityPlayerMP) event.player);
			if (worlddata != null)
				FeedingRebalanced.PACKET_HANDLER.sendTo(new FeedingRebalancedVariables.WorldSavedDataSyncMessage(1, worlddata),
						(EntityPlayerMP) event.player);
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.player.world.isRemote) {
			WorldSavedData worlddata = FeedingRebalancedVariables.WorldVariables.get(event.player.world);
			if (worlddata != null)
				FeedingRebalanced.PACKET_HANDLER.sendTo(new FeedingRebalancedVariables.WorldSavedDataSyncMessage(1, worlddata),
						(EntityPlayerMP) event.player);
		}
	}
	private int messageID = 0;
	public <T extends IMessage, V extends IMessage> void addNetworkMessage(Class<? extends IMessageHandler<T, V>> handler, Class<T> messageClass,
			Side... sides) {
		for (Side side : sides)
			FeedingRebalanced.PACKET_HANDLER.registerMessage(handler, messageClass, messageID, side);
		messageID++;
	}
	public static class GuiHandler implements IGuiHandler {
		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			if (id == GuiPage1Gui.GUIID)
				return new GuiPage1Gui.GuiContainerMod(world, x, y, z, player);
			if (id == GuiPage2Gui.GUIID)
				return new GuiPage2Gui.GuiContainerMod(world, x, y, z, player);
			if (id == GuiPage3Gui.GUIID)
				return new GuiPage3Gui.GuiContainerMod(world, x, y, z, player);
			if (id == GuiPage4Gui.GUIID)
				return new GuiPage4Gui.GuiContainerMod(world, x, y, z, player);
			if (id == GuiPage5Gui.GUIID)
				return new GuiPage5Gui.GuiContainerMod(world, x, y, z, player);
			if (id == GuiPage6Gui.GUIID)
				return new GuiPage6Gui.GuiContainerMod(world, x, y, z, player);
			if (id == GuiFarmersStorageGui.GUIID)
				return new GuiFarmersStorageGui.GuiContainerMod(world, x, y, z, player);
			if (id == GuiPage7Gui.GUIID)
				return new GuiPage7Gui.GuiContainerMod(world, x, y, z, player);
			if (id == GuiPage8Gui.GUIID)
				return new GuiPage8Gui.GuiContainerMod(world, x, y, z, player);
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			if (id == GuiPage1Gui.GUIID)
				return new GuiPage1Gui.GuiWindow(world, x, y, z, player);
			if (id == GuiPage2Gui.GUIID)
				return new GuiPage2Gui.GuiWindow(world, x, y, z, player);
			if (id == GuiPage3Gui.GUIID)
				return new GuiPage3Gui.GuiWindow(world, x, y, z, player);
			if (id == GuiPage4Gui.GUIID)
				return new GuiPage4Gui.GuiWindow(world, x, y, z, player);
			if (id == GuiPage5Gui.GUIID)
				return new GuiPage5Gui.GuiWindow(world, x, y, z, player);
			if (id == GuiPage6Gui.GUIID)
				return new GuiPage6Gui.GuiWindow(world, x, y, z, player);
			if (id == GuiFarmersStorageGui.GUIID)
				return new GuiFarmersStorageGui.GuiWindow(world, x, y, z, player);
			if (id == GuiPage7Gui.GUIID)
				return new GuiPage7Gui.GuiWindow(world, x, y, z, player);
			if (id == GuiPage8Gui.GUIID)
				return new GuiPage8Gui.GuiWindow(world, x, y, z, player);
			return null;
		}
	}
	public List<ModElement> getElements() {
		return elements;
	}

	public List<Supplier<Block>> getBlocks() {
		return blocks;
	}

	public List<Supplier<Item>> getItems() {
		return items;
	}

	public List<Supplier<Biome>> getBiomes() {
		return biomes;
	}

	public List<Supplier<EntityEntry>> getEntities() {
		return entities;
	}

	public List<Supplier<Potion>> getPotions() {
		return potions;
	}
	public static class ModElement implements Comparable<ModElement> {
		@Retention(RetentionPolicy.RUNTIME)
		public @interface Tag {
		}
		protected final ElementsFeedingRebalanced elements;
		protected final int sortid;
		public ModElement(ElementsFeedingRebalanced elements, int sortid) {
			this.elements = elements;
			this.sortid = sortid;
		}

		public void initElements() {
		}

		public void init(FMLInitializationEvent event) {
		}

		public void preInit(FMLPreInitializationEvent event) {
		}

		public void generateWorld(Random random, int posX, int posZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		public void registerModels(ModelRegistryEvent event) {
		}

		public int addFuel(ItemStack fuel) {
			return 0;
		}

		@Override
		public int compareTo(ModElement other) {
			return this.sortid - other.sortid;
		}
	}
}
