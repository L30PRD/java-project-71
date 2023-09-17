run:
	./app/build/install/app/bin/app file1.json file2.json

build:
	make -C app build

test:
	make -C app test

lint:
	make -C app lint

report:
	make -C app report

clean:
	make -C app report

