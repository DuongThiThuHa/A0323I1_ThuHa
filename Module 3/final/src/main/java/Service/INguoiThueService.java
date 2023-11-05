package Service;

import Model.NguoiThue;

import java.util.List;

public interface INguoiThueService {
    List<NguoiThue> findAll();

    NguoiThue findByID(int id);
}
