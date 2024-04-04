# About
This repo demonstrates implementations of merge sort, heap sort, and insertion sort. It includes a framework to test these algorithms on arrays of varying sizes, from 100 to 200 million elements, analyzing their efficiency and suitability for different sizes of input. It is not recommended to increase past 200 million items in the array, as you will run out of heapspace.

To change the tested sorting method, change the marked line in the driver method test(): 

```java
            long start = System.currentTimeMillis();
            //***************************************
            MergeSort.sort(array); // Change this to switch to different sorts.
            //***************************************
            long timespan = System.currentTimeMillis() - start;
```

Available sorts are:
- MergeSort.sort()
- HeapSort.sort()
- InsertionSort.sort()
