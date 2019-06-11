package ru.constantin.netstore.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "store", name = "items")
public class Item {
    @Id
    @GeneratedValue(generator = "items_s")
    @SequenceGenerator(name = "items_s", schema = "store", sequenceName = "items_s", allocationSize = 1)
    @Column(name = "item_id")
    private Long itemID;

    @Size(min = 10, max = 40, message = "Item number length must be between 10 and 40 symbols!")
    @Column(name = "item_number")
    private String itemNumber;

    @Column(name = "item_name")
    @NotEmpty(message = "Item name cannot be null!")
    private String itemName;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "primary_uom_code")
    @NotEmpty(message = "Primary uom code cannot be empty!")
    private String primaryUOMCode;

//    @Column(name = "onhand_quantity")
//    private float onhandQuantity;
//
//    @Column(name = "item_price")
//    private float itemPrice;
}
