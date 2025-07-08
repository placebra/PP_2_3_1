package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void removeUser(int id){
        userDao.removeUser(id);
    }

    @Transactional
    @Override
    public void updateUserName(int id, String name){
        userDao.updateUserName(id, name);
    }

    @Transactional
    @Override
    public void updateUserDepartment(int id, String department){
        userDao.updateUserDepartment(id, department);
    }

    @Transactional
    @Override
    public void updateUserSalary(int id, Double salary){
        userDao.updateUserSalary(id, salary);
    }

}
