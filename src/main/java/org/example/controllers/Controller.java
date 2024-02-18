package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.entity.Item;
import org.example.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")

@Tag(name = "EatNDrinkLT endpoints", description = "Swagger of project EatNDrinkLT")
public class Controller {
    private final ItemService itemService;
    public Controller(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "Get a random item", description = "Возвращает в ответ рандомного студента.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(example = "{\"id\": \"3\", \"name\": \"Nikita\"}"), mediaType = "application/json")})})
    @GetMapping(value = "/random")
    public Item getItems() {
        return itemService.getItem();
    }

    @Operation(summary = "Get true", description = "Возвращает в ответ всегда true.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(example = "true"), mediaType = "application/json")})})
    @GetMapping(value = "/true")
    public boolean getBool() {
        return true;
    }

    @Operation(summary = "Get string", description = "Возвращает 'Я твой лучший ответ, но это не точно'.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(example = "Я твой лучший ответ, но это не точно"), mediaType = "application/json")})})
    @GetMapping(value = "/string")
    public String getString() {
        return "Я твой лучший ответ, но это не точно";
    }


    @Operation(summary = "Get {itemtName}", description = "Возвращает возвращает айди товара по имени.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(example = "{\"id\": \"1\", \"name\": \"Буханка\"}"), mediaType = "application/json")})})
    @GetMapping(value = "itemName/{itemName}")
    public Item getItems(@PathVariable(name = "itemName") String itemName) {
        return itemService.getItemByName(itemName); // Передаем значение параметра itemName
    }
}


