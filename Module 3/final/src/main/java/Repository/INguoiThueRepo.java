package Repository;

import Model.NguoiThue;

import java.util.List;

public interface INguoiThueRepo {
    List<NguoiThue> findAll();

    NguoiThue findByID(int id);
}
