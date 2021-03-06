package net.canarymod.commandsys;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.MessageReceiver;

/**
 * A class that handels the "@" attribute
 * 
 * @author Ehud  (EhudB)
 * @author Almog (Swift)
 */
public interface PlayerSelector {

    /**
     * Get one player that matches the pattern
     * 
     * @param caller  the {@link MessageReceiver} that sent the pattern 
     * @param pattern the pattern that was sent
     * @return the one {@link Player} that matches the pattern, if multiple or none returns null
     */
    public Player matchOnePlayer(MessageReceiver caller, String pattern);

    /**
     * Get all players that matches the pattern
     * 
     * @param caller  the {@link MessageReceiver} that sent the pattern 
     * @param pattern the pattern that was sent
     * @return all players that matches the pattern
     */
    public Player[] matchPlayers(MessageReceiver caller, String pattern);

    /**
     * Returns if the pattern can match more then one player
     * 
     * @param pattern the pattern to check
     * @return if the pattern matches more the one player
     */
    public boolean matchesMultiplePlayers(String pattern);
}
