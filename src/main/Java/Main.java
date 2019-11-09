import dataBase.DAOImpl;
import domain.User;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        DAOImpl dao = new DAOImpl();

        List<User>  list = dao.getAllUsers();
        Stream<User> userStream = list.stream();
        userStream.forEach(x -> {
            System.out.println(x.getName());
            System.out.println(x.getEmail());
            System.out.println(x.getPassword());
            System.out.println(x.getGender());
            System.out.println("--------------------------");
        });
    }
}
