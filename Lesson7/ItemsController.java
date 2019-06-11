package ru.constantin.netstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.constantin.netstore.entities.Item;
import ru.constantin.netstore.services.ItemsService;

import javax.validation.Valid;

@Controller
public class ItemsController {

    private ItemsService itemsService;

    @Autowired
    public void setItemsService(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/itemsList")
    public String showItemsList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Item> items = itemsService.findAll(PageRequest.of(page, 5, Sort.by("itemNumber").ascending()));
        model.addAttribute("items", items);
        return "items-list";
    }

    @GetMapping("/item/add-edit/{itemID}")
    public String addEditItemPage(Model model, @PathVariable("itemID") Long itemID) {
        Item item = itemsService.findByID(itemID);
        if (item == null) {
            item = new Item();
        }
        model.addAttribute("item", item);
        return "add-edit-item";
    }

    @PostMapping("/item/add-edit")
    public String addEditItem(Model model, @Valid @ModelAttribute("item") Item item, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-edit-item";
        }
        Item existing = itemsService.findOneByItemNumber(item.getItemNumber());

        if (existing != null && (item.getItemID() == null || !existing.getItemID().equals(item.getItemID()))) {
            model.addAttribute("item", item);
            model.addAttribute("itemCreationError", "Item number already exists!");
            return "add-edit-item";
        }
        itemsService.saveOrUpdate(item);
        return "redirect:/itemsList";
    }

    @PostMapping("/item/bulk-delete")
    public String deleteMultipleItems(Model model, @RequestParam("selectItemID") Long[] itemIDs) {
        itemsService.deleteCheckedItems(itemIDs);
        return "redirect:/itemsList";
    }
}
