package org.example.utils;

import org.example.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    //Create Read Update Delete

//    private final String ADD_STUDENT = "INSERT INTO test_table VALUES(?,?)";
//    private final String GET_STUDENTS = "SELECT * FROM test_table";
//    private final String UPDATE_STUDENTS = "UPDATE test_table set name = ? where id = ?";
//    private final String DELETE_STUDENT = "Delete From test_table WHERE name = ?";
//    private final String ORDER_STUDENT = "SELECT * FROM test_table ORDER BY id";

    public static List<Item> addItem(String id, String name) {
        List<Item> listItem = null;
        CRUDUtils crudUtils = new CRUDUtils(); // Создание экземпляра CRUDUtils
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.INSERT.getQuery())) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            //conn.commit(); коммит уже включен по дефолту
            listItem = crudUtils.getItems(); // Вызов метода getItems() через экземпляр класса CRUDUtils
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listItem;
    }

    public List<Item> getItems() {
        List<Item> listItem = new ArrayList<>();
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.SELECT.getQuery())) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                listItem.add(new Item(id, name));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listItem;
    }

    public List<Item> updateItems(String id, String name) {
        List<Item> listItem = new ArrayList<>();
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.UPDATE.getQuery())) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            //conn.commit(); коммит уже включен по дефолту
            listItem = getItems();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listItem;
    }

    public List<Item> deleteItem(String itemName) {
        List<Item> listItem = new ArrayList<>();
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.DELETE.getQuery())) {
            preparedStatement.setString(1, itemName);
            preparedStatement.executeUpdate();
            //conn.commit(); коммит уже включен по дефолту
            listItem = getItems();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listItem;
    }

    public List<Item> orderItem() {
        List<Item> listItem = new ArrayList<>();
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.ORDER.getQuery())) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                listItem.add(new Item(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listItem;
        }
    public Item getItemById(int itemID) {
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.SELECTID.getQuery())) {
            preparedStatement.setString(1, String.valueOf(itemID));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                return new Item(String.valueOf(itemID), name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

        public Item getItemByName(String itemName){
            try (Connection conn = new DBConnection().getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.SELECTNAME.getQuery())) {
                preparedStatement.setString(1, itemName);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String id = resultSet.getString("id");
                    return new Item(id, itemName);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }
