# Добро пожаловать в "Чипок-онлайн"! Мы вам рады, но не сильно
- Схема проекта, заметки Figma https://www.figma.com/file/42apT2RakRBQUuK2kMMrRu/Untitled?type=design&node-id=0-1&mode=design&t=W5PdgAVV6VOGAwAW-0

- Запуск Mock02
http://localhost:8082/api/mock02

java -jar wiremock.jar \
--port 8082
--global-response-templating \
--container-threads 120 \
--no-request-journal \
--async-response-enabled true \
--async-response-threads 80