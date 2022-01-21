package com.example.agenda.dao;

import com.example.agenda.modelo.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salvar(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        contadorDeIds++;
    }

    public void edita(Aluno aluno) {
        Aluno alunoEncontrado = null;

        for (Aluno a :
                alunos) {
            if (a.getId() == aluno.getId()) {//verifica se o aluno existe
                alunoEncontrado = a;

            }
        }
        if (alunoEncontrado != null) {//garante que o alunofoi encontrado
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);//pega a posicao do aluno
            alunos.set(posicaoDoAluno, aluno);//subistitui pelo aluno que veio de fora (parametro)


        }
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);

    }
}
