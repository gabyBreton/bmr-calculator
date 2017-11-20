package td3.bmr.breton.model;

/**
 * This enumeration contains all the life style values.
 *
 * @author Gabriel Breton - 43397
 */
public enum Lifestyle {

    SEDENTARY("Sedentary"),
    LOW_ACTIV("Low active"),
    ACTIV("Active"),
    VERY_ACTIV("High active"),
    EXTREM_ACTIV("Extremely active");

    private final String lifeStyle;

    /**
     * Creates a lifestyle.
     *
     * @param lifeStyle
     */
    Lifestyle(String lifeStyle) {
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
