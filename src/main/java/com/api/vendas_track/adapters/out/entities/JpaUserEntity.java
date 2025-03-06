package com.api.vendas_track.adapters.out.entities;

import com.api.vendas_track.domain.enums.UserAccess;
import com.api.vendas_track.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class JpaUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserAccess access;


    public JpaUserEntity(Long id, String name, String email, String password, UserAccess access) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.access = access;
    }

    public JpaUserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.access = user.getAccess();
        this.password = user.getPassword();
    }
}