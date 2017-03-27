/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class Rectangle extends DisplayObject {
	
	private String text;
	private int width;
	private int height;
	private int strokeWidth;
	private Color fillColor;
	private Color textColor;
	private Color strokeColor;
	private boolean enabled;
	private Font font;
	private boolean hovered;
			
	public Rectangle(int x, int y, int width, int height) {
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
		setInternalName("");
		this.strokeWidth = 1;
	}
	
	@Override
	public BufferedImage getDisplay(float zoom) {
		BufferedImage display = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = display.getGraphics();
		
		
		if (this.enabled) {
			g.setColor(strokeColor);
			g.fillRect(0, 0, width, height);
		}
		
		
		g.setColor(fillColor);
		g.fillRect(strokeWidth, strokeWidth, width-(strokeWidth*2), height-(strokeWidth*2));
		
		
		g.setColor(textColor);
		
		FontMetrics metrics = g.getFontMetrics(font);
		int fontX = (this.width - metrics.stringWidth(text)) / 2;
		int fontY = ((this.height - metrics.getHeight()) / 2) + metrics.getAscent();
		
		g.setFont(font);
		g.drawString(text, fontX, fontY);
		
		return display;
	}
	
	//<editor-fold defaultstate="collapsed" desc="Getters & Setters">
	
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
	 * @param strokeColor the strokeColor to set
	 */
	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
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
	 * @param strokeWidth the strokeWidth to set
	 */
	public void setStrokeWidth(int strokeWidth) {
		this.strokeWidth = strokeWidth;
	}

	//</editor-fold>

}
