package com.zzg.freemarker.entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TemplateEntity {
	// ftl 包路径
	private String ftlPackagePath;
	// ftl 文件名称
	private String ftlFileName;

	private Configuration configuration = null;
	private Template template = null;
	
	// get 和 set 方法
	public String getFtlPackagePath() {
		return ftlPackagePath;
	}

	public void setFtlPackagePath(String ftlPackagePath) {
		this.ftlPackagePath = ftlPackagePath;
	}

	public String getFtlFileName() {
		return ftlFileName;
	}

	public void setFtlFileName(String ftlFileName) {
		this.ftlFileName = ftlFileName;
	}

	public TemplateEntity(String ftlPackagePath,String ftlFileName) {
		this.ftlPackagePath = ftlPackagePath;
		this.ftlFileName = ftlFileName;
		// freemarker 模板配置对象
		configuration = new Configuration();
		// 设置编码格式: utf-8
		configuration.setDefaultEncoding("utf-8");
		// 设置ftl 文件目录
		configuration.setClassForTemplateLoading(TemplateEntity.class, this.ftlPackagePath);
		// 设置ftl 文件
		try {
			template = configuration.getTemplate(this.ftlFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createTemplate(Map data, String docFileName){
		File file = new File(docFileName);
		if(file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Writer writer = new OutputStreamWriter(new FileOutputStream(file),"utf-8");
			template.process(data, writer);
			writer.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	

}
