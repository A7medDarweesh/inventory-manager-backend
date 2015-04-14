package inventory.pl.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity")
    private String quantity;
    @OneToOne
    @JoinColumn(name = "item_id")
    private ProductItem requestItems;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Procurement order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public ProductItem getRequestItems() {
        return requestItems;
    }

    public void setRequestItems(ProductItem requestItems) {
        this.requestItems = requestItems;
    }

    public Procurement getOrder() {
        return order;
    }

    public void setOrder(Procurement order) {
        this.order = order;
    }
    
}
