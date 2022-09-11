test:
	docker-compose run --rm java javac -cp "vendor/*:." -d classes tests/TestMyList.java
	docker-compose run --rm java java -cp "vendor/*:classes:." org.junit.runner.JUnitCore tests.TestMyList

main:
	docker-compose run --rm java javac -d classes lib/MyList.java Main.java
	docker-compose run --rm java java -cp "classes:." Main

clear:
	docker-compose run --rm java rm -rf classes && mkdir classes
