package dao;

import constant.Constant;
import entity.UserEntity;
import entity.VideoEntity;

import java.sql.Date;

/**
 * Created by Uther on 2016/4/9.
 */
public class UserDAO extends Dao {

    public UserEntity getUser(int id){
        UserEntity user = null;
        try{
            begin();
            user = (UserEntity)getSession().get(UserEntity.class,id);
            commit();
        }catch (Exception e){
            rollback();
            e.printStackTrace();
        }
        return user;
    }


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
        UserDAO dao = new UserDAO();
        dao.save(user);

        VideoEntity video = new VideoEntity();
        video.setFile(new byte[10]);
        video.setFirstType(Constant.ORIGIN);
        video.setSecondType("旅游");
        video.setIsPublic(Constant.NOT_PUBLIC);
        video.setStatus(Constant.WAIT);
        video.setUploadDate(new java.sql.Date(System.currentTimeMillis()));
        video.setVideoName("f");
        video.setUploadUser(user);
        dao.save(video);
        user.getCollections().add(video);
        dao.update(user);

        UserEntity nu = dao.getUser(user.getUserId());
        for (VideoEntity v : nu.getCollections()){
            System.out.println(v.getVideoName());
        }

    }
}
