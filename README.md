# How to run project
### Required version
```agsl
gradle version >= 7
java version 17
database: mariaDB  
```
### Chuẩn bị
- Đảm bảo database mariaDB cần được tạo và chạy script
- Sửa `url`, `username`, `password` tới database trong file `application.yml`

### Các bước run project
cần cài đặt môi trường `openjdk:17` và gradle \
image-name: `gradle:7.4.2-jdk17-alpine`

Build source
```shell
gradle clean build
```
Run component
```shell
gradle bootRun
```

