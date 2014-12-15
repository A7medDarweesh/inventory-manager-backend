package inventory.pl.configs;

import inventory.pl.entities.BuyOrder;
import inventory.pl.services.BuyOrderService;
import inventory.pl.services.ServiceManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
	   ServiceManager manager=ctx.getBean(ServiceManager.class);
           BuyOrderService orderService=manager.getBuyOrderSrervice();
           BuyOrder p=new BuyOrder();
           p.setName("spring project test");
            p.setDescription("desc");
            orderService.save(p);
	
//            ProjectService projectService = manager.getProjectService();
//            Projects p=new Projects();
//            p.setName("spring project test");
//            p.setDescription("desc");
//            projectService.save(p);
//		System.out.println(manager.getProjectService()==null);
	
//	ServicesManager manager=new ServicesManager();
//	SearchService searc=manager.getSearchService();
//	System.out.println(searc.hashCode());
//	
}
}
