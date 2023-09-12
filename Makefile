run-dist:
	./app/build/install/app/bin/app filepath1.yml filepath2.yml

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

build:
	./gradlew clean build

report:
	./gradlew jacocoTestReport

.PHONY: build