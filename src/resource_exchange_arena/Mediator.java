package resource_exchange_arena;

public interface Mediator {

    /**
     * Register an agent to the Mediator pattern. The Mediator has a list of all Agents in the environment.
     * @param agentID agent to be registered
     */
    void registerAgent(Agent agentID);

    /**
     * Get an agent's reputation from the global reputation system.
     *
     * @param agentID The agent to be assessed.
     * @return Return true if the agent has positive social capital, false if it doesn't.
     */
    boolean getAgentReputation(int agentID);

    /**
     * After an exchange is performed, updates the agent's global score of favours it has given.
     *
     * @param agentID the agent whose reputation is to be updated
     * @param update the amount by which the reputation has to be updated. Can be positive or negative.
     */
    void updateFavoursGiven(int agentID, int update);

    /**
     * After an exchange is performed, updates the agent's global score of favours it is owed.
     *
     * @param agentID the agent whose reputation is to be updated
     * @param update the amount by which the reputation has to be updated. Can be positive or negative.
     */
    void updateFavoursOwed(int agentID, int update);
}
