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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ahmed_darweeesh
 */
@Entity
public class ProductItems implements Serializable {

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
    @Column(name="creation_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creationeDate;
    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "productItem")
    private List<FeatureValue>featuresValues;
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

}
