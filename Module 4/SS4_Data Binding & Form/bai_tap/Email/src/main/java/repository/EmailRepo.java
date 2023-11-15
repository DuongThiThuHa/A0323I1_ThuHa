package repository;

import model.Email;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailRepo implements IEmailRepo{
    private static Map<String, Email> emailMap;
    static {
        emailMap = new HashMap<>();
        emailMap.put("E01",new Email("E01","English",25,true,"ha"));
        emailMap.put("E02",new Email("E02","English",25,false,"nhi"));
        emailMap.put("E03",new Email("E03","English",25,false,"hoang"));
        emailMap.put("E04",new Email("E04","English",25,true,"toan"));
    }
    @Override
    public List<Email> findAll() {
        return new ArrayList<>(emailMap.values());
    }

    @Override
    public void update(Email email) {
        if (emailMap.containsKey(email.getMailID())){
            emailMap.put(email.getMailID(),email);
        }
    }

    @Override
    public Email findById(String id) {
        return emailMap.get(id);
    }
}
