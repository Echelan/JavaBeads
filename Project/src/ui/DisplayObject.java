/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.image.BufferedImage;

/**
 *
 * @author Andres
 */
public abstract class DisplayObject {
	private int x;
	private int y;
	private String internalName;
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the internalName
	 */
	public String getInternalName() {
		return internalName;
	}
	
	/**
	 * @param internalName the internalName to set
	 */
	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}
	
	public abstract BufferedImage getDisplay(float zoom);

	
}
