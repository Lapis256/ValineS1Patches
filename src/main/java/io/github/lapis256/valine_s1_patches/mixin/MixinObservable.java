package io.github.lapis256.valine_s1_patches.mixin;

import io.github.lapis256.valine_s1_patches.patches.ObservablePatch;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import observable.Observable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(value = Observable.class, remap = false)
public class MixinObservable {
    @Inject(method = "hasPermission", at = @At("HEAD"), cancellable = true)
    private void init$lambda$0(Player player, CallbackInfoReturnable<Boolean> cir) {
        if (player instanceof ServerPlayer serverPlayer) {
            cir.setReturnValue(ObservablePatch.Permission.TEST.has(serverPlayer));
        }
    }
}
