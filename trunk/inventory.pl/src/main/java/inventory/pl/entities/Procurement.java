package inventory.pl.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "procurement")
public class Procurement implements Serializable {
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
	public ProductItems getAddedItem() {
		return addedItem;
	}
	public void setAddedItem(ProductItems addedItem) {
		this.addedItem = addedItem;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private long id;
	@Column(name="added_date")
	private Date addingDate;
	@OneToOne
	@JoinColumn(name = "item_id")
	private ProductItems addedItem;

}
