package me.zerobugs.config;

import org.bspfsystems.yamlconfiguration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;

public final class ConfigHandler {

    private final HashMap<String, YamlConfiguration> configs;
    private final File outputFolder;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public ConfigHandler() {
        configs = new HashMap<>();
        outputFolder = new File("Currency");
        if (!outputFolder.exists()) {
            outputFolder.mkdir();
        }
    }

    public ConfigHandler createConfig(String name) {

        InputStream input = getClass().getResourceAsStream("/" + name + ".yml");
        File outputFile = new File(outputFolder, name + ".yml");

        if (!outputFile.exists()) {
            try {
                assert input != null;
                Files.copy(input, outputFile.toPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        saveConfig(YamlConfiguration.loadConfiguration(outputFile), name);
        return this;
    }

    public void saveConfig(YamlConfiguration config, String configName) {
        configs.put(configName, config);
    }

    public ConfigHandler deleteConfig(String configName) {
        configs.remove(configName);
        return this;
    }

    public YamlConfiguration getConfig(String configName) {
        return configs.get(configName);
    }
}
