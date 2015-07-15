package inventory.pl.test;

import inventory.pl.configs.MainApp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	static final Logger LOG = LoggerFactory.getLogger(MainApp.class);
@Around(" @annotation(Loggable)")
public void checkBefore(ProceedingJoinPoint  jp){
	 MethodSignature signature = (MethodSignature) jp.getSignature();
	 Class c = signature.getReturnType();
	Loggable loggable=signature.getMethod().getAnnotation(Loggable.class);
	if(loggable.value().equalsIgnoreCase("proceed")){
		LOG.info("parameter is correct for method {}, prooceding",signature.getName());
		try {
			Object returnValue=jp.proceed();
			LOG.info("Return value from method:"+signature.getName()+"is:"+returnValue);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else{
		LOG.error("wron parameter for method:"+signature.getName()+",");
	}

	
}
}
