package itemsCurroptedItems.items.repository;

import itemsCurroptedItems.items.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Item , Long> {
    Item findItemByName(String name);
}
