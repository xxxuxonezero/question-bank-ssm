package com.onezero;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanFactory implements ApplicationContextAware {
    private static ApplicationContext ac;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return ac;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        if (ac == null){
            return null;
        }
        return (T)ac.getBean(name);
    }

    public static <T> T getBean(Class clazz) throws BeansException {
        if (ac == null){
            return null;
        }
        return (T)ac.getBean(clazz);
    }
}
