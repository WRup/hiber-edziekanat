package model;


import javax.persistence.*;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numerSali;

    @OneToOne(mappedBy = "sala", fetch = FetchType.EAGER)
    private Zajęcia zajęcia;

    public Sala() {
    }

    public Sala(String numerSali) {
        this.numerSali = numerSali;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", numerSali='" + numerSali + '\'' +
                ", zajęcia=" + zajęcia +
                '}';
    }
}
