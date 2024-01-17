package vn.service;

import vn.model.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface IBlogService extends IService< Blog > {
    List< Blog > findAllByName(String name);
}
