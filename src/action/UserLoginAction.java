package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import entity.UserEntity;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Uther on 2016/4/11.
 */
public class UserLoginAction extends ActionSupport {
    private String message;
    private String username;
    private String password;
    private JSONObject json;

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

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public String login(){
        UserDAO dao = new UserDAO();
        UserEntity user = dao.getUser(username);
        Map<String,String> map = new HashMap<>();
        if (user != null && user.getPassword().equals(password)){
            message = "登录成功！";
            map.put("message",message);
            map.put("success","true");
            json = new JSONObject().fromObject(map);
            ActionContext.getContext().getSession().put("login_user",user);
            return SUCCESS;
        }else if (user != null){
            message = "密码错误！";
            map.put("message",message);
            map.put("success","false");
            json = new JSONObject().fromObject(map);
            return SUCCESS;
        }
        message = "没有此用户";
        map.put("message",message);
        map.put("success","false");
        json = new JSONObject().fromObject(map);
        return SUCCESS;
    }

}
