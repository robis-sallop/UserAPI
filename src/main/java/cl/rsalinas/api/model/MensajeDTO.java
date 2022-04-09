package cl.rsalinas.api.model;

import org.springframework.beans.factory.annotation.Autowired;

public class MensajeDTO {
    private String mensaje;

    public MensajeDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "MensajeDTO{" +
                "mensaje='" + mensaje + '\'' +
                '}';
    }
}
