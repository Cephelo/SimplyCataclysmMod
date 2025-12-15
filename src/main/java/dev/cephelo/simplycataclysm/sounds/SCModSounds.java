package dev.cephelo.simplycataclysm.sounds;

import dev.cephelo.simplycataclysm.SimplyCataclysm;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SCModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, SimplyCataclysm.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> IGNITIUM_HIT = registerSoundEvent("ignitium_hit");
    public static final DeferredHolder<SoundEvent, SoundEvent> CURSIUM_HIT = registerSoundEvent("cursium_hit");
    public static final DeferredHolder<SoundEvent, SoundEvent> WITHERITE_HIT = registerSoundEvent("witherite_hit");
    public static final DeferredHolder<SoundEvent, SoundEvent> ACCURSED_RAGE_MAX = registerSoundEvent("accursed_rage_max");
    public static final DeferredHolder<SoundEvent, SoundEvent> MECHA_PULSE_SHOCKWAVE = registerSoundEvent("mecha_pulse_shockwave");

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () ->
                SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(SimplyCataclysm.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}