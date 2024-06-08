package io.github.lapis256.valine_s1_patches.mixin.mekanismTweaks;

import mekanism.api.Upgrade;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;


@Mixin(value = Upgrade.class, remap = false)
public class MixinUpgrade {
    @Shadow
    @Final
    private String name;

    @Inject(method = "getMax", at = @At("HEAD"), cancellable = true)
    private void init$lambda$0(CallbackInfoReturnable<Integer> cir) {
        if(Objects.equals(this.name, "speed") || Objects.equals(this.name, "energy")) {
            cir.setReturnValue(32);
        }
    }

    @Redirect(method = "buildMap", at = @At(value = "FIELD", target = "Lmekanism/api/Upgrade;maxStack:I", opcode = Opcodes.GETFIELD))
    private static int injected(Upgrade self) {
        return self.getMax();
    }
}
