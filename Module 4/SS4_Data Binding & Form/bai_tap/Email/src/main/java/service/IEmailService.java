package service;

import model.Email;

import java.util.List;

public interface IEmailService {
    public List<Email> findAll();
    public void update(Email email);
    public Email findById(String id);
}
