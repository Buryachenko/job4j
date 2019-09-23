package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private final int limitX;
    private final int limitY;
    private final double dx = 1.0f;
    private final double dy = 1.0f;

    public RectangleMove(Rectangle rect, int limitX, int limitY) {
        this.rect = rect;
        this.limitX = limitX;
        this.limitY = limitY;
    }

    @Override
    public void run() {
        int signX = 1;
        int signY = 1;

        while (!Thread.currentThread().isInterrupted()) {
            double tekX = this.rect.getX();
            double tekY = this.rect.getY();
            if (this.limitX <= tekX || 0 >= tekX) {
                signX = -1 * signX;
            }
            if (this.limitY <= tekY || 0 >= tekY) {
                signY = -1 * signY;
            }
            this.rect.setX(tekX + signX * this.dx);
            this.rect.setY(tekY + signY * this.dy);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
