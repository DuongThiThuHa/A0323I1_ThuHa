package Service;

import Model.PhongTro;

import java.util.List;

public interface IPhongTroService {
    List<PhongTro> findAll();
    PhongTro findByID(String id);

}
