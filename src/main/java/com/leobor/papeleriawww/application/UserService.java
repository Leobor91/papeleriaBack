package com.leobor.papeleriawww.application;

import com.leobor.papeleriawww.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();


    User save(User user);

    User findByDocumentTypeAndDocumentNumber(String documentType, String documentNumber);

    User findByUsernameAndPassword(String username, String password);


}


