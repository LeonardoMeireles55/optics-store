package com.leonardo.optics.store.infra.persistence;

import com.leonardo.optics.store.infra.constants.Roles;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "USERS")
public class UserEntity {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String cep;
    private String address;
    private String telephone;
    private String cpf;
    private Roles role;

    public UserEntity() {

    }

    public UserEntity(String firstName, String lastName, String password, String email, String cep,
                      String address, String telephone, String cpf, Roles role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.cep = cep;
        this.address = address;
        this.telephone = telephone;
        this.cpf = cpf;
        this.role = role;
    }

    public UserEntity(String firstName, String lastName, String password, String email, String cep,
                      String address, String telephone, String cpf) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.cep = cep;
        this.address = address;
        this.telephone = telephone;
        this.cpf = cpf;
        this.role = Roles.USER;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
