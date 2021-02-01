//Sapozhnikov Arkady
//Drawing picture in swing(Julia)
//11.02.2018

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class Julia extends JPanel {
    public double a;
    public double b;
    public double red;
    public double green;
    public double blue;
    public double newX;
    public double newY;
    public double zoom;


    public Julia(double a, double b, double red, double green, double blue, double newX, double newY, double zoom) {
        this.a = a;
        this.b = b;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.newX = newX;
        this.newY = newY;
        this.zoom = zoom;
    }

    public static void setNewX(double newX, Julia j) {
        j.newX = newX;
    }

    public static void setNewY(double newY, Julia j) {
        j.newY = newY;
    }

    public static void setzoom(double zoom, Julia j) {
        j.zoom = zoom;
    }

    public static void setA(double a, Julia j) {
        j.a = a;
    }

    public static void setB(double b, Julia j) {
        j.b = b;
    }

    public static void setRed(double red, Julia j) {
        j.red = red;
    }

    public static void setGreen(double green, Julia j) {
        j.green = green;
    }

    public static void setBlue(double blue, Julia j) {
        j.blue = blue;
    }


    @Override
    protected void paintComponent(Graphics arg0) {
        Graphics2D g2d = (Graphics2D) arg0;
        for (int i = 0; i <= getWidth(); i++) {
            for (int j = 0; j <= getHeight(); j++) {
                double x = zoom * i / getWidth() + newX;
                double y = zoom * j / getHeight() + newY;
                Complex z0 = new Complex(a, b);
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
