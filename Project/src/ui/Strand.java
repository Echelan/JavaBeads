/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class Strand extends DisplayObject {
	
	private ArrayList<Bead> beads;
	private boolean hovered;

	public Strand() {
		this.beads = new ArrayList<>();
		this.hovered = false;
	}
	
	@Override
	public BufferedImage getDisplay(float zoom) {
		int beadSize = (int) (Bead.BEAD_RADIUS*2*zoom);
		
		BufferedImage display = new BufferedImage(beadSize*(beads.size()+1), beadSize, BufferedImage.TYPE_INT_ARGB);
		Graphics g = display.getGraphics();
		
		if (isHovered()) {
			g.setColor(Color.black);
//			g.fillOval(0, 0, BEAD_RADIUS*2,BEAD_RADIUS*2);
		}	
		for (int i = 0; i < beads.size(); i++) {
		g.drawImage(beads.get(i).getDisplay(zoom), beadSize*(i+1), 0, null);
		}
		
		return display;
	}
	
	//<editor-fold defaultstate="collapsed" desc="Getters & Setters">
	
	/**
	 * @return the hovered
	 */
	public boolean isHovered() {
		return hovered;
	}

	/**
	 * @param hovered the hovered to set
	 */
	public void setHovered(boolean hovered) {
		this.hovered = hovered;
	}
	
	//</editor-fold>
	
}
