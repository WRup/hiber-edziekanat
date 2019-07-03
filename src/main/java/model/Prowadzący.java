package model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Prowadzący {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imię;

    private String nazwisko;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "prowadzący", fetch = FetchType.EAGER)
    private Set<Przedmiot> przedmioty;

    public Prowadzący() {
    }

    public Prowadzący(String imię, String nazwisko) {
        this.imię = imię;
        this.nazwisko = nazwisko;
    }
}
