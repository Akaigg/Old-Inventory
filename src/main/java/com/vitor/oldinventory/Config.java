package com.vitor.oldinventory;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    // Aqui você pode adicionar configurações futuras se desejar.
    // Por exemplo: public static final ModConfigSpec.BooleanValue ENABLE_OLD_HOTBAR = BUILDER.define("enableOldHotbar", true);

    static final ModConfigSpec SPEC = BUILDER.build();
}