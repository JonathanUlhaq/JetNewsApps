package com.belajar.jetnewsapp.utils

class StatePercent {
    fun percent(
        allItem:Int,
        firstVisibleIndex:Int,
        allVisibleIndex: Int
    ):Float {
        return (firstVisibleIndex / (allItem - allVisibleIndex).toFloat())*100
    }
}