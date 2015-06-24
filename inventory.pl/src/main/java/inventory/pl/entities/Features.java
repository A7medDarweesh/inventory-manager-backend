/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.entities;

import java.io.Serializable;
import java.util.List;

import inventory.pl.helpers.FeatureType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author ahmed_darweeesh
 */
@Entity
@Table(name = "features")
public class Features implements Serializable {
	private static final long serialVersionUID = -8690151907728387216L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private int order;
	@Column
	private FeatureType type;
	@ManyToOne
	@JoinColumn(name = "product")
	private Product product;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "feature")
	private List<FeatureValue> featureValues;
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
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public FeatureType getType() {
		return type;
	}
	public void setType(FeatureType type) {
		this.type = type;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<FeatureValue> getFeatureValues() {
		return featureValues;
	}
	public void setFeatureValues(List<FeatureValue> featureValues) {
		this.featureValues = featureValues;
	}

    @Override
    public String toString() {
        return "Features{" + "name=" + name + ", type=" + type + ", product=" + product + '}';
    }

}
