package com.example.testdemo.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter());


    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            private String user;
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                this.user = "name";
                return HandlerInterceptor.super.preHandle(request, response, handler);
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                System.out.println(this.user);
                HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
            }
        });
    }

    class DataList{
        private List<String> deleteMetrics;
        private Set<String> metricsSet;

        public DataList(Set<String> set){
            deleteMetrics = new ArrayList<>();
            this.metricsSet = set;
        }

        public void add(String str) {
            if (!metricsSet.contains(str)) {
                deleteMetrics.add(str);
            }
        }

        public List<String> getDeleteMetrics() {
            return deleteMetrics;
        }
    }
    public void main(String[] args) {
        Set<String> set = new HashSet<>();
        DataList dataList = new DataList(set);
        dataList.add("a");
        List<String> deleteMetrics = dataList.getDeleteMetrics();

    }
}
