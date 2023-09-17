### Hexlet tests and linter status:
[![Actions Status](https://github.com/L30PRD/java-project-71/workflows/hexlet-check/badge.svg)](https://github.com/L30PRD/java-project-71/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/19c301554ad18117240c/maintainability)](https://codeclimate.com/github/L30PRD/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/19c301554ad18117240c/test_coverage)](https://codeclimate.com/github/L30PRD/java-project-71/test_coverage)


### Вычислитель отличий
Вычислитель отличий – программа, определяющая разницу между двумя структурами данных. Это популярная задача, для решения которой существует множество онлайн-сервисов, например: http://www.jsondiff.com/. Подобный механизм используется при выводе тестов или при автоматическом отслеживании изменении в конфигурационных файлах.

Возможности утилиты:

Поддержка разных входных форматов: yaml и json
Генерация отчета в виде plain text, stylish и json

### Как собрать и запустить:

make build

Запуск из директории проекта:

./app/build/install/app/bin/app "file1.json" "file2.json" -f --format "stylish" , "plain", "json"

### Пример использования:

Asciinema Json
[![asciicast](https://asciinema.org/a/Je0Jzwwb7Bt923BLFeBmkRc9Q.svg)](https://asciinema.org/a/Je0Jzwwb7Bt923BLFeBmkRc9Q)

Asciinema Yml
[![asciicast](https://asciinema.org/a/RydL9Qm96yeYqoYv7kTcJYhH3.svg)](https://asciinema.org/a/RydL9Qm96yeYqoYv7kTcJYhH3)