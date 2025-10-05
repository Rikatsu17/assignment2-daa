# Insertion Sort Analysis – Assignment 2

## Author
Student: Adilbekov Daniyal
Group: SE-2435  
Course: Design and analysis of algorithms

## Overview
This project implements **Insertion Sort** with performance tracking and benchmarking using Java, Maven, and JUnit.  
It is part of Assignment 2: *Algorithmic Analysis and Peer Code Review*.

## Contents
algorithms/InsertionSort.java — insertion sort implementation with performance tracking and minor early-stop optimization.<br>

metrics/PerformanceTracker.java — counts comparisons, swaps, and array accesses (reads/writes).<br>

cli/BenchmarkRunner.java — command-line interface for benchmarking with multiple input sizes and data patterns.<br>

src/test/java/.../InsertionSortTest.java — JUnit 5 tests for small, sorted, reversed, and random arrays.<br>

docs/performance-plots/ — folder containing CSV outputs and runtime/comparison graphs.<br>

## Features
- Maven project structure with JUnit tests
- Performance metrics (comparisons, accesses, swaps)
- Command-line benchmark tool (`BenchmarkRunner`)
- Handles sorted, reverse-sorted, random, and nearly-sorted arrays

## Algorithm Details

| Case | Time Complexity | Space Complexity |
|------|------------------|------------------|
| Best | Θ(n) | O(1) |
| Average | Θ(n²) | O(1) |
| Worst | Θ(n²) | O(1) |

Optimizations:<br>

Early termination when the current element is already greater than the previous (avoids unnecessary comparisons).<br>

Minimal array writes — only shifts necessary elements, not every position.<br>

## Example Benchmark Output

N = 10000 <br>
Random Data: 28 ms <br>
Sorted Data: 0 ms<br>
Reverse Sorted: 45 ms<br>
Nearly Sorted: 0 ms<br>


## Repository Structure
assignment2-insertion-sort/<br>
├── src/<br>
│ ├── main/java/<br>
│ │ ├── algorithms/InsertionSort.java<br>
│ │ ├── metrics/PerformanceTracker.java<br>
│ │ └── cli/BenchmarkRunner.java<br>
│ └── test/java/algorithms/InsertionSortTest.java<br>
├── docs/<br>
│ ├── analysis-report.pdf<br>
│ └── performance-plots/<br>
├── README.md<br>
└── pom.xml<br>

## Conclusion

The implemented Insertion Sort algorithm successfully demonstrates the expected theoretical behavior:<br>

It performs efficiently on small and nearly sorted datasets, showing linear-like performance.<br>

It exhibits quadratic growth (Θ(n²)) in runtime and operations for large or reverse-sorted inputs, aligning with its theoretical complexity.<br>

Performance metrics collected by the PerformanceTracker confirm clear differences between best, average, and worst cases.<br>

Although Insertion Sort is not optimal for large datasets, it remains a valuable algorithm for educational analysis, stability testing, and hybrid sorting strategies (e.g., combining it with faster algorithms for small partitions).
The benchmarking results validate both correctness and scalability, providing a solid foundation for future optimization or algorithm comparison work.
