package Service;

import Model.Rent;
import Repository.IRentRepo;
import Repository.RentRepo;

import java.util.List;

public class RentService implements IRentService{
    private IRentRepo iRentRepo = new RentRepo();
    @Override
    public void add(Rent rent) {
        iRentRepo.add(rent);
    }

    @Override
    public List<Rent> findAll() {
        return iRentRepo.findAll();
    }
}
