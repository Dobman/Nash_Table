package Nash;

import java.util.List;

public interface NashDao {
   int addNash( Nash nash);
   void deleteNash(String name);
   void showNash(String name);
   void showAllNash();
   void findNash(String name);
}
