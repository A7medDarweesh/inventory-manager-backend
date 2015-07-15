package inventory.pl.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AspectBean {
	@Loggable(value="dont")
public void testAspect(){
}
	@Loggable(value="proceed")
public List<String> testAspect2(){
		List<String>s=new ArrayList<>();
		for(int i=0;i<9;i++)
		s.add("s"+i);
		return s;
}
}
