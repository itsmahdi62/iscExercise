package itemsCurroptedItems.items.repository;

import itemsCurroptedItems.items.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemsRepository extends JpaRepository<Item , Long> {
    Item findItemByName(String name);
    Optional<Item> findById(Long id);

}
