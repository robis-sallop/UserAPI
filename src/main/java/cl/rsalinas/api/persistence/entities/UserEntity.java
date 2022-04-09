package cl.rsalinas.api.persistence.entities;

import javax.persistence.*;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "created_date")
    private Date createDate;

    @Column(name = "modified_date")
    private Date modifieDate;

    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy="users")
    private List<PhoneEntity> phones;
}
