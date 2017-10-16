package td3.bmr.breton.model;

/**
 * This enumeration contains all the life style values.
 * 
 * @author Gabriel Breton - 43397
 */
public enum LifeStyle {
    
    SEDENTARY ("Sedentary"),
    LOW_ACTIV ("Low activ"),
    ACTIV ("Activ"),
    VERY_ACTIV ("High activ"),
    EXTREM_ACTIV ("Extremely activ");
    
    private final String lifeStyle;
    
    /**
     * Creates a lifestyle.
     * 
     * @param lifeStyle 
     */
    LifeStyle (String lifeStyle) {
        this.lifeStyle = lifeStyle;
    }
    
    /**
     * Gives the lifestyle.
     * 
     * @return the lifestyle.
     */
    public String getLifeStyle() {
        return lifeStyle;
    }
    
    @Override
    public String toString() {
            return lifeStyle;
    }
    
    
}
