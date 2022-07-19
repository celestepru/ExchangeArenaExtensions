package resource_exchange_arena;

import java.util.ArrayList;

public class Flexibility {


    int[] flexibilityCurve;

    /**
     *
     * @param maxDistance - The maximum distance in terms of hours acceptable by the agent
     */
    Flexibility(int maxDistance) {
        if(maxDistance<0) {
            System.out.println("Flexibility must be at least 0");
            return;
        }
        maxDistance++;
        flexibilityCurve = new int[maxDistance];
        for(int i = 0; i<flexibilityCurve.length; i++) {
            if(i>0) {
                flexibilityCurve[i] = 0;
            }
        }
        int decrement = 100/maxDistance;
        for(int i = 0; i<flexibilityCurve.length; i++) {
            if(i==flexibilityCurve.length-1) {
                flexibilityCurve[i] = 0;
            } else {
                flexibilityCurve[i] = 100-(decrement*i);
            }
        }
    }

    int[] getFlexibilityCurve() {
        return flexibilityCurve;
    }
}
