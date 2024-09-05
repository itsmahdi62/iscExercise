package itemsCurroptedItems.items.service;

import itemsCurroptedItems.items.entity.CorruptedItem;
import itemsCurroptedItems.items.entity.Item;
import itemsCurroptedItems.items.repository.CorruptedItemsRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class CorruptedItemsService {
    private final CorruptedItemsRepository corruptedItemsRepository;
    private final  ItemService itemService ;
    public CorruptedItemsService(CorruptedItemsRepository corruptedItemsRepository, ItemService itemService) {
        this.corruptedItemsRepository = corruptedItemsRepository;
        this.itemService = itemService;
    }


    @Transactional
    public String save(CorruptedItem corruptedItem) {
        try{
            Item item = itemService.findByName(corruptedItem.getName());
            corruptedItem.setItem(item);
            corruptedItemsRepository.save(corruptedItem);
            return "corruptedItem saved ";
        }catch (Exception e){
            return "insert failed , cauesed by " +e ;
        }

    }

    public List<CorruptedItem> getAll()
    {
        return corruptedItemsRepository.findAll();
    }
    @Transactional
    public CorruptedItem update( CorruptedItem newItem , long id ) {
        Optional<CorruptedItem> corruptedItem = findOneById(id);
        if (corruptedItem.isPresent()) {
            CorruptedItem existingItem = corruptedItem.get(); // Get the existing item
            existingItem.setName(newItem.getName());

            return corruptedItemsRepository.save(existingItem);
        } else {
            // Handle the case where the item is not found (e.g., throw an exception)
            throw new RuntimeException("Item not found with id: " + id);
        }
    }
    public Optional<CorruptedItem> findOneById(long id) {
        return  corruptedItemsRepository.findById(id);
    }

    public void delete(CorruptedItem corruptedItem){
        corruptedItemsRepository.delete(corruptedItem);
    }
}
