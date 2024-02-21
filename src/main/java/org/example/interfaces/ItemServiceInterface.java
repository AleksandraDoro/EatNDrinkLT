package org.example.interfaces;

import org.example.entity.Item;


public interface ItemServiceInterface {
    Item getItem();

    Item getItemByName(String requestedItem);
}
