/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.MouseHandler;
import java.awt.Canvas;

/**
 *
 * @author Andres
 */
public abstract class Display extends Canvas implements Runnable {
	
	protected final MouseHandler actionHandler;

	public Display() {
		actionHandler = new MouseHandler(this);
		this.addMouseListener(actionHandler);
		this.addMouseMotionListener(actionHandler);
		this.addMouseWheelListener(actionHandler);
	}
	
	public void receiveAction(int action, int x, int y) {
		if (action == MouseHandler.EVENT_LEFT_CLICK) {
			clickEvent(x,y);
		} else if (action == MouseHandler.EVENT_RIGHT_CLICK) {
			rightClickEvent(x,y);
		} else if (action == MouseHandler.EVENT_MOVE) {
			moveEvent(x,y);
		} else if (action == MouseHandler.EVENT_DRAG) {
			dragEvent(x,y);
		} else if (action == MouseHandler.EVENT_PRESS) {
			pressEvent(x,y);
		} else if (action == MouseHandler.EVENT_RELEASE) {
			releaseEvent(x,y);
		}
	}
	
	public abstract void modifyZoom(float units);
	protected abstract void clickEvent(int x, int y);
	protected abstract void rightClickEvent(int x, int y);
	protected abstract void moveEvent(int x, int y);
	protected abstract void dragEvent(int x, int y);
	protected abstract void pressEvent(int x, int y);
	protected abstract void releaseEvent(int x, int y);
}
