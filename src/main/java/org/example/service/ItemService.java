package org.example.service;

import org.example.entity.Item;
import org.example.interfaces.ItemServiceInterface;
import org.example.utils.CRUDUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ItemService implements ItemServiceInterface {
    @Override
    public Item getItem() {
        CRUDUtils crudUtils = new CRUDUtils();
        List<Item> listItem = crudUtils.getItems();
        System.out.println(listItem.size());
        System.out.println(listItem.get(new Random().nextInt(listItem.size())));

        return listItem.get(new Random().nextInt(listItem.size()));
    }

    public Item getItemById(int itemtId) {
        CRUDUtils crudUtils = new CRUDUtils();
                return crudUtils.getItemById(itemtId);
            }

    public Item getItemByName(String itemName) {
        CRUDUtils crudUtils = new CRUDUtils();
        return crudUtils.getItemByName(itemName);
    }
}

