package RequestPayLoads;



import java.util.ArrayList;
import java.util.Random;

public class CreateUserPayLoad {
    public static void main(String[] args) {
        CreateUserPayLoad user1 = new CreateUserPayLoad();
        user1.anyUser();
    }


    public static ArrayList<String> createUserPayLoad() {
        ArrayList<String> users;
        users = new ArrayList<String>();
        String user = null;
        for (int i = 0; i < 100; i++){
            user = "{\n" +
                    "    \"name\": \"user" + i + "\",\n" +
                    "    \"job\": \"job" + i + "\"\n" +

                    "}";


            users.add(user);
        }
         return users;
    }

    public  static String anyUser(){

        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(createUserPayLoad().size());
        String us = createUserPayLoad().get(index);
        System.out.println(us);
        return  createUserPayLoad().get(index);

    }

}
