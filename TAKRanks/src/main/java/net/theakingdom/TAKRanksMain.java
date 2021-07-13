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

        this.loadDataConfig();
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

    public FileConfiguration loadDataConfig() {
        data = new File(this.getDataFolder(), "ranks.yml");
        if (!data.exists()) {
            try {
                data.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        dataConfig = YamlConfiguration.loadConfiguration(data);
        return dataConfig;
    }

    public static void setRank(String player, String rank) {
        dataConfig.set("player." + Bukkit.getPlayer(player).getUniqueId().toString(), rank);
        try {
            dataConfig.save(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRank(String player) {
        return dataConfig.getString("player." + Bukkit.getPlayer(player).getUniqueId().toString());
    }
}
