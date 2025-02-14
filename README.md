# File Parser

Это консольное приложение на Java для чтения и обработки текстовых файлов.

## Описание

Приложение позволяет читать текстовые файлы и выполнять базовые операции с их содержимым. Оно разработано с использованием Java 17 и собирается с помощью Maven 4.0.0. Для обработки аргументов командной строки используется библиотека Apache Commons CLI.

## Требования

- Java 17 или выше
- Maven 4.0.0 или выше

## Зависимости

Для работы приложения используется библиотека Apache Commons CLI. Она добавляется в проект через Maven:

```xml
<dependency>
    <groupId>commons-cli</groupId>
    <artifactId>commons-cli</artifactId>
    <version>1.9.0</version>
</dependency>
```

## Сборка, запуск и использование
Клонируйте репозиторий: </br>
git clone https://github.com/ваш-репозиторий/test-task.git

## Соберите проект с помощью Maven:
mvn clean package

## Запустите приложение, указав путь к текстовому файлу:
java -jar test-task-1.0-SNAPSHOT.jar -f /путь/к/файлу.txt</br>
Где:
-f или --file: Путь к текстовому файлу для обработки.</br>
## Пример:
java -jar target/test-task-1.0-SNAPSHOT.jar -f input.txt