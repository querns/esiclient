package gbsio.esiclient.api.domain.response.industry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableMap;
import gbsio.esiclient.api.domain.response.character.CharacterInfo;
import gbsio.esiclient.api.util.EnumUtil;
import gbsio.esiclient.internal.domain.response.industry.IndustryJobImpl;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Represents an industry job.
 */
@JsonDeserialize(as = IndustryJobImpl.class)
public interface IndustryJob {
    /**
     * Get the ID of the activity being performed by this job.
     *
     * IndustryActivity IDs are found in the SDE in table industryActivity.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the activity ID
     */
    int getActivityID();

    /**
     * Get the ID of the blueprint item being used for the job.
     *
     * @return the item ID of the blueprint
     */
    long getBlueprintID();

    /**
     * Get the ID of the location of the blueprint.
     *
     * This can refer to a station, corp hangar, or a container inside a station
     * or corp hangar.
     *
     * @return the blueprint location ID
     */
    long getBlueprintLocationID();

    /**
     * Get the item type ID of the blueprint currently being used for this job.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the blueprint item type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    int getBlueprintTypeID();

    /**
     * Get the ID of the character that delivered this job.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID
     * @see CharacterInfo
     */
    Optional<Integer> getCompletedCharacterID();

    /**
     * Get the date that the job was delivered.
     *
     * @return the delivery date
     */
    Optional<ZonedDateTime> getCompletionDate();

    /**
     * Gets the cost of the job.
     *
     * The job cost is the sum of the installation fee and facility fee.
     *
     * @return the job cost
     */
    Optional<Double> getCost();

    /**
     * Get the duration of the job.
     *
     * @return the duration, in seconds
     */
    int getDuration();

    /**
     * Get the date that the job is finished.
     *
     * @return the finish date
     */
    ZonedDateTime getEndDate();

    /**
     * Get the ID of the facility currently handling this job.
     *
     * @return the facility ID
     */
    long getFacilityID();

    /**
     * Get the ID of the character that installed this job.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the character ID of the installer
     * @see CharacterInfo
     */
    int getInstallerCharacterID();

    /**
     * Get the unique ID for this job.
     *
     * @return the job ID
     */
    int getID();

    /**
     * Get the number of runs each blueprint copy being created will bear.
     *
     * Only applicable to copy jobs.
     *
     * @return the number of runs each copy will have
     */
    Optional<Integer> getLicensedRuns();

    /**
     * Get the ID of the location where the job's outputs will deposit.
     *
     * This can refer to a station, corp hangar, or a container inside a station
     * or corp hangar.
     *
     * @return the location ID where the outputs will go
     */
    long getOutputLocationID();

    /**
     * Get the date that the job was paused.
     *
     * Only applicable for jobs with status {@link Status#PAUSED "paused."}
     *
     * @return the pause date, or absent if the job wasn't paused
     */
    Optional<ZonedDateTime> getPauseDate();

    /**
     * Get the success chance of an invention job.
     *
     * @return the probability of invention success, or absent for non-invention
     * jobs
     */
    Optional<Float> getProbability();

    /**
     * Get the item type ID of the finished product of this job.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the output item's type ID
     * @see gbsio.esiclient.api.domain.response.universe.ItemType
     */
    Optional<Integer> getProductItemTypeID();

    /**
     * Get the number of runs being produced by this job.
     *
     * @return the number of runs
     */
    int getRuns();

    /**
     * Get the date this job was installed.
     *
     * @return the start date
     */
    ZonedDateTime getStartDate();

    /**
     * Get the ID of the station or structure housing the facility being used
     * for this job.
     *
     * Only the ID is returned; further discovery will be required for more
     * information and is not in scope for this function call.
     *
     * @return the station or structure ID
     */
    long getStationID();

    /**
     * Get the status of this job.
     *
     * @return the job's status
     */
    Status getStatus();

    /**
     * Get the number of runs that succeeded for this job.
     *
     * Only applicable to invention jobs.
     *
     * @return the number of successful runs
     */
    Optional<Integer> getSuccessfulRuns();

    /**
     * Represents the status of a job.
     */
    enum Status implements EnumUtil.MappableEnum {
        ACTIVE("active"), CANCELLED("cancelled"), DELIVERED("delivered"),
        PAUSED("paused"), READY("ready"), REVERTED("reverted"),
        UNKNOWN("unknown");

        private final String identifier;
        private static final ImmutableMap<String, Status> map = EnumUtil.generateMap(values());

        Status(String identifier) {
            this.identifier = identifier;
        }

        @JsonValue
        public String getIdentifier() {
            return identifier;
        }

        @JsonCreator
        public static Status of(String identifier) {
            return map.getOrDefault(identifier, UNKNOWN);
        }
    }
}
