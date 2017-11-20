package td3.bmr.breton.util;

import td3.bmr.breton.model.BMRCalculator;

/**
 * Interface to implements for an observer object.
 * 
 * @author Gabriel Breton - 43397
 */
public interface Observer {
    
    /**
     * Updates an observer.
     * 
     * @param person the person with its attributes with new values.
     */
    public void update(BMRCalculator person);    
}
