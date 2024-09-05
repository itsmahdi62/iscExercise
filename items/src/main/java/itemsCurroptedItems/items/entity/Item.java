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

    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catalog='" + catalog + '\'' +
                ", price=" + price +
                '}';
    }
}
