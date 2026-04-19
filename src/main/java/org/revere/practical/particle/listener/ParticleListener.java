package org.revere.practical.particle.listener;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import org.bukkit.entity.Player;
import org.revere.practical.Practical;
import org.revere.practical.PracticalConstants;

/**
 * @author Venyo
 * @since 4/1/2026
 */
public class ParticleListener extends PacketAdapter {
    public ParticleListener() {
        super(Practical.getInstance(), ListenerPriority.NORMAL, PacketType.Play.Server.ANIMATION, PacketType.Play.Server.WORLD_PARTICLES);
    }

    @Override
    public void onPacketSending(PacketEvent event) {
        Player player = event.getPlayer();
        if (player.isDead() || !Practical.getInstance().getParticleService().shouldBlock(player.getUniqueId())) {
            return;
        }

        if (event.getPacketType() == PacketType.Play.Server.ANIMATION) {
            Integer entityId = event.getPacket().getIntegers().readSafely(0);
            Integer animationId = event.getPacket().getIntegers().readSafely(1);
            if (entityId == null || animationId == null) {
                return;
            }

            int eid = entityId;
            int aid = animationId;
            if (eid == player.getEntityId() && (aid == PracticalConstants.CRIT_ANIMATION || aid == PracticalConstants.MAGIC_CRIT_ANIMATION)) {
                event.setCancelled(true);
            }
            return;
        }

        EnumWrappers.Particle particle = event.getPacket().getParticles().readSafely(0);
        if (particle == EnumWrappers.Particle.CRIT || particle == EnumWrappers.Particle.CRIT_MAGIC) {
            event.setCancelled(true);
        }
    }
}