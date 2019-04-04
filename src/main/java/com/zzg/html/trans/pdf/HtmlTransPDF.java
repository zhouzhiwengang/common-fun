package com.zzg.html.trans.pdf;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class HtmlTransPDF {
	/**
	 * 
	 * @Title: htmlTransPdf   
	 * @Description: html 转 pdf ,简单字符和数字  
	 * @param: @param inputStream
	 * @param: @param outputStream      
	 * @return: void      
	 * @throws
	 */
	public static void htmlTransPdf(InputStream inputStream, OutputStream outputStream){
		try{
			 Document document = new Document();
	            // 为该Document创建一个Writer实例
	            PdfWriter pdfwriter = PdfWriter.getInstance(document,
	            		outputStream);
	            pdfwriter.setViewerPreferences(PdfWriter.HideToolbar);
	            // 打开当前的document
	            document.open();
	            XMLWorkerHelper.getInstance().parseXHtml(pdfwriter, document,inputStream);
	            document.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Title: htmlTransPdfChinese   
	 * @Description: html 转 pdf, 简单中文
	 * @param: @param pdfFile
	 * @param: @param content      
	 * @return: void      
	 * @throws
	 */
	public static void htmlTransPdfChinese(String pdfFile, String content){
		try{
			 Document document = new Document();
	         // 为该Document创建一个Writer实例
	         PdfWriter pdfwriter = PdfWriter.getInstance(document,
	        		 new FileOutputStream(pdfFile));
	         pdfwriter.setViewerPreferences(PdfWriter.HideToolbar);
	         // 打开当前的document
	         document.open();
	         XMLWorkerHelper.getInstance().parseXHtml(pdfwriter, document,new ByteArrayInputStream(content.getBytes("Utf-8")),Charset.forName("UTF-8"));
	         document.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
