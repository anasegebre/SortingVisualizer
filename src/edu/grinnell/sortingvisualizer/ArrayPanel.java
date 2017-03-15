package edu.grinnell.sortingvisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;

    /**
     * Constructs a new ArrayPanel that renders the given note indices to the
     * screen.
     * 
     * @param notes
     *            the indices to render
     * @param width
     *            the width of the panel
     * @param height
     *            the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, (int) this.getWidth(), (int) this.getHeight());
        g.setColor(Color.WHITE);
        int num = notes.getNotes().size();
        int width = this.getWidth() / num; 
        int height = this.getHeight() / num;
        for (int i = 0; i < num; i++) {
            if (notes.isHighlighted(i)) {
                g.setColor(Color.MAGENTA);
            } else {
                g.setColor(new Color(30, 250 - 5 * notes.getNotes().get(i), 250 - 5 * notes.getNotes().get(i)));
            }
            g.fillRect(i * width, this.getHeight() - height * (notes.getNotes().get(i) + 1), width,
                    this.getHeight());
            g.setColor(Color.BLACK);
            g.drawRect(i * width, this.getHeight() - height * (notes.getNotes().get(i) + 1), width,
                    this.getHeight());
        }
    }
}
