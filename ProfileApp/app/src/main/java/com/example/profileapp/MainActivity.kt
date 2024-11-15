package com.example.profileapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando componentes
        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val nameText = findViewById<TextView>(R.id.nameText)
        val descriptionText = findViewById<TextView>(R.id.descriptionText)
        val currentJobText = findViewById<TextView>(R.id.currentJobText)
        val experienceLayout = findViewById<LinearLayout>(R.id.experienceLayout)
        // Definindo informações de perfil
        nameText.text = "Francisco Paulino Arruda Filho"
        descriptionText.text = "Desenvolvedora de software com 2 anos de experiência."
        currentJobText.text = "Emprego Atual: Engenheira de Software na TechX"

        // Inicializando novos layouts
        val educationLayout = findViewById<LinearLayout>(R.id.educationLayout)
        val skillsLayout = findViewById<LinearLayout>(R.id.skillsLayout)
        val projectsLayout = findViewById<LinearLayout>(R.id.projectsLayout)

        // Lista de educação
        val educations = listOf(
            "Bacharelado em Engenharia de Software - UFC"
        )

        // Lista de habilidades
        val skills = listOf(
            "Java", "Git", "GitHub",
            "React", "TS", "JS", "Ionic", "PHP", "Firebase", "MySQL", "PSQL"
        )

        // Lista de projetos
        val projects = listOf(
            "Site musseu de Quixadá - Colaborador",
            "Sustainow - Colaborador",
            "SGEC - Colaborador"
        )

        // Adicionando educação dinamicamente
        for (education in educations) {
            val textView = TextView(this)
            textView.text = education
            textView.textSize = 16f
            educationLayout.addView(textView)
        }

        // Adicionando habilidades dinamicamente
        for (skill in skills) {
            val textView = TextView(this)
            textView.text = skill
            textView.textSize = 16f
            skillsLayout.addView(textView)
        }

        // Adicionando projetos dinamicamente
        for (project in projects) {
            val textView = TextView(this)
            textView.text = project
            textView.textSize = 16f
            projectsLayout.addView(textView)
        }


        // Lista de experiências
        val experiencias = listOf(
            "Analista de Sistemas - Empresa A",
            "Desenvolvedora Júnior - Empresa B",
            "Estagiário - Empresa C"
        )

        // Adicionando experiências dinamicamente
        for (experiencia in experiencias) {
            val textView = TextView(this)
            textView.text = experiencia
            textView.textSize = 16f
            experienceLayout.addView(textView)
        }

        profileImage.setOnClickListener {
            Toast.makeText(this, "Foto de perfil de Francisco Paulino Arruda Filho", Toast.LENGTH_SHORT).show()
        }
    }


}
