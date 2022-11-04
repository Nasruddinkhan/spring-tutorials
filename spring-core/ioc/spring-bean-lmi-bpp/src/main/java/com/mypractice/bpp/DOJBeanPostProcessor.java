package com.mypractice.bpp;

import com.mypractice.bo.BaseBO;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.Date;

public class DOJBeanPostProcessor implements BeanPostProcessor {
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("DOJBeanPostProcessor.postProcessBeforeInitialization(-,-)");
		if(bean instanceof BaseBO) {
			System.out.println("1");
			((BaseBO) bean).setDoj(new Date());
		}
		
	    return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("DOJBeanPostProcessor.postProcessAfterInitialization(-,-)");
       return bean;
	}

}
