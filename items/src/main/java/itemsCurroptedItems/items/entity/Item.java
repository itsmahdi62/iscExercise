package itemsCurroptedItems.items.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "Item")
@Table(name = "Item")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String catalog;
    private int price;

    @OneToOne(cascade = CascadeType.ALL)
    private CorruptedItem corruptedItem ;

    public CorruptedItem getCorruptedItem() {
        return corruptedItem;
    }

    public Item setCorruptedItem(CorruptedItem corruptedItem) {
        this.corruptedItem = corruptedItem;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getCatalog() {
        return catalog;
    }

    public Item setCatalog(String catalog) {
        this.catalog = catalog;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Item setPrice(int price) {
        this.price = price;
        return this;
    }
}
