package int

var opCount = 0

fun performOperation() {
    opCount++
}

fun reportOperationCount() {
    println("$opCount times")
}

class Operation {
}