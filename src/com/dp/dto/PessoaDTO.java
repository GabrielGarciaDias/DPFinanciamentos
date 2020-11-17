
package com.dp.dto;

import java.io.Serializable;


public class PessoaDTO implements Serializable {
    
    
    private String nome;

    private String endereco;
    private String telefone;
    private String cpfCnpj;
    private String rg;
    private String email;
    private String FlAtivo; 
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getFlAtivo() {
        return FlAtivo;
    }

    public void setFlAtivo(String FlAtivo) {
        this.FlAtivo = FlAtivo;
    }
    

    
    
}
