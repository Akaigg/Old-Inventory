package com.vitor.oldinventory.mixin;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Gui.class)
public class GuiMixin {

    // Este Mixin intercepta o momento em que a GUI tenta desenhar um item na hotbar.
    // Se o item for o da mão secundária, nós cancelamos o desenho.
    @Redirect(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;renderItem(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/item/ItemStack;IIH)V"))
    private void stopRenderingOffhandItem(GuiGraphics instance, net.minecraft.world.entity.LivingEntity entity, ItemStack stack, int x, int y, int seed) {
        if (entity instanceof Player player) {
             // Se o item que o jogo quer desenhar é o mesmo que está na mão secundária do jogador...
             if (stack == player.getOffhandItem()) {
                 // ...nós não fazemos nada (return), efetivamente escondendo ele da HUD.
                 return;
             }
        }
        // Se não for a mão secundária, desenha normalmente (hotbar principal).
        instance.renderItem(entity, stack, x, y, seed);
    }
}