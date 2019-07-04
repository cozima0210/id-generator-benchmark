# id-generator-benchmark

- $ docker-compose -f docker/docker-compose.yml up -d --build
- $ sbt
- $ jmh:run -i 5 -wi 5 -f 2 .*InsertBenchmark*.
- docker-compose -f docker/docker-compose.yml rm -s -f