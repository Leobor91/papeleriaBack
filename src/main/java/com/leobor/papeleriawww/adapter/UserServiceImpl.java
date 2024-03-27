package com.leobor.papeleriawww.adapter;

import com.leobor.papeleriawww.application.UserService;
import com.leobor.papeleriawww.domain.User;
import com.leobor.papeleriawww.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        List<User> usuarios = userRepository.findAll();
        for (User usuario : usuarios) {
            System.out.println(usuario.toString());
        }
        return usuarios;
    }

    @Override
    public User save(User user) {
        return (userRepository.findByDocumentTypeAndDocumentNumber(user.getDocumentType(), user.getDocumentNumber()) == null && userRepository.findByCorreo(user.getCorreo()) == null) ? userRepository.save(user) : null;
    }

    @Override
    public User findByDocumentTypeAndDocumentNumber(String documentType, String documentNumber) {
        User user = userRepository.findByDocumentTypeAndDocumentNumber(documentType, documentNumber);
        return user == null ? null: user;

    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,password);
        return  user == null ? null : user;
    }
}
