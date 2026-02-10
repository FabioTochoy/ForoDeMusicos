package foromusicos.apirestreto.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String clave;

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getClave() {
        return clave;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}

