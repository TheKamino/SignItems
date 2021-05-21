package de.kamikazozi.signitems.commands;

import de.kamikazozi.signitems.utils.Data;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Florian Dohms
 * <p>
 * Copyright (c) 2017 - 2020 by KamiKazozi to present. All rights served.
 */

public class CommandSignItems implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Data.onlyPlayer);
            return true;
        }

        if (sender.hasPermission("signitems.sign") || sender.hasPermission("signitems.*")) {
            Player player = (Player) sender;
            if (player.getItemInHand() == null || player.getItemInHand().getType() == null || player.getItemInHand().getType() == Material.AIR) {
                player.sendMessage(Data.prefix + "§cNehme ein gültiges Item in die Hand!");
                return true;
            }
            ItemStack itemInHand = player.getItemInHand();
            ItemMeta itemMeta = itemInHand.getItemMeta();

            if (itemMeta.hasLore()) {
                player.sendMessage(Data.prefix + "§cDu kannst dieses Item nicht verifizieren!");
                return true;
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String date = simpleDateFormat.format(new Date());

            itemMeta.setLore(Arrays.asList("§aVerifiziert von §b" + player.getName(), "§8[§7" + date + "§8]"));
            itemInHand.setItemMeta(itemMeta);
            player.sendMessage(Data.prefix + "§aDas Item wurde erfolgreich verifiziert.");
        } else {
            sender.sendMessage(Data.noPerm);
        }
        return true;
    }
}
