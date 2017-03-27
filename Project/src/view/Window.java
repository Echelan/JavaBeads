/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;

/**
 *
 * @author Andres
 */
public abstract class Window extends JFrame implements ComponentListener  {
	
	public static int FRAME_BORDER_X = 8;
	public static int FRAME_BORDER_Y = 31;
	
	protected final int ssX;
	protected final int ssY;
	
	public Window(int ssX, int ssY) {
		this.ssX = ssX;
		this.ssY = ssY;
	}
	
	@Override
	public abstract void componentResized(ComponentEvent e);

	@Override
	public abstract void componentMoved(ComponentEvent e);

	@Override
	public abstract void componentShown(ComponentEvent e);

	@Override
	public abstract void componentHidden(ComponentEvent e);
}
