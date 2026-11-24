# Nail Salon REST API — Grade 5

Учебный проект по заданию: RESTful API + Swagger/OpenAPI + валидация + обработка ошибок + JWT.

## Что реализовано
- Spring Boot 3.4.5, Java 17
- REST API для 8 таблиц: users, clients, masters, nail_services, appointments, materials, payments, reviews
- Swagger/OpenAPI: `/swagger-ui.html`
- JWT авторизация через Swagger `Authorize`
- Bean Validation для входных данных
- GlobalExceptionHandler: 400/404/500 и ошибки валидации
- H2 file database: отдельный PostgreSQL не требуется
- CRUD: GET, GET/{id}, POST, PUT/{id}, DELETE/{id}

## Запуск
```powershell
mvn spring-boot:run
```
или
```powershell
.\mvnw.cmd spring-boot:run
```

## Swagger
http://localhost:8080/swagger-ui.html

## Авторизация
POST `/api/auth/login`
```json
{"login":"admin","password":"admin123"}
```
Скопировать `token` из ответа, нажать **Authorize** и вставить JWT. После этого доступны защищённые `/api/**`.

Пользователь: `user / user123`
Администратор: `admin / admin123`

## Примеры
GET `/api/clients`
POST `/api/clients`
```json
{"name":"Ольга","phone":"+79991234567","email":"olga@example.com"}
```

PUT `/api/clients/1` — заменить запись.
DELETE `/api/clients/1` — удалить запись.

## Демонстрация преподавателю
1. Открыть Swagger.
2. Показать группы контроллеров и пояснения `summary/description`.
3. Выполнить login.
4. Нажать Authorize и вставить JWT.
5. Выполнить GET/POST/PUT/DELETE для одной сущности.
6. Показать ошибку валидации, например пустое имя клиента.
7. Показать 404 для несуществующего ID.


## Размещение в интернете и HTTPS
Для развёртывания подготовлены `Dockerfile`, `render.yaml`, профиль `application-prod.properties` и инструкция `DEPLOYMENT_GUIDE_RU.md`. В production используется PostgreSQL и переменные окружения. Хостинг с поддержкой Docker/Java (например Render) выдаёт HTTPS-домен и автоматически управляет TLS-сертификатом для своего стандартного домена.

Подробная инструкция: `DEPLOYMENT_GUIDE_RU.md`. Шаблон отчёта: `REPORT_HOSTING_TEMPLATE_RU.md`. Реальный адрес и скриншоты браузера нужно добавить после публикации приложения.
