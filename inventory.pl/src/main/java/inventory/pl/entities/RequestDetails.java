package inventory.pl.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "request_details")
public class RequestDetails implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5140505199554863586L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity")
    private String quantity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private ProductItem requestItems;
    @ManyToOne
    @JoinColumn(name = "request_id")
    private NeedsRequest request;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the requestItems
     */
    public ProductItem getRequestItems() {
        return requestItems;
    }

    /**
     * @param requestItems the requestItems to set
     */
    public void setRequestItems(ProductItem requestItems) {
        this.requestItems = requestItems;
    }

    /**
     * @return the request
     */
    public NeedsRequest getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(NeedsRequest request) {
        this.request = request;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof RequestDetails)) {
            return false;
        }
        RequestDetails other = (RequestDetails) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
