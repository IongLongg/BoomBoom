package program.player;

import program.Settings;
import program.core.GameObject;
import program.core.GameWindow;
import program.renderer.SingleImageRenderer;

public class Bomb extends GameObject {
    public int damage;

    public Bomb() {
        damage = 1;
        renderer = new SingleImageRenderer("assests/image/Boom/Bomb/bomb.png");
    }

    @Override
    public void run() {
        this.timerExplode();
    }

    public static int getBoomRate() {
        return Settings.BOOM_RATE;
    }

    public static void addBoomRate(int i) {
        Settings.BOOM_RATE += i;
    }

    public static int getBoomTimer() {
        return Settings.BOOM_TIMER;
    }

    public static int setBoomTimer(int i) {
        return Settings.BOOM_TIMER = i;
    }

    public static void timerExplode() {
        if(Settings.BOOM_TIMER < -750) {
            Settings.BOOM_TIMER = 0;
        } else {
            Settings.BOOM_TIMER --;
        }
    }
}
