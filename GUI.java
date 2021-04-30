package Project02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.List;

/**
 * Gui representing how a user plays the game
 */
public class GUI implements KeyListener {

    /** Encounter boolean to further the next encounter or round */
    public volatile boolean playNextEncounter;
    JFrame frame;
    JTextPane roundPane;
    ArrayList<JTextPane> panes;
    List<String> fields = Arrays.asList("Character Name: ", "Nation Name: ", "Tribe Name: ",
            "Life Points: ", "Damage Dealt: ");


    /**
     * Create the JFrame, set the size, and set the default panes.
     * Set the key listener and focus the frame
     */
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

    /**
     * Adds two of the same text panes to the main panel for both players in the game
     * @param panel  The panel to add the panes to
     * @param text  The text to go in the pane
     */
    private void addTextFields(JPanel panel, String text) {
        JTextPane pane = createTextPane(text);
        panel.add(pane);
        panes.add(pane);
        pane = createTextPane(text);
        panel.add(pane);
        panes.add(pane);
    }

    /**
     * Create a default text pane that isn't editable using html for centering
     * @param text  The text to put on the pane
     * @return The created JTextPane
     */
    private JTextPane createTextPane(String text) {
        JTextPane pane = new JTextPane();
        pane.setContentType("text/html");
        pane.setText("<h1 style=\"text-align: center\">" + text + "</h1>");
        pane.setEditable(false);
        return pane;
    }

    /**
     * Need to implement but don't need to use
     * @param e Key event
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * If the right arrow key is pressed, the game is furthered
     * @param e Key event
     */
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

    /**
     * Need to implement but don't need to use
     * @param e Key event
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Update all text panes with the correct info based on the current encounter
     * @param roundNum The current round number
     * @param encounterNum The current encounter number for this round
     * @param info The text to display in the panes
     */
    void updateUI(int roundNum, int encounterNum, List<String> info) {
        roundPane.setText("<h1 style=\"text-align: center\"> Encounter: " + encounterNum + " of Round: " + roundNum + "</h1>");
        for (int i = 0; i < fields.size(); i++) {
            JTextPane pane1 = panes.get(i * 2), pane2 = panes.get(i * 2 + 1);
            String field = fields.get(i);
            pane1.setText("<h1 style=\"text-align: center\">" + field + info.get(i * 2) + "</h1>");
            pane2.setText("<h1 style=\"text-align: center\">" + field + info.get(i * 2 + 1) + "</h1>");
        }
    }

    /**
     * Displays the final screen for who won the game
     * @param nationName The nation that won the game
     */
    void updateUIGameEnded(Set<String> nationName){
        roundPane.setText("<h1 style=\"text-align: center\">" + "Winning Nation is: " + nationName.toString() + "</h1>"
        + "<h1 style=\"text-align: center\">" + "Close window to quit" + "<h1>");
        for (int i = 0; i < fields.size(); i++) {
            JTextPane pane1 = panes.get(i * 2), pane2 = panes.get(i * 2 + 1);
            pane1.setText("<h1 style=\"text-align: center\">" + "\n"  + "</h1>");
            pane2.setText("<h1 style=\"text-align: center\">" + "\n" + "</h1>");
        }
    }
}
