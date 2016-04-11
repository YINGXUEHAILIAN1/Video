package entity;

import constant.Constant;

import java.sql.Date;
import java.util.Arrays;

/**
 * Created by Uther on 2016/4/9.
 */
public class VideoEntity {

    private int videoId;
    private String filePath;
    private String videoName;
    private UserEntity uploadUser;

    private int collectTime = 0;
    private int downloadTime = 0;
    private Date uploadDate = new Date(System.currentTimeMillis());
    private String isPublic = Constant.NOT_PUBLIC;
    private String reason = null;
    private String firstType = Constant.SHARE;
    private String secondType = null;
    private String status = Constant.WAIT;

    public VideoEntity(){

    }

    /**
     * 推荐的构造video的函数
     * @param videoName video名
     * @param uploadUser 上传用户
     * @param filePath 上传文件路径
     */
    public VideoEntity(String videoName,UserEntity uploadUser,String filePath){
        this.videoName = videoName;
        this.uploadUser = uploadUser;
        this.filePath = filePath;
    }

    public UserEntity getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(UserEntity uploadUser) {
        this.uploadUser = uploadUser;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFirstType() {
        return firstType;
    }

    public void setFirstType(String firstType) {
        this.firstType = firstType;
    }

    public String getSecondType() {
        return secondType;
    }

    public void setSecondType(String secondType) {
        this.secondType = secondType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public int getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(int collectTime) {
        this.collectTime = collectTime;
    }

    public int getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(int downloadTime) {
        this.downloadTime = downloadTime;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoEntity that = (VideoEntity) o;

        if (videoId != that.videoId) return false;
        if (collectTime != that.collectTime) return false;
        if (downloadTime != that.downloadTime) return false;
        if (!filePath.equals(that.filePath)) return false;
        if (firstType != null ? !firstType.equals(that.firstType) : that.firstType != null) return false;
        if (secondType != null ? !secondType.equals(that.secondType) : that.secondType != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (videoName != null ? !videoName.equals(that.videoName) : that.videoName != null) return false;
        if (uploadDate != null ? !uploadDate.equals(that.uploadDate) : that.uploadDate != null) return false;
        if (isPublic != null ? !isPublic.equals(that.isPublic) : that.isPublic != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = videoId;
        result = 31 * result + (filePath != null ? filePath.hashCode():0);
        result = 31 * result + (firstType != null ? firstType.hashCode() : 0);
        result = 31 * result + (secondType != null ? secondType.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (videoName != null ? videoName.hashCode() : 0);
        result = 31 * result + collectTime;
        result = 31 * result + downloadTime;
        result = 31 * result + (uploadDate != null ? uploadDate.hashCode() : 0);
        result = 31 * result + (isPublic != null ? isPublic.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        return result;
    }
}
