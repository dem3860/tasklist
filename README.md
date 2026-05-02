# Tasklist

Spring Boot を使った簡単なタスク管理アプリケーションです。  
Thymeleaf による画面表示と、H2 Database によるデータ保存を試すための学習用プロジェクトです。

## 使用技術

- Java 21
- Spring Boot 4.0.6
- Spring Web MVC
- Thymeleaf
- JDBC
- H2 Database

## 起動方法

プロジェクト直下、つまり `pom.xml` があるディレクトリで以下を実行します。

```bash
./mvnw spring-boot:run
```

初回や pom.xml を変更した後は、以下のように一度ビルドし直すと確実です。
```bash
./mvnw clean package
./mvnw spring-boot:run
```

## H2 Consoleへのアクセス
H2 Console を有効にしている場合、アプリ起動後に以下のURLからアクセスできます。
```
http://localhost:8080/h2-console
```
ログイン画面が表示されたら、以下を入力します。
```
JDBC URL: jdbc:h2:~/taskdb
User Name: gihyo
Password: gihyodb
```
