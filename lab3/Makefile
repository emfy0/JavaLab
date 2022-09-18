test:
	docker-compose run --rm java javac -cp "vendor/*:." -d classes tests/TestMyVector.java
	docker-compose run --rm java java -cp "vendor/*:classes:." org.junit.runner.JUnitCore tests.TestMyVector

main:
	docker-compose run --rm java javac -d classes lib/MyVector.java Main.java
	docker-compose run --rm java java -cp "classes:." Main

clear:
	docker-compose run --rm java rm -rf classes && mkdir classes
