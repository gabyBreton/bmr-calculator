package td3.bmr.breton.util;

/**
 *
 * @author Gabriel Breton - 43397
 */
public interface Observable {
    
    public void addObserver(Observer o);

    public void deleteObserver(Observer o);

}
