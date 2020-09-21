package com.codejerry.序列化;


import java.io.*;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/09/21 21:34
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\76582\\Documents\\object.out"));
        oos.writeObject(new User("codeJerry", "123456", "男"));

        ObjectInputStream ois= new ObjectInputStream(new FileInputStream("C:\\Users\\76582\\Documents\\object.out"));
        User user = (User) ois.readObject();
        System.out.println(user.toString());
    }
}

class User implements Serializable {
    String name;
    String password;
    String sex;

    public User(String name, String password, String sex) {
        this.name = name;
        this.password = password;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
