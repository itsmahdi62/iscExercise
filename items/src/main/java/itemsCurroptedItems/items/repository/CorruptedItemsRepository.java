package itemsCurroptedItems.items.repository;

import itemsCurroptedItems.items.entity.CorruptedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorruptedItemsRepository extends JpaRepository<CorruptedItem , Long> {
}
