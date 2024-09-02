package itemsCurroptedItems.items.controller;

import itemsCurroptedItems.items.entity.Item;
import itemsCurroptedItems.items.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("items")
public class ItemsController {
    private final ItemService itemService;
    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/getAll")
    public void save() {
         itemService.getAll();
    }

    @PostMapping("/save")
    public Object insert(@ModelAttribute Item item) {
        itemService.save(item);
        return item;
    }

    @PostMapping("/edit")
    public Object update(@PathVariable long id ,@ModelAttribute Item newItem){
        return itemService.update( newItem , id);
    }

    @PostMapping("/remove")
    public  void delete(@ModelAttribute Item item){
        itemService.delete(item);
    }
}
