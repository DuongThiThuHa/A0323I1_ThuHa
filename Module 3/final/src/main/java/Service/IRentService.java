package Service;

import Model.Rent;

import java.util.List;

public interface IRentService {
    void add(Rent rent);

    List<Rent> findAll();
}
