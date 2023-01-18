package com.example.isevwvaleba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.isevwvaleba.databinding.ActivityRegistriaciaaBinding
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text
private lateinit var binding : ActivityRegistriaciaaBinding
private lateinit var emaili : TextView
private lateinit var paroli : TextView
private lateinit var confirmi : TextView
private lateinit var ghilaki : TextView
private lateinit var firebaseAuth : FirebaseAuth


class registriaciaa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistriaciaaBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setContentView(R.layout.activity_registriaciaa)

        emaili = findViewById(R.id.emailregi)
        paroli = findViewById(R.id.paroliregi)
        confirmi = findViewById(R.id.paroliconfirm)
        ghilaki = findViewById(R.id.signupbutton)



firebaseAuth = FirebaseAuth.getInstance()
    ghilaki.setOnClickListener() {

        val emaili1 = emaili.text.toString()
        val paroli1 = paroli.text.toString()
        val confirmi1 = confirmi.text.toString()
        if(paroli1.isEmpty() || confirmi1.isEmpty() ){

            Toast.makeText(this, "ერთ-ერთი ველი ცარიელია", Toast.LENGTH_SHORT).show()

        }else  if(emaili1.contains('@') ==false){
            Toast.makeText(this, "მეილის ველი არასწორია", Toast.LENGTH_SHORT).show()
        }
        if(paroli1==confirmi1 && paroli1.isEmpty()==false && confirmi1.isEmpty()==false && emaili1
        .contains('@')){


           firebaseAuth.createUserWithEmailAndPassword(emaili1,paroli1).addOnCompleteListener {
              if(it.isSuccessful){

                  startActivity(Intent(this, MainActivity::class.java))
                  Toast.makeText(this, "წარმატებით გაიარეთ რეგისტრაცია", Toast.LENGTH_LONG).show()

              }else{
                  Toast.makeText(this, "რაღაც რიგზე ვერაა", Toast.LENGTH_SHORT).show()
              }



           }
        }

        if(paroli1!=confirmi1){
            Toast.makeText(this, "პაროლები არ ემთხვევა", Toast.LENGTH_SHORT).show()
        }

    }
    }
}