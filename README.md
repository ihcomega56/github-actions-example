リクエストしたテキストをそのまま返します

```shell
$ gradle bootRun
$ curl -H 'Content-Type: text/plain' -H 'Accept: text/plain'  localhost:9000/echo -d 'やっほー'
```
