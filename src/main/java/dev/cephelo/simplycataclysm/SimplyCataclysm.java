package dev.cephelo.simplycataclysm;

import com.mojang.logging.LogUtils;
import dev.cephelo.simplycataclysm.effects.ModEffects;
import dev.cephelo.simplycataclysm.item.ModItems;
import dev.cephelo.simplycataclysm.sounds.SCModSounds;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sweenus.simplyswords.SimplySwords;
import org.slf4j.Logger;

@Mod(SimplyCataclysm.MODID)
public class SimplyCataclysm
{
    public static final String MODID = "simplycataclysm";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> SC_WEAPONS_TAB = CREATIVE_MODE_TABS.register("sc_weapons", () -> CreativeModeTab.builder()
            .withTabsBefore(SimplySwords.SIMPLYSWORDS.getKey())
            .icon(() -> ModItems.IGNITIUM_CHAKRAM.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.simplycataclysm.sc_weapons"))
            .displayItems((parameters, output) -> {
                for (RegistryObject<Item> item : ModItems.ITEMS.getEntries())
                    output.accept(item.get());
            }).build());

    public SimplyCataclysm()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SCConfig.SPEC);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEffects.register(modEventBus);
        SCModSounds.register(modEventBus);
        ModItems.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
