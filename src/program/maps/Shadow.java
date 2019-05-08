package program.maps;

import program.core.GameObject;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;

public class Shadow extends GameObject {
    public Shadow() {
        hitBox = new BoxCollider(this, 45, 22);
        renderer = new SingleImageRenderer("assests/image/Boom/Box/shawdow1.png");
    }
}
