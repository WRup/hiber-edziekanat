package model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {

    public Student() {
    }

    @Id
    private int nrAlbumu;

    private String imię;

    private String nazwisko;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "przedmiot_id")}
    )
    private Set<Przedmiot> przedmioty;

    public Student(int nrAlbumu, String imię, String nazwisko, Set<Przedmiot> przedmioty) {
        this.nrAlbumu = nrAlbumu;
        this.imię = imię;
        this.nazwisko = nazwisko;
        this.przedmioty = przedmioty;
    }

    public String getImię() {
        return imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nrAlbumu=" + nrAlbumu +
                ", imię='" + imię + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", przedmioty=" + przedmioty +
                '}';
    }
}
