package dao;

import entity.AdminEntity;
import org.hibernate.Query;

/**
 * Created by Uther on 2016/4/11.
 */
public class AdminDAO extends Dao {
    public AdminEntity getAdmin(int id){
        AdminEntity admin = null;

        try{
            begin();
            admin = (AdminEntity)getSession().get(AdminEntity.class,id);
            commit();
        }catch (Exception e){
            rollback();
            e.printStackTrace();
        }
        return admin;
    }

    public AdminEntity getAdmin(String username){
        AdminEntity admin = null;

        try{
            begin();
            Query q = getSession().createQuery("from AdminEntity where username=:username");
            q.setParameter("username",username);
            commit();
        }catch (Exception e){
            rollback();
            e.printStackTrace();
        }

        return admin;
    }


}
