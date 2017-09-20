package Nash;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

public class CallNash extends Nash {
    String pushPosition;
    public CallNash( String position, int bb, List<String> range, String pushPosition) {
        super( position, bb, range);
        this.pushPosition = pushPosition;
        this.name = position + " " + bb;
        this.nashId = nashId;
    }


}
