package repository;

import model.Email;

import java.util.List;

public interface IEmailRepo {
    List<Email> findAll();
    public void update(Email email);
    public Email findById(String id);
}
