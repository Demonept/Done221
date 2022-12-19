package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      User user1 = new User("newUser", "newUserLast", "gmail@mail.com");
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      Car car1 = new Car("lada", 2312313);
      Car car2 = new Car("bmmw", 1231456);
      Car car3 = new Car("chevrole", 6663581);


      userService.add(user1);
      car1.setUser(user1);
      carService.add(car1);
      User user2 = new User("newUser2", "newUserLast2", "gmail2@mail.com");
      User user3 = new User("newUser3", "newUserLast3", "gmail3@mail.com");

      userService.add(user2);
      car2.setUser(user2);
      carService.add(car2);
      userService.add(user3);
      car3.setUser(user3);
      carService.add(car3);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      Object owner = carService.getUser("chevrole", 6663581);
      System.out.println(((User)owner).getFirstName() + " id : " +  ((User)owner).getId());
      context.close();
   }
}
