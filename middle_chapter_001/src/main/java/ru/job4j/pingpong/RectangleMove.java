package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private int limitX;
    private int limitY;
    private int signX = 1;
    private int signY = 1;
    private double dx = 1.0f;
    private double dy = 1.0f;

    public RectangleMove(Rectangle rect, int limitX, int limitY) {
        this.rect = rect;
        this.limitX = limitX;
        this.limitY = limitY;
    }

    @Override
    public void run() {
        while (true) {
            double tekX = this.rect.getX();
            double tekY = this.rect.getY();
            if (this.limitX <= tekX || 0 >= tekX) {
                this.signX = -1 * this.signX;
            }
            if (this.limitY <= tekY || 0 >= tekY) {
                this.signY = -1 * this.signY;
            }
            this.rect.setX(tekX + this.signX * this.dx);
            this.rect.setY(tekY + this.signY * this.dy);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
