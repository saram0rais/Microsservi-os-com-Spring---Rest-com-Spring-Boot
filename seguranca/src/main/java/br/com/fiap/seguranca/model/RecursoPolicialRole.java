package br.com.fiap.seguranca.model;

public enum RecursoPolicialRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    RecursoPolicialRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

}