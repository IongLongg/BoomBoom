package program.core;

import program.maps.Box;
import program.physics.BoxCollider;
import program.renderer.Renderer;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;


public class GameObject {
    public Vector2D position;
    public Vector2D velocity;
    public Vector2D anchor;
    public Renderer renderer;
    public boolean active;
    public BoxCollider hitBox;


    public static ArrayList<GameObject> objects = new ArrayList<>();

    public static <E extends GameObject> E findIntersects(Class<E> cls, BoxCollider hitBox) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active
                && object.getClass().isAssignableFrom(cls)
                && object.hitBox != null
                && object.hitBox.intersects(hitBox)) {
                return (E) object;
            }
        }
        return null;
    }

    public GameObject() {
        objects.add(this);
        position = new Vector2D();
        velocity = new Vector2D();
        anchor = new Vector2D(0.5,0.5);
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
