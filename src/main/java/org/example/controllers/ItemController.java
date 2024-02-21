package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "Chipok's endpoints", description = "Swagger Чипок-онлайн")
public class ItemController {
    private final ProductService itemService;

    // Конструктор для внедрения зависимостей
    public ItemController(ProductService itemService) {
        this.itemService = itemService;
    }
    @Operation(summary = "Получаем в ответ продукт по его имени", description = "Возвращает в ответ продукт")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(example = "{\"уплотите 200 рублей\"}"), mediaType = "application/json")})
    })
    @GetMapping("item/{itemName}")
    public ResponseEntity<Object> getItemInfo(@PathVariable("itemName") String itemName) {
        Object itemInfo = itemService.getItemInfo(itemName);
        return ResponseEntity.ok(itemInfo);
    }
}

