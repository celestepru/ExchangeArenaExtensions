# Resource Exchange Arena with Global Social Capital and Altruism

_Author:_ Celeste Prussiani

### Work based on _Resource Exchange Arena 1.0_ by Nathan A. Brooks
https://github.com/NathanABrooks/ResourceExchangeArena

### Description
Smart energy refers to the integration of IT and electronics to build more reliable, engaging, and sustainable energy systems. While substituting traditional power systems with smart energy is considered ambitious, the step is essential to allow households to exclusively rely on Renewable Energy (RE) sources and address environmental concerns. The unpredictability of RE aggravates the problems linked to peak household energy consumption, which traditional price-based strategies such as demand-side management (DSM) have often been unsuccessful at mitigating. Multi-Agent Systems is a suitable methodology for problem domains such as energy optimisation, which involves complex, heterogenous entities, and is therefore being increasingly employed in smart grids for a variety of purposes.

An interesting MAS simulation is implemented by Brooks’ et al. (2020), who build an environment of selfish and social agents negotiating to manage peak consumption in a community of households. In the model, social agents collaborate through social capital, a measure of reciprocity which grants the proliferation of social agents and the ostracization of selfish agents from the environment. Research on literature about Artificial Intelligence and psychological game theory led to the formulation of two research questions about Brooks’ model, concerning the effects of introducing a global form of social capital and altruistic exchanges.

Global social capital involves agents assessing a reputation of others that is built upon the feedback from multiple agents in the system: once an exchange is completed, agents post their reviews to a Mediator interface, which can be consulted before an exchange as well.

Altruism involves social agents accepting exchanges that might be detrimental to their own satisfaction, with the hopes that their kindness will grant them positive feedback from other agents and that their sacrifice will be reciprocated. Social agents assess how profitable a timeslot is for them and for the requesting agents; if the requesting agent’s gain is higher than their own by a user-specified margin of kindness, then they will accept the exchange.

Amongst a range of positive differences, the experiments reveal that global reputation aids the speed of the expulsion of selfish agents from the environment, while altruism grants higher satisfactions in social agents when learning is not available in the environment.
