package com.vitor.oldinventory.mixin;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.events.GuiEventListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import java.util.List;

@Mixin(Screen.class)
public interface ScreenAccessor {
    // Isto cria um método público para aceder à lista privada 'children'
    @Accessor("children")
    List<GuiEventListener> getChildren();
}