package program.maps;

import program.core.GameObject;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;

public class Wood extends GameObject {
    public Wood() {
        hitBox = new BoxCollider(this, 45, 45);
        renderer = new SingleImageRenderer("assests/image/Boom/Box/wood.png");
    }
}
