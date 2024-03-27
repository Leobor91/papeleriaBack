package com.leobor.papeleriawww.adapter;


import com.leobor.papeleriawww.domain.User;
import com.leobor.papeleriawww.persistence.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        // Datos de prueba
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "CC", "12345", "Juan", "Pérez", "juan@example.com", "123 Calle Principal", "1234567890", "juanperez", "password1"));
        userList.add(new User(2, "CC", "67890", "María", "Gómez", "maria@example.com", "123 Calle Principal", "1234567890","mariagomez", "password2"));

        // Configuración del comportamiento del repositorio mock
        when(userRepository.findAll()).thenReturn(userList);

        // Llamada al método bajo prueba
        List<User> result = userService.findAll();

        // Verificación del resultado
        assertEquals(userList.size(), result.size());
        assertEquals(userList.get(0), result.get(0));
        assertEquals(userList.get(1), result.get(1));
    }
    @Test
    void saveUserTest() {
        // Given
        User user = new User();
        user.setId(1L);
        user.setDocumentType("CC");
        user.setDocumentNumber("1234567890");
        user.setNombre("Juan");
        user.setApellido("Perez");
        user.setCorreo("juan@example.com");
        user.setUsername("jperez");
        user.setPassword("1234");

        when(userRepository.save(any(User.class))).thenReturn(user);

        // When
        User savedUser = userService.save(user);

        // Then
        assertNotNull(savedUser);
        assertEquals(1L, savedUser.getId());
        assertEquals("CC", savedUser.getDocumentType());
        assertEquals("1234567890", savedUser.getDocumentNumber());
        assertEquals("Juan", savedUser.getNombre());
        assertEquals("Perez", savedUser.getApellido());
        assertEquals("juan@example.com", savedUser.getCorreo());
        assertEquals("jperez", savedUser.getUsername());
        assertEquals("1234", savedUser.getPassword());
        verify(userRepository, times(1)).save(any(User.class));
    }


}