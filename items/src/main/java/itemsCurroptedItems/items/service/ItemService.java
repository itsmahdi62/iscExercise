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
            Item insertItem = new Item().setName(item.getName()).setCatalog(item.getCatalog()).setPrice(item.getPrice());
            itemsRepository.save(insertItem);
//            System.out.println(item.toString());
//            System.out.println(insertItem.toString());
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
            itemsRepository.save(existingItem);
            return existingItem;
        } else {
            // Handle the case where the item is not found (e.g., throw an exception)
            throw new RuntimeException("Item not found with id: " + id);
        }
    }
    public Optional<Item> findOneById(long id) {
        System.out.println( itemsRepository.findById(id).toString());
        return  itemsRepository.findById(id);
    }

    public void delete(Long id) {
        // logical delete was better
        Optional<Item> deleteItemOptional = findOneById(id);
        System.out.println(deleteItemOptional.toString());
        System.out.println(id);
        if (deleteItemOptional.isPresent()) {
            Item deleteItem = deleteItemOptional.get();

            itemsRepository.delete(deleteItem);
        } else {
            throw new RuntimeException("Item not found with id: " + id);
        }
    }
    public Item findByName(String name ){
        return itemsRepository.findItemByName(name);
    }
}
