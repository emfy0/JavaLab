test:
	docker-compose run --rm java javac -cp "vendor/*:." -d classes tests/TestLinSort.java
	docker-compose run --rm java java -cp "vendor/*:classes:." org.junit.runner.JUnitCore tests.TestLinSort

clear:
	docker-compose run --rm java rm -rf classes && mkdir classes
