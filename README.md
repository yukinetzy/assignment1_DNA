# Assignment 1 — Design and Analysis of Algorithms

## 1. Architecture Notes
This project includes four algorithms: MergeSort, QuickSort, Deterministic Select, and Closest Pair of Points.  
We track recursion depth, comparisons, and memory allocations using the `Metrics` class.
- MergeSort uses a reusable buffer.
- QuickSort uses a smaller-first recursion method to limit recursion depth.
- Deterministic Select uses the "Median of Medians" method to ensure good performance.

---

## 2. Recurrence Analysis

### MergeSort
Recurrence: `T(n) = 2T(n/2) + Θ(n)`  
Method: Master Theorem (Case 2)  
Result: `Θ(n log n)`

### QuickSort
Recurrence: `T(n) = T(k) + T(n-k-1) + Θ(n)`  
Method: Intuition from Akra–Bazzi theorem  
Result: average case `Θ(n log n)`, worst case `Θ(n²)`

### Deterministic Select
Recurrence: `T(n) = T(n/5) + T(7n/10) + Θ(n)`  
Method: Master Theorem / Akra–Bazzi  
Result: `Θ(n)`

### Closest Pair of Points
Recurrence: `T(n) = 2T(n/2) + Θ(n)`  
Method: Master Theorem (Case 2)  
Result: `Θ(n log n)`

---

## 3. Plots
Add here your experimental plots:
- Time vs n
- Depth vs n

---

## 4. Discussion
Our experiments match theory.  
MergeSort and Closest Pair have stable `Θ(n log n)` behavior.  
QuickSelect works in `Θ(n)` time.  
QuickSort usually works in `Θ(n log n)`, but depends on the pivot choice.  
Cache and memory allocation affect speed for big inputs.

---

## 5. Summary
The results agree with theory.  
Using recursion control and buffer reuse helps performance.  
All algorithms work for random and special test cases.

---

**Author:** Sultan

**Date:** 2025-09-28
