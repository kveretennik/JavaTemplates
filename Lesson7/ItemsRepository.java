package ru.constantin.netstore.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.constantin.netstore.entities.Item;

@Repository
public interface ItemsRepository extends PagingAndSortingRepository<Item, Long> {
    Page<Item> findAll(Pageable pageable);
    Item findOneByItemNumber(String itemNumber);

    @Override
    void deleteById(Long itemID);
}
