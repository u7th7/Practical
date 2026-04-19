package org.revere.practical.combat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.revere.practical.Practical;

/**
 * @author Venyo
 * @since 4/1/2026
 */
public class CombatListener implements Listener {
    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) {
            return;
        }

        if (event.getEntity() instanceof Player) {
            Player target = (Player) event.getEntity();
            Practical.getInstance().getParticleService().addBlockedPlayer(target.getUniqueId());
        }
    }
}
