package al.yl.cathandshake;

import al.yl.cathandshake.listener.TouchCatListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class CatHandshake extends JavaPlugin {
    public static final String VERSION = "@version@";

    private static CatHandshake INSTANCE;

    private final Random random = new Random();

    public CatHandshake() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        getLogger().info("CatHandshake is loading. Ver: " + VERSION);

        getServer().getPluginManager().registerEvents(new TouchCatListener(), this);
    }

    public static CatHandshake getInstance() {
        return INSTANCE;
    }

    public Random getRandom() {
        return random;
    }
}
