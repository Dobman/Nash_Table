package Nash;

import java.util.List;

public class PushNash extends Nash  {

    public PushNash( String position, int bb, List<String> range) {
        super( position, bb, range);
        this.name = position + " " + bb;
    }

}
