package Game.Entities;

import Engine.GameObject;

import java.awt.*;

/**
 * Created by shpatnaik on 8/4/14.
 */
public class Paddle extends GameObject {

    private final int keyUp;
    private final int keyDown;

    private static final int PADDLE_HEIGHT = 20;
    private static final int PADDLE_WIDTH = 5;

    private static final int SPEED = 5;

    private final Color paddleColor;

    public Paddle(int x, int height, Color paddleColor, int keyUp, int keyDown) {
        this.x = x;
        this.y = height / 2 - PADDLE_HEIGHT / 2;
        this.paddleColor = paddleColor;
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.height = PADDLE_HEIGHT;
        this.width = PADDLE_WIDTH;
    }

    @Override
    public void update(int dt) {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(paddleColor);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void keyPressed(int key) {
        if (key == keyUp) {
            y -= SPEED;
        } else if (key == keyDown) {
            y += SPEED;
        }
    }
}
