package resource_exchange_arena;

public interface Mediator {

    void registerAgent(Agent agentID);
    boolean getAgentReputation(int agentID);
    void updateFavoursGiven(int agentID, int update);
    void updateFavoursOwed(int agentID, int update);
    int getFavoursGiven(int agentID);
    int getFavoursOwed(int agentID);

    int getAgentType(int agentID);

}
