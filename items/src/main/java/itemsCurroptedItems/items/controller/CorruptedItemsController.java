package itemsCurroptedItems.items.controller;

import itemsCurroptedItems.items.entity.CorruptedItem;

import itemsCurroptedItems.items.service.CorruptedItemsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class CorruptedItemsController {
    private final CorruptedItemsService corruptedItemsService;

    public CorruptedItemsController(CorruptedItemsService corruptedItemsService) {
        this.corruptedItemsService = corruptedItemsService;
    }

    @GetMapping("/getAll")
    public List<CorruptedItem> save() {
        return  corruptedItemsService.getAll();
    }

    @PostMapping("/save")
    public String insert(@ModelAttribute CorruptedItem corruptedItem) {
        return corruptedItemsService.save(corruptedItem);

    }

    @PostMapping("/edit")
    public Object update(@PathVariable long id , @ModelAttribute CorruptedItem newCorruptedItem){
        return corruptedItemsService.update( newCorruptedItem , id);
    }

    @PostMapping("/remove")
    public  void delete(@ModelAttribute CorruptedItem corruptedItem){
        corruptedItemsService.delete(corruptedItem);
    }
}
