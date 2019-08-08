package com.uttampanchasara.baseprojectkotlin

import android.content.Context
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.view.View
import com.uttampanchasara.baseprojectkotlin.ui.base.BaseActivity
import java.text.SimpleDateFormat
import android.net.NetworkInfo
import android.content.Context.CONNECTIVITY_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.net.ConnectivityManager


/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 11/15/2018
 */
fun BaseActivity.showSnackbar(@StringRes message: Int,
                              @StringRes actionName: Int,
                              onActionClick: View.OnClickListener?) {
    Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
            .setAction(actionName, onActionClick)
            .show()
}

fun BaseActivity.showSnackbar(@StringRes message: Int) {
    Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
}

fun BaseActivity.showSnackbar(message: String) {
    Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
}

fun BaseActivity.showAlertDialog(dialogBuilder: AlertDialog.Builder.() -> Unit) {
    val builder = AlertDialog.Builder(this)
    builder.dialogBuilder()
    val dialog = builder.create()

    dialog.show()
}

fun getDateInFormat(date: String): String {
    var spf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val newDate = spf.parse(date)
    spf = SimpleDateFormat("dd/MM/YYYY HH:mm")

    return spf.format(newDate)
}

fun isConnected(context: Context): Boolean {
    val cm = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

    val activeNetwork = cm.activeNetworkInfo
    return activeNetwork != null && activeNetwork.isConnected
}