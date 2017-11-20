package td3.bmr.breton.util;

/**
 * Interface to implements for an observable object.
 *
 * @author Gabriel Breton - 43397
 */
public interface Observable {

    /**
     * Add an observer in the list of observers.
     *
     * @param o the observer to add.
     */
    public void addObserver(Observer o);

    /**
     * Add a variable number of observers.
     *
     * @param o the differents observers.
     */
    public void addAllObserver(Observer... o);

    /**
     * Deletes an observer from the list of observers.
     *
     * @param o the observer to delete.
     */
    public void deleteObserver(Observer o);

}
