package com.zzg.freemarker.test;

import java.util.HashMap;
import java.util.Map;

import com.zzg.freemarker.entity.TemplateEntity;
import com.zzg.util.Base64Util;

public class FreemarkerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 图片数据
		String imageContent = Base64Util.getEncodeValue("C:\\image\\1.png");
		// 数据组装
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("imageurl", imageContent);
		map.put("name", "zhouzhiwengang");
		map.put("time", "2019-04-03");
		map.put("factory", "深圳富士康");
		map.put("product", "苹果电脑");
		map.put("price", "8999");
		map.put("num", "十万台");
		
		// 构建模板引擎实体对象
		TemplateEntity entity = new TemplateEntity("/com/zzg/ftl","template.ftl");
		String docFileName = "C:\\image\\测试模板.doc";
		entity.createTemplate(map, docFileName);
		
		
	}

}
