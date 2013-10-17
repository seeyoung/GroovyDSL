writer = new StringWriter()
builder = new groovy.xml.MarkupBuilder(writer)
builder.numbers {
    description 'Squares and factors of 10..15'
    for (i in 10..15) {
        number (value: i, square: i*i) {
            //#1
            for (j in 2..<i) {
                if (i % j == 0) {
                    factor (value: j) //#2
                }
            }
        }
    }
}
println writer