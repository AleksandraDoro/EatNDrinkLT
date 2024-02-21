//package org.example.service;
//
//import org.example.entity.Item;
//import org.example.interfaces.ItemServiceInterface;
//import org.example.utils.CRUDUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Random;
//
//@Service
//public class ItemService implements ItemServiceInterface {
//    private final CRUDUtils crudUtils;
//    @Autowired
//    public ItemService(CRUDUtils crudUtils) {
//        this.crudUtils = crudUtils;
//    }
//    public Item getItem() {
//        List<Item> listItems = crudUtils.getItems();
//        System.out.println(listItems.size());
//        System.out.println(listItems.get(new Random().nextInt(listItems.size())));
//
//        return listItems.get(new Random().nextInt(listItems.size()));
//    }
//
//    public Item getItemByName(String itemName) {
//        return crudUtils.getItemByName(itemName);
//    }
//}
