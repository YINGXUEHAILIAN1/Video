package entity;

import java.sql.Date;

/**
 * Created by Uther on 2016/4/9.
 */
public class CollectLogEntity {
    private int collectId;
    private Date collectDate;

    public int getCollectId() {
        return collectId;
    }

    public void setCollectId(int collectId) {
        this.collectId = collectId;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectLogEntity that = (CollectLogEntity) o;

        if (collectId != that.collectId) return false;
        if (collectDate != null ? !collectDate.equals(that.collectDate) : that.collectDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = collectId;
        result = 31 * result + (collectDate != null ? collectDate.hashCode() : 0);
        return result;
    }
}
