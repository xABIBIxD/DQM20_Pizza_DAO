package pizza;

import javax.swing.*;
import java.awt.*;

public class PizzaApp extends JFrame {

    public PizzaApp() {
        setVisible(true);
        setPreferredSize(new Dimension(400, 300));
        setTitle("PizzaApp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PizzaComponent comp = new PizzaComponent();
        setContentPane(comp.getRootPanel());


        pack();
    }

    public static void main(String[] args) {
        new PizzaApp();
    }
}
