package service;

import model.Email;
import repository.EmailRepo;
import repository.IEmailRepo;

import java.util.List;

public class EmailService implements IEmailService{
    private IEmailRepo iEmailRepo = new EmailRepo();
    @Override
    public List<Email> findAll() {
        return iEmailRepo.findAll();
    }

    @Override
    public void update(Email email) {
        iEmailRepo.update(email);
    }

    @Override
    public Email findById(String id) {
        return iEmailRepo.findById(id);
    }
}
