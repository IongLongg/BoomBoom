package program.maps;

import javafx.application.Platform;
import program.Background;
import program.core.GameObject;

import java.util.List;

public class Layer {
    private List<Integer> data;
    private int width;
    private int height;

    @Override
    public String toString() {
        return "Layer{" +
                "data=" + data +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    public void generate() {
        for (int tileY = 0; tileY < height; tileY++) {
            for (int tileX = 0; tileX < width; tileX++) {
                int mapData = data.get(tileY * width + tileX);

                if (mapData == 1) {
                    Box box = new Box();
                    box.position.set(tileX * 45, tileY * 45);
                    GameObject.objects.add(box);
                }
                if (mapData == 2) {
                    Wood wood = new Wood();
                    wood.position.set(tileX * 45, tileY * 45);
                    GameObject.objects.add(wood);
                }
                if (mapData == 3) {
                    Shadow shadow = new Shadow();
                    shadow.position.set(tileX * 45, tileY * 45);
                    GameObject.objects.add(shadow);
                }
            }
        }
    }
}
