package com.mypractice.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyPostProcoessor implements BeanPostProcessor {
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanId) throws BeansException {
	        System.out.println("MyPostProcoessor::postProcessBeforeInitialization(-,-)-->"+bean.getClass()+" "+beanId);
	        return bean;
		}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanId) throws BeansException {
		System.out.println("MyPostProcoessor::postProcessAfterInitialization(-,-)");
		return bean;
	}

}
