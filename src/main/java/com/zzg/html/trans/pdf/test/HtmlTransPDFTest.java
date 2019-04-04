package com.zzg.html.trans.pdf.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.zzg.html.trans.pdf.HtmlTransPDF;

public class HtmlTransPDFTest {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String htmlPath = "c:\\image\\2.html";
//		String pdfPath ="c:\\image\\2.pdf";
//		File htmlFile = new File(htmlPath);
//		File pdfFile = new File(pdfPath);
//		if(htmlFile.exists()){
//			if(!pdfFile.exists()){
//				try {
//					pdfFile.createNewFile();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			// html开始转换
//			try {
//				HtmlTransPDF.htmlTransPdf(new FileInputStream(htmlFile), new FileOutputStream(pdfFile));
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
	
	public static void main(String[] args) {
		String htmlPath = "C:\\image\\2.html";
		String pdfPath = "C:\\image\\3.pdf";
		String content = "";
		File htmlFile = new File(htmlPath);
		File pdfFile = new File(pdfPath);
		if(htmlFile.exists()){
			if(!pdfFile.exists()){
				try {
					pdfFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 开始读取html 文件内容
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader(
						new FileInputStream(htmlFile), "UTF-8"));
				String row = "";
				while ((row = br.readLine()) != null) {
					// System.out.println(t);
					content += row;
				}
				HtmlTransPDF.htmlTransPdfChinese(pdfPath, content);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
	}

}
