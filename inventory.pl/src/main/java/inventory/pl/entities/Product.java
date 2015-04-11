/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.pl.entities;

import inventory.pl.helpers.QuantityType;

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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ahmed_darweeesh
 */
@Entity
public class Product implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2207639837994592277L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Column
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    @Column
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    private String description;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name="quantity_type")
    QuantityType quantityType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductItems> productItems;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Features> productFeatures;
    public List<Features> getProductFeatures() {
        return productFeatures;
    }

    public void setProductFeatures(List<Features> productFeatures) {
        this.productFeatures = productFeatures;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<ProductItems> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<ProductItems> productItems) {
        this.productItems = productItems;
    }

}
