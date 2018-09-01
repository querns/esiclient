package gbsio.esiclient.api.domain.response.common;

public interface Attributes {
    /**
     * Gets the character's charisma attribute.
     *
     * @return the charisma attribute
     */
    int getCharisma();

    /**
     * Gets the character's intelligence attribute.
     *
     * @return the intelligence attribute
     */
    int getIntelligence();

    /**
     * Gets the character's memory attribute.
     *
     * @return the memory attribute
     */
    int getMemory();

    /**
     * Gets the character's perception attribute.
     *
     * @return the perception attribute
     */
    int getPerception();

    /**
     * Gets the character's willpower attribute.
     *
     * @return the willpower attribute
     */
    int getWillpower();
}
