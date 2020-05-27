# Spring-cipher-page

#### Quick start:
```
mvn archetype:generate
spring-boot
выбрать номер web-static-archetype (73)
задать groubId, artifactId
mvn clean package
```
P.S. это создание проекта неэффективно, проще сделать через IDE.

#### Frontend:
Для построения веб страниц используется шаблонизатор **Thymeleaf**. Базовым(расширяемым) шаблоном является wrapper.html, который задаёт начальную структуру сайта.