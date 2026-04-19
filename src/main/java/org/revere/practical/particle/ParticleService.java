package org.revere.practical.particle;

import lombok.Getter;
import org.revere.practical.Practical;
import org.revere.practical.PracticalConstants;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Venyo
 * @since 4/1/2026
 */

@Getter
public class ParticleService {
    private final Map<UUID, Long> blockedPlayers = new ConcurrentHashMap<>();

    public void addBlockedPlayer(UUID uuid) {
        blockedPlayers.put(uuid, System.currentTimeMillis() + PracticalConstants.BLOCK_DURATION_MILLIS);
    }

    public boolean shouldBlock(UUID uuid) {
        Long expiresAt = blockedPlayers.get(uuid);
        if (expiresAt == null) {
            return false;
        }

        if (expiresAt < System.currentTimeMillis()) {
            blockedPlayers.remove(uuid, expiresAt);
            return false;
        }

        return true;
    }
}
