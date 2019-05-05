package program.core;

import program.renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;


public class GameObject {
    public Vector2D position;
    public Vector2D velocity;
    public Renderer renderer;
    public boolean active;

    public static ArrayList<GameObject> objects = new ArrayList<>();

    public GameObject() {
        objects.add(this);
        position = new Vector2D();
        velocity = new Vector2D();
        active = true;
    }

    public void render(Graphics g) {
        if(renderer != null ) {
            renderer.render(g, this);
        }
    }

    public void run() {
        position.add(velocity);
    }

    public void deactive() {
        active = false;
    }

    public void reset() {
        active = true;
    }
}
