package com.example.mycamera

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var imagen:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val captura:Button = findViewById(R.id.btnFoto)
        imagen = findViewById(R.id.imagenPhoto)
        captura.setOnClickListener {
            takePhoto()
        }
    }
    val getAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val bitmap = it.data?.extras?.get("data") as Bitmap
        imagen.setImageBitmap(bitmap)
    }
    fun takePhoto(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null){
            getAction
        }
    }
}