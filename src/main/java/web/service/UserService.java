package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    public void saveUser(User user);
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void removeUser(int id);

    public void updateUserName(int id, String name);
    public void updateUserDepartment(int id, String department);
    public void updateUserSalary(int id, Double salary);
}
