package program.core;

import program.Background;
import program.maps.Box;
import program.maps.Map;
import program.player.Bomber;
import program.player.Bomb;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Bomber bomber;
    Bomb bomb;

    public GamePanel() {
        background = new Background();
        bomber = new Bomber();
        bomb = new Bomb();
        addMap();
    }

    private void addMap() {
        Map map = Map.load("assests/map/map.json");
        map.generate();
    }


    @Override
    public void paint(Graphics g) {
        for(int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.render(g);
            }
        }
    }

    public void runAll() {
        for(int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.run();
            }
        }
    }

    public void gameLoop() {
        long lastTime = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime >= 1000 / 60) {
                this.repaint();
                this.runAll();
                lastTime = currentTime;
            }
        }
    }
}
