package Game;

import Engine.Game;
import Engine.GameManager;

import Engine.GameWindow;
import Game.Entities.*;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by shpatnaik on 8/3/14.
 */
public class PongGame implements Game {

    private static final int WINDOW_WIDTH = 320;
    private static final int WINDOW_HEIGHT = 240;
    private static final int WINDOW_SCALE = 2;

    private static final int PADDLE_PADDING = 15;
    private static final int BOUNDARY_PADDING = 5;
    private static final int BOUNDARY_HEIGHT = 5;
    private static final int GOAL_WIDTH = 5;

    private static final Font SCORE_FONT = new Font("Century Gothic", Font.PLAIN, 28);
    private static final Color PLAYER1_SCORE_COLOR = Color.BLUE;
    private static final Color PLAYER2_SCORE_COLOR = Color.RED;
    private static final int SCORE_PADDING = 50;

    private GameManager gm = new GameManager();

    private int width;
    private int height;

    // Game Objects
    private Paddle player1Paddle;
    private Paddle player2Paddle;
    private Ball ball;
    private Boundary topBoundary;
    private Boundary bottomBoundary;
    private Boundary player1Goal;
    private Boundary player2Goal;
    private Score player1Score;
    private Score player2Score;

    public static void main(String[] args) {
        GameWindow.show(new PongGame(), "Pong", WINDOW_WIDTH, WINDOW_HEIGHT, WINDOW_SCALE);
    }

    @Override
    public void init(int width, int height) {

        this.width = width;
        this.height = height;

        player1Paddle = new Paddle(PADDLE_PADDING, height, Color.BLUE, KeyEvent.VK_Q, KeyEvent.VK_A);
        player2Paddle = new Paddle(width - (PADDLE_PADDING * 2), height, Color.RED, KeyEvent.VK_UP, KeyEvent.VK_DOWN);

        ball = new Ball(width, height);

        topBoundary = new Boundary(BOUNDARY_PADDING, 0, width - (2 * BOUNDARY_PADDING), BOUNDARY_HEIGHT);
        bottomBoundary = new Boundary(BOUNDARY_PADDING, height - BOUNDARY_HEIGHT,
                width - (2 * BOUNDARY_PADDING), BOUNDARY_HEIGHT);

        player1Goal = new Boundary(0, 0, GOAL_WIDTH, height);
        player2Goal = new Boundary(width - GOAL_WIDTH, 0, GOAL_WIDTH, height);

        player1Score = new Score(SCORE_PADDING, SCORE_PADDING, SCORE_FONT, PLAYER1_SCORE_COLOR);
        player2Score = new Score(width - (int)(SCORE_PADDING * 1.5), SCORE_PADDING, SCORE_FONT, PLAYER2_SCORE_COLOR);

        gm.add(new StarField(width, height, 200, 0.1));

        gm.add(player1Paddle);
        gm.add(player2Paddle);
        gm.add(ball);

        gm.add(topBoundary);
        gm.add(bottomBoundary);
        gm.add(player1Goal);
        gm.add(player2Goal);

        gm.add(player1Score);
        gm.add(player2Score);
    }

    @Override
    public void draw(Graphics2D g) {
        gm.draw(g);
    }

    @Override
    public void update(int dt) {
        gm.update(dt);

        // Check and modify collisions
        if (ball.getRectangle().intersects(player1Paddle.getRectangle())) {
            // Set new Velocity
            ball.setVelocity(ball.getVx() * -1, ball.getVy());

            // Set position correction
            ball.setPosition(player1Paddle.getX() + player1Paddle.getWidth(), ball.getY());
        }

        if (ball.getRectangle().intersects(player2Paddle.getRectangle())) {
            // Set new Velocity
            ball.setVelocity(ball.getVx() * -1, ball.getVy());

            // Set position correction
            ball.setPosition(player2Paddle.getX() - 2, ball.getY());
        }

        if (ball.getRectangle().intersects(topBoundary.getRectangle())) {
            // Set new Velocity
            ball.setVelocity(ball.getVx(), ball.getVy() * -1);

            // Set position correction
            ball.setPosition(ball.getX(), topBoundary.getY() + topBoundary.getHeight());
        }

        if (ball.getRectangle().intersects(bottomBoundary.getRectangle())) {
            // Set new Velocity
            ball.setVelocity(ball.getVx(), ball.getVy() * -1);

            // Set position correction
            ball.setPosition(ball.getX(), bottomBoundary.getY() - 5);
        }

        if (ball.getRectangle().intersects(player1Goal.getRectangle())) {
            player2Score.increment();
            ball.reset();
        }

        if (ball.getRectangle().intersects(player2Goal.getRectangle())) {
            player1Score.increment();
            ball.reset();
        }
    }

    @Override
    public void keyPressed(int key) {
        gm.keyPressed(key);
    }
}
