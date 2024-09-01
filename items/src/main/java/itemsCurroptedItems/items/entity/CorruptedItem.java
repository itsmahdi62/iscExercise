package itemsCurroptedItems.items.entity;


import jakarta.persistence.*;

@Entity(name = "CorruptedItem")
@Table(name = "CorruptedItem")
public class CorruptedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String reason;

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
