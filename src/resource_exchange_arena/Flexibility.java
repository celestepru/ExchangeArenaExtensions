package resource_exchange_arena;

import java.util.ArrayList;

public class Flexibility {

    int maxValue;
    int minValue;
    int[] flexibilityCurve;

    /**
     *
     * @param maxDistance - The maximum distance in terms of hours acceptable by the agent. Can be set to match number of wanted slots.
     */
    Flexibility(int maxDistance) {
        maxValue = 100;
        minValue = 0;
        //Check flexibility is not negative
        if(maxDistance<minValue) {
            System.out.println("Flexibility must be at least " + minValue);
            return;
        }
        //Increment to include 0 in case of exceeding limit
        maxDistance++;
       // System.out.println("mx" + maxDistance);
        flexibilityCurve = new int[maxDistance];

        //Calculate value to decrement from maxValue each time. This allows an even spread of values
        int decrement = maxValue/(maxDistance-1);

        //populate the curve
        for(int i = 0; i<flexibilityCurve.length; i++) {
            flexibilityCurve[i] = maxValue-(decrement*i);
        }
    }
    int[] getFlexibilityCurve() {
        return flexibilityCurve;
    }

}
