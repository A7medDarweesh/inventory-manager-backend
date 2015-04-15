package inventory.pl.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feature_values")
public class FeatureValue implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String value;
	@ManyToOne
	@JoinColumn(name = "product_item")
	private ProductItem productItem;
        @ManyToOne
	@JoinColumn(name = "product_item_spec")
	private ProductItemSpecs productItemspecs;

	@ManyToOne
	@JoinColumn(name = "fet_id")
	private Features feature;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
        
    public ProductItemSpecs getProductItemspecs() {
        return productItemspecs;
    }

    public void setProductItemspecs(ProductItemSpecs productItemspecs) {
        this.productItemspecs = productItemspecs;
    }
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public ProductItem getProductItem() {
		return productItem;
	}
	public void setProductItem(ProductItem productItem) {
		this.productItem = productItem;
	}
	public Features getFeature() {
		return feature;
	}
	public void setFeature(Features feature) {
		this.feature = feature;
	}
	
}
