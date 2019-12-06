package com.qf.freemarker01;

import com.qf.freemarker01.pojo.Student;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FreeMarker02 {

    @Test
    public void freemarker() throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setDefaultEncoding("utf-8");
        configuration.setDirectoryForTemplateLoading(new File("E:\\ZZJavaEE1908\\JavaEE\\Day63-freemarker\\ftl"));

        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1, "zhuyongji1", 18, "航海中路60");
        Student student2 = new Student(2, "zhuyongji2", 18, "航海中路60");
        Student student3 = new Student(3, "zhuyongji3", 18, "航海中路60");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        HashMap<String, List> map = new HashMap<>();
        map.put("stuList", students);
        FileWriter fileWriter = new FileWriter(new File("E:\\ZZJavaEE1908\\JavaEE\\Day63-freemarker\\html\\student.html"));

        Template template = configuration.getTemplate("student.ftl");
        template.process(map, fileWriter);

        fileWriter.close();
    }
}
