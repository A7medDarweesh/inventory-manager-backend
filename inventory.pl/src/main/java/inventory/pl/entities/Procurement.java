package inventory.pl.entities;

import inventory.pl.helpers.RequestStatus;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
/**
 * Class procuremetn represents procurements orders made by users
 * @author ahmed_darweeesh
 */
@Entity
@Table(name = "procurement")
public class Procurement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Column(name = "added_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date addingDate;
    @Column(name = "status")
    private RequestStatus requestStatus;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "buyOrder")
    private List<RequestDetails> procrumentProducts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public List<RequestDetails> getProducts() {
        return procrumentProducts;
    }

    public void setProducts(List<RequestDetails> products) {
        this.procrumentProducts = products;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

   


}
