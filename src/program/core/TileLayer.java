package program.core;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TileLayer {
    private int [][] map;
    private BufferedImage tileSheet;

    public TileLayer(int[][] existingMap) {
        map = new int[existingMap.length][existingMap[0].length];

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                map[y][x] = existingMap[y][x];
            }
        }

        tileSheet = SpriteUtils.loadImage("assests/image/Boom/Backgound/background_Play.png");
    }

    public void DrawLayer(Graphics g) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x< map[y].length; x++) {
                int index = map[y][x];
                int yOffset = 0;


            }
        }
    }

    public TileLayer(int width, int height) {
        map = new int[height][width];
    }

    public static TileLayer FromFile(String fileName) {
        TileLayer layer = null;

        ArrayList<ArrayList<Integer>> tempLayout = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.isEmpty())
                    continue;

                ArrayList<Integer> row = new ArrayList<>();

                String[] values = currentLine.trim().split(" ");

                for(String string : values) {
                    if (!string.isEmpty()) {
                        int id = Integer.parseInt(string);

                        row.add(id);
                    }
                }

                tempLayout.add(row);
            }
        } catch (IOException e) {

        }

        int width = tempLayout.get(0).size();
        int height = tempLayout.size();

        layer = new TileLayer(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                layer.map[y][x] = tempLayout.get(y).get(x);
            }
        }

        layer.tileSheet = SpriteUtils.loadImage("assests/image/Boom/Backgound/background_Play.png");

        return layer;
    }
}
