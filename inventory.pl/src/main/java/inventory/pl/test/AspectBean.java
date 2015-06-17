package inventory.pl.test;

import org.springframework.stereotype.Component;

@Component
public class AspectBean {
	@Loggable("proceed")
public void testAspect(){
	System.out.println("rununig.....");
}
}
