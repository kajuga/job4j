package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

/**
 * Rectangle moving realisation
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;
    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        boolean moveStraight = true;
        while (!Thread.currentThread().isInterrupted()) {
            if (this.rect.getX() == 290) {
                moveStraight = false;
            }
            if (this.rect.getX() == 0) {
                moveStraight = true;
            }
            if (moveStraight) {
                this.rect.setX(this.rect.getX() + 1);
            } else {
                this.rect.setX(this.rect.getX() - 1);
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}