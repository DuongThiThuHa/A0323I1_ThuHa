package org.example.repository;

import org.example.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepo implements ICustomerRepo{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> customerTypedQuery = entityManager.createQuery("select c from Customer c", Customer.class);
        return customerTypedQuery.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> customerTypedQuery = entityManager.createQuery("select c from Customer c where c.id=:id",Customer.class);
        customerTypedQuery.setParameter("id",id);
        try {
            return customerTypedQuery.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer != null){
            entityManager.remove(customer);
        }
    }
}
