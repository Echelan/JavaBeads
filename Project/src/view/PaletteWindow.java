/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import model.BeadColor;
import model.Handler;
import ui.Button;
import ui.DisplayObject;
import ui.Rectangle;

/**
 *
 * @author Andres
 */
public class PaletteWindow extends Window {
	
	private static final String INTERNAL_COLOR_BUTTON = "CBUTTON";
	private static final String INTERNAL_COLOR_DISPLAY = "CDISPLAY";
	private static final String INTERNAL_COLOR_LEVEL = "CLEVEL";
			
	private static final int COLOR_BUTTON_SIZE = 40;
	private static final int COLOR_BUTTON_SPACING = 5;
	
	private static final int COLOR_LEVEL_WIDTH = 50;
	private static final int COLOR_LEVEL_HEIGHT = 20;
	
	private Handler main;
	private ArrayList<DisplayObject> objects;
	private BeadColor primaryColor;
	private BeadColor secondaryColor;
	private Display screen;
	private int colorLevel;

	public PaletteWindow(Handler main, int ssX, int ssY) {
		super(ssX, ssY);
		this.main = main;
		this.colorLevel = data.NIC.mainColor;
		this.objects = new ArrayList<>();
		this.main = main;
		
		screen = new PaletteDisplay(this);
		screen.setLocation(1,1);
		add(screen);
		
		addComponentListener(this);
		
		setSize(ssX, ssY);
		setTitle("Paleta");
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		buildColorDisplay();
		
		setVisible(true);
		new Thread(screen).start();
	}
	
	private void updateColors() {
		for (int i = 0; i < data.NIC.colors.size(); i++) {
			Color newColor = data.NIC.colors.get(i)[getColorLevel()].getColor();
			((Button) objects.get(i)).setFillColor(newColor);
			((Button) objects.get(i)).setSelectionFillColor(newColor);
		}
	}
	
