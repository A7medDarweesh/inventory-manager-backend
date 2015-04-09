package inventory.pl.entities;

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
public class OrderDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
 @Column(name = "quantity")
    private String quantity;
@OneToOne
@JoinColumn(name = "item_id")
private ProductItems requestItems;
@ManyToOne
@JoinColumn(name = "order_id")
private Procurement order;
}
