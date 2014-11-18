package de.mxro.javafileutils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Collect {

	
	public static List<String> getFilesRecursively(final File dir) {
		final ArrayList<String> list = new ArrayList<String>(100);

		if (dir.isFile()) {
			list.add(dir.getAbsolutePath());
			return list;
		}

		final File[] files = dir.listFiles();
		if (files != null) {
			for (final File f : files) {
				if (f.isDirectory()) {
					list.addAll(getFilesRecursively(f));
				} else {
					list.add(f.getAbsolutePath());
				}
			}
		}
		return list;
	}

	public static List<File> getFilesRecursively(final List<File> files) {
		List<String> res = new ArrayList<String>(files.size());
		for (File file : files) {
			res.addAll(getFilesRecursively(file));
		}

		List<File> resFiles = new ArrayList<File>(res.size());

		for (String path : res) {
			resFiles.add(new File(path));
		}

		return resFiles;
	}

	public static interface LeafCheck {
		public boolean isLeaf(File f);
	}

	public static List<File> getLeafDirectoriesRecursively(File dir,
			LeafCheck lc) {
		final ArrayList<File> list = new ArrayList<File>(10);

		if (dir.isFile()) {
			return list;
		}

		if (lc.isLeaf(dir)) {
			list.add(dir);
			return list;
		}

		final File[] files = dir.listFiles();
		if (files != null) {
			for (final File f : files) {
				list.addAll(getLeafDirectoriesRecursively(f, lc));
			}
		}

		return list;
	}

}
