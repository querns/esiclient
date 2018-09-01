package gbsio.functional.request.unauthenticated.universe;

import gbsio.esiclient.api.Client;
import gbsio.esiclient.api.domain.response.universe.*;
import gbsio.esiclient.api.response.Response;
import gbsio.esiclient.client.request.universe.*;
import gbsio.functional.FunctionalTestHarness;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CelestialsTest extends FunctionalTestHarness {
    @Test
    void requests() {
        // Perimeter
        final int solarSystemID = 30000144;
        final Client client = getClient();

        // Solar system
        final Response<SolarSystem> solarSystemResponse = client.sendRequest(
            new SolarSystemRequest(solarSystemID)
        ).join();
        final SolarSystem solarSystem = assertResponseExistsAndGet(solarSystemResponse);
        assertEquals(solarSystemID, solarSystem.getID());

        // Constellation
        final int constellationID = solarSystem.getConstellationID();
        final Response<Constellation> constellationResponse = client.sendRequest(
            new ConstellationRequest(constellationID)
        ).join();
        final Constellation constellation = assertResponseExistsAndGet(constellationResponse);
        assertEquals(constellationID, constellation.getID());

        // Region
        final int regionID = constellation.getRegionID();
        final Response<Region> regionResponse = client.sendRequest(
            new RegionRequest(regionID)
        ).join();
        final Region region = assertResponseExistsAndGet(regionResponse);
        assertEquals(region.getID(), regionID);

        // Planet
        final Optional<SolarSystem.PlanetData> planet = solarSystem.getPlanets().stream()
            .filter(planetData ->
                planetData.getAsteroidBeltIDs().size() > 0
                && planetData.getMoonIDs().size() > 0
            )
            .findFirst()
            ;
        assertTrue(planet.isPresent());
        final Response<Planet> planetResponse = client.sendRequest(
            new PlanetRequest(planet.get().getPlanetID())
        ).join();
        final Planet retrievedPlanet = assertResponseExistsAndGet(planetResponse);
        assertEquals(planet.get().getPlanetID(), retrievedPlanet.getID());

        // Asteroid Belt
        final Integer asteroidBeltID = planet.get().getAsteroidBeltIDs().get(0);
        final Response<AsteroidBelt> asteroidBeltResponse = client.sendRequest(
            new AsteroidBeltsRequest(asteroidBeltID)
        ).join();
        final AsteroidBelt belt = assertResponseExistsAndGet(asteroidBeltResponse);
        assertEquals(solarSystemID, belt.getSolarSystemID());

        // Moon
        final Response<Moon> moonResponse = client.sendRequest(
            new MoonRequest(planet.get().getMoonIDs().get(0))
        ).join();
        final Moon moon = assertResponseExistsAndGet(moonResponse);
        assertEquals(solarSystemID, moon.getSolarSystemID());

        // Star
        assertTrue(solarSystem.getStarID().isPresent());
        final Response<Star> starResponse = client.sendRequest(new StarRequest(
            solarSystem.getStarID().get()
        )).join();
        final Star star = assertResponseExistsAndGet(starResponse);
        assertEquals(solarSystemID, star.getSolarSystemID());

        // Stargates
        assertTrue(solarSystem.getStargateIDs().size() > 0);
        final Integer stargateID = solarSystem.getStargateIDs().get(0);
        final Response<Stargate> gateResponse = client.sendRequest(
            new StargateRequest(stargateID)
        ).join();
        final Stargate gate = assertResponseExistsAndGet(gateResponse);
        assertEquals(stargateID.intValue(), gate.getID());

        // Stations
        assertTrue(solarSystem.getStationIDs().size() > 0);
        final Integer stationID = solarSystem.getStationIDs().get(0);
        final Response<Station> stationResponse = client.sendRequest(
            new StationRequest(stationID)
        ).join();
        final Station station = assertResponseExistsAndGet(stationResponse);
        assertEquals(stationID.intValue(), station.getID());
    }
}