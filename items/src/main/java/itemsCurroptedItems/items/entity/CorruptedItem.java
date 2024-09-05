package itemsCurroptedItems.items.entity;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "CorruptedItem")
@Table(name = "CorruptedItem")
public class CorruptedItem  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String reason;
    @OneToOne(cascade = CascadeType.ALL)
    private Item item;

    public Item getItem() {
        return item;
    }

    public CorruptedItem setItem(Item item) {
        this.item = item;
        return this;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
