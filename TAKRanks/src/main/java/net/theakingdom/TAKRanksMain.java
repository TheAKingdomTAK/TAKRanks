package net.theakingdom;

import org.bukkit.plugin.java.JavaPlugin;

public class TAKRanksMain implements JavaPlugin
{
    public static File data;
    public static YamlConfiguration dataConfig;

    public void onEnable() {
        System.out.println("Ranks Enabling...");
        if (!this.getDataFolder().exists()) {
            this.getDataFolder.mkdir();
        }

        this.loadDataConfig();
        if (dataConfig.getConfigurationSection("ranks") == null) {
            dataConfig.set("ranks.Owner.prefix", "§x§F§E§9§1§9§F§[§x§5§4§F§9§B§AOwner§x§F§E§9§1§9§F]");
            dataConfig.set("ranks.Admin.prefix", "§x§5§4§F§9§B§A[§x§F§E§9§1§9§FAdmin§x§5§4§F§9§B§A]");

            try {
                dataConfig.save(dataFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
