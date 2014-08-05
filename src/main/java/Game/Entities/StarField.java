package Game.Entities;

import Engine.GameObject;
import Engine.Utilities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by shpatnaik on 8/3/14.
 */
public class StarField extends GameObject {

    private static final int STAR_WIDTH = 2;
    private static final int STAR_HEIGHT = 2;
    private static final Color STAR_COLOR = Color.white;

    private final int noOfStars;
    private double speed;
    private BufferedImage image;

    public void init() {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D context = (Graphics2D) image.getGraphics();
        context.setColor(STAR_COLOR);

        for (int i = 0; i < noOfStars; i++) {
            Point star = new Point();
            star.x = Utilities.randomNumber(0, width);
            star.y = Utilities.randomNumber(0, height);
            context.fillRect(star.x, star.y, STAR_WIDTH, STAR_HEIGHT);
        }
    }

    public StarField(int width, int height, int noOfStars, double speed) {
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.noOfStars = noOfStars;

        init();
    }

    @Override
    public void update(int dt) {
        y += (dt * speed);

        if (y >= height - 1) {
            y = 0;
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);

        // Draw Bottom Half
        g.drawImage(image.getSubimage(0, 0, width, height - y - 1), 0, y, width, height - y - 1, null);

        // Draw Top Half
        g.drawImage(image.getSubimage(0, height - y - 1, width, y + 1), 0, 0, width, y + 1, null);
    }

    @Override
    public void keyPressed(int key) {
        // Do Nothing
    }
}
