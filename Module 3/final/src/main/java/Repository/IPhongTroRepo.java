package Repository;

import Model.PhongTro;

import java.util.List;

public interface IPhongTroRepo {
    List<PhongTro> findAll();

    PhongTro findByID(String id);

}
