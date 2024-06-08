package io.github.lapis256.valine_s1_patches.patches;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import noobanidus.mods.lootr.entity.LootrChestMinecartEntity;


public class LootrPatch {
    public static void onAttachLootrChestMinecart(AttackEntityEvent event) {
        if (!(event.getPlayer() instanceof ServerPlayer player)) {
            return;
        }
        if (!(event.getTarget() instanceof LootrChestMinecartEntity lootrCart)) {
            return;
        }

        if (player.isShiftKeyDown()) {
            lootrCart.kill();
        }
    }
}
