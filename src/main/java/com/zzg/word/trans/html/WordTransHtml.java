package com.zzg.word.trans.html;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.AbstractWordConverter;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class WordTransHtml {

	/**
	 * 
	 * @Title: docxTransHtml @Description: docx 转换 HTML @param: @param
	 * inputStream: docx 文件输入流 @param: @param outputStream: html
	 * 文件输出流 @param: @param imageSaveDir：图片路径 @return: void @throws
	 */
	public static void docxTransHtml(InputStream inputStream, OutputStream outputStream, String imageSaveDir) {
		try {
			XWPFDocument document = new XWPFDocument(inputStream);

			XHTMLOptions options = XHTMLOptions.create();
			options.setExtractor(new FileImageExtractor(new File(imageSaveDir)));
			options.URIResolver(new BasicURIResolver(imageSaveDir));

			org.apache.poi.xwpf.converter.xhtml.XHTMLConverter.getInstance().convert(document, outputStream, options);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: docTransHtml
	 * @Description: docx 转换 HTML
	 * @param inputStream
	 *            DOC文件输入流
	 * @param outputStream
	 *            HTML文件输出流
	 * @param imageSaveDir
	 *            图片存储路径
	 */
	public static void docTransHtml(InputStream inputStream, OutputStream outputStream, String imageSaveDir)
			throws Exception {
		HWPFDocument document = new HWPFDocument(inputStream);
		AbstractWordConverter wordToHtmlConverter = new WordToHtmlConverter(
				DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());

		// 将文档中的图片抽取放入到指定位置
		wordToHtmlConverter.setPicturesManager(new PicturesManager() {
			@Override
			public String savePicture(byte[] content, PictureType pictureType, String suggestedName, float widthInches,
					float heightInches) {

				try {
					FileOutputStream fileOutputStream = new FileOutputStream(imageSaveDir + suggestedName);
					fileOutputStream.write(content);
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return imageSaveDir + suggestedName;
			}
		});

		wordToHtmlConverter.processDocument(document);
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, StandardCharsets.UTF_8.toString());
		transformer.setOutputProperty(OutputKeys.INDENT, "true");
		transformer.setOutputProperty(OutputKeys.METHOD, "html");
		DOMSource domSource = new DOMSource(wordToHtmlConverter.getDocument());

		transformer.transform(domSource, new StreamResult(outputStream));
	}

}
