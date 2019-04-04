package com.zzg.word.trans.html.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.zzg.word.trans.html.WordTransHtml;

public class WordTransHtmlTest {
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String imagePath = "C:\\image\\iamges";
//		String docPath ="C:\\image\\1.docx";
//		String htmlPath = "c:\\image\\1.html";
//		File docFile = new File(docPath);
//		File htmlFile = new File(htmlPath);
//		File imageDir = new File(imagePath);
//		// 判断文件夹是否存在，不存在则创建文件夹
//		if(!imageDir.exists()){
//			imageDir.mkdirs();
//		}
//		// 判断html 文件是否存在，不存在则创建
//		if(!htmlFile.exists()){
//			try {
//				htmlFile.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		if(docFile.exists() && htmlFile.exists()){
//			try {
//				InputStream inputStream = new FileInputStream(docFile);
//				OutputStream outputStream = new FileOutputStream(htmlFile);
//				WordTransHtml.docxTransHtml(inputStream, outputStream, imagePath);
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		
//	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String imagePath = "C:\\image\\iamges";
		String docPath ="C:\\image\\2.doc";
		String htmlPath = "c:\\image\\2.html";
		File docFile = new File(docPath);
		File htmlFile = new File(htmlPath);
		File imageDir = new File(imagePath);
		// 判断文件夹是否存在，不存在则创建文件夹
		if(!imageDir.exists()){
			imageDir.mkdirs();
		}
		// 判断html 文件是否存在，不存在则创建
		if(!htmlFile.exists()){
			try {
				htmlFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(docFile.exists() && htmlFile.exists()){
			try {
				InputStream inputStream = new FileInputStream(docFile);
				OutputStream outputStream = new FileOutputStream(htmlFile);
				WordTransHtml.docTransHtml(inputStream, outputStream, imagePath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
