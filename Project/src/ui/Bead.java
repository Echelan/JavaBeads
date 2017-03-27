/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Andres
 */
public class Bead extends DisplayObject {
	
	public static final int BEAD_RADIUS = 20;
	private boolean hovered;
	private Color beadColor;
	
	public Bead() {
		this.hovered = false;
		this.beadColor = Color.white;
	}
	
	public boolean isContained(int x, int y, float zoom) {
		boolean value = false;
		if (getX() < x && x < getX()+(BEAD_RADIUS*2*zoom)) {
			if (getY() < y && y < getY()+(BEAD_RADIUS*2*zoom)) {
				value = true;
			}
		}
		return value;
	}
	
	@Override
	public BufferedImage getDisplay(float zoom) {
		BufferedImage display = new BufferedImage((int) (BEAD_RADIUS*2*zoom), (int) (BEAD_RADIUS*2*zoom), BufferedImage.TYPE_INT_ARGB);
		Graphics g = display.getGraphics();
		
		if (isHovered()) {
			g.setColor(Color.black);
			g.fillOval(0, 0, BEAD_RADIUS*2,BEAD_RADIUS*2);
		}	
	
		g.setColor(beadColor);
		g.fillOval(0, 0, (int)(BEAD_RADIUS*1.75), (int)(BEAD_RADIUS*1.75));
		
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

	/**
	 * @return the beadColor
	 */
	public Color getBeadColor() {
		return beadColor;
	}

	/**
	 * @param beadColor the beadColor to set
	 */
	public void setBeadColor(Color beadColor) {
		this.beadColor = beadColor;
	}
	
	//</editor-fold>
}
