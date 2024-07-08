package br.com.fiap.seguranca.model;

public enum HabitanteRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    HabitanteRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}

