package com.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CommonUtils {
	public static List<String> getOldFileList(File fileList) {
		File[] listFiles = fileList.listFiles();
		ArrayList<String> arrayList = new ArrayList<String>();
		for (File file : listFiles) {
			arrayList.add(file.getName());
		}
		return arrayList;
	}

	public static List<String> renameFile(List<String> oldFileList) {
		ArrayList<String> arrayList = new ArrayList<String>();
		for (String oldFileName : oldFileList) {

			oldFileName = "123_" + oldFileName;
			arrayList.add(oldFileName);
		}

		return arrayList;
	}
}
