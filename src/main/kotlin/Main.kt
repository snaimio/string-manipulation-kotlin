package org.example

fun main() {
    println("=== String Analysis 2026 ===\n")

    val sentences = listOf(
        "The brown fox jumps over the lazy dog",
        "Kotlin makes coding fun and efficient",
        "A quick brown fox jumps over the lazy dog",
        "Hello world",
        "a b c d e f g",
        ""
    )

    sentences.forEach { sentence ->
        if (sentence.isNotEmpty()) {
            analyzeShortestWords(sentence)
            println("\n" + "=".repeat(50) + "\n")
        }
    }
}

data class ShortestWordsResult(
    val words: List<String>,
    val length: Int,
    val count: Int,
    val totalWords: Int,
    val longestWords: List<String>,
    val longestLength: Int,
    val averageLength: Double
)

fun findShortestWordsWithStats(input: String): ShortestWordsResult? {
    val words = input
        .split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }

    if (words.isEmpty()) return null

    val minLength = words.minOf { it.length }
    val maxLength = words.maxOf { it.length }
    val shortestWords = words.filter { it.length == minLength }
    val longestWords = words.filter { it.length == maxLength }
    val averageLength = words.map { it.length }.average()

    return ShortestWordsResult(
        words = shortestWords,
        length = minLength,
        count = shortestWords.size,
        totalWords = words.size,
        longestWords = longestWords,
        longestLength = maxLength,
        averageLength = averageLength
    )
}

fun analyzeShortestWords(input: String) {
    println("📝 Analyzing: '$input'\n")

    val stats = findShortestWordsWithStats(input)

    if (stats == null) {
        println("❌ No words found.")
        return
    }

    println("📊 Word Statistics:")
    println("  Total words: ${stats.totalWords}")
    println("  Average length: %.2f".format(stats.averageLength))

    println("\n🔤 Shortest Words (${stats.length} characters):")
    if (stats.count == 1) {
        println("    ${stats.words.first()}")
    } else {
        stats.words.forEachIndexed { index, word ->
            println("    ${index + 1}. '$word'")
        }
        println("    (${stats.count} words tied for shortest)")
    }

    println("\n🔤 Longest Words (${stats.longestLength} characters):")
    stats.longestWords.forEachIndexed { index, word ->
        println("    ${index + 1}. '$word'")
    }

    // Find unique shortest words (case-insensitive)
    val uniqueShortest = stats.words.map { it.lowercase() }.distinct()
    if (uniqueShortest.size < stats.count) {
        println("\n🔄 Unique shortest words (case-insensitive):")
        uniqueShortest.forEach { word ->
            println("    • $word")
        }
    }
}

// Extension functions for convenience
fun String.shortestWords(): List<String> {
    return this.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }
        .let { words ->
            if (words.isEmpty()) emptyList()
            else {
                val minLength = words.minOf { it.length }
                words.filter { it.length == minLength }
            }
        }
}

fun String.shortestWord(): String? = shortestWords().firstOrNull()

fun String.longestWords(): List<String> {
    return this.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }
        .let { words ->
            if (words.isEmpty()) emptyList()
            else {
                val maxLength = words.maxOf { it.length }
                words.filter { it.length == maxLength }
            }
        }
}

fun String.longestWord(): String? = longestWords().firstOrNull()

fun String.wordCount(): Int {
    return this.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }
        .size
}

fun String.averageWordLength(): Double {
    val words = this.split(Regex("[^A-Za-z]+")).filter { it.isNotEmpty() }
    return if (words.isEmpty()) 0.0 else words.map { it.length }.average()
}

// Bonus: Find words starting with specific letter
fun String.wordsStartingWith(letter: Char): List<String> {
    return this.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() && it.first().lowercase() == letter.lowercase() }
}

// Bonus: Check if string is a palindrome (ignoring spaces and case)
fun String.isPalindrome(): Boolean {
    val cleaned = this.filter { it.isLetterOrDigit() }.lowercase()
    return cleaned == cleaned.reversed()
}