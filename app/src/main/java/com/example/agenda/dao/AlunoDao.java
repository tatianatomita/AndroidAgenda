package com.example.agenda.dao;

import com.example.agenda.modelo.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

    private final static List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunos.add(aluno);

    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);

    }
}
