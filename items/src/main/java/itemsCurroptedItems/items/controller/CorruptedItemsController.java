package itemsCurroptedItems.items.controller;

import itemsCurroptedItems.items.entity.CorruptedItem;

import itemsCurroptedItems.items.service.CorruptedItemsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("corruptedItems")
public class CorruptedItemsController {
    private final CorruptedItemsService corruptedItemsService;

    public CorruptedItemsController(CorruptedItemsService corruptedItemsService) {
        this.corruptedItemsService = corruptedItemsService;
    }

    @GetMapping("/getAll")
    public List<CorruptedItem> save() {
        return  corruptedItemsService.getAll();
    }

    @PostMapping("/save/{id}")
    public String insert(@RequestBody CorruptedItem corruptedItem , @PathVariable long id) {
        System.out.println("ddidm");
        return corruptedItemsService.save(corruptedItem , id);
    }

    @PostMapping("/edit/{id}")
    public Object update(@PathVariable long id , @RequestBody CorruptedItem newCorruptedItem){
        return corruptedItemsService.update( newCorruptedItem , id);
    }

    @PostMapping("/remove/{id}")
    public  void delete(@PathVariable long id){
//        corruptedItemsService.delete(id);
    }
}
