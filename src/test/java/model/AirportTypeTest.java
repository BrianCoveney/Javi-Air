package model;

import helpers.Consts;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by brian on 29/01/17.
 */
public class AirportTypeTest {


    String paris = String.valueOf(Airport.CDG);
    String stansted = String.valueOf(Airport.STN);
    String st_brieuc = String.valueOf(Airport.SBK);


    

    @Test
    public void isSelectedAirportStanstedOrParis() {

        assertEquals(true,
                AirportType.AIRPORT_LOCATION.selectedFlightsParisOrStansted(paris, stansted));

        assertEquals(true,
                AirportType.AIRPORT_LOCATION.selectedFlightsParisOrStansted(stansted, paris));

        assertEquals(false,
                AirportType.AIRPORT_LOCATION.selectedFlightsParisOrStansted(st_brieuc, paris));

    }


    @Test
    public void isSelectedAirportStanstedOrSt_Brieuc() {

        assertEquals(true,
                AirportType.AIRPORT_LOCATION.selectedFlightsStBrieucOrStansted(stansted, st_brieuc));

        assertEquals(true,
                AirportType.AIRPORT_LOCATION.selectedFlightsStBrieucOrStansted(st_brieuc, stansted));

        assertEquals(false,
                AirportType.AIRPORT_LOCATION.selectedFlightsStBrieucOrStansted(st_brieuc, paris));

    }


    @Test
    public void flightSelection() {

        assertEquals(Consts.ONE_HND,
                AirportType.AIRPORT_LOCATION.flightSelection(String.valueOf(Airport.ORK), String.valueOf(Airport.MAD)));

        assertEquals(Consts.TWO_HND_FIFTY,
                AirportType.AIRPORT_LOCATION.flightSelection(String.valueOf(Airport.JER), String.valueOf(Airport.CDG)));


    }



}