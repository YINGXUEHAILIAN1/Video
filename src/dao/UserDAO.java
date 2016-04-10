package dao;

import constant.Constant;
import entity.UserEntity;
import entity.VideoEntity;
import org.hibernate.Query;

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

    public UserEntity getUser(String username){
        UserEntity user = null;
        try{
            begin();
            Query query = getSession().createQuery("from UserEntity where username=:username");
            query.setParameter("username",username);
            user = (UserEntity)query.uniqueResult();
            commit();
        }catch (Exception e){
            rollback();
            e.printStackTrace();
        }

        return user;
    }


    public static void main(String[] args){
        UserEntity user = new UserEntity("asdasd","s");
        UserDAO dao = new UserDAO();
        dao.save(user);
        VideoEntity video = new VideoEntity("fff",user,new byte[19]);
        dao.save(video);
        user.getCollections().add(video);
        dao.update(user);

        UserEntity nu = dao.getUser("asdasd");
        for (VideoEntity v : nu.getCollections()){
            System.out.println(v.getVideoName());
        }

    }
}
