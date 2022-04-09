package cl.rsalinas.api.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="PHONES")
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long phone_id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "citycode", nullable = false)
    private Integer citycode;

    @Column(name = "countrycode", nullable = false)
    private Integer countrycode;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity users;
}
