json:
	./build/install/app/bin/app ./src/test/resources/filepath1.json ./src/test/resources/filepath2.json

json-stylish:
	./build/install/app/bin/app ./src/test/resources/filepath1.json ./src/test/resources/filepath2.json -f stylish

json-json:
	./build/install/app/bin/app ./src/test/resources/filepath1.json ./src/test/resources/filepath2.json -f json

json-plain:
	./build/install/app/bin/app ./src/test/resources/filepath1.json ./src/test/resources/filepath2.json -f plain

yml:
	./build/install/app/bin/app ./src/test/resources/filepath1.yml ./src/test/resources/filepath2.yml

yml-stylish:
	./build/install/app/bin/app ./src/test/resources/filepath1.yml ./src/test/resources/filepath2.yml -f stylish

yml-json:
	./build/install/app/bin/app ./src/test/resources/filepath1.yml ./src/test/resources/filepath2.yml -f json

yml-plain:
	./build/install/app/bin/app ./src/test/resources/filepath1.yml ./src/test/resources/filepath2.yml -f plain

lint:
	./gradlew checkstyleMain checkstyleTest

test:
	./gradlew test

build:
	./gradlew clean build

report:
	./gradlew jacocoTestReport

clean:
	./gradlew clean

.PHONY: build