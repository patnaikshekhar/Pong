package Game.Entities;

import Engine.GameObject;
import Engine.Utilities;

import java.awt.*;

/**
 * Created by shpatnaik on 8/4/14.
 */
public class Ball extends GameObject {

    private static final Color BALL_COLOR = Color.GREEN;
    private static final int BALL_SIZE = 4;

    private final int boundaryWidth;
    private final int boundaryHeight;

    public Ball(int width, int height) {

        this.boundaryWidth = width;
        this.boundaryHeight = height;

        this.width = BALL_SIZE;
        this.height = BALL_SIZE;

        reset();
    }

    public void reset() {
        x = boundaryWidth / 2;
        y = boundaryHeight / 2;

        boolean xDirection = Utilities.randomNumber(1, 2) == 1;
        boolean yDirection = Utilities.randomNumber(1, 2) == 1;

        vx = xDirection ? 0.08: -0.08;
        vy = yDirection ? 0.08: -0.08;
    }

    @Override
    public void update(int dt) {
        x += (vx * dt);
        y += (vy * dt);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(BALL_COLOR);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void keyPressed(int key) {
        // Do Nothing
    }
}
