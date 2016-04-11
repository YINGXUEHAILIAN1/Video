package entity;

import constant.Constant;
import org.apache.struts2.json.annotations.JSON;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Uther on 2016/4/9.
 */
public class UserEntity {
    private int userId;
    private String username;
    private String password;

    private String userType = Constant.NORMAL;
    private Date registerDate = new Date(System.currentTimeMillis());
    private String email = null;
    private String imagePath = null;
    private String sex = Constant.MALE;
    private Date birthday = null;
    private Set<VideoEntity> downloads = new HashSet<>();
    private Set<VideoEntity> collections = new HashSet<>();

    public UserEntity(){
    }

    public UserEntity(String username,String password){
        this.username = username;
        this.password = password;
    }

    public Set<VideoEntity> getDownloads() {
        return downloads;
    }

    @JSON(serialize=false)
    public void setDownloads(Set<VideoEntity> downloads) {
        this.downloads = downloads;
    }

    public Set<VideoEntity> getCollections() {
        return collections;
    }

    @JSON(serialize=false)
    public void setCollections(Set<VideoEntity> collections) {
        this.collections = collections;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (userType != null ? !userType.equals(that.userType) : that.userType != null) return false;
        if (registerDate != null ? !registerDate.equals(that.registerDate) : that.registerDate != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (imagePath != null ? !imagePath.equals(that.imagePath) : that.imagePath != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
