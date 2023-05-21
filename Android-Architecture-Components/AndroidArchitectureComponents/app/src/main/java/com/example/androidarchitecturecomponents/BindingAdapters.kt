package com.example.androidarchitecturecomponents

import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

/**
 * appProgressSclae이 값을 전달받을 때마다 BindingAdapters에서 자동으로 setProgress가 실행된다
 * */

@BindingAdapter("android:progress")
fun setProgress(progressBar: ProgressBar, counter: Int) {
    progressBar.progress = counter
}