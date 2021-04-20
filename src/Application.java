import dao.FilePersonDao;
import dao.SerializablePersonDao;
import dao.XMLPersonDao;
import exc.DaoException;
import model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) throws DaoException {
        Person amila = new Person("12323", "Amila", "Hasović", 13);
        Person aida = new Person("2435", "Aida", "Buza", 18);
        Person mitar = new Person("24554", "Mitar", "Zirojević", 23);
        Person amer = new Person("2323", "Amer", "Jahjaefendić", 43);
        Person benjamin = new Person("76878", "Benjamin", "Knežević", 13);
        List<Person> personList = new ArrayList<>(Arrays.asList(amila, aida, mitar, amer, benjamin));




        PersonPersistanceStrategy persistanceStrategy = new PersonPersistanceStrategy(new FilePersonDao());
        //PISATI PODATKE
        persistanceStrategy.writePersons(personList);//TXT
        persistanceStrategy.setPersonDao(new SerializablePersonDao());
        persistanceStrategy.writePersons(personList);//DAT
        persistanceStrategy.setPersonDao(new XMLPersonDao());
        persistanceStrategy.writePersons(personList);//XML
        //TESTIRATI ČITANJE LISTE IZ FAJLA
        //txt
        persistanceStrategy.setPersonDao(new FilePersonDao());
        List<Person> učitanePersone = persistanceStrategy.readPersons();
        učitanePersone.forEach(System.out::println);
        System.out.println();
        //dat
        persistanceStrategy.setPersonDao(new SerializablePersonDao());
        List<Person> serijalizovanePersone = persistanceStrategy.readPersons();
        serijalizovanePersone.forEach(System.out::println);
        //XML
        System.out.println();
        persistanceStrategy.setPersonDao(new XMLPersonDao());
        List<Person> xmlPersone = persistanceStrategy.readPersons();
        xmlPersone.forEach(System.out::println);
    }
}
