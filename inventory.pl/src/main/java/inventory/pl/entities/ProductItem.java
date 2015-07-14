/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.pl.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ahmed_darweeesh
 */
@Entity
@Table(name="product_item")
public class ProductItem implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8015759928203779827L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Column
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String code;
    @Column(name = "creation_date")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creationeDate;
    @Column(name = "amount")
    private double amount;
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productItem")
    private List<FeatureValue> featuresValues;
    @ManyToMany(mappedBy = "products")
    private List<InventoryOut> outMoves;
    @ManyToMany(mappedBy = "products")
    private List<InventoryIn> inMoves;
    @ManyToOne
    @JoinColumn(name = "warehouse")
    private Warehouse warehouse;
    

    public List<FeatureValue> getFeaturesValues() {
        return featuresValues;
    }

    public void setFeaturesValues(List<FeatureValue> featuresValues) {
        this.featuresValues = featuresValues;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getCreationeDate() {
        return creationeDate;
    }

    public void setCreationeDate(Date creationeDate) {
        this.creationeDate = creationeDate;
    }

    public List<InventoryOut> getOutMoves() {
        return outMoves;
    }

    public void setOutMoves(List<InventoryOut> outMoves) {
        this.outMoves = outMoves;
    }

    public List<InventoryIn> getInMoves() {
        return inMoves;
    }

    public void setInMoves(List<InventoryIn> inMoves) {
        this.inMoves = inMoves;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}


}
