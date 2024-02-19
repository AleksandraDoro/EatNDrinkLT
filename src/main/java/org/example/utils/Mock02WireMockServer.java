package org.example.utils;

import com.github.tomakehurst.wiremock.WireMockServer;

import java.time.LocalDate;
import java.util.Random;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class Mock02WireMockServer {

    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(8081); // Запуск сервера WireMock на порту 8081
        wireMockServer.start();

        // Настройка заглушки
        configureFor("localhost", 8081);
        stubFor(get(urlEqualTo("/api/mock02"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/plain; charset=UTF-8")
                        .withBody("Весь ассортимент нужных вам товаров появится только ДД/ММ/ГГГГ. Ждите или дойдите до магазина ногами. Мы за ЗОЖ" + generateRandomDate())));
      // !!!!!! русский язык кодируется, как исправить, непонятно, но надо
        // "Весь ассортимент нужных вам товаров появится только ДД/ММ/ГГГГ. Ждите или дойдите до магазина ногами. Мы за ЗОЖ" Goods you choose will be here at

        // Ждем, пока не будет получен сигнал для остановки сервера
        System.out.println("Нажмите Enter для остановки сервера WireMock");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Остановка сервера WireMock
        wireMockServer.stop();
    }
    private static String generateRandomDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.now().toEpochDay();
        int maxDay = (int) LocalDate.now().plusYears(10).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate.toString(); // Возвращаем рандомную дату в формате "ГГГГ-ММ-ДД"
    }
}
