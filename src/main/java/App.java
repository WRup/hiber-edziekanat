import dbconnector.PostgresConnector;
import org.hibernate.Session;

public class App {


    public static void main(String[] args) {
        Session session = PostgresConnector.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.getTransaction().commit();


    }
}
