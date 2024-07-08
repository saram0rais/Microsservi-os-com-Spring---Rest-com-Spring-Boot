package br.com.fiap.seguranca.model;

public enum EmergenciaRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    EmergenciaRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}

