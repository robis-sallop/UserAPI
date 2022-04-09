package cl.rsalinas.api.model;

import java.util.Date;
import java.util.List;

public class UserDTO {

    private long user_id;
    private String name;
    private String email;
    private String password;
    private List<PhoneDTO> phones;
    private Date createDate;
    private Date modifieDate;
    private Date lastLogin;
    private boolean active;
    private String token;
    private MensajeDTO mensaje;

    public UserDTO(){}

    public UserDTO(long user_id, String name, String email, String password, List<PhoneDTO> phones, Date createDate, Date modifieDate, Date lastLogin, boolean active, String token, MensajeDTO mensaje) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.createDate = createDate;
        this.modifieDate = modifieDate;
        this.lastLogin = lastLogin;
        this.active = active;
        this.token = token;
        this.mensaje = mensaje;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifieDate() {
        return modifieDate;
    }

    public void setModifieDate(Date modifieDate) {
        this.modifieDate = modifieDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive(){ return active; }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }

    public MensajeDTO getMensaje() {
        return mensaje;
    }

    public void setMensaje(MensajeDTO mensaje) {
        this.mensaje = mensaje;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phones=" + phones +
                ", createDate=" + createDate +
                ", modifieDate=" + modifieDate +
                ", lastLogin=" + lastLogin +
                ", active=" + active +
                ", token='" + token + '\'' +
                ", mensaje=" + mensaje +
                '}';
    }
}
