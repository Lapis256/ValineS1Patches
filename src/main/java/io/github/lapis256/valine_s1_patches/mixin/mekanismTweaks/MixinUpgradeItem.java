package io.github.lapis256.valine_s1_patches.mixin.mekanismTweaks;

import mekanism.api.Upgrade;
import mekanism.common.item.ItemUpgrade;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


@Mixin(value = ItemUpgrade.class, remap = false)
public class MixinUpgradeItem {
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lmekanism/api/Upgrade;getMax()I"))
    private static int injected(Upgrade self) {
        return 64;
    }
}
