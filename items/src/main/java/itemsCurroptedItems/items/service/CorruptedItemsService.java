package itemsCurroptedItems.items.service;

import itemsCurroptedItems.items.entity.CorruptedItem;
import itemsCurroptedItems.items.repository.CorruptedItemsRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class CorruptedItemsService {
    private final CorruptedItemsRepository corruptedItemsRepository;

    public CorruptedItemsService(CorruptedItemsRepository corruptedItemsRepository) {
        this.corruptedItemsRepository = corruptedItemsRepository;
    }


    @Transactional
    public String save(CorruptedItem corruptedItem) {
        try{
            corruptedItemsRepository.save(corruptedItem);
            return "corruptedItem saved ";
        }catch (Exception e){
            System.out.println(e);
        }
        return "d";
    }

    public List<CorruptedItem> getAll() {
        return corruptedItemsRepository.findAll();
    }
    @Transactional
    public CorruptedItem update( CorruptedItem newItem , long id ) {
        Optional<CorruptedItem> item = findOneById(id);
        if (item.isPresent()) {
            CorruptedItem existingItem = item.get(); // Get the existing item
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
