package Project02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GUI implements KeyListener {

    JFrame frame;
    JTextPane roundPane;
    ArrayList<JTextPane> panes;
    List<String> fields = Arrays.asList("Character Name: ", "Nation Name: ", "Tribe Name: ",
            "Life Points: ", "Damage Dealt: ");
    List<String> randomNames = Arrays.asList("Mark", "Richie", "Kyle");
    Random r;
    int roundNum = 0;

    public GUI() {
        frame = new JFrame("Warring Nations");
        panes = new ArrayList<>();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        r = new Random();

        JPanel mainPanel = new JPanel(new GridLayout(6,1));
        roundPane = createTextPane("Press right arrow to play game!");
        mainPanel.add(roundPane);

        JPanel subPanel;
        for (String text: fields) {
            subPanel = new JPanel(new GridLayout(1, 2));
            addTextFields(subPanel, text);
            mainPanel.add(subPanel);
        }

        frame.add(mainPanel);
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.setFocusTraversalKeysEnabled(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addTextFields(JPanel panel, String text) {
        JTextPane pane = createTextPane(text);
        panel.add(pane);
        panes.add(pane);
        pane = createTextPane(text);
        panel.add(pane);
        panes.add(pane);
    }

    private JTextPane createTextPane(String text) {
        JTextPane pane = new JTextPane();
        pane.setContentType("text/html");
        pane.setText("<h1 style=\"text-align: center\">" + text + "</h1>");
        pane.setEditable(false);
        return pane;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("key typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("pressed right arrow key");
            ArrayList<String> names = new ArrayList<>();
            ArrayList<Integer> points = new ArrayList<>();
            for (int i = 0; i < 6; i++) names.add(randomNames.get(r.nextInt(3)));
            for (int i = 0; i < 4; i++) points.add(r.nextInt(100));
            updateUI(++roundNum, names, points);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key released");
    }

    void updateUI(int roundNum, ArrayList<String> names, ArrayList<Integer> points) {
        roundPane.setText("<h1 style=\"text-align: center\"> Round: " + roundNum + "</h1>");
        int pointIndex = 0;
        for (int i = 0; i < fields.size(); i++) {
            JTextPane pane1 = panes.get(i*2), pane2 = panes.get(i*2+1);
            String field = fields.get(i);
            if (i < 3) {
                pane1.setText("<h1 style=\"text-align: center\">" + field + names.get(i * 2) + "</h1>");
                pane2.setText("<h1 style=\"text-align: center\">" + field + names.get(i * 2 + 1) + "</h1>");
            } else {
                pane1.setText("<h1 style=\"text-align: center\">" + field + points.get(pointIndex) + "</h1>");
                pane2.setText("<h1 style=\"text-align: center\">" + field + points.get(pointIndex + 1) + "</h1>");
                pointIndex += 2;
            }
        }
    }
}
