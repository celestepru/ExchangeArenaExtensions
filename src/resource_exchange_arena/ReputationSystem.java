package resource_exchange_arena;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReputationSystem implements Mediator{
    ArrayList<ArrayList<Integer>> globalFavoursGiven;
    ArrayList<ArrayList<Integer>> globalFavoursOwed;
    ArrayList<Agent> agents;

    int maxSocialCap;

    public ReputationSystem() {
        agents = new ArrayList<>();
        globalFavoursGiven = new ArrayList<>();
        globalFavoursOwed = new ArrayList<>();
    }

    @Override
    public void registerAgent(Agent agent) {
        agents.add(agent);
        ArrayList<Integer> favoursOwedRelation = new ArrayList<>();
        ArrayList<Integer> favoursGivenRelation = new ArrayList<>();

        // Initially, no favours are owed or have been given to any other Agent.
        favoursOwedRelation.add(agent.agentID);
        favoursOwedRelation.add(0);

        favoursGivenRelation.add(agent.agentID);
        favoursGivenRelation.add(0);

        // Store a reference to the new relations in the Agents corresponding lists of relations.
        globalFavoursOwed.add(favoursOwedRelation);
        globalFavoursGiven.add(favoursGivenRelation);
    }


    public boolean getAgentReputationSt(int agentID) {
        int favoursGiven = 0;
        int favoursOwed = 0;
        for(ArrayList<Integer> given : globalFavoursGiven) {
            if(given.get(0) == agentID) {
                favoursGiven = given.get(1);
                break;
            }
        }
        for(ArrayList<Integer> owed : globalFavoursOwed) {
            if(owed.get(0) == agentID) {
                favoursOwed = owed.get(1);
                break;
            }
        }
        if(favoursOwed > favoursGiven) {
            return true;
        }
        return false;
    }

    public boolean getAgentReputationWithMargin1(int agentID) {
        int maxOwed = calculateMaxFavours();
        int margin = maxOwed-(maxOwed/3);
        int favoursGiven = 0;
        int favoursOwed = 0;
        for(ArrayList<Integer> given : globalFavoursGiven) {
            if(given.get(0) == agentID) {
                favoursGiven = given.get(1);
                break;
            }
        }
        for(ArrayList<Integer> owed : globalFavoursOwed) {
            if(owed.get(0) == agentID) {
                favoursOwed = owed.get(1);
                break;
            }
        }
        if(favoursOwed>favoursGiven) {
            if(favoursOwed-favoursGiven>25) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean getAgentReputation(int agentID) {
        int maxOwed = calculateMaxFavours();
        int margin = maxOwed-(maxOwed/3);
        int favoursGiven = 0;
        int favoursOwed = 0;
        for(ArrayList<Integer> given : globalFavoursGiven) {
            if(given.get(0) == agentID) {
                favoursGiven = given.get(1);
                break;
            }
        }
        for(ArrayList<Integer> owed : globalFavoursOwed) {
            if(owed.get(0) == agentID) {
                favoursOwed = owed.get(1);
                break;
            }
        }
        if(favoursOwed>favoursGiven) {
            if(favoursOwed>margin) {
                return true;
            }
        }
        return false;
    }

    public int calculateMaxFavours() {
        int maxOwed = 0;
        for(ArrayList<Integer> owed : globalFavoursOwed) {
            if(owed.get(1) > maxOwed) {
                maxOwed = owed.get(1);
            }
        }
        return maxOwed;
    }

    @Override
    public void updateFavoursOwed(int agentID, int update) {
        for(ArrayList<Integer> rep : globalFavoursOwed) {
            if(rep.get(0).equals(agentID)) {
                int currentFavours = rep.get(1);
                rep.set(1, currentFavours+update);
            }
        }
    }

    @Override
    public void updateFavoursGiven(int agentID, int update) {
        for(ArrayList<Integer> rep : globalFavoursGiven) {
            if(rep.get(0).equals(agentID)) {
                int currentFavours = rep.get(1);
                rep.set(1, currentFavours+update);
            }
        }
    }

}
