package org.jiang.controller;

import java.io.BufferedReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloWorldController extends AbstractController {
	@Override
    protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Map map = new HashMap();  
        Enumeration paramNames = req.getParameterNames();  
        while (paramNames.hasMoreElements()) {  
            String paramName = (String) paramNames.nextElement();  
  
            String[] paramValues = req.getParameterValues(paramName);  
            if (paramValues.length == 1) {  
                String paramValue = paramValues[0];  
                if (paramValue.length() != 0) {  
                    map.put(paramName, paramValue);  
                }  
            }  
        }
        req.setCharacterEncoding("UTF-8");
		StringBuffer jb = new StringBuffer();
		String line = null;
		try
		{
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(jb);
		
  
        Set<Map.Entry<String, String>> set = map.entrySet();  
        System.out.println("------------------------------");  
        for (Map.Entry entry : set) {  
            System.out.println(entry.getKey() + ":" + entry.getValue());  
        }  
        System.out.println("------------------------------");
        
       //1、收集参数、验证参数  
       //2、绑定参数到命令对象  
       //3、将命令对象传入业务对象进行业务处理  
       //4、选择下一个页面  
       ModelAndView mv = new ModelAndView();  
       //添加模型数据 可以是任意的POJO对象  
       mv.addObject("message", "Hello World!");  
       //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面  
       mv.setViewName("hello2");  
       return mv;
    }


} 