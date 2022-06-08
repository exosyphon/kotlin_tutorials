/*
  https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
  You are given an unsorted array with both positive and negative elements.
  You have to find the smallest positive number missing from the array in O(n)
  time using constant extra space. You can modify the original array.
 */
fun example(input: List<Int>): Int {
    val sortedInput = input.filter { it > 0 }.distinct().sorted()

    var result = 1
    var resultFound = false
    var i = 0
    while (i < sortedInput.size) {
        if ((i + 1) != sortedInput[i]) {
            result = i + 1
            resultFound = true
            break
        }
        i++;
    }
    if (!resultFound) {
        result = sortedInput.last() + 1
    }
    return result
}

fun exampleWithBuckets(input: List<Int>): Int {
    val maxElement = input.maxOrNull() ?: 0
    val buckets = IntArray(maxElement + 2) { 0 }

    var i = 0
    while (i < input.size) {
        if (input[i] > 0) {
            buckets[input[i]] = 1
        }
        i++;
    }

    var result = 1
    var j = 1
    while (j < buckets.size) {
        if (buckets[j] == 0) {
            result = j
            break
        }
        j++;
    }
    return result
}

fun exampleFunctional(input: List<Int>): Int {
    var result = 0
    input.filter { it > 0 }
        .distinct()
        .sorted()
        .reduceIndexed { i, acc, data ->
            if (i != acc && result == 0) {
                result = i
            }
            data
        }.also {
            if (result == 0) {
                result = it + 1
            }
        }

    return result
}
