package inventory.pl.configs;

import inventory.pl.entities.NeedsRequest;
import inventory.pl.entities.Procurement;
import inventory.pl.entities.Product;
import inventory.pl.entities.ProductItems;
import inventory.pl.entities.RequestDetails;
import inventory.pl.helpers.RequestStatus;
import inventory.pl.services.ProcrumentService;
import inventory.pl.services.RequestsService;
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
        RequestsService requestsService = ctx.getBean(RequestsService.class);
        ProductItems item1 = service.getItem(4);
        ProductItems item2 = service.getItem(5);
        RequestDetails detail1 = new RequestDetails();
        detail1.setRequestItems(item1);
        RequestDetails detail2 = new RequestDetails();
        detail2.setRequestItems(item2);
        NeedsRequest request = new NeedsRequest();
        request.setRequestDate(new Date());
        request.setStatus(RequestStatus.DONE);
        requestsService.saveRequest(request);
        List<RequestDetails> details = new ArrayList<>();
        detail1.setRequest(request);
        detail2.setRequest(request);
        details.add(detail1);
        details.add(detail2);
        request.setProductList(details);
        requestsService.saveRequest(request);
        item1.setRequest(detail1);
        item2.setRequest(detail2);
        //service.saveProductItem(item2);
        service.saveProductItem(item1);
//      
        /*
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JPAConfig.class);
        ProcrumentService manager = ctx.getBean(ProcrumentService.class);
        ProductService service = ctx.getBean(ProductService.class);
        RequestsService requestsService = ctx.getBean(RequestsService.class);
        Product p = service.getByName("Hard Disks");
        assert p != null;
        ProductItems item1 = new ProductItems();
        item1.setCode("asdf-xyz");
        item1.setCreationeDate(new Date());
        item1.setProduct(p);
        RequestDetails detail1 = new RequestDetails();
        item1.setRequest(detail1);
        detail1.setRequestItems(item1);
        NeedsRequest request = new NeedsRequest();
        request.setRequestDate(new Date());
        List<RequestDetails> requests = new ArrayList<>();
        detail1.setRequest(request);
        requests.add(detail1);
        request.setProductList(requests);
        requestsService.saveRequest(request);
        service.saveProductItem(item1);
        */
    }
}
