package repository.exceptions

class CsvFileNotFoundException(csvPath: String) : RuntimeException("The csv could not be found in $csvPath")