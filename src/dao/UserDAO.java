package dao;

import constant.Constant;
import entity.UserEntity;

import java.sql.Date;

/**
 * Created by Uther on 2016/4/9.
 */
public class UserDAO extends Dao {

    public static void main(String[] args){
        UserEntity user = new UserEntity();
        user.setImagePath(null);
        user.setBirthday(null);
        user.setEmail(null);
        user.setPassword("a");
        user.setUsername("b");
        user.setSex(Constant.MALE);
        user.setUserType(Constant.ARTIST);
        user.setRegisterDate(new java.sql.Date(System.currentTimeMillis()));
        new UserDAO().save(user);
    }
}
