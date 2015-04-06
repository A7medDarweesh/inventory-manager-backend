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
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ahmed_darweeesh
 */
@Entity
@Table(name = "inventory_out")
public class InventoryOut implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "issue_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;
    @Column(name = "move_type")
    private short moveType=2;
    @OneToOne
    @JoinColumn(name = "request_id")
    NeedsRequest request;
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

    public short getMoveType() {
        return moveType;
    }

    public void setMoveType(short moveType) {
        this.moveType = moveType;
    }

    public NeedsRequest getRequest() {
        return request;
    }

    public void setRequest(NeedsRequest request) {
        this.request = request;
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
