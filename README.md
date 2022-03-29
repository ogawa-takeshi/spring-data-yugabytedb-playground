# Spring Data YugabyteDB Playground

```
sudo ifconfig lo0 alias 10.200.10.1/24
sudo ifconfig lo0 alias 10.200.10.2/24
sudo ifconfig lo0 alias 10.200.10.3/24
```

```
docker compose up -d
```

Admin UI: http://10.200.10.1:7000/

```
docker run -it yugabytedb/yugabyte-client ysqlsh -h 10.200.10.1 -p 5433
```
