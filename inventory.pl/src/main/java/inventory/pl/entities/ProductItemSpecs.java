package inventory.pl.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_item_specs")
public class ProductItemSpecs implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7903479688084570446L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "request_details_id")
    private RequestDetails request;
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productItemspecs")
    private List<FeatureValue> featuresValues;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RequestDetails getRequest() {
        return request;
    }

    public void setRequest(RequestDetails request) {
        this.request = request;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductItemSpecs other = (ProductItemSpecs) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<FeatureValue> getFeaturesValues() {
        return featuresValues;
    }

    public void setFeaturesValues(List<FeatureValue> featuresValues) {
        this.featuresValues = featuresValues;
    }
    

}
