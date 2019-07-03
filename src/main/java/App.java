import dbconnector.InicjalizacjaDanych;
import widok.WidokOgólny;

public class App {


    public static void main(String[] args) {

        InicjalizacjaDanych.inicjalizacjaDanych();
        WidokOgólny widokOgólny = new WidokOgólny();
        widokOgólny.wybórRoli();
    }
}
