package me.megamagnum.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED +  "UpgradedHome" + ChatColor.LIGHT_PURPLE+ " is now turned on and ready for use!");
        Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "SMP Manager is made by " + ChatColor.GOLD +  "MegaMagnum#7570");




        Storage.setup();

        Storage.get().options().copyDefaults(true);
        Storage.save();


        getConfig().options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new warp(), this);

        recipes();


        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void recipes(){



        ItemStack estar = new ItemStack(Material.NETHER_STAR);
        ItemMeta estarmeta = estar.getItemMeta();
        ArrayList<String> estarlore = new ArrayList();
        estarlore.add(ChatColor.DARK_PURPLE + "This star has been enlightened with glowstone!");
        estarmeta.setLore(estarlore);
        estarmeta.setDisplayName( ChatColor.GOLD  + "Enlightened Star");
        estar.setItemMeta(estarmeta);

        ItemStack eyeender = new ItemStack(Material.ENDER_EYE);
        ItemMeta eyeendermeta = eyeender.getItemMeta();
        ArrayList<String> eyeenderlore = new ArrayList();
        eyeenderlore.add(ChatColor.DARK_PURPLE + "This eye will let the teleport to your enlightened star!");
        eyeendermeta.setLore(eyeenderlore);
        eyeendermeta.setDisplayName( ChatColor.GOLD  + "Warping Eye");
        eyeender.setItemMeta(eyeendermeta);

    

        ShapedRecipe eyeendercraft = new ShapedRecipe(new NamespacedKey(this, "eyeenderkey"), eyeender);
        eyeendercraft.shape("BBB", "EME", "BBB");
        eyeendercraft.setIngredient('B', Material.BLAZE_POWDER);
        eyeendercraft.setIngredient('E', Material.ENDER_PEARL);
        eyeendercraft.setIngredient('M', Material.ENDER_EYE);



        ShapedRecipe estarcraft = new ShapedRecipe(new NamespacedKey(this, "estarKey"), estar);
        estarcraft.shape("GGG", "GEG", "GGG");
        estarcraft.setIngredient('G', Material.GLOWSTONE);
        estarcraft.setIngredient('E', Material.NETHER_STAR);



        Bukkit.addRecipe(eyeendercraft);
        Bukkit.addRecipe(estarcraft);

    }

}
