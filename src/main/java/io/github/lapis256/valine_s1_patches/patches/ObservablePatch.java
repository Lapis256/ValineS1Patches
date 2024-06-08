package io.github.lapis256.valine_s1_patches.patches;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.server.permission.PermissionAPI;
import net.minecraftforge.server.permission.events.PermissionGatherEvent;
import net.minecraftforge.server.permission.nodes.PermissionNode;
import net.minecraftforge.server.permission.nodes.PermissionTypes;


public class ObservablePatch {
    public static final String OBSERVABLE_MOD_ID = "observable";

    private static final PermissionNode.PermissionResolver<Boolean> DEFAULT_PERMISSION_RESOLVER = (player, playerUUID, context) -> {
        if(player == null) {
            return false;
        }

        var server = player.getServer();
        if(server != null && server.isSingleplayer()) {
            return true;
        }

        return player.hasPermissions(4);
    };

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(OBSERVABLE_MOD_ID, path);
    }

    public static void registerPermissions(PermissionGatherEvent.Nodes event) {
        Permission.register(event);
    }

    public enum Permission {
        TEST("all");

        final ResourceLocation location;
        final PermissionNode<Boolean> node;

        Permission(String path) {
            this.location = rl(path);
            this.node = new PermissionNode<>(location, PermissionTypes.BOOLEAN, DEFAULT_PERMISSION_RESOLVER);
        }

        public boolean has(ServerPlayer player) {
            return PermissionAPI.getPermission(player, node);
        }

        private static void register(PermissionGatherEvent.Nodes event) {
            for(var permission : values()) {
                event.addNodes(permission.node);
            }
        }
    }
}
