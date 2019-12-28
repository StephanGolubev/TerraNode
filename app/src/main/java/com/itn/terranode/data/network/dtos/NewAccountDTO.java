package com.itn.terranode.data.network.dtos;

public class NewAccountDTO {

    private String name;

    private String email;

    private String password;

    private String sponsor_id;

    public NewAccountDTO(String name, String email, String password, String sponsor_id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.sponsor_id = sponsor_id;
    }
}
