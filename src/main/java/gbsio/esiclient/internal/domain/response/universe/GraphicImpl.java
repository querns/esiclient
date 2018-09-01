package gbsio.esiclient.internal.domain.response.universe;

import com.fasterxml.jackson.annotation.JsonProperty;
import gbsio.esiclient.api.domain.response.universe.Graphic;

import java.util.Optional;

public class GraphicImpl implements Graphic {
    private final String collisionFile;
    private final String graphicFile;
    private final int ID;
    private final String iconFolder;
    private final String sofDna;
    private final String sofFactionName;
    private final String sofHullName;
    private final String sofRaceName;

    GraphicImpl(
        @JsonProperty("collision_file")
        final String collisionFile,
        @JsonProperty("graphic_file")
        final String graphicFile,
        @JsonProperty(value = "graphic_id", required = true)
        final int id,
        @JsonProperty("icon_folder")
        final String iconFolder,
        @JsonProperty("sof_dna")
        final String sofDna,
        @JsonProperty("sof_faction_name")
        final String sofFactionName,
        @JsonProperty("sof_hull_name")
        final String sofHullName,
        @JsonProperty("sof_race_name")
        final String sofRaceName
    ) {
        this.collisionFile = collisionFile;
        this.graphicFile = graphicFile;
        ID = id;
        this.iconFolder = iconFolder;
        this.sofDna = sofDna;
        this.sofFactionName = sofFactionName;
        this.sofHullName = sofHullName;
        this.sofRaceName = sofRaceName;
    }

    @Override
    public Optional<String> getCollisionFile() {
        return Optional.ofNullable(collisionFile);
    }

    @Override
    public Optional<String> getGraphicFile() {
        return Optional.ofNullable(graphicFile);
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public Optional<String> getIconFolder() {
        return Optional.ofNullable(iconFolder);
    }

    @Override
    public Optional<String> getSofDna() {
        return Optional.ofNullable(sofDna);
    }

    @Override
    public Optional<String> getSofFactionName() {
        return Optional.ofNullable(sofFactionName);
    }

    @Override
    public Optional<String> getSofHullName() {
        return Optional.ofNullable(sofHullName);
    }

    @Override
    public Optional<String> getSofRaceName() {
        return Optional.ofNullable(sofRaceName);
    }
}
