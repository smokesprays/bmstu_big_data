fun main(args: Array<String>) {

    // laba 1
    // 1.2
    println("Program arguments: ${args.toString().reversed()}")

    // 1.3
    val number: Int = 6
    for(i in 1..number){
        print("I'm string with number $i without new line ")
        println("and i'm string with number $i on new line (next my copy, if not last)")
    }

    print("Input numbers with separate - space: ")
    val numbers: String = readln()
    val newNumbers = numbers.split(" ").map { it.toInt() }.toIntArray().toList()
    // неявный параметр лямбда выражения, примени сам к себе?
    // List<Int> - можно сразу, но по заданию массиив, поэтому сначала переводим в массив

    val numbers39: MutableList<Int> = mutableListOf() // Изменяемый тип нужен
    for (i in newNumbers) {
        if (i % 3 == 0 || i % 9 == 0) { // вроде работает, как надо. Достаточно проверки на 3, ведь все, что
            // делится на 9 естественно делится и на 3
            numbers39.add(i)
        }
    }
    println("min: ${newNumbers.min()}, max: ${newNumbers.max()} divided into 3 and 9: $numbers39")

    // laba 2
    // 2.2
    // функция compareBy() из стандартной библиотеки. Она принимает лямбда-функцию,
    // которая из объекта создаёт Comparable значение и задаёт пользовательский порядок
    println("Input strings with separate - comma")
    val strings: String = readln()
    var newStrings :List<String> = strings.split(",")
    newStrings = newStrings.sortedWith(compareBy { it.length }) // оказывается, val - не изменяемое значение, а
    // вот var - изменяемое

    // 2.3
    var totalSize: Int = 0
    for (i in newStrings) {
        totalSize += i.length
    }

    var averageSize: Float = 0F
    averageSize += totalSize / newStrings.size
    val average: MutableList<String> = mutableListOf() // Добавление в писок разве не изменяет переменную?
    for (i in newStrings) {
        if (i.length < averageSize) {
            average.add(i)
        }
    }
    println("Strings sorted by length: $newStrings, strings whose length is less average size: $average " +
            "(average- $averageSize)")
}