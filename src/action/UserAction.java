package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import entity.UserEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.json.annotations.JSON;

import java.io.InputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Uther on 2016/4/10.
 */
public class UserAction extends ActionSupport{
    private int id;
    private String username;
    private String password;
    private String email;
    private JSONArray json;
    private String type;
    private String birthday;
    private String message;



    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JSONArray getJson() {
        return json;
    }

    public void setJson(JSONArray json) {
        this.json = json;
    }

    public String saveUser(){
        json = new JSONArray();
        UserEntity user = new UserEntity(username,password);
        user.setUserType(type);
        user.setEmail(email);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
            Date date = sdf.parse(birthday);
            user.setBirthday(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        UserDAO dao = new UserDAO();
        dao.save(user);
        return SUCCESS;
    }

    public String login(){
        UserDAO dao = new UserDAO();
        UserEntity user = dao.getUser(username);
        if (user != null && user.getPassword().equals(password)){
            message = "登录成功！";
            return SUCCESS;
        }else if (user != null){
            message = "密码错误！";
            return "error";
        }
        message = "没有此用户";
        return SUCCESS;
    }

    public String editUser(){
        UserDAO dao = new UserDAO();
        UserEntity user = dao.getUser(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setUserType(type);
        dao.update(user);
        return SUCCESS;
    }

    public String deleteUser(){
        UserDAO dao = new UserDAO();
        UserEntity user = dao.getUser(id);
        dao.delete(user);
        return SUCCESS;
    }

    public String allUsers(){
        json = new JSONArray();
        UserDAO dao = new UserDAO();
        List<UserEntity> list = dao.getAllUsers();
        if (username != null && username.equals(""))
            username = null;
        if (type != null && (type.equals("") || type.equals("all")))
            type = null;
        for (UserEntity user : list){
            if (username != null && user.getUsername().equals(username) == false)
                continue;
            if (id != 0 && id != user.getUserId())
                continue;
            if (type != null && user.getUserType().equals(type) == false){
                continue;
            }
            Map<String,String> map = new HashMap<>();
            map.put("id",Integer.toString(user.getUserId()));
            map.put("username",user.getUsername());
            map.put("password",user.getPassword());
            map.put("email","dandi007@qq.com");
            map.put("type",user.getUserType());
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
            map.put("birthday",sdf.format(user.getBirthday()));
            json .add(new JSONObject().fromObject(map));
        }

        return SUCCESS;
    }



}
