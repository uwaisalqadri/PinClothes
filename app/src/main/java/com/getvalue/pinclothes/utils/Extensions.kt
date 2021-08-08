package com.getvalue.pinclothes.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

fun Context.showToast(msg: String) {
	Toast.makeText(
		this,
		msg,
		Toast.LENGTH_SHORT
	).show()
}

fun ImageView.loadImage(image: Any) {
	Glide.with(this)
		.load(image)
		.into(this)
}

fun View.showSnackBar(msg: String) {
	Snackbar.make(
		this,
		msg,
		Snackbar.LENGTH_SHORT
	).show()
}

fun Context.openLink(url: String) {
	val openLink = Intent(Intent.ACTION_VIEW)
	openLink.data = Uri.parse(url)
	this.startActivity(openLink)
}

fun Spinner.selectValue(value: Any) {
	for (item in 0 until this.count) {
		if (this.getItemAtPosition(item).equals(value)) {
			this.setSelection(item)
		}
	}
}

fun getCurrentDate(format: String): String {
	val formatter = SimpleDateFormat(format, Locale.getDefault())
	return formatter.format(Date())
}







