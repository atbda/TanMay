
import com.sony.config.HibernateConfig;
import com.sony.dao.UserDao;
import com.sony.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shahrukh
 */
public class TestUserDao {
    public static void main(String[] args) {
        ApplicationContext c=new AnnotationConfigApplicationContext(HibernateConfig.class);
        User u=new User();
        u.setName("bashah2");
        u.setUsername("king");
        u.setPassword("meking");
        u.setMobileNumber("904992786");
        u.setAddress("Hig 52 Bangalore");
        u.setRole("super admin");
        
        UserDao ud=(UserDao)c.getBean("udao");
        ud.save(u);
        
    }
}
