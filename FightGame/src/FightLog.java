import java.util.ArrayList;
import java.util.List;

public class FightLog {
    List<String> list = new ArrayList<String>();

    public void add(String message){
        list.add(message);
    }



    public List<String> getMessages(){
        return list;
    }
}
