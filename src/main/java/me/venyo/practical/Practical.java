package me.venyo.practical;

import com.comphenix.protocol.ProtocolLibrary;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import me.venyo.practical.combat.CombatListener;
import me.venyo.practical.particle.ParticleService;
import me.venyo.practical.particle.listener.ParticleListener;

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
