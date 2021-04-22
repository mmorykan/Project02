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

    public volatile boolean playNextEncounter;
    JFrame frame;
    JTextPane roundPane;
    ArrayList<JTextPane> panes;
    List<String> fields = Arrays.asList("Character Name: ", "Nation Name: ", "Tribe Name: ",
            "Life Points: ", "Damage Dealt: ");


    public GUI() {
        frame = new JFrame("Warring Nations");
        panes = new ArrayList<>();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        playNextEncounter = false;

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
            setPlayNext(true);
        }
    }

    public void setPlayNext(boolean playNext) {
        playNextEncounter = playNext;
    }

    public boolean getPlayNext() {
        return playNextEncounter;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key released");
    }

    void updateUI(int roundNum, int encounterNum, List<String> info) {
        roundPane.setText("<h1 style=\"text-align: center\"> Encounter: " + encounterNum + " of Round: " + roundNum + "</h1>");
        for (int i = 0; i < fields.size(); i++) {
            JTextPane pane1 = panes.get(i * 2), pane2 = panes.get(i * 2 + 1);
            String field = fields.get(i);
            pane1.setText("<h1 style=\"text-align: center\">" + field + info.get(i * 2) + "</h1>");
            pane2.setText("<h1 style=\"text-align: center\">" + field + info.get(i * 2 + 1) + "</h1>");
        }
    }
}
