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
        System.out.println(item.toString());
        return itemService.save(item);
    }

    @PostMapping("/edit")
    public Object update(@PathVariable long id ,@RequestBody Item newItem){
        return itemService.update( newItem , id);
    }

    @PostMapping("/remove")
    public  void delete(@ModelAttribute Item item){
        itemService.delete(item);
    }

}
