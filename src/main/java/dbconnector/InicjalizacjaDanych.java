package dbconnector;

import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

public class InicjalizacjaDanych {


    public static void inicjalizacjaDanych(){
        Session sesja = PostgresConnector.getSessionFactory().getCurrentSession();

        Transaction tanzakcja = sesja.beginTransaction();
        Sala sala = new Sala("12B");
        Sala sala1 = new Sala("55C");
        Sala sala2 = new Sala("12A");
        Sala sala3 = new Sala("204C");

        Prowadzący prowadzący1 = new Prowadzący("Jan", "Kowalski");
        Prowadzący prowadzący2 = new Prowadzący("Mariusz", "Bach");
        Prowadzący prowadzący3 = new Prowadzący("Barbara", "Mnich");


        Przedmiot przedmiot1 = new Przedmiot("Bazy Danych", 3, Set.of(prowadzący1, prowadzący2));
        Przedmiot przedmiot2 = new Przedmiot("Programowanie", 2, Set.of(prowadzący3, prowadzący2));
        Przedmiot przedmiot3 = new Przedmiot("Matematyka", 1, Set.of(prowadzący1, prowadzący3));

        Zajęcia zajęcia1 = new Zajęcia(true, TypZajęć.WYKŁAD, sala, przedmiot1);
        Zajęcia zajęcia2 = new Zajęcia(false, TypZajęć.ĆWICZENIA, sala1, przedmiot3);
        Zajęcia zajęcia3 = new Zajęcia(true, TypZajęć.PROJEKT, sala2, przedmiot2);
        Zajęcia zajęcia4 = new Zajęcia(true, TypZajęć.LABORATORIUM, sala3, przedmiot1);

        Student student1 = new Student(12425, "Karol", "Mały", Set.of(przedmiot1, przedmiot2));
        Student student2 = new Student(12352, "Michał", "Krupnik", Set.of(przedmiot1, przedmiot3));
        Student student3 = new Student(555324, "Marcin", "Nowak", Set.of(przedmiot3));

        sesja.saveOrUpdate(zajęcia1);
        sesja.saveOrUpdate(zajęcia2);
        sesja.saveOrUpdate(zajęcia3);
        sesja.saveOrUpdate(zajęcia4);
        sesja.saveOrUpdate(student1);
        sesja.saveOrUpdate(student2);
        sesja.saveOrUpdate(student3);


        tanzakcja.commit();

    }
}