	private void buildColorDisplay() {
		int startX = COLOR_BUTTON_SPACING;
		int startY = COLOR_BUTTON_SPACING;
		for (int i = 0; i < data.NIC.colors.size(); i++) {
			int x = startX + ((COLOR_BUTTON_SIZE+COLOR_BUTTON_SPACING)*(i%2));
			int y = startY + (int)((COLOR_BUTTON_SIZE+COLOR_BUTTON_SPACING)*Math.floor(i/2f));
			Button btn = new Button(x,y,COLOR_BUTTON_SIZE,COLOR_BUTTON_SIZE);
			btn.setStrokeWidth(2);
			btn.setInternalName(INTERNAL_COLOR_BUTTON+";"+i);
			btn.setSelectionStrokeColor(Color.white);
			btn.setFillColor(data.NIC.colors.get(i)[data.NIC.mainColor].getColor());
			btn.setSelectionFillColor(data.NIC.colors.get(i)[data.NIC.mainColor].getColor());
			objects.add(btn);
		}
		startX = ((startX+COLOR_BUTTON_SIZE)*2) + (COLOR_BUTTON_SPACING*2);
		for (int i = 0; i < data.NIC.colorVariation; i++) {
			int x = startX;
			int y = startY + (i*(COLOR_LEVEL_HEIGHT+COLOR_BUTTON_SPACING));
			
			Button btn = new Button(x,y,COLOR_LEVEL_WIDTH,COLOR_LEVEL_HEIGHT);
			btn.setStrokeWidth(2);
			btn.setInternalName(INTERNAL_COLOR_LEVEL+";"+i);
			int level = data.NIC.mainColor-i;
			btn.setText(""+level);
			objects.add(btn);
		}
		
		int x = startX + COLOR_LEVEL_WIDTH + (COLOR_BUTTON_SPACING*2);
		int y = startY;
		
		Rectangle btn = new Rectangle(x+(COLOR_BUTTON_SPACING*5),y+(COLOR_BUTTON_SPACING*5),COLOR_BUTTON_SIZE*3,COLOR_BUTTON_SIZE*3);
		btn.setStrokeWidth(2);
		btn.setInternalName(INTERNAL_COLOR_DISPLAY);
		objects.add(btn);
		
		btn = new Rectangle(x,y,COLOR_BUTTON_SIZE*3,COLOR_BUTTON_SIZE*3);
		btn.setStrokeWidth(2);
		btn.setInternalName(INTERNAL_COLOR_DISPLAY);
		objects.add(btn);
		
		setPrimaryColor(data.NIC.colors.get(0)[data.NIC.mainColor]);
		setSecondaryColor(data.NIC.colors.get(2)[data.NIC.mainColor]);
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
	 * @return the colorLevel
	 */
	public int getColorLevel() {
		return colorLevel;
	}

	/**
	 * @param colorLevel the colorLevel to set
	 */
	public void setColorLevel(int colorLevel) {
		this.colorLevel = colorLevel;
		updateColors();
	}
	
	/**
	 * @return the objects
	 */
	public ArrayList<DisplayObject> getObjects() {
		return objects;
	}

	/**
	 * @return the primaryColor
	 */
	public BeadColor getPrimaryColor() {
		return primaryColor;
	}

	/**
	 * @param primaryColor the primaryColor to set
	 */
	public void setPrimaryColor(BeadColor primaryColor) {
		this.primaryColor = primaryColor;
		((Rectangle)objects.get(objects.size()-1)).setFillColor(primaryColor.getColor());
	}

	/**
	 * @return the secondaryColor
	 */
	public BeadColor getSecondaryColor() {
		return secondaryColor;
	}

	/**
	 * @param secondaryColor the secondaryColor to set
	 */
	public void setSecondaryColor(BeadColor secondaryColor) {
		this.secondaryColor = secondaryColor;
		((Rectangle)objects.get(objects.size()-2)).setFillColor(secondaryColor.getColor());
	}
	
	//</editor-fold>
	
	private class PaletteDisplay extends Display  {

		private PaletteWindow parentWindow;
		private float zoom;
		
		public PaletteDisplay(PaletteWindow parent) {
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
			createBufferStrategy(3);
			while (true) {
				repaint();
				try {
					Thread.sleep(200);
				} catch (InterruptedException ex) {
				}
			}
		}

		@Override
		protected void moveEvent(int x, int y){
			for (int i = 0; i < objects.size(); i++) {
				if (parentWindow.getObjects().get(i) instanceof Button) {
					Button btn = (Button)parentWindow.getObjects().get(i);
					btn.setHovered(btn.isContained(x, y));
				}
			}
		}
		
		@Override
		public void modifyZoom(float units) {
//			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}
		
		private String getSelectedInternalName() {
			String internalName = "";
			for (int i = 0; i < objects.size(); i++) {
				if (parentWindow.getObjects().get(i) instanceof Button) {
					if (((Button)parentWindow.getObjects().get(i)).isHovered()) {
						internalName = parentWindow.getObjects().get(i).getInternalName();
					}
				}
			}
			return internalName;
		}
		
		@Override
		protected void clickEvent(int x, int y) {
			String internalName = getSelectedInternalName();
			if (!internalName.isEmpty()) {
				if (internalName.contains(INTERNAL_COLOR_BUTTON)) {
					int colorID = Integer.parseInt(internalName.split(";")[1]);
					setPrimaryColor(data.NIC.colors.get(colorID)[getColorLevel()]);
				} else if (internalName.contains(INTERNAL_COLOR_LEVEL)) {
					int newColorLevel = Integer.parseInt(internalName.split(";")[1]);
					setColorLevel(newColorLevel);
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
			String internalName = getSelectedInternalName();
			if (!internalName.isEmpty()) {
				if (internalName.contains(INTERNAL_COLOR_BUTTON)) {
					int colorID = Integer.parseInt(internalName.split(";")[1]);
					setSecondaryColor(data.NIC.colors.get(colorID)[getColorLevel()]);
				}
			}
		}
	}


}
