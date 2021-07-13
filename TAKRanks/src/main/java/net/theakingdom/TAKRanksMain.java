package net.theakingdom;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public class TAKRanksMain extends JavaPlugin {
    public static File data;
    public static YamlConfiguration dataConfig;

    public void onEnable() {
        System.out.println("Ranks Enabling...");
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }

        if (dataConfig.getConfigurationSection("ranks") == null) {
            dataConfig.set("ranks.Owner.prefix", "§x§F§E§9§1§9§F§[§x§5§4§F§9§B§AOwner§x§F§E§9§1§9§F]");
            dataConfig.set("ranks.Admin.prefix", "§x§5§4§F§9§B§A[§x§F§E§9§1§9§FAdmin§x§5§4§F§9§B§A]");

            try {
                dataConfig.save(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
