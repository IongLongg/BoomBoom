package program;

import com.google.gson.Gson;
import program.core.GamePanel;
import program.core.GameWindow;
import program.maps.Layer;
import program.maps.Map;
import program.utlis.Utils;

import java.awt.*;

public class Program {
    public static void main(String[] args ) {
        GameWindow window = new GameWindow();
        GamePanel panel = new GamePanel();

        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH, Settings.GAME_HEIGHT));
        window.add(panel);
        window.pack();
        window.setVisible(true);

        panel.gameLoop();
//        System.out.println(Utils.readTextFile("assests/map/map.json"));

    }
}
