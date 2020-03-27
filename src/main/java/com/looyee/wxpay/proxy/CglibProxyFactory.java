package com.looyee.wxpay.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib子类代理工厂
 */
public class CglibProxyFactory implements MethodInterceptor {

	//给目标对象创建一个代理对象
	public Object getProxyInstance(Class clazz) {
		Enhancer enhancer = new Enhancer();
		//2.设置父类
		enhancer.setSuperclass(clazz);
		//3.设置回调函数
		enhancer.setCallback(this);
		//4.创建子类(代理对象)
		return enhancer.create();

	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		PerformanceMonitor.begin(obj.getClass().getName() + "." + method.getName());
		//执行目标对象的方法
		Object result = proxy.invokeSuper(obj, args);
		PerformanceMonitor.end();
		return result;
	}
}