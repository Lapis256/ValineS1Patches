package io.github.lapis256.valine_s1_patches;

import io.github.lapis256.valine_s1_patches.patches.LootrPatch;
import io.github.lapis256.valine_s1_patches.patches.ObservablePatch;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Mod(ValineS1Patches.MOD_ID)
public class ValineS1Patches {
    public static final String MOD_ID = "valine_s1_patches";
    public static final String MOD_NAME = "Valine S1 Patches";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public ValineS1Patches() {
        MinecraftForge.EVENT_BUS.addListener(ObservablePatch::registerPermissions);
        MinecraftForge.EVENT_BUS.addListener(LootrPatch::onAttachLootrChestMinecart);
    }
}
