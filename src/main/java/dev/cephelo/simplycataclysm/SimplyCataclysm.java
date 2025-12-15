package dev.cephelo.simplycataclysm;

import com.mojang.logging.LogUtils;
import dev.cephelo.simplycataclysm.effects.ModEffects;
import dev.cephelo.simplycataclysm.item.ModItems;
import dev.cephelo.simplycataclysm.sounds.SCModSounds;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.CreativeModeTabRegistry;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.sweenus.simplyswords.SimplySwords;
import org.slf4j.Logger;

@Mod(SimplyCataclysm.MODID)
public class SimplyCataclysm
{
    public static final String MODID = "simplycataclysm";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SC_WEAPONS_TAB = CREATIVE_MODE_TABS.register("sc_weapons", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabRegistry.getName(SimplySwords.SIMPLYSWORDS.value()))
            .icon(() -> ModItems.IGNITIUM_CHAKRAM.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.simplycataclysm.sc_weapons"))
            .displayItems((parameters, output) -> {
                for (DeferredHolder<Item, ? extends Item> item : ModItems.ITEMS.getEntries())
                    output.accept(item.get());
            }).build());

    public SimplyCataclysm(IEventBus modEventBus, ModContainer modContainer)
    {
        modContainer.registerConfig(ModConfig.Type.STARTUP, SCConfig.SPEC);

        ModEffects.register(modEventBus);
        SCModSounds.register(modEventBus);
        ModItems.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
