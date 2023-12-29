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

	public long getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(long phone_id) {
		this.phone_id = phone_id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getCitycode() {
		return citycode;
	}

	public void setCitycode(Integer citycode) {
		this.citycode = citycode;
	}

	public Integer getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(Integer countrycode) {
		this.countrycode = countrycode;
	}

	public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}
    
    
}
