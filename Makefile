run-dist:
	./app/build/install/app/bin/app ./app/src/test/resources/filepath1.json ./app/src/test/resources/filepath2.json -f plain

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

build:
	./gradlew clean build

report:
	./gradlew jacocoTestReport

.PHONY: build