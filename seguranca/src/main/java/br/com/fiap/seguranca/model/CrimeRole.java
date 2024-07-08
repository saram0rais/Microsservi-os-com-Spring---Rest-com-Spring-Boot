package br.com.fiap.seguranca.model;

public enum CrimeRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    CrimeRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
