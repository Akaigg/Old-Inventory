package com.vitor.oldinventory;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

// O valor aqui deve corresponder a uma entrada no arquivo META-INF/neoforge.mods.toml
@Mod(OldInventory.MODID)
public class OldInventory {
    // Defina o mod id em um local comum
    public static final String MODID = "oldinventory";
    // Logger para depuração
    public static final Logger LOGGER = LogUtils.getLogger();

    public OldInventory(IEventBus modEventBus, ModContainer modContainer) {
        // Registra a configuração (opcional, mas mantive a estrutura caso queira adicionar opções depois)
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        
        LOGGER.info("OldInventory inicializado: Restaurando a GUI da 1.7.2");
    }
}