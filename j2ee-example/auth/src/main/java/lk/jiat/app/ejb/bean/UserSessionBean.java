package lk.jiat.app.ejb.bean;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.jiat.app.core.model.User;
import lk.jiat.app.core.service.UserService;

@Stateless
public class UserSessionBean implements UserService {

    @PersistenceContext
    private EntityManager em;



    @Override
    public User getUserById(Long id) {
        User userId = em.find(User.class , id);
        return userId;
    }

    @Override
    public User getUserByEmail(String email) {
        return em.createNamedQuery("User.findByEmail", User.class).setParameter("email", email).getSingleResult();

    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @RolesAllowed({"USER","ADMIN","SUPER_ADMIN"})
    @Override
    public void updateUser(User user) {

        em.merge(user);
    }

    @RolesAllowed({"USER","ADMIN","SUPER_ADMIN"})
    @Override
    public void deleteUser(User user) {

        em.remove(user);
    }

    @Override
    public boolean validate(String email, String password) {

        User u = em.createNamedQuery("User.findByEmailAndPassword",User.class)
                .setParameter("email", email)
                .setParameter("password",password)
                .getSingleResult();

        return u != null;
    }
}
