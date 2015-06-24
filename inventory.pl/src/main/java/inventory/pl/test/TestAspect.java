package inventory.pl.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
@Around("execution(* inventory.pl.test.AspectBean.testAspect(..))&& @annotation(Loggable)")
public void checkBefore(ProceedingJoinPoint  jp){
	 MethodSignature signature = (MethodSignature) jp.getSignature();
	Loggable loggable=signature.getMethod().getAnnotation(Loggable.class);
	if(loggable.value().equalsIgnoreCase("proceed")){
		System.out.println("proceeding....");
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else{
		System.out.println("Value not found,  found:"+loggable.value());
	}

	
}
}
