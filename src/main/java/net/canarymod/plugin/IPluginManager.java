package net.canarymod.plugin;

import net.visualillusionsent.utils.PropertiesFile;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

/**
 * Main interface for the Canary Plugin Manager
 *
 * @author Pwootage
 */
public interface IPluginManager {
    /**
     * Enables the given plugin. Loads the plugin if not loaded (and available)
     *
     * @param name the name of the {@link net.canarymod.plugin.Plugin}
     * @return {@code true} on success, {@code false} on failure
     */
    boolean enablePlugin(String name);

    /**
     * Enables all plugins, used when starting up the server.
     */
    void enableAllPlugins();

    /**
     * Disables the given plugin
     *
     * @param name the name of the {@link net.canarymod.plugin.Plugin}
     * @return {@code true} on success, {@code false} on failure
     */
    boolean disablePlugin(String name);

    /**
     * Disables all plugins, used when shutting down the server.
     */
    void disableAllPlugins();

    /**
     * Disables all plugins, used when shutting down the server.
     *
     * @param log The {@link org.apache.logging.log4j.Logger} to use when shutting down. This is
     *            necessary when in the shutdown hook, since we can't rely on external
     *            libraries there (see the javadoc at
     *            {@link Runtime#addShutdownHook(Thread)})
     */
    void disableAllPlugins(Logger log);

    /**
     * Reload the specified plugin
     *
     * @param name
     * @return true on success, false on failure which probably means the plugin is now not enabled nor loaded
     */
    boolean reloadPlugin(String name);

    /**
     * Get the Plugin with specified name.
     *
     * @param name
     * @return The plugin for the given name, or null on failure.
     */
    Plugin getPlugin(String name);

    /**
     * Gets an unmodifiable collection of currently loaded Plugins
     *
     * @return unmodifiable collection of Plugins
     */
    Collection<Plugin> getPlugins();

    /**
     * Gets an unmodifiable collection of currently known PluginDescriptions
     *
     * @return unmodifiable collection of PluginDescriptions
     */
    Collection<PluginDescriptor> getPluginDescriptors();

    /**
     * Gets the plugin descriptor for a plugin.
     *
     * @param plugin Plugin to get descriptor for
     * @return Descriptor for plugin
     */
    PluginDescriptor getPluginDescriptor(Plugin plugin);

    /**
     * Gets the plugin descriptor for a plugin by name, loading it if not loaded.
     *
     * @param plugin Plugin to get descriptor for
     * @return Descriptor for plugin
     */
    PluginDescriptor getPluginDescriptor(String plugin);

    /**
     * Scans the plugin folder for any new plugins. Will ignore any already-known plugins.
     */
    void scanForPlugins();
}
