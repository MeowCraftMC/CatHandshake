package al.yl.cathandshake.listener;

import al.yl.cathandshake.CatHandshake;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Cat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class TouchCatListener implements Listener {
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        var entity = event.getRightClicked();
        var player = event.getPlayer();
        var world = player.getWorld();

        if (entity instanceof Cat cat) {
            var rand = CatHandshake.getInstance().getRandom();
            var soundType = rand.nextInt(0, 5);

            switch (soundType) {
                case 0 -> player.playSound(cat, Sound.ENTITY_CAT_AMBIENT, 1.0f, 1.0f);
                case 1 -> player.playSound(cat, Sound.ENTITY_CAT_PURR, 1.0f, 1.0f);
                case 2 -> player.playSound(cat, Sound.ENTITY_CAT_PURREOW, 1.0f, 1.0f);
                case 3 -> player.playSound(cat, Sound.ENTITY_CAT_STRAY_AMBIENT, 1.0f, 1.0f);
                case 4 -> player.playSound(cat, Sound.ENTITY_CAT_BEG_FOR_FOOD, 1.0f, 1.0f);
            }

            world.spawnParticle(Particle.HEART, cat.getLocation(), rand.nextInt(1, 6), 0.2, 0.5, 0.2);
        }
    }
}
