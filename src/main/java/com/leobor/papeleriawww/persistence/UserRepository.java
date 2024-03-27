package com.leobor.papeleriawww.persistence;

import com.leobor.papeleriawww.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByDocumentTypeAndDocumentNumber(String documentType, String documentNumber);

    User findByCorreo(String correo);

    User findByUsernameAndPassword(String username, String password);
}
