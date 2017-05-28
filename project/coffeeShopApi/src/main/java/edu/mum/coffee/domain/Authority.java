package edu.mum.coffee.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "authorities",
        indexes = {@Index(name = "ix_auth_username",
                columnList = "username,authority",
                unique = true)
        })
public class Authority {

    @Id
    private String username;
    @Enumerated(EnumType.STRING)
    private AuthorityType authority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "email",
            insertable = false, updatable = false)
    @JsonIgnore private Person person;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AuthorityType getAuthority() {
        return authority;
    }

    public void setAuthority(AuthorityType authority) {
        this.authority = authority;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }}