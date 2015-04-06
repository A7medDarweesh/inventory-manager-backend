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

}
