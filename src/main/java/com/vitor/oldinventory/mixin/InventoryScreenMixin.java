package com.vitor.oldinventory.mixin;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.world.inventory.InventoryMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public abstract class InventoryScreenMixin extends AbstractContainerScreen<InventoryMenu> {

    public InventoryScreenMixin(InventoryMenu menu, net.minecraft.world.entity.player.Inventory playerInventory, net.minecraft.network.chat.Component title) {
        super(menu, playerInventory, title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void removeRecipeBookButton(CallbackInfo ci) {
        // Remove da lista pública 'renderables' (sem erro)
        this.renderables.removeIf(widget -> widget instanceof ImageButton);
        
        // Remove da lista privada 'children' usando o Accessor (a correção)
        ((ScreenAccessor)this).getChildren().removeIf(widget -> widget instanceof ImageButton);
    }
}