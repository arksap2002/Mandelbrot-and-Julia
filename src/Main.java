//Sapozhnikov Arkady
//Drawing picture in swing(Game)
//11.02.2018

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Fractal");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        JPanel up = new JPanel();
        JPanel center = new JPanel();
        Mandelbrot mandelbrot = new Mandelbrot(1, 1, 3, -2.0, -2.0, 4.0);
        Julia julia = new Julia(0.28, 0.0113, 1, 1, 3, -2.0, -2.0, 4.0);
        JPanel left = new JPanel();
        JPanel down = new JPanel();
        window.add(center, BorderLayout.CENTER);
        up.setLayout(new GridLayout(2, 6));
        ButtonGroup bgUp = new ButtonGroup();
        JRadioButton rbMand = new JRadioButton("Mandelbrot");
        JLabel lAlpha = new JLabel("Alpha");
        JScrollBar alpha = new JScrollBar(JScrollBar.HORIZONTAL);
        JButton redraw = new JButton("redraw");
        JButton restart = new JButton("restart");
        JRadioButton rbJulia = new JRadioButton("Julia");
        JLabel lBetta = new JLabel("Betta");
        JScrollBar betta = new JScrollBar(JScrollBar.HORIZONTAL);
        JLabel alphaVal = new JLabel(Double.toString(1.0 * alpha.getValue() / 100.0));
        JLabel bettaVal = new JLabel(Double.toString(1.0 * betta.getValue() / 100));
        down.setLayout(new FlowLayout());
        JTextField x = new JTextField(5);
        x.setToolTipText("x");
        x.setText("-2");
        JTextField y = new JTextField(5);
        y.setToolTipText("y");
        y.setText("-2");
        JTextField z = new JTextField(5);
        z.setToolTipText("z");
        z.setText("4");

        mandelbrot.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mandelbrot.zoom /= 2;
                mandelbrot.newX = mandelbrot.zoom * e.getX() / mandelbrot.getWidth() + mandelbrot.newX;
                mandelbrot.newY = mandelbrot.zoom * e.getY() / mandelbrot.getHeight() + mandelbrot.newY;
                mandelbrot.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        julia.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                julia.zoom /= 2;
                julia.newX = julia.zoom * e.getX() / julia.getWidth() + julia.newX;
                julia.newY = julia.zoom * e.getY() / julia.getHeight() + julia.newY;
                julia.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        betta.addAdjustmentListener(e -> {
            bettaVal.setText(Double.toString(betta.getValue() / 100.0));
            Julia.setB(betta.getValue() / 100.0, julia);
            Julia.setA(alpha.getValue() / 100.0, julia);
            window.repaint();
        });
        alpha.addAdjustmentListener(e -> {
            alphaVal.setText(Double.toString(alpha.getValue() / 100.0));
            Julia.setA(alpha.getValue() / 100.0, julia);
            Julia.setB(betta.getValue() / 100.0, julia);
            window.repaint();
        });
        ButtonGroup bgJul = new ButtonGroup();
        JRadioButton rbSc = new JRadioButton("ScrollBar");
        JRadioButton rbTf = new JRadioButton("TextField");
        final boolean[] flagSBAndTF = {true};
        JTextField tfAlpha = new JTextField(5);
        JTextField tfBetta = new JTextField(5);
        tfAlpha.setText("0.28");
        tfBetta.setText("0.11");
        down.add(x);
        down.add(y);
        down.add(z);
        window.add(down, BorderLayout.SOUTH);
        down.setVisible(false);
        up.add(rbMand);
        up.add(lAlpha);
        up.add(alphaVal);
        up.add(rbSc);
        up.add(redraw);
        up.add(rbJulia);
        up.add(lBetta);
        up.add(bettaVal);
        up.add(rbTf);
        up.add(restart);
        bgJul.add(rbSc);
        bgJul.add(rbTf);
        bgUp.add(rbMand);
        bgUp.add(rbJulia);
        alphaVal.setVisible(false);
        bettaVal.setVisible(false);
        lAlpha.setVisible(false);
        lBetta.setVisible(false);
        alpha.setVisible(false);
        betta.setVisible(false);
        rbSc.setVisible(false);
        rbTf.setVisible(false);
        restart.setVisible(true);
        rbSc.addActionListener(e -> {
            flagSBAndTF[0] = true;
            up.removeAll();
            up.revalidate();
            up.add(rbMand);
            up.add(lAlpha);
            up.add(alphaVal);
            up.add(alpha);
            up.add(rbSc);
            up.add(redraw);
            up.add(rbJulia);
            up.add(lBetta);
            up.add(bettaVal);
            up.add(betta);
            up.add(rbTf);
            up.add(restart);
            rbMand.setVisible(true);
            rbJulia.setVisible(true);
            redraw.setVisible(true);
            alphaVal.setVisible(true);
            bettaVal.setVisible(true);
            lAlpha.setVisible(true);
            lBetta.setVisible(true);
            alpha.setVisible(true);
            betta.setVisible(true);
            rbSc.setVisible(true);
            rbTf.setVisible(true);
            restart.setVisible(true);
            window.repaint();
        });
        rbTf.addActionListener(e -> {
            flagSBAndTF[0] = false;
            up.removeAll();
            up.revalidate();
            up.add(rbMand);
            up.add(lAlpha);
            up.add(alphaVal);
            up.add(tfAlpha);
            up.add(rbSc);
            up.add(redraw);
            up.add(rbJulia);
            up.add(lBetta);
            up.add(bettaVal);
            up.add(tfBetta);
            up.add(rbTf);
            up.add(restart);
            rbMand.setVisible(true);
            rbJulia.setVisible(true);
            redraw.setVisible(true);
            alphaVal.setVisible(false);
            bettaVal.setVisible(false);
            lAlpha.setVisible(true);
            lBetta.setVisible(true);
            tfAlpha.setVisible(true);
            tfBetta.setVisible(true);
            rbSc.setVisible(true);
            rbTf.setVisible(true);
            restart.setVisible(true);
            window.repaint();
        });
        rbMand.addActionListener(e -> {
            center.removeAll();
            center.revalidate();
            center.setLayout(new GridLayout(1, 0));
            center.add(mandelbrot);
            alpha.setVisible(false);
            betta.setVisible(false);
            lAlpha.setVisible(false);
            lBetta.setVisible(false);
            alphaVal.setVisible(false);
            bettaVal.setVisible(false);
            rbSc.setVisible(false);
            rbTf.setVisible(false);
            tfAlpha.setVisible(false);
            tfBetta.setVisible(false);
            window.repaint();
        });
        rbJulia.addActionListener(e -> {
            center.removeAll();
            center.revalidate();
            center.setLayout(new GridLayout(1, 0));
            center.add(julia);
            lAlpha.setVisible(true);
            lBetta.setVisible(true);
            alphaVal.setVisible(true);
            bettaVal.setVisible(true);
            rbSc.setVisible(true);
            rbTf.setVisible(true);
            tfAlpha.setVisible(true);
            tfBetta.setVisible(true);
            alpha.setVisible(true);
            betta.setVisible(true);
            window.repaint();
        });
        redraw.addActionListener((ActionEvent e) -> {
            alphaVal.setText(Double.toString(1.0 * alpha.getValue() / 100.0));
            bettaVal.setText(Double.toString(1.0 * betta.getValue() / 100.0));
            String sX = x.getText();
            String sY = y.getText();
            String sZ = z.getText();
            Mandelbrot.setNewX(Double.parseDouble(sX), mandelbrot);
            Mandelbrot.setNewY(Double.parseDouble(sY), mandelbrot);
            Mandelbrot.setzoom(Double.parseDouble(sZ), mandelbrot);
            Julia.setNewX(Double.parseDouble(sX), julia);
            Julia.setNewY(Double.parseDouble(sY), julia);
            Julia.setzoom(Double.parseDouble(sZ), julia);
            if (flagSBAndTF[0]) {
                Julia.setA(1.0 * alpha.getValue() / 100.0, julia);
                Julia.setB(1.0 * betta.getValue() / 100.0, julia);
            } else {
                Julia.setA(Double.parseDouble(tfAlpha.getText()), julia);
                Julia.setB(Double.parseDouble(tfBetta.getText()), julia);
            }
            window.repaint();
        });
        restart.addActionListener(e -> {
            Mandelbrot.setNewX(-2.0, mandelbrot);
            Mandelbrot.setNewY(-2.0, mandelbrot);
            Mandelbrot.setzoom(4.0, mandelbrot);
            Julia.setNewX(-2.0, julia);
            Julia.setNewY(-2.0, julia);
            Julia.setzoom(4.0, julia);
            window.repaint();
        });
        window.add(up, BorderLayout.NORTH);
        up.setVisible(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        JCheckBox ch1 = new JCheckBox("up panel");
        JCheckBox ch2 = new JCheckBox("down panel");
        left.add(ch1);
        left.add(ch2);
        ch1.addActionListener(e -> up.setVisible(!up.isVisible()));
        ch2.addActionListener(e -> down.setVisible(!down.isVisible()));
        JTextField tfRed = new JTextField(5);
        tfRed.setToolTipText("Red");
        JTextField tfGreen = new JTextField(5);
        tfGreen.setToolTipText("Green");
        JTextField tfBlue = new JTextField(5);
        tfBlue.setToolTipText("Blue");
        JButton setColour = new JButton("setColour");
        tfRed.setText("1");
        tfGreen.setText("1");
        tfBlue.setText("3");
        setColour.addActionListener(e -> {
            String sRed = tfRed.getText();
            String sGreen = tfGreen.getText();
            String sBlue = tfBlue.getText();
            Mandelbrot.setRed(Double.parseDouble(sRed), mandelbrot);
            Mandelbrot.setGreen(Double.parseDouble(sGreen), mandelbrot);
            Mandelbrot.setBlue(Double.parseDouble(sBlue), mandelbrot);
            Julia.setRed(Double.parseDouble(sRed), julia);
            Julia.setGreen(Double.parseDouble(sGreen), julia);
            Julia.setBlue(Double.parseDouble(sBlue), julia);
            window.repaint();
        });
        left.add(tfRed);
        left.add(tfGreen);
        left.add(tfBlue);
        left.add(setColour);
        window.add(left, BorderLayout.WEST);
        window.setVisible(true);
    }
}
