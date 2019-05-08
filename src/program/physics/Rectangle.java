package program.physics;

import program.core.Vector2D;

public class Rectangle {
    public Vector2D position;
    public int width;
    public int height;

    public Rectangle() {
        this(new Vector2D(0, 0), 1, 1);
    }

    public Rectangle(double x, double y, int width, int height) {
        this(new Vector2D(x, y), width, height);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public double top() {
        return this.position.y;
    }
    public double bot() {
        return top() + this.height;
    }
    public double left() {
        return this.position.x;
    }
    public double right() {
        return left() + this.width;
    }

    /**
     * return true if: this rectangle intersects with the other rectangle
     * else return false
     * @param other: the rectangle need to check intersects with this rectangle
     * @return
     */
    public boolean intersects(Rectangle other) {
        // 1. TODO: remove default return statement and implements methods
//        if ((Math.abs(this.position.x - other.position.x) < this.width) && (Math.abs(this.position.y - other.position.y) < this.height))
//            return true;
//        else return false;

        return this.right() >= other.left()
                && this.left() <= other.right()
                && this.top() <= other.bot()
                && this.bot() >= other.top();
    }
}
