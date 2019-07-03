package model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Przedmiot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ects;

    private String nazwaPrzedmiotu;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Prowadzący> prowadzący;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "przedmiot", fetch = FetchType.EAGER)
    private Set<Zajęcia> zajęcia;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "przedmioty", fetch = FetchType.EAGER)
    private Set<Student> studenci;

    public Przedmiot() {
    }

    public Przedmiot(String nazwaPrzedmiotu, int ects, Set<Prowadzący> prowadzący) {
        this.nazwaPrzedmiotu = nazwaPrzedmiotu;
        this.ects = ects;
        this.prowadzący = prowadzący;
    }

    @Override
    public String toString() {
        return "Przedmiot{" +
                "id=" + id +
                ", ects=" + ects +
                ", nazwaPrzedmiotu='" + nazwaPrzedmiotu + '\'' +
                ", prowadzący=" + prowadzący +
                ", zajęcia=" + zajęcia +
                ", studenci=" + studenci +
                '}';
    }
}

