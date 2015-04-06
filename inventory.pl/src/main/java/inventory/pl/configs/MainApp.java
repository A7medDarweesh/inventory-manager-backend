package inventory.pl.configs;

import inventory.pl.entities.Procurement;
import inventory.pl.entities.Product;
import inventory.pl.services.ProcrumentService;
import inventory.pl.services.product.ProductService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JPAConfig.class);
        ProcrumentService manager = ctx.getBean(ProcrumentService.class);
        ProductService service = ctx.getBean(ProductService.class);
//        List<Product> products = service.getAll();
//        products.stream().forEach((p) -> {
//            Procurement proc = new Procurement();
//            proc.setAddingDate(new Date());
//            List<Product> lp = new ArrayList<>();
//            lp.add(p);
//            proc.setProducts(lp);
//            manager.saveProcurement(proc);
//            service.saveProduct(p);
//        });
    }
}
