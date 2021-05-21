package de.kamikazozi.signitems;

import de.kamikazozi.signitems.commands.CommandSignItems;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Florian Dohms
 * <p>
 * Copyright (c) 2017 - 2020 by KamiKazozi to present. All rights served.
 */
public class SignItems extends JavaPlugin {

    public void onEnable() {
        registerCommands();
    }

    public void registerCommands() {
        getCommand("signitems").setExecutor(new CommandSignItems());
    }
}
