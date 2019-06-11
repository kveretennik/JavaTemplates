package ru.constantin.netstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.constantin.netstore.entities.Item;
import ru.constantin.netstore.repositories.ItemsRepository;

@Service
public class ItemsService {

    private ItemsRepository itemsRepository;

    @Autowired
    public void setItemsRepository(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public Page<Item> findAll(Pageable pageable) {
        return itemsRepository.findAll(pageable);
    }

    public Item findByID(Long itemID) {
        return itemsRepository.findById(itemID).orElse(null);
    }

    public Item findOneByItemNumber(String itemNumber) {
        return itemsRepository.findOneByItemNumber(itemNumber);
    }


    public Item saveOrUpdate(Item item) {
        return itemsRepository.save(item);
    }

    public void deleteCheckedItems(Long[] checkedItemIDs) {
        for (int i=0; i < checkedItemIDs.length; i++) {
            itemsRepository.deleteById(checkedItemIDs[i]);
        }
    }
}
