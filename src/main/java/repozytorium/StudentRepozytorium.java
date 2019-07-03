package repozytorium;


import dbconnector.PostgresConnector;
import model.Student;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class StudentRepozytorium {

    public static List<Student> znajdźStudentaOPodanymNumerzeAlbumu(int nrAlbumu) {
        Session sesja = PostgresConnector.getSessionFactory().getCurrentSession();
        sesja.beginTransaction();
        NativeQuery sqlQuery = sesja.createSQLQuery("SELECT * FROM STUDENT WHERE NRALBUMU = :nrAlbumu");
        sqlQuery.addEntity(Student.class);
        List<Student> students = sqlQuery.setParameter("nrAlbumu", nrAlbumu).list();
        sesja.getTransaction().commit();
        return students;
    }
}
