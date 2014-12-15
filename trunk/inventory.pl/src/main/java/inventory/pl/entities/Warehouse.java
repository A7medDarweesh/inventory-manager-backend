package inventory.pl.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "warehouse")
public class Warehouse {
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
}
