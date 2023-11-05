package Repository;

import Model.Rent;

import java.util.List;

public interface IRentRepo {
    void add(Rent rent);

    List<Rent> findAll();
}
