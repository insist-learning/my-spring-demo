package com.example.testdemo.spring.propertyeditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TestCustomEditorConfigurer extends CustomEditorConfigurer {



    public TestCustomEditorConfigurer(){
        Map<Class<?>, Class<? extends PropertyEditor>> customeditors = new HashMap<>();
        // 所有的 Date 类型都通过这个转换器
        customeditors.put(Date.class, MyEditor.class);
        this.setCustomEditors(customeditors);
    }



    public static class MyEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String text) {
            System.out.println("text:"+text);
            Date date = new Date();
            date.setYear(1998);
            setValue(date);
        }
    }
}
