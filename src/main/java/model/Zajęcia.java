package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Zajęcia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Sala sala;

    private boolean czyObowiązkowe;

    @Enumerated(EnumType.STRING)
    private TypZajęć typZajęć;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Przedmiot przedmiot;

    public Zajęcia() {
    }

    public Zajęcia(boolean czyObowiązkowe, TypZajęć typZajęć, Sala sala, Przedmiot przedmiot) {
        this.czyObowiązkowe = czyObowiązkowe;
        this.sala = sala;
        this.typZajęć = typZajęć;
        this.przedmiot = przedmiot;
    }

    @Override
    public String toString() {
        return "Zajęcia{" +
                "id=" + id +
                ", data=" + data +
                ", sala=" + sala +
                ", czyObowiązkowe=" + czyObowiązkowe +
                ", typZajęć=" + typZajęć +
                ", przedmiot=" + przedmiot +
                '}';
    }
}
