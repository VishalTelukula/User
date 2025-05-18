package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {
    Mock mock;
    Mockito mockito;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;
    User sampleUser;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleUser = new User();
        sampleUser.setId(1L);
        sampleUser.setfName("Vishal blah blah");
        sampleUser.setlName("Telukula");
    }
    @Test
    public void getAllUsersTest(){
       mockito.when(userRepository.findAll()).thenReturn(List.of(sampleUser));
        List<User> users = userService.getAllUsers();
        assertEquals("Vishal blah blah",users.get(0).getfName());
    }

}
