package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

/**
 * Rectangle moving realisation
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private boolean moveStraight = true;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while (true) {
            checkMove();
            move();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Mooving checker
     */
    private void checkMove(){
        if (this.rect.getX() == 290) {
            moveStraight = false;
        }
        if (this.rect.getX() == 0) {
            moveStraight = true;
        }
    }

    /**
     * Moover
     */
    private void move(){
        if (moveStraight) {
            this.rect.setX(this.rect.getX() + 1);
        } else {
            this.rect.setX(this.rect.getX() - 1);
        }
    }
}