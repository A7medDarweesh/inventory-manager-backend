/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.pl.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ahmed_darweeesh
 */
@Entity
@Table(name = "inventory_in")
public class InventoryIn implements Serializable {

	private static final long serialVersionUID = -6987460371331220680L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "issue_date")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date issueDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "move_type")
    private final short moveType = 1;
    @OneToOne
    @JoinColumn(name = "request_id")
    NeedsRequest request;
    @OneToOne
    @JoinColumn(name = "procurement_id")
    Procurement procurement;
    @ManyToMany()
    @JoinTable(name = "product_history", joinColumns = {
        @JoinColumn(name = "move_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "product_id")})
    private Set<ProductItems> products;
    @OneToOne
    @JoinColumn(name = "from_warehouse")
    Warehouse fromWarehousew;
    @OneToOne
    @JoinColumn(name = "toWarehouse")
    Warehouse toWarehouse;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

	public NeedsRequest getRequest() {
		return request;
	}

	public void setRequest(NeedsRequest request) {
		this.request = request;
	}

	public Procurement getProcurement() {
		return procurement;
	}

	public void setProcurement(Procurement procurement) {
		this.procurement = procurement;
	}

	public Set<ProductItems> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductItems> products) {
		this.products = products;
	}

	public Warehouse getFromWarehousew() {
		return fromWarehousew;
	}

	public void setFromWarehousew(Warehouse fromWarehousew) {
		this.fromWarehousew = fromWarehousew;
	}

	public Warehouse getToWarehouse() {
		return toWarehouse;
	}

	public void setToWarehouse(Warehouse toWarehouse) {
		this.toWarehouse = toWarehouse;
	}

	public short getMoveType() {
		return moveType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((issueDate == null) ? 0 : issueDate.hashCode());
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
		if (!(obj instanceof InventoryIn)) {
			return false;
		}
		InventoryIn other = (InventoryIn) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

}
