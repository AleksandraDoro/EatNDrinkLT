package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.entity.Item;
import org.example.service.ItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "Chipok's endpoints", description = "Swagger Чипок-онлайн")
public class ItemController {
    private final ItemService itemService;
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "Get a random item", description = "Возвращает в ответ рандомный продукт.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(example = "{\"id\": \"2\", \"name\": \"Водка\"}"), mediaType = "application/json")})})
    @GetMapping(value = "/random")
    public Item getRandomItem() {
        return itemService.getRandomItem();
    }

    @Operation(summary = "Get {itemName}", description = "Возвращает возвращает айди и имя продукта по имени.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(example = "{\"id\": \"1\", \"name\": \"Буханка\"}"), mediaType = "application/json")})})
    @GetMapping(value = "itemName/{itemName}")
    public Item getItems(@PathVariable(name = "itemName") String itemName) {
        return itemService.getItemByName(itemName); // Передаем значение параметра itemName
    }
}


