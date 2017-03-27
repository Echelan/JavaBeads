/*
 *  Pokemon Violet - A University Project by Andres Movilla
 *  Pokemon COPYRIGHT 2002-2016 Pokemon.
 *  COPYRIGHT 1995-2016 Nintendo/Creatures Inc./GAME FREAK inc. TRADEMARK, REGISTERED TRADEMARK
 *  and Pokemon character names are trademarks of Nintendo.
 *  No copyright or trademark infringement is intended in using Pokemon content on Pokemon Violet.
 */
package data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import model.BeadColor;

/**
 *
 * @author Andres
 */
public abstract class NIC {
	
	//<editor-fold defaultstate="collapsed" desc="Information Lists">
		public static ArrayList<BeadColor[]> colors;
//		public static int uniqueColors;
		public static int mainColor;
		public static int colorVariation;
		private static final float colorDiff = 8;
	//</editor-fold>

	public static void loadAllData() {
		
		try {
			buildColors();
		} catch (IOException ex) {
		
		}
	}
	
	private static void buildColors() throws IOException {
		
		// original, 4 darker, 4 brighter
		colorVariation = 1 + (4*2);
		mainColor = 4;
		
		List<String> readInfoC;

		File archivo = new File("db/listColors.txt");
		readInfoC = Files.readAllLines(archivo.toPath());
		
		colors = new ArrayList<>();
		
		for (int i = 0; i < readInfoC.size(); i++) {
			String[] split = readInfoC.get(i).split(";");
			String name = split[0];
			float h = Float.parseFloat(split[1]);
			float s = Float.parseFloat(split[2]);
			float b = Float.parseFloat(split[3]);
			BeadColor[] thisColor = new BeadColor[colorVariation];
			BeadColor original  = new BeadColor(name,0,h,s,b);
			int counter = 0;
			for (int j = 0; j < 4; j++) {
				thisColor[mainColor-(counter+1)] = goBrighter(original, j+1);
				counter++;
			}
			thisColor[mainColor] = original;
			counter++;
			for (int j = 0; j < 4; j++) {
				thisColor[counter] = goDarker(original, j+1);
				counter++;
			}
			colors.add(thisColor);
		}
		
		System.out.println("272.1,100,82.7");
		BeadColor asd = goBrighter(new BeadColor("test",-1,272.1f,100f,82.7f),1);
		System.out.println(asd.getHSB()[0]+","+asd.getHSB()[1]+","+asd.getHSB()[2]);
	}
	
	private static BeadColor goDarker(BeadColor original, int darkness) {
		String name = original.getName();
		float h = original.getHSB()[0];
		float s = original.getHSB()[1];
		float b = original.getHSB()[2];
		
//		h = h - ((h/colorDiff) * darkness);
//		s = s - ((s/colorDiff) * darkness);
		b = b - ((b/colorDiff) * darkness);
		
		return new BeadColor(name, darkness, h, s, b);
	}
	
	private static BeadColor goBrighter(BeadColor original, int brightness) {
		String name = original.getName();
		float h = original.getHSB()[0];
		float s = original.getHSB()[1];
		float b = original.getHSB()[2];
		
//		h = h + (( (360-h)/colorDiff) * brightness);
		s = s - ((s/colorDiff) * brightness);
//		b = b + (( (100-b)/colorDiff) * brightness);
		
		return new BeadColor(name, brightness*-1, h, s, b);
	}
	
}
