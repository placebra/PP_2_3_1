package web.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    //Сохранить пользователя
    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    //Получить всех пользователей
    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    //Получить пользователя по айди
    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    //Удалить пользователя
    @Override
    public void removeUser(int id) {
        Query query = em.createQuery("delete from User where id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    //Обновить имя
    @Override
    public void updateUserName(int id, String name) {
        Query query = em.createQuery("update User set name= :name where id= :id");
        query.setParameter("name", name);
        query.setParameter("id", id);
        query.executeUpdate();
    }


    //Обновить департамент
    @Override
    public void updateUserDepartment(int id, String department) {
        Query query = em.createQuery("update User set department= :department where id= :id");
        query.setParameter("department", department);
        query.setParameter("id", id);
        query.executeUpdate();
    }


    //Обновить зарплату
    @Override
    public void updateUserSalary(int id, Double salary) {
        Query query = em.createQuery("update User set salary= :salary where id= :id");
        query.setParameter("salary", salary);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
