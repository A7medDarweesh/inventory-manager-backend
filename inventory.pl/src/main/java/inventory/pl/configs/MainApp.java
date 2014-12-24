package inventory.pl.configs;

import inventory.pl.entities.BuyOrder;
import inventory.pl.entities.Product;
import inventory.pl.services.BuyOrderService;
import inventory.pl.services.ServiceManager;
import inventory.pl.services.product.ProductService;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
public static void main(String[] args) {
	ApplicationContext ctx = new AnnotationConfigApplicationContext(JPAConfig.class);
	   ServiceManager manager=ctx.getBean(ServiceManager.class);
           ProductService service=manager.getProductService();
            Product product=new Product();
            product.setCreateDate(new Date());
            product.setDescription("Flash drives");
            product.setName("Flash Drivez");
            service.saveProduct(product);
            service.getProductNameLike("%Drive%").stream().forEach((p) -> {
        System.out.println("p:"+p.getName());
    });
            service.removeDuplicateNames("Flash Drivez");
            System.out.println("products after remove");
                service.getProductNameLike("%Drive%").stream().forEach((p) -> {
        System.out.println("p:"+p.getName());
    });
}
}
