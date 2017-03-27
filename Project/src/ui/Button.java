/*
 *  Monopoly Violet - A University Project by Andres Movilla
 *  MONOPOLY COPYRIGHT
 *  the distinctive design of the gameboard
 *  the four corner squares
 *  the Mr. Monopoly name and character
 *  and each of the distinctive elements of the board
 *  are trademarks of Hasbro, Inc.
 *  for its property trading game and game equipment.
 *  COPYRIGHT 1999 Hasbro, Inc. All Rights Reserved.
 *  No copyright or trademark infringement is intended in using Monopoly content on Monopoly Violet.
 */
package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Andres
 */
public class Button extends DisplayObject {
	
	private String text;
	private int width;
	private int height;
	private int strokeWidth;
	private Color fillColor;
	private Color textColor;
	private Color strokeColor;
	private Color selectionFillColor;
	private Color selectionTextColor;
	private Color selectionStrokeColor;
	private boolean enabled;
	private Font font;
	private boolean hovered;
			
	public Button(int x, int y, int width, int height) {
		this.enabled = true;
		setX(x);
		setY(y);
		this.width = width;
		this.height = height;
		this.text = "";
		this.hovered = false;
		this.font = new Font("Arial",Font.PLAIN,20);
		this.fillColor = Color.white;
		this.textColor = Color.black;
		this.strokeColor = Color.black;
		this.selectionFillColor = Color.gray;
		this.selectionTextColor = Color.white;
		this.selectionStrokeColor = Color.black;
		setInternalName("");
		this.strokeWidth = 3;
	}
	
	@Override
	public BufferedImage getDisplay(float zoom) {
		BufferedImage display = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = display.getGraphics();
		
		if (this.enabled) {
			if (this.isHovered()) {
				g.setColor(selectionStrokeColor);
			} else {
				g.setColor(strokeColor);
			}
			g.fillRect(0, 0, width, height);
		}
		
		if (this.isHovered()) {
			g.setColor(selectionFillColor);
		} else {
			g.setColor(fillColor);
		}
		
		g.fillRect(strokeWidth, strokeWidth, width-(strokeWidth*2), height-(strokeWidth*2));
		
		if (this.isHovered()) {
			g.setColor(selectionTextColor);
		} else {
			g.setColor(textColor);
		}
		
		FontMetrics metrics = g.getFontMetrics(font);
		int fontX = (this.width - metrics.stringWidth(text)) / 2;
		int fontY = ((this.height - metrics.getHeight()) / 2) + metrics.getAscent();
		
		g.setFont(font);
		g.drawString(text, fontX, fontY);
		
		return display;
	}
	
	//<editor-fold defaultstate="collapsed" desc="Getters & Setters">
	
	public boolean isContained(int x, int y) {
		boolean value = false;
		if (getX() < x && x < getX()+this.width) {
			if (getY() < y && y < getY()+this.height) {
				value = true;
			}
		}
		return value;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @param fillColor the fillColor to set
	 */
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	/**
	 * @param textColor the textColor to set
	 */
	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}

	/**
	 * @param font the font to set
	 */
	public void setFont(Font font) {
		this.font = font;
	}

	/**
	 * @param hovered the hovered to set
	 */
	public void setHovered(boolean hovered) {
		this.hovered = hovered;
	}

	/**
	 * @param strokeColor the strokeColor to set
	 */
	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

	/**
	 * @param selectionFillColor the selectionFillColor to set
	 */
	public void setSelectionFillColor(Color selectionFillColor) {
		this.selectionFillColor = selectionFillColor;
	}

	/**
	 * @param selectionStrokeColor the selectionStrokeColor to set
	 */
	public void setSelectionStrokeColor(Color selectionStrokeColor) {
		this.selectionStrokeColor = selectionStrokeColor;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @param selectionTextColor the selectionTextColor to set
	 */
	public void setSelectionTextColor(Color selectionTextColor) {
		this.selectionTextColor = selectionTextColor;
	}
	
	/**
	 * @param strokeWidth the strokeWidth to set
	 */
	public void setStrokeWidth(int strokeWidth) {
		this.strokeWidth = strokeWidth;
	}
	
	/**
	 * @return the hovered
	 */
	public boolean isHovered() {
		return hovered;
	}

	//</editor-fold>

	
}
