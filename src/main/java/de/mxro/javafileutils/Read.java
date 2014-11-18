package de.mxro.javafileutils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Read {

	public static String asString(File f) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(f);

			final Scanner scanner = new Scanner(fis, "UTF-8");

			String file = "";
			while (scanner.hasNextLine()) {
				file += scanner.nextLine() + "\n";
			}
			scanner.close();
			fis.close();
			return file;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
