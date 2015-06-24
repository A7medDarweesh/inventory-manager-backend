package inventory.pl.test;

import inventory.pl.helpers.FeatureType;
import org.springframework.stereotype.Component;

@Component
public class AspectBean {
	@Loggable(value="dont")
public void testAspect(){
	System.out.println("rununig.....");
}
}
