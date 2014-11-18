package de.mxro.javafileutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

import one.utils.jre.OneUtilsJre;

public class Write {

	public static void setContent(File forFile, String content) {
		 FileOutputStream fos;
		try {
			fos = new FileOutputStream(forFile);
			
			byte[] data = content.getBytes("UTF-8");
	         fos.write(data, 0, data.length);

	         fos.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

         
	}

	public static void replace(File file, String pattern, String replacement) {
	
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			String original = new String(OneUtilsJre.toByteArray(fis));
			fis.close();
	
			String altered = original.replaceAll(pattern, replacement);
	
			file.delete();
			file.createNewFile();
	
			FileWriter fw = new FileWriter(file);
			fw.write(altered);
			fw.close();
	
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
	}
	
}
