package com.changefilename;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.utils.CommonUtils;

public class ChangeFileNameDemo {

	public static void main(String[] args) throws IOException {

		String oldFilePath = "D:\\00-proxy";
		File fileList = new File(oldFilePath);
		List<String> oldFileList = CommonUtils.getOldFileList(fileList);
		// 重命名文件
		List<String> newFiles = CommonUtils.renameFile(oldFileList);

		// 新文件的路径
		String newFilePath = oldFilePath + "\\" + String.valueOf(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		File newFileList = new File(newFilePath);
		if (!newFileList.exists()) {
			newFileList.mkdir();
		}
		for (int i = 0; i < oldFileList.size(); i++) {
			InputStream fileInputStream = new FileInputStream(new File(oldFilePath + "\\" + oldFileList.get(i)));
			FileOutputStream fileOutputStream = new FileOutputStream(new File(newFilePath + "\\" + newFiles.get(i)));
			IOUtils.copy(fileInputStream, fileOutputStream);
			fileOutputStream.flush();

		}
	}

}
