test:
	docker-compose run --rm java javac -cp "vendor/*:." -d classes tests/TestВinaryTree.java
	docker-compose run --rm java java -cp "vendor/*:classes:." org.junit.runner.JUnitCore tests.TestВinaryTree

clear:
	docker-compose run --rm java rm -rf classes && mkdir classes
