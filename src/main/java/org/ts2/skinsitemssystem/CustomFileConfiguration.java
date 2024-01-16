package org.ts2.skinsitemssystem;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomFileConfiguration {
    private File file;
    private FileConfiguration config;
    private String name;

    public CustomFileConfiguration(String name) {
        this.name = name;
        file = new File(SkinsItemsSystem.instance.getDataFolder(), name);

        try {
            if (!file.exists() && !file.createNewFile()) throw new IOException();
        } catch (IOException e) {
            throw new RuntimeException("failed to create " + name, e);
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException("failed to save " + name, e);
        }
    }
}
