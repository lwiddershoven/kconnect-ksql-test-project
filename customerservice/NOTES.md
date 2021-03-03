docker run -d \
--name customer-db \
-e POSTGRES_PASSWORD=s$cret \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-p 5432:5432 \
postgres:alpine


# -v /custom/mount:/var/lib/postgresql/data \

docker run -d \
--name customer-db \
-e POSTGRES_USER=postgres \
-e POSTGRES_PASSWORD=secret \ # do NOT use s$cret - illegal char ignored!
-e POSTGRES_DB=customerdb \
-p 5432:5432 \
postgres:alpine

start app
mvn spring-boot:run -Dspring-boot.run.profiles=postgres

