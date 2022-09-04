test:
	docker-compose run --rm java javac -cp "vendor/*:." -d classes tests/TestComplex.java
	docker-compose run --rm java java -cp "vendor/*:classes:." org.junit.runner.JUnitCore tests.TestComplex

main:
	docker-compose run --rm java javac -d classes lib/Complex.java Main.java
	docker-compose run --rm java java -cp "classes:." Main

clear:
	docker-compose run --rm java rm -rf classes && mkdir classes
