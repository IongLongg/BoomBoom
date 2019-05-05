package program.player;

import program.Settings;
import program.core.GameObject;
import program.core.GameWindow;
import program.renderer.SingleImageRenderer;
import tklibs.Mathx;

public class Bomber extends GameObject {
    public Bomber() {
        renderer = new SingleImageRenderer("assests/image/Boom/Bomber/bomber_right.png");
        position.set(0,0);
    }

    public void run() {
        super.run();
        this.move();
        this.fire();
        this.limitPosition();
    }

    public void fire() {
        Bomb boom = new Bomb();

        if(GameWindow.isFirePress && Bomb.getBoomRate() > 0 && Bomb.getBoomTimer() < -700) {
            boom.position.set(this.position);
            Bomb.addBoomRate(-1);
        }
    }

    public void move() {
        double playerSpeed = Settings.PLAYER_SPEED;
        double vx = 0;
        double vy = 0;

        if(GameWindow.isUpPress) {
            vy -= playerSpeed;
            renderer = new SingleImageRenderer("assests/image/Boom/Bomber/bomber_up.png");
        }
        if(GameWindow.isRightPress) {
            vx += playerSpeed;
            renderer = new SingleImageRenderer("assests/image/Boom/Bomber/bomber_right.png");
        }
        if(GameWindow.isDownPress) {
            vy += playerSpeed;
            renderer = new SingleImageRenderer("assests/image/Boom/Bomber/bomber_down.png");
        }
        if(GameWindow.isLeftPress) {
            vx -= playerSpeed;
            renderer = new SingleImageRenderer("assests/image/Boom/Bomber/bomber_left.png");
        }

        if(vx != 0 && vy != 0) {
            double v = playerSpeed / Math.sqrt(2);
            vx = Math.signum(vx) * v;
            vy = Math.signum(vy) * v;
        }

        velocity.set(vx, vy);
    }

    public void limitPosition() {
        position.setX(Mathx.clamp(position.x, 0, Settings.BACKGROUND_WIDTH - Settings.PLAYER_WIDTH));
        position.setY(Mathx.clamp(position.y, 0, Settings.GAME_HEIGHT - Settings.PLAYER_HEIGHT));
    }
}
