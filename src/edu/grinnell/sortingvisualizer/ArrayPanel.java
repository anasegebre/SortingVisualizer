package edu.grinnell.sortingvisualizer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

    private NoteIndices notes;
    
    /**
     * Constructs a new ArrayPanel that renders the given note indices to
     * the screen.
     * @param notes the indices to render
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
    	g.setColor(Color.WHITE);
    	g.fillRect(0, 0, this.getWidth(), this.getHeight());
    	int width = WIDTH / notes.getNotes().size();
    	int height = HEIGHT / notes.getNotes().size();
    	
    	
        for(int i = 0; i < notes.getNotes().size(); i++) {
        	if (notes.isHighlighted(i)) {
        		g.setColor(Color.MAGENTA);
        	} else {
        		g.setColor(new Color(0, 180 - notes.getNotes().get(i), 150 - notes.getNotes().get(i))); //hopefully it will create a nice cool colors pattern
        	}
        	g.fillRect(width * i, (notes.getNotes().size() - notes.getNotes().get(i) - 10) * height, width, height * notes.getNotes().get(i) + 10); //idk anymore
        }
    }
}