package org.example.furama4.repository.role;

import org.example.furama4.model.role.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository< User, String > {
}
