package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;

import java.util.List;

public class ClientDemo {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        Customer c1 = new Customer();
        c1.setName("Alias saketh");
        c1.setEmail("saketh@gmail.com");
        c1.setAge(19);
        c1.setLocation("vijayawada");

     

        session.save(c1);
        transaction.commit();

        @SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Customer.class);

        criteria.add(Restrictions.eq("name", "Alias saketh"));
        @SuppressWarnings("unchecked")
		List<Customer> equalResults = criteria.list();
        System.out.println("Equal Restriction: " + equalResults);

        criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.ne("name", "Alias saketh"));
        @SuppressWarnings("unchecked")
		List<Customer> notEqualResults = criteria.list();
        System.out.println("Not Equal Restriction: " + notEqualResults);

        criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.gt("age", 25));
        @SuppressWarnings("unchecked")
		List<Customer> greaterThanResults = criteria.list();
        System.out.println("Greater Than Restriction: " + greaterThanResults);

        criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.between("age", 20, 30));
        @SuppressWarnings("unchecked")
		List<Customer> betweenResults = criteria.list();
        System.out.println("Between Restriction: " + betweenResults);

        criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.like("location", "vijayawada%"));
        @SuppressWarnings("unchecked")
		List<Customer> likeResults = criteria.list();
        System.out.println("Like Restriction: " + likeResults);

        session.close();
    }
}
