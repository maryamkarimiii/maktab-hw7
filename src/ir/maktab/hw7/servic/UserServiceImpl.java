package ir.maktab.hw7.servic;

import ir.maktab.hw7.modle.Patient;
import ir.maktab.hw7.repository.UserRepository;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl userService;

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if (userService == null)
            userService = new UserServiceImpl();
        return userService;
    }

    UserRepository userRepository = UserRepository.getInstance();

    @Override
    public boolean register(Patient patient) throws SQLException {
        return userRepository.addUser(patient);
    }
    @Override
    public Patient logIN(String userName, String password) throws SQLException {
        return userRepository.selectUser(userName, password);
    }
}
