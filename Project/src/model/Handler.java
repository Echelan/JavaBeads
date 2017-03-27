/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.MainWindow;
import view.PaletteWindow;

/**
 *
 * @author Andres
 */
public class Handler {
	public static boolean INVERTED = false;
	public static boolean SIDEWAYS = false;
	
	public MainWindow mainWindow;
	public PaletteWindow paletteWindow;
	
	public Handler() {
//		mainWindow = new MainWindow(this, 200, 200);
		paletteWindow = new PaletteWindow(this, 400, 260);
	}
	
	
}
