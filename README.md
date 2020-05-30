# Spring-cipher-page

### Quick start:
```
mvn archetype:generate
spring-boot
выбрать номер web-static-archetype (73)
задать groubId, artifactId
mvn clean package
```
P.S. это создание проекта неэффективно, проще сделать через IDE.

### Frontend:
Для построения веб страниц используется шаблонизатор **Thymeleaf**. 
Базовым(расширяемым) шаблоном является wrapper.html, который задаёт начальную структуру сайта.

Валидации форм осуществляется при помощи javax.validation и dto объектов, которые передаются в шаблонизатор при помощи spring интерфейса ui.Model. 

### CRUD:
Используется база данных MySql (в ней создана схема springpagedb и пользователь sudoCipher).

Взаимодействие с бд осуществляется посредством hibernate (одна из реализаций спецификации JPA). 

Создана таблица user и для быстрого поиска по бд были проиндексированы атрибуты: login и password.

