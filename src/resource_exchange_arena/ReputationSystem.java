package resource_exchange_arena;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReputationSystem implements Mediator{
    ArrayList<ArrayList<Integer>> globalFavoursGiven;
    ArrayList<ArrayList<Integer>> globalFavoursOwed;
    ArrayList<Agent> agents;

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


    /**
     * Getter method for agent reputation. Picks a method based on whether a reputation margin is enabled.
     *
     * @param agentID The agent to be assessed.
     * @return Return true if the agent has positive social capital, false if it doesn't.
     */
    @Override
    public boolean getAgentReputation(int agentID) {
        if(ResourceExchangeArena.USE_REPUTATION_MARGIN) {
            return getAgentReputationWithMargin(agentID);
        } else {
            return getAgentReputationWithoutMargin(agentID);
        }
    }

    /**
     * Get an agent's reputation from the list. Return a result without using a threshold of reputation.
     *
     * @param agentID The agent to be assessed.
     * @return Return true if the agent has positive social capital, false if it doesn't.
     */
    public boolean getAgentReputationWithoutMargin(int agentID) {
        int favoursGiven = 0;
        int favoursOwed = 0;
        //Find agent in list of favours it has been given
        for(ArrayList<Integer> given : globalFavoursGiven) {
            if(given.get(0) == agentID) {
                favoursGiven = given.get(1);
                break;
            }
        }
        //Find agent in list of favours it is owed
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

    /**
     * Get an agent's reputation from the list. Return a result using a threshold of reputation:
     * an agent's reputation must be higher than 2/3 of the maximum social capital in the system.
     *
     * @param agentID The agent to be assessed.
     * @return Return true if the agent has positive social capital, false if it doesn't.
     */
    public boolean getAgentReputationWithMargin(int agentID) {
        int maxOwed = calculateMaxFavours();    //find maximum favours given
        int margin = maxOwed-(maxOwed/3);   //Calculate 2/3
        int favoursGiven = 0;
        int favoursOwed = 0;
        //Find agent in list of favours it has been given
        for(ArrayList<Integer> given : globalFavoursGiven) {
            if(given.get(0) == agentID) {
                favoursGiven = given.get(1);
                break;
            }
        }
        //Find agent in list of favours it is owed
        for(ArrayList<Integer> owed : globalFavoursOwed) {
            if(owed.get(0) == agentID) {
                favoursOwed = owed.get(1);
                break;
            }
        }
        //Assess favours with margin
        if(favoursOwed>favoursGiven) {
            if(favoursOwed>margin) {
                return true;
            }
        }
        return false;
    }


    /**
     * Find maximum number of favours given in the system.
     *
     * @return maximum number of favours given in the system.
     */
    public int calculateMaxFavours() {
        int maxOwed = 0;
        for(ArrayList<Integer> owed : globalFavoursOwed) {
            if(owed.get(1) > maxOwed) {
                maxOwed = owed.get(1);
            }
        }
        return maxOwed;
    }

    /**
     * After an exchange is performed, updates the agent's global score of favours it is owed.
     *
     * @param agentID the agent whose reputation is to be updated
     * @param update the amount by which the reputation has to be updated. Can be positive or negative.
     */
    @Override
    public void updateFavoursOwed(int agentID, int update) {
        for(ArrayList<Integer> rep : globalFavoursOwed) {
            if(rep.get(0).equals(agentID)) {
                int currentFavours = rep.get(1);
                rep.set(1, currentFavours+update);
            }
        }
    }

    /**
     * After an exchange is performed, updates the agent's global score of favours it has given.
     *
     * @param agentID the agent whose reputation is to be updated
     * @param update the amount by which the reputation has to be updated. Can be positive or negative.
     */
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
