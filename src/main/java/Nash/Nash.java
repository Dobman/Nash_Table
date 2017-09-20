package Nash;


import com.sun.istack.internal.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


@Entity
public  class Nash  {
    @Id
    int nashId;
    @NotNull
    String name;
    String position;
    int bb;
    String range;
    String pushPosition;

    public String getPushPosition() {
        return pushPosition;
    }

    public void setPushPosition(String pushPosition) {
        this.pushPosition = pushPosition;
    }

    public  Nash(String position, int bb, List<String> range) {
        this.name = position + " " + bb ;
        this.position = position;
        this.bb = bb;
        StringBuilder sb = new StringBuilder();

        for(String s: range){
            sb.append(s).append(" ");
        }
        this.range = sb.toString();
    }
    public  Nash( String position, int bb, List<String> range, String pushPosition) {
        this.name = position + " " + bb ;
        this.position = position;
        this.bb = bb;
        StringBuilder sb = new StringBuilder();
        this.pushPosition = pushPosition;
        for(String s: range){
            sb.append(s).append(" ");
        }
        this.range = sb.toString();
    }

    @Override
    public String toString() {
        return "Nash{" +
                "nashId=" + nashId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", bb=" + bb +
                ", range='" + range + '\'' +
                '}';
    }

    public int getNashId() {
        return nashId;
    }

    public void setNashId(int nashId) {
        this.nashId = nashId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBb() {
        return bb;
    }

    public void setBb(int bb) {
        this.bb = bb;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
