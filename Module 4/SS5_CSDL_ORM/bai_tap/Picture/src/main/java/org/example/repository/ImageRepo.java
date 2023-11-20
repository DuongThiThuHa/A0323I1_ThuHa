package org.example.repository;

import org.example.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ImageRepo implements IImageRepo{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Image image) {
        entityManager.persist(image);
    }

    @Override
    public List<Image> findAll() {
        return entityManager.createQuery("from images i").getResultList();
    }
}
