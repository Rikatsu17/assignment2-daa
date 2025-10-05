# Insertion Sort Analysis – Assignment 2

## Author
Student: Adilbekov Daniyal
Group: SE-2435  
Course: Design and analysis of algorithms

## Overview
This project implements **Insertion Sort** with performance tracking and benchmarking using Java, Maven, and JUnit.  
It is part of Assignment 2: *Algorithmic Analysis and Peer Code Review*.

## Features
- Maven project structure with JUnit tests
- Performance metrics (comparisons, accesses, swaps)
- Command-line benchmark tool (`BenchmarkRunner`)
- Handles sorted, reverse-sorted, random, and nearly-sorted arrays

## Complexity
| Case | Time Complexity | Space Complexity |
|------|------------------|------------------|
| Best | Θ(n) | O(1) |
| Average | Θ(n²) | O(1) |
| Worst | Θ(n²) | O(1) |

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

