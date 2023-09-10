run-dist:
	./build/install/app/bin/app filepath1.json filepath2.json -f JSON

lint:
	../gradlew checkstyleMain checkstyleTest

test:
	../gradlew test

build:
	../gradlew clean build

report:
	../gradlew jacocoTestReport

.PHONY: build