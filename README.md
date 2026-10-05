<div align="center">

# 🔡 Kotlin String & Lexical Analysis Engine
### Idiomatic Kotlin String Tokenization, Statistical Text Analytics & Metric Evaluation

[![Kotlin](https://img.shields.io/badge/Kotlin-2.0%2B-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![JVM](https://img.shields.io/badge/JVM-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Gradle](https://img.shields.io/badge/Build-Gradle%20Kotlin%20DSL-02303A?style=for-the-badge&logo=gradle&logoColor=white)](https://gradle.org/)
[![License](https://img.shields.io/badge/License-MIT-CEFF00?style=for-the-badge&logoColor=black)](LICENSE)

<br/>

**An algorithmic string processing and lexical evaluation toolkit in Kotlin demonstrating functional transformations, regex tokenization, immutable data models, and statistical distribution analytics.**

<br/>

[Overview](#-technical-overview) •
[Features](#-key-features) •
[How to Run](#-how-to-build-and-run) •
[License](#-license)

</div>

<br/>

---

## 📌 Technical Overview

This repository demonstrates idiomatic Kotlin functional programming applied to text parsing and lexical analysis. It implements robust regular expression delimiters, statistical aggregations (word counts, min/max length distributions, character averages), and type-safe `data class` result modeling.

---

## ✨ Key Features

- **Regex-Driven Tokenization**: Sanitizes input strings and splits across arbitrary punctuation and whitespace boundaries using `Regex("[^A-Za-z]+")`.
- **Lexical Aggregation & Metric Scoring**:
  - Minimum and maximum word length identification (`minOf`, `maxOf`).
  - Average word length statistical computations (`.average()`).
  - Frequency counts and tie-breaking collection extractions.
- **Immutable Data Modeling**: Strongly-typed `ShortestWordsResult` data structures encapsulating analysis metrics.
- **Edge Case Resilience**: Safe handling for empty strings, uniform sequences, and multi-symbol noise.

---

## 🛠️ Tech Stack & Concepts

- **Language**: Kotlin 2.0+ (JVM target 17+)
- **Build System**: Gradle (Kotlin DSL)
- **Paradigms**: Functional programming, higher-order collection processing, immutability, pattern matching

---

## 🚀 How to Build and Run

### Prerequisites
- JDK 17 or newer

### Execution
```bash
# Clone the repository
git clone https://github.com/snaimio/string-manipulation-kotlin.git
cd string-manipulation-kotlin

# Build and run with Gradle
./gradlew run
```

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
