package inventory.pl.entities;

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
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "warehouse")
    private List<ProductItems>items;
    @ManyToOne
    @JoinColumn(name="project_id")
    Project project;

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

    public List<ProductItems> getItems() {
        return items;
    }

    public void setItems(List<ProductItems> items) {
        this.items = items;
    }
}
