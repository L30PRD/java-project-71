run-dist:
	./app/build/install/app/bin/app ./app/src/test/resources/filepath1.json ./app/src/test/resources/filepath2.json

json:
	./app/build/install/app/bin/app ./app/src/test/resources/filepath1.json ./app/src/test/resources/filepath2.json

json-stylish:
	./app/build/install/app/bin/app ./app/src/test/resources/filepath1.json ./app/src/test/resources/filepath2.json -f stylish

json-json:
	./app/build/install/app/bin/app ./app/src/test/resources/filepath1.json ./app/src/test/resources/filepath2.json -f json

json-plain:
	./app/build/install/app/bin/app ./app/src/test/resources/filepath1.json ./app/src/test/resources/filepath2.json -f plain

yml:
	./app/build/install/app/bin/app ./app/src/test/resources/filepath1.yml ./app/src/test/resources/filepath2.yml

yml-stylish:
	./app/build/install/app/bin/app ./app/src/test/resources/filepath1.yml ./app/src/test/resources/filepath2.yml -f stylish

yml-json:
	./app/build/install/app/bin/app ./app/src/test/resources/filepath1.yml ./app/src/test/resources/filepath2.yml -f json

yml-plain:
	./app/build/install/app/bin/app ./app/src/test/resources/filepath1.yml ./app/src/test/resources/filepath2.yml -f plain

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

build:
	./gradlew clean build

report:
	./gradlew jacocoTestReport

.PHONY: build