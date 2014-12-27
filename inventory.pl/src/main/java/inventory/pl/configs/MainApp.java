package inventory.pl.configs;

import inventory.pl.entities.BuyOrder;
import inventory.pl.entities.FeatureValue;
import inventory.pl.entities.Features;
import inventory.pl.entities.Product;
import inventory.pl.entities.Role;
import inventory.pl.entities.User;
import inventory.pl.services.BuyOrderService;
import inventory.pl.services.ServiceManager;
import inventory.pl.services.UserService;
import inventory.pl.services.product.ProductService;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(JPAConfig.class);
	   ServiceManager manager=ctx.getBean(ServiceManager.class);
           ProductService service=ctx.getBean(ProductService.class);
    List<FeatureValue> fets = service.getItemValues(1);
           System.out.println("size="+fets.size());
//           UserService service=ctx.getBean(UserService.class);
//           Role r=service.getRoleByID(1);
//           User a7med=new User();
//           a7med.setName("A7med3");
//           a7med.setJoinDate(new Date());
//           a7med.setRole(r);
//           service.addUser(a7med);
//           service.removeDuplicateNames("A7med3");
//           service.getAllUsersInRole(1).stream().forEach(e->{
//               System.out.println("user name:"+e.getName());
//           });
           
//           ProductService service=manager.getProductService();
//            Product product=new Product();
//            product.setCreateDate(new Date());
//            product.setDescription("Flash drives");
//            product.setName("Flash Drivez");
//            service.saveProduct(product);
//            service.getProductNameLike("%Drive%").stream().forEach((p) -> {
//        System.out.println("p:"+p.getName());
//    });
//            service.removeDuplicateNames("Flash Drivez");
//            System.out.println("products after remove");
//                service.getProductNameLike("%Drive%").stream().forEach((p) -> {
//        System.out.println("p:"+p.getName());
//    });
}
}
