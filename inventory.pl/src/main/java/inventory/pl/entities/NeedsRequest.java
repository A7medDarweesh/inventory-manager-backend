/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ahmed_darweeesh
 */
@Entity
public class NeedsRequest implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2593545438773861676L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @Column
    private RequestStatus status;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
   @OneToMany(cascade=CascadeType.ALL,mappedBy="request")
    private List<RequestDetails>productList;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

  

}
