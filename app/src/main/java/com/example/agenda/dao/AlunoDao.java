package com.example.agenda.dao;

import androidx.annotation.Nullable;

import com.example.agenda.modelo.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salvar(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeIds++;
    }

    public void edita(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPeloId(aluno);
        if (alunoEncontrado != null) {//garante que o alunofoi encontrado
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);//pega a posicao do aluno
            alunos.set(posicaoDoAluno, aluno);//subistitui pelo aluno que veio de fora (parametro)


        }
    }

    @Nullable
    private Aluno buscaAlunoPeloId(Aluno aluno) {
        for (Aluno a :
                alunos) {
            if (a.getId() == aluno.getId()) {//verifica se o aluno existe
                return a;

            }
        }
        return null;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);

    }

    public void remove(Aluno aluno) {
        Aluno alunoDevolvido = buscaAlunoPeloId(aluno);
        if (alunoDevolvido != null) {
            alunos.remove(alunoDevolvido);
        }
    }
}
