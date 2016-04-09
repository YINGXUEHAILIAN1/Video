package entity;

import java.sql.Date;

/**
 * Created by Uther on 2016/4/9.
 */
public class DownloadLogEntity {
    private int downloadId;
    private UserEntity user;
    private VideoEntity video;

    private Date downloadDate = new Date(System.currentTimeMillis());


    public DownloadLogEntity(){}

    public DownloadLogEntity(UserEntity user,VideoEntity video){
        this.user = user;
        this.video = video;
    }


    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public VideoEntity getVideo() {
        return video;
    }

    public void setVideo(VideoEntity video) {
        this.video = video;
    }

    public int getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(int downloadId) {
        this.downloadId = downloadId;
    }

    public Date getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(Date downloadDate) {
        this.downloadDate = downloadDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DownloadLogEntity that = (DownloadLogEntity) o;

        if (downloadId != that.downloadId) return false;
        if (downloadDate != null ? !downloadDate.equals(that.downloadDate) : that.downloadDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = downloadId;
        result = 31 * result + (downloadDate != null ? downloadDate.hashCode() : 0);
        return result;
    }
}
