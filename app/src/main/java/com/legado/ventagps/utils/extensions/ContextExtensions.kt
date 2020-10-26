package com.legado.ventagps.utils.extensions

import android.content.Context
import android.net.ConnectivityManager

fun Context.getConnectivityManager() = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager