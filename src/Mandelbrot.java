//Sapozhnikov Arkady
//Drawing picture in swing(Mandelbrot)
//01.01.2018

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class Mandelbrot extends JPanel {
    public double red;
    public double green;
    public double blue;
    public double newX;
    public double newY;
    public double zoom;

    public Mandelbrot(double red, double green, double blue, double newX, double newY, double zoom) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.newX = newX;
        this.newY = newY;
        this.zoom = zoom;
    }

    public static void setNewX(double newX, Mandelbrot m) {
        m.newX = newX;
    }

    public static void setNewY(double newY, Mandelbrot m) {
        m.newY = newY;
    }

    public static void setzoom(double zoom, Mandelbrot m) {
        m.zoom = zoom;
    }

    public static void setRed(double red, Mandelbrot m) {
        m.red = red;
    }

    public static void setGreen(double green, Mandelbrot m) {
        m.green = green;
    }

    public static void setBlue(double blue, Mandelbrot m) {
        m.blue = blue;
    }

    @Override
    protected void paintComponent(Graphics arg0) {
        Graphics2D g2d = (Graphics2D) arg0;
        for (int i = 0; i <= getWidth(); i++) {
            for (int j = 0; j <= getHeight(); j++) {
                double x = zoom * i / getWidth() + newX;
                double y = zoom * j / getHeight() + newY;
                Complex z0 = new Complex(x, y);
                Complex z = new Complex(x, y);
                int k;
                for (k = 0; k <= 255; k++) {
                    if (Complex.abs(z) >= 2) {
                        g2d.setColor(new Color((int) ((Math.pow(k, red)) % 255), (int) ((Math.pow(k, green)) % 255), (int) ((Math.pow(k, blue)) % 255)));
                        break;
                    } else {
                        Complex tmp = Complex.multiply(z, z);
                        tmp = Complex.add(tmp, z0);
                        z = tmp;
                    }
                }
                g2d.drawLine(i, j, i, j);
            }
        }
    }
}
