package Game.Entities;

import Engine.GameObject;

import java.awt.*;

/**
 * Created by shpatnaik on 8/5/14.
 */
public class Boundary extends GameObject {

    private Color BOUNDARY_COLOR = Color.WHITE;

    public Boundary(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void update(int dt) {
        // Do Nothing
    }

    @Override
    public void draw(Graphics2D g) {
        // Do Nothing
        g.setColor(BOUNDARY_COLOR);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void keyPressed(int key) {
        // Do Nothing
    }
}
