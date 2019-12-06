package com.qf.freemarker01;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class FreeMarker01 {
    @Test
    public void freemarkerTest() throws IOException, TemplateException {
        /**
         * 第一步：获取配置对象，设置编码集，设置模板的目录
         */
        //获取配置对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        //设置编码集
        configuration.setDefaultEncoding("utf-8");
        //设置模板的文件地址
        configuration.setDirectoryForTemplateLoading(new File("E:\\ZZJavaEE1908\\JavaEE\\Day63-freemarker\\ftl"));

        /**
         * 第二步：
         * 创建map集合，添加返回数据；
         * 创建输出流对象
         */
        //创建map集合，返回数据
        HashMap<String, String> map = new HashMap<>();
        map.put("hello", "china");
        //创建输出流对象
        FileWriter fileWriter = new FileWriter(new File("E:\\ZZJavaEE1908\\JavaEE\\Day63-freemarker\\html\\hello.html"));

        /**
         * 第三步：
         * 获取ftl模板对象
         * 模板对象调用process()方法。传入map集合和输出流对象，生成html页面
         */
        //获取模板
        Template template = configuration.getTemplate("hello.ftl");
        //生成html页面
        template.process(map, fileWriter);

        /**
         * 关闭输出流
         */
        //关闭输出流
        fileWriter.close();
    }
}
