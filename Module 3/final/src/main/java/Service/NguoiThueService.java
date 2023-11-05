package Service;

import Model.NguoiThue;
import Repository.INguoiThueRepo;
import Repository.NguoiThueRepo;

import java.util.List;

public class NguoiThueService implements INguoiThueService{
    private INguoiThueRepo iNguoiThueRepo = new NguoiThueRepo();
    @Override
    public List<NguoiThue> findAll() {
        return iNguoiThueRepo.findAll();
    }

    @Override
    public NguoiThue findByID(int id) {
        return iNguoiThueRepo.findByID(id);
    }
}
