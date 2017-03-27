/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;

/**
 *
 * @author Andres
 */
public class BeadColor {
	
	private String name;
	private Color color;
	private float[] HSB;
	private boolean metallic;
	private boolean transparent;
	private int modifier;

	public BeadColor(String name, int mod, float h, float s, float b) {
		this.name = name;
		this.modifier = mod;
		HSB = new float[3];
		HSB[0] = h;
		HSB[1] = s;
		HSB[2] = b;
		
		this.color = Color.getHSBColor(h/360f, s/100f, b/100f);
	}
	
	//<editor-fold defaultstate="collapsed" desc="Getters & Setters">
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public String getModifier() {
		String modString = " ";
		if (modifier!=0) {
			modString = " "+modifier;
		}
		return modString;
	}
	
	public String getSpecials() {
		String specialString = "";
		if (isMetallic()) {
			specialString = specialString + " metalico";
		}
		if (isTransparent()) {
			specialString = specialString + " transparente";
		} 
		return specialString;
	}
	
	public String getFullName() {
		return (getName()+getModifier())+getSpecials();
	}
	
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return the HSB
	 */
	public float[] getHSB() {
		return HSB;
	}

	/**
	 * @return the metallic
	 */
	public boolean isMetallic() {
		return metallic;
	}

	/**
	 * @param metallic the metallic to set
	 */
	public void setMetallic(boolean metallic) {
		this.metallic = metallic;
	}

	/**
	 * @return the transparent
	 */
	public boolean isTransparent() {
		return transparent;
	}

	/**
	 * @param transparent the transparent to set
	 */
	public void setTransparent(boolean transparent) {
		this.transparent = transparent;
	}
	
	//</editor-fold>
	
}
