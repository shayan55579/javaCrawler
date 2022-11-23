package ir.roshd.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class UserAgentManagement {
    private List<String> userAgents = new ArrayList<>();
    private static UserAgentManagement uam;
    public final Selector<String> randomSelector = new RandomSelector<>();
    public final Selector<String> orderSelector = new OrderedSelector<>();


    private UserAgentManagement(){
    }

    public static UserAgentManagement instance(){
        if(uam == null){
            uam = new UserAgentManagement();
        }
        return uam;
    }

    public void addAgent(String agent){
        userAgents.add(agent);
    }

    public String getAnItem(Selector<String> selector){
        return selector.select(userAgents);
    }


}
