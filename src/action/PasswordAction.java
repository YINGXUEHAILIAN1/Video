package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import entity.UserEntity;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Uther on 2016/4/11.
 */
public class PasswordAction extends ActionSupport{
    private String username;
    private String email;
    private JSONObject json;

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String findPassword(){
        UserDAO dao = new UserDAO();
        UserEntity user = dao.getUser(username);

        Map<String,String> map = new HashMap<>();

        if (user == null){
            map.put("message","没有此用户！");
            map.put("success","false");
        }else{
            if (user.getEmail().equals(email) == false){
                map.put("message","邮箱填写错误！");
                map.put("success","false");
            }else{
                map.put("message","已经发送密码到邮箱！");
                map.put("success","true");
            }
        }

        json = new JSONObject().fromObject(map);
        return SUCCESS;
    }

}
