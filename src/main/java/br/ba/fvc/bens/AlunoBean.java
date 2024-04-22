/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ba.fvc.bens;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author ALUNO TI
 */
@ManagedBean(name = "alBean")
@SessionScoped
public class AlunoBean {
    
    private List<Aluno> alunos;
    private Aluno alunoSelecionado;
    private boolean editar=false;

    public AlunoBean() {
        alunos = new ArrayList<Aluno>();
        alunoSelecionado=new Aluno();
    }

    
    
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Aluno getAlunoSelecionado() {
        return alunoSelecionado;
    }

    public void setAlunoSelecionado(Aluno alunoSelecionado) {
        this.alunoSelecionado = alunoSelecionado;
    }
    
    public String novo(){
        alunoSelecionado = new Aluno();
        editar=false;
        return "adicionar";
    }
    public void excluir(){
        alunos.remove(alunoSelecionado);
    }
    
    public String editar(){
        editar=true;
        return "adicionar";
    }
    
    public String salvar(){
        if (editar)
            alunos.set(alunos.indexOf(alunoSelecionado), alunoSelecionado);
        else alunos.add(alunoSelecionado);
        return "index";
    }
}