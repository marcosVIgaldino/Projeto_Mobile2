package com.example.empregaeu4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.empregaeu4.databinding.ActivityMain2Binding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityMain2Binding
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var edngo = binding.edngo
        var eddesc = binding.eddesc
        var edhow = binding.edhow
        var bttadd = binding.btadd
        var bttlist = binding.buttonlist

        dbRef = FirebaseDatabase.getInstance().getReference("ONG")
        val database = Firebase.database
        val myRef: DatabaseReference = database.getReference("dadosdousuario")

        bttadd.setOnClickListener{
            val empName = edngo.text.toString()
            val empDesc = eddesc.text.toString()
            val empHow = edhow.text.toString()

            if(empName.isEmpty()){
                edngo.error = "Por favor insira um nome"
            }
            if(empDesc.isEmpty()){
                edhow.error = "Por favor insira uma descrição"
            }
            if(empHow.isEmpty()){
                edhow.error = "Por favor insira como doar"
            }

            val empId = dbRef.push().key!!

            val ONG = NGOModelo(empId, empName, empDesc, empHow)

            dbRef.child(empId).setValue(ONG)
                .addOnCompleteListener{
                    Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                    edngo.text.clear()
                    eddesc.text.clear()
                    edhow.text.clear()

                }.addOnFailureListener{err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }
        }
        bttlist.setOnClickListener{
            val intent = Intent(this, Listadeinst::class.java)
            startActivity(intent)
        }
    }

}