/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.Handler;
import ui.Button;
import ui.DisplayObject;

/**
 *
 * @author Andres
 */
public class MainWindow extends Window {
	
	private boolean menu;
	private MainDisplay screen;
	private Handler main;
	
	private ArrayList<DisplayObject> objects;
	
	public MainWindow(Handler main, int ssX, int ssY) throws HeadlessException {
		super(ssX,ssY);
		
		this.objects = new ArrayList<>();
		this.main = main;
		this.menu = true;
		
		screen = new MainDisplay(this);
		screen.setLocation(1,1);
		add(screen);
		
		addComponentListener(this);
		
		setSize(ssX, ssY);
		setTitle("Ardnas");
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initialMenu();
		
		setVisible(true);
	}
	
	private void initialMenu() {
		Button btn = new Button(10,10,100,20);
		this.objects.add(btn);
	}
	
	//<editor-fold defaultstate="collapsed" desc="Overrides">
	
	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
		screen.setSize(width-FRAME_BORDER_X, height-FRAME_BORDER_Y);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		screen.setSize(getWidth()-FRAME_BORDER_X, getHeight()-FRAME_BORDER_Y);
	}

	@Override
	public void componentMoved(ComponentEvent e) {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void componentShown(ComponentEvent e) {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void componentHidden(ComponentEvent e) {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="Getters & Setters">
	
	/**
	 * @return the objects
	 */
	public ArrayList<DisplayObject> getObjects() {
		return objects;
	}

	/**
	 * @return the ssX
	 */
	public int getSsX() {
		return ssX;
	}

	/**
	 * @return the ssY
	 */
	public int getSsY() {
		return ssY;
	}

	/**
	 * @return the menu
	 */
	public boolean isMenu() {
		return menu;
	}

	//</editor-fold>
	
	private class MainDisplay extends Display {

		private MainWindow parentWindow;
		private float zoom;

		public MainDisplay(MainWindow parent) {
			setBackground(Color.red);
			this.parentWindow = parent;
			this.zoom = 1.0f;
		}

		@Override
		public void paint(Graphics g) {
			for (int i = 0; i < parentWindow.getObjects().size(); i++) {
				BufferedImage img = parentWindow.getObjects().get(i).getDisplay(zoom);
				int x = parentWindow.getObjects().get(i).getX();
				int y = parentWindow.getObjects().get(i).getY();
				g.drawImage(img, x, y, null);
			}
		}

		@Override
		public void run() {
			while (true) {
				repaint();
			}
		}

		@Override
		public void modifyZoom(float units) {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

		@Override
		protected void clickEvent(int x, int y) {
			String action = "";
			for (int i = 0; i < objects.size(); i++) {
				if (objects.get(i) instanceof Button) {
					Button btn = (Button)objects.get(i);
					if (btn.isHovered()) {
						action = btn.getInternalName();
					}
				}
			}
			if (!action.isEmpty()) {
				// action code
			}
		}

		@Override
		protected void moveEvent(int x, int y) {
        for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i) instanceof Button) {
				Button btn = (Button)objects.get(i);
				if (btn.isContained(x, y)) {
					btn.setHovered(true);
				} else {
					btn.setHovered(false);
				}
			}
		}
		}

		@Override
		protected void dragEvent(int x, int y) {
//			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

		@Override
		protected void pressEvent(int x, int y) {
//			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

		@Override
		protected void releaseEvent(int x, int y) {
//			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}

		@Override
		protected void rightClickEvent(int x, int y) {
//			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}
	}
}
