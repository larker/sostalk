package com.larkersos.sostalk.utils;

import java.text.DecimalFormat;

public class Util {

	//生成唯一ID码
	public static int getMyId(){
		int id = (int)(Math.random()*1000000);
		return id;
	}
	
	// 转换文件大小
	public static String formatFileSize(long fileS) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = fileS + "B";
			// fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "K";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}
}
