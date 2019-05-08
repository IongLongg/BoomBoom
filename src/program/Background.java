package program;

import program.core.GameObject;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;

public class Background extends GameObject {
    public Background() {
        position.set(0, 0);
        renderer = new SingleImageRenderer("assests/image/Boom/Backgound/background_Play.png");
    }
}
