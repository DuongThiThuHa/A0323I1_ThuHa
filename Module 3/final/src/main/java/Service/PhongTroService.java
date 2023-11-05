package Service;

import Model.PhongTro;
import Repository.IPhongTroRepo;
import Repository.PhongTroRepo;

import java.util.List;

public class PhongTroService implements IPhongTroService{
    private IPhongTroRepo iPhongTroRepo = new PhongTroRepo();

    @Override
    public List<PhongTro> findAll() {
        return iPhongTroRepo.findAll();
    }

    @Override
    public PhongTro findByID(String id) {
        return iPhongTroRepo.findByID(id);
    }
}
