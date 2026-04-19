package org.revere.practical;

import com.comphenix.protocol.ProtocolLibrary;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.revere.practical.combat.CombatListener;
import org.revere.practical.particle.ParticleService;
import org.revere.practical.particle.listener.ParticleListener;

@Getter
public final class Practical extends JavaPlugin {
    @Getter
    private static Practical instance;

    private ParticleService particleService;

    @Override
    public void onEnable() {
        instance = this;

        this.particleService = new ParticleService();

        Practical.getInstance().getServer().getPluginManager().registerEvents(
                new CombatListener(), this
        );

        ProtocolLibrary.getProtocolManager().addPacketListener(
                new ParticleListener()
        );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
