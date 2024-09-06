package itemsCurroptedItems.items.service;

import itemsCurroptedItems.items.entity.CorruptedItem;
import itemsCurroptedItems.items.entity.Item;
import itemsCurroptedItems.items.repository.CorruptedItemsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class CorruptedItemsService {
    private final CorruptedItemsRepository corruptedItemsRepository;
    private final  ItemService itemService ;
    public CorruptedItemsService(CorruptedItemsRepository corruptedItemsRepository, ItemService itemService) {
        this.corruptedItemsRepository = corruptedItemsRepository;
        this.itemService = itemService;
    }


    @Transactional
    public String save(CorruptedItem corruptedItem ,long id) {
        System.out.println("before");
            Optional<Item> item = itemService.findOneById(id);
        System.out.println("after");
            if(item.isPresent()){
                Item existingItem = item.get();
                CorruptedItem newCorruptedItem = new CorruptedItem().setItem(existingItem);
                newCorruptedItem.setReason(corruptedItem.getReason());
                corruptedItemsRepository.save(corruptedItem);
                return "Item saved";
            }else{
                return "corruptedItem did save ";
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
