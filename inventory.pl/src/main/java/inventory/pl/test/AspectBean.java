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
	@Loggable(value="proceed")
	public void testAspect3(String string, String string2, AspectBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "aspect beaqn impl";
	} 
}
