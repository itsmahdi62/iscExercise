package itemsCurroptedItems.items.service;

import itemsCurroptedItems.items.entity.Item;
import itemsCurroptedItems.items.repository.ItemsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemsRepository itemsRepository;

    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @Transactional
    public String save(Item item) {
        try{
            itemsRepository.save(item);
            return "item saved ";
        }catch (Exception e){
            System.out.println(e);
        }
        return "d";
    }

    public List<Item>  getAll() {
        return itemsRepository.findAll();
    }
    @Transactional
    public Item update( Item newItem , long id ) {
        Optional<Item> item = findOneById(id);
        if (item.isPresent()) {
            Item existingItem = item.get(); // Get the existing item
            existingItem.setName(newItem.getName());
            existingItem.setCatalog(newItem.getCatalog());
            existingItem.setPrice(newItem.getPrice());
            return itemsRepository.save(existingItem);
        } else {
            // Handle the case where the item is not found (e.g., throw an exception)
            throw new RuntimeException("Item not found with id: " + id);
        }
    }
    public Optional<Item> findOneById(long id) {
        return  itemsRepository.findById(id);
    }

    public void delete(Item item){
        itemsRepository.delete(item);
    }
}
