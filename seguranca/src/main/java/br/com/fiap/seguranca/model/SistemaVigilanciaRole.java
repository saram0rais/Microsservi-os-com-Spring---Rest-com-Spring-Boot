package br.com.fiap.seguranca.model;

public enum SistemaVigilanciaRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    SistemaVigilanciaRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
