//package com.example.workmanager
//
//class Example {
//}
//
//fun main() {
//
//}
//
//fun linerSearch(list: List<Int>, searchElement: Int): Int {
//    for (i in list) {
//        if (searchElement == list[i]) {
//            return list[i]
//        }
//
//
//    }
//    return -1
//}
//1/2/3/4/5/6/7/8/9/10
//
//
//fun binerySearch(list: List<Int>, searchElement: Int): Int {
//
//    var low = 0
//    var high = list.size - 1
//    var med: Int
//    while (low <= high) {
//        med = low + ((high - low) / 2)
//
//        when {
//            searchElement > med -> low = med + 1
//            searchElement == med -> return med
//            searchElement < med -> high = med - 1
//        }
//    }
//
//
//}