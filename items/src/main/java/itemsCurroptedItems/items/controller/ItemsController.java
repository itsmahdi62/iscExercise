package itemsCurroptedItems.items.controller;

import itemsCurroptedItems.items.entity.Item;
import itemsCurroptedItems.items.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("items")
public class ItemsController {
    private final ItemService itemService;
    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/getAll")
    public List<Item> save() {
        return  itemService.getAll();
    }

    @PostMapping("/save")
    public String insert(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PostMapping("/edit/{id}")
    public Object update(@PathVariable long id ,@RequestBody Item newItem){
//        System.out.println(newItem.toString()+id);
        return itemService.update( newItem , id);
    }

    @PostMapping("/remove/{id}")
    public  void delete(@PathVariable long id){
        itemService.delete(id);
    }
}
