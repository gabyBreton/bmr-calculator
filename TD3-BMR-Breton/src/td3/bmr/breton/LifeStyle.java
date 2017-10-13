package td3.bmr.breton;

/**
 * This enumeration contains all the life style values.
 * 
 * @author Gabriel Breton - 43397
 */
public enum LifeStyle {
    
    SEDENTARY ("Sédentaire"),
    LOW_ACTIV ("Peu actif"),
    ACTIV ("Actif"),
    VERY_ACTIV ("Fort actif"),
    EXTREM_ACTIV ("Extrêmement actif");
    
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
