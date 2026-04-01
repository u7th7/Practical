package org.revere.practical;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Practical extends JavaPlugin {
    private static Practical instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
