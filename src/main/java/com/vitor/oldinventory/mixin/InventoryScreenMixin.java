package com.vitor.oldinventory.mixin;

import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.world.inventory.InventoryMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public abstract class InventoryScreenMixin extends EffectRenderingInventoryScreen<InventoryMenu> {

    public InventoryScreenMixin(InventoryMenu menu, net.minecraft.world.entity.player.Inventory playerInventory, net.minecraft.network.chat.Component title) {
        super(menu, playerInventory, title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    private void removeRecipeBookButton(CallbackInfo ci) {
        // Remove qualquer ImageButton adicionado à tela (o botão do livro de receitas é um ImageButton)
        this.renderables.removeIf(widget -> widget instanceof ImageButton);
        this.children.removeIf(widget -> widget instanceof ImageButton);
        
        // Na 1.7.2, o inventário ficava fixo no centro, mesmo com poções.
        // O código vanilla move ele para a direita se tiver efeitos. Vamos forçar o centro se você quiser:
        // this.leftPos = (this.width - this.imageWidth) / 2;
    }
}