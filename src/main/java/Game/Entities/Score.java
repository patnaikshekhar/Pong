package Game.Entities;

import Engine.GameObject;

import java.awt.*;

/**
 * Created by shpatnaik on 8/5/14.
 */
public class Score extends GameObject {

    private final Font font;
    private final Color color;

    private int score;

    public Score(int x, int y, Font font, Color color) {
        this.x = x;
        this.y = y;
        this.font = font;
        this.color = color;
        score = 0;
    }

    public void increment() {
        score += 1;
    }

    @Override
    public void update(int dt) {
        // Do Nothing
    }

    @Override
    public void draw(Graphics2D g) {
        g.setFont(font);
        g.setColor(color);
        g.drawString(String.valueOf(score), x, y);
    }

    @Override
    public void keyPressed(int key) {
        // Do Nothing
    }
}
