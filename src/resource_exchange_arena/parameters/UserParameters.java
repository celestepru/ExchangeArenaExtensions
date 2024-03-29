package resource_exchange_arena.parameters;

public abstract class UserParameters extends FixedParameters {
    /**
     * Contains all system parameters that can be changed by the user in order to experiment with various scenarios.
     */

    // The seed can be set to replicate previous simulations.
    public static long seed = System.currentTimeMillis();
    // Example: "1599767866160L"
    // Alternatively if no specific seed is required...
    // Example: "System.currentTimeMillis()"

    // Name of the folder that will contain the set of simulations currently being ran.
    public static final String FOLDER_NAME = "D:/ResourceExchangeArena-d3097b823157675d7a00879ec8e57269a27abf92/results/Set_" + seed;


    // Conda env. location.
    public static final String PYTHON_EXE =
            "C:/Users/celes/anaconda3/envs/age/python";

    // Location of data visualiser python scripts on your machine.
    public static final String PYTHON_PATH =
            "D:/ResourceExchangeArena-d3097b823157675d7a00879ec8e57269a27abf92/src/data_analysis/";
    
    // Alter the population size.
    public static final int POPULATION_SIZE = 96;

    // Alter the number of timeslots that each agent requests each day.
    public static final int SLOTS_PER_AGENT = 4;

    // Alter the length of time to be simulated.
    public static final int DAYS = 500;
    // Example: "500"

    // Increase the number of simulation runs for more consistent results.
    public static final int SIMULATION_RUNS = 50;
    // Example: "50"

    // Days that will have the Agents average satisfaction over the course of the day, and satisfaction distribution at
    // the end of the day visualised.
    public static final int[] DAYS_OF_INTEREST = {1, 100, 200, 300, 400, 500};
    // Example: "{1, 100, 200, 300, 400, 500}"

    // Specify whether only a single agent type should exist in the simulation, used for establishing baseline results.
    public static boolean SINGLE_AGENT_TYPE = false;

    // Specify the single agent type to be simulated when 'SINGLE_AGENT_TYPE = true', e.g. 'SELFISH' or 'SOCIAL'.
    public static int SELECTED_SINGLE_AGENT_TYPE = SOCIAL;

    // Specify whether social capital should be used by the social agents.
    public static boolean USE_SOCIAL_CAPITAL = true;

    //Specify which type of social capital should be used by agents. 1 for individual, 2 for global.
    public static int SOCIAL_CAPITAL_TYPE = 2;

    // Specify whether flexibility (altruism) should be used by the social agents.
    // Parameter will not be useful without social capital enabled.
    public static boolean USE_FLEXIBILITY = true;

    //Specify the maximum distance acceptable by social agents performing altruistic exchanges.
    //Parameter will not be useful without flexibility enabled.
    // MUST BE HIGHER THAN 0
    public static int MAX_DISTANCE = 10;

    //Specify the threshold of kindness used by social agents.
    //Parameter will not be useful without flexibility enabled.
    public static int MARGIN_OF_KINDNESS = 50;
    // Example: 50

    //Specify whether to use a margin of reputation to assess agents in social capital exchanges.
    public static boolean USE_REPUTATION_MARGIN = false;

    // Arrays of demand used by the agents, when multiple curves are used the agents are split equally between the curves.
    // The arrays should have 1 value for each 10 minute segment of the day.
    public static final double[][] DEMAND_CURVES = {{1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0}};

    // The proportion of energy available for each hour of the of day.
    // The arrays should have 1 value for each 30 minute segment of the day.
    public static final int[] AVAILABILITY_CURVE = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

    // In order to schedule multiple parameter combinations when performing a parameter sweep, add more items to
    // the following arrays. All possible combinations will be simulated.
    // ################################################################################################################
    // Number of exchange rounds per day.
    public static final int[] EXCHANGES_ARRAY = {1,50,100,150,200};
    // Example: "{1,50,100,150,200};"

    // Percentage of agents that will evolve their strategy per day.
    // CURRENTLY MUST HAVE MORE THAN 1 VALUE
    public static final int[] PERCENTAGE_OF_AGENTS_TO_EVOLVE_ARRAY = {0, 100};
    // Example: "{0,50,100}" {0, 10, 25, 50,100}

    // Ratio of starting agent types, i.e. {SELFISH, SELFISH, SOCIAL} would cause the simulation to start with two
    // selfish agents for each social agent.
    // Note that both types of agents need to exist, for testing with a single agent type set 'SINGLE_AGENT_TYPE'
    // to 'true' and set the 'SELECTED_SINGLE_AGENT_TYPE' as required.
    public static final int[][] AGENT_TYPES_ARRAY = {{SELFISH, SOCIAL}};
    // Example: "{{SELFISH, SOCIAL}}"
    // ################################################################################################################

    // Sets the level of comparisons that will be made:
    // Note that this overrides some of the previously set parameters and can result in much longer compute times.
    // 0 = Only the parameter combinations set will be made.
    // 1 = The above combinations will be ran both with and without social capital enabled so that the results can
    //     be compared.
    // 2 = The above combinations will be ran both with and without social capital enabled and with only selfish agents
    //     and with only social agents so that a baseline comparison can be made between the agents types.
    public static int COMPARISON_LEVEL = 1;
}
