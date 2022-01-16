package com.example.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agenda.R;
import com.example.agenda.dao.AlunoDao;
import com.example.agenda.modelo.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        AlunoDao dao = new AlunoDao();
        final EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        final EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);
        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);

        botaoSalvar.setOnClickListener((view) -> {
               String nome = campoNome.getText().toString();
               String telefone = campoTelefone.getText().toString();
               String email = campoEmail.getText().toString();
               Aluno alunoCriado = new Aluno(nome, telefone, email);
               dao.salvar(alunoCriado);
               startActivity(new Intent(FormularioAlunoActivity.this, ListaAlunosActivity.class));

       });


    }
}