package com.example.isevwvaleba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.isevwvaleba.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var gadasvla : TextView
    private lateinit var registracia : TextView
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var mail : TextView
    private lateinit var parol : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_main)
        gadasvla = findViewById(R.id.signin)
        registracia = findViewById(R.id.signup)

        gadasvla.setOnClickListener{
            mail = findViewById(R.id.emailmain)
            parol = findViewById(R.id.passwordmain)
            val mail1 = mail.text.toString()
            val parol1 = parol.text.toString()



            if (parol1.isEmpty()==false && mail1.isEmpty()==false){

                firebaseAuth.signInWithEmailAndPassword(mail1,parol1).addOnCompleteListener{

                    if(it.isSuccessful){
                        startActivity(Intent(this,HomePage::class.java))
                    }else{
                        Toast.makeText(this, "ხარვეზია", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "ერთ-ერთი ველი ცარიელია", Toast.LENGTH_SHORT).show()
            }


        }
       registracia.setOnClickListener(){

           startActivity(Intent(this,registriaciaa::class.java))
       }
    }
}