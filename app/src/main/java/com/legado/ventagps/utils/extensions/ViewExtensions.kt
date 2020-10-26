package com.legado.ventagps.utils.extensions

import android.content.Context
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.inputmethod.InputMethodManager

fun View.fadeIn(duration: Int = 400) {
    clearAnimation()
    val alphaAnimation = AlphaAnimation(this.alpha, 1.0f)
    alphaAnimation.duration = duration.toLong()
    startAnimation(alphaAnimation)
}
fun View.showSoftKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    this.requestFocus()
    imm.showSoftInput(this, 0)
}
