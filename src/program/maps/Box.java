package program.maps;

import program.core.GameObject;
import program.physics.BoxCollider;
import program.player.Bomber;
import program.renderer.Renderer;
import program.renderer.SingleImageRenderer;

public class Box extends GameObject {
    public Box() {
        hitBox = new BoxCollider(this, 45,45);
        renderer = new SingleImageRenderer("assests/image/Boom/Box/box1.png");
    }


}
