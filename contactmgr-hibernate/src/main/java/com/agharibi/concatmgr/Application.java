package com.agharibi.concatmgr;

import com.agharibi.concatmgr.model.Contact;
import com.agharibi.concatmgr.model.Contact.ContactBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created by Armen on 6/23/16.
 */
public class Application {

    //Hold a reuseable refernce to a sessionFactory
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        // ServiceRegistery gives us access to Hibernate main services, including
        // Hiberante JDBC connectivity, Hibernate configuration via XML,
        // Importing initial database data from a SQL file if we needed to
        // Building a SessionFactory.
        final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

        // MetaDataSources encapsulate all the ORM mappings loaded from annotated Entities.
        return new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }

    public static void main(String[] args) {
        Contact contact = new ContactBuilder("Armen", "Gharibi")
                .withEmail("a.gharibi@yahoo.com")
                .withPhone(8586002332L)
                .build();
        int id = save(contact);

        // Display a list of contacts before the update
        fetchAllContacts().stream().forEach(System.out::println);

        // Get the persisted contact
        Contact c  = findContactById(id);

        // Update the contact
        c.setFirstName("Daniella");

        // Persistd the changes
        update(c);

        // Display a list of contacts after the update
        fetchAllContacts().stream().forEach(System.out::println);
    }


    @SuppressWarnings("unchecked")
    private static List<Contact> fetchAllContacts() {
        // Open a session
        Session session = sessionFactory.openSession();

        // Create a criteria Object
        Criteria criteria = session.createCriteria(Contact.class);

        // Get a list of contact object according to the criteria object
        List<Contact> contacts = criteria.list();

        // Close the session
        session.close();
        return contacts;
    }

    private static int save(Contact contact) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Use the session to save the contact
        int id = (int) session.save(contact);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
        return id;
    }

    private static Contact findContactById(int id) {
        // open a session
        Session session = sessionFactory.openSession();

        //Retrieve the persistant objec
        Contact contact = session.get(Contact.class,id);

        // Close the session
        session.close();
        //Return the object
        return contact;
    }

    private static void update(Contact contact){
        // Open a session
        Session session = sessionFactory.openSession();
        // Use a transaction
        session.beginTransaction();
        // Use the session to update the contact
        session.update(contact);
        // Commit the transaction
        session.getTransaction().commit();
        // Close the session
        session.close();
    }

    private static void delete(Contact contact) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(contact);
        session.getTransaction().commit();
        session.close();
    }

}
