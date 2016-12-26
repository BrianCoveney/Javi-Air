package model;

import helpers.Consts;

/**
 * Created by brian on 14/12/16.
 */
public class FlightTimes {

    private String flightTime1;
    private String flightTime2;

    public FlightTimes(){}

    public FlightTimes(String flightTime1, String flightTime2) {
        this.flightTime1 = flightTime1;
        this.flightTime2 = flightTime2;
    }


    public FlightTimes getFlightTimes(String dptFlight, String rtnFlight) {

        if (dptFlight.equals(Consts.CORK) && rtnFlight.equals(Consts.MADRID)) {
            flightTime1 = Consts.ORK_MAD_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.CORK) && rtnFlight.equals(Consts.ST_BRIEUC)) {
            flightTime1 = Consts.ORK_SBK_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.CORK) && rtnFlight.equals(Consts.JERSEY)) {
            flightTime1 = Consts.ORK_JER_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.CORK) && rtnFlight.equals(Consts.PARIS)) {
            flightTime1 = Consts.ORK_CDG_1;
            flightTime2 = Consts.ORK_CDG_2;
        } else if (dptFlight.equals(Consts.CORK) && rtnFlight.equals(Consts.STANSTED)) {
            flightTime1 = Consts.ORK_STN_1;
            flightTime2 = Consts.ORK_STN_2;
        } else if (dptFlight.equals(Consts.CORK) && rtnFlight.equals(Consts.MALAGA)) {
            flightTime1 = Consts.ORK_AGP_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.MADRID) && rtnFlight.equals(Consts.CORK)) {
            flightTime1 = Consts.MAD_ORK_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.MADRID) && rtnFlight.equals(Consts.ST_BRIEUC)) {
            flightTime1 = Consts.MAD_SBK_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.MADRID) && rtnFlight.equals(Consts.JERSEY)) {
            flightTime1 = Consts.MAD_JER_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.MADRID) && rtnFlight.equals(Consts.PARIS)) {
            flightTime1 = Consts.MAD_CDG_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.MADRID) && rtnFlight.equals(Consts.STANSTED)) {
            flightTime1 = Consts.MAD_STN_1;
            flightTime2 = Consts.MAD_STN_2;
        } else if (dptFlight.equals(Consts.MADRID) && rtnFlight.equals(Consts.MALAGA)) {
            flightTime1 = Consts.MAD_AGP_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.ST_BRIEUC) && rtnFlight.equals(Consts.CORK)) {
            flightTime1 = Consts.SBK_ORK_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.ST_BRIEUC) && rtnFlight.equals(Consts.MADRID)) {
            flightTime1 = Consts.SBK_MAD_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.ST_BRIEUC) && rtnFlight.equals(Consts.JERSEY)) {
            flightTime1 = Consts.SBK_JER_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.ST_BRIEUC) && rtnFlight.equals(Consts.PARIS)) {
            flightTime1 = Consts.SBK_CDG_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.ST_BRIEUC) && rtnFlight.equals(Consts.STANSTED)) {
            flightTime1 = Consts.SBK_STN_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.ST_BRIEUC) && rtnFlight.equals(Consts.MALAGA)) {
            flightTime1 = Consts.SBK_AGP_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.JERSEY) && rtnFlight.equals(Consts.CORK)) {
            flightTime1 = Consts.JER_ORK_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.JERSEY) && rtnFlight.equals(Consts.MADRID)) {
            flightTime1 = Consts.JER_MAD_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.JERSEY) && rtnFlight.equals(Consts.PARIS)) {
            flightTime1 = Consts.JER_CDG_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.JERSEY) && rtnFlight.equals(Consts.STANSTED)) {
            flightTime1 = Consts.JER_STN_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.JERSEY) && rtnFlight.equals(Consts.MALAGA)) {
            flightTime1 = Consts.JER_AGP_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.PARIS) && rtnFlight.equals(Consts.CORK)) {
            flightTime1 = Consts.CDG_ORK_1;
            flightTime2 = Consts.CDG_ORK_2;
        } else if (dptFlight.equals(Consts.PARIS) && rtnFlight.equals(Consts.MADRID)) {
            flightTime1 = Consts.CDG_MAD_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.PARIS) && rtnFlight.equals(Consts.ST_BRIEUC)) {
            flightTime1 = Consts.CDG_SBK_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.PARIS) && rtnFlight.equals(Consts.JERSEY)) {
            flightTime1 = Consts.CDG_JER_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.PARIS) && rtnFlight.equals(Consts.STANSTED)) {
            flightTime1 = Consts.CDG_STN_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.PARIS) && rtnFlight.equals(Consts.MALAGA)) {
            flightTime1 = Consts.CDG_AGP_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.CORK)) {
            flightTime1 = Consts.STN_ORK_1;
            flightTime2 = Consts.STN_ORK_2;
        } else if (dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.MADRID)) {
            flightTime1 = Consts.STN_MAD_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.ST_BRIEUC)) {
            flightTime1 = Consts.STN_SBK_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.JERSEY)) {
            flightTime1 = Consts.STN_JER_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.PARIS)) {
            flightTime1 = Consts.STN_CDG_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.STANSTED) && rtnFlight.equals(Consts.MALAGA)) {
            flightTime1 = Consts.STN_AGP_1;
            flightTime2 = Consts.STN_AGP_2;
        } else if (dptFlight.equals(Consts.MALAGA) && rtnFlight.equals(Consts.CORK)) {
            flightTime1 = Consts.AGP_ORK_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.MALAGA) && rtnFlight.equals(Consts.MADRID)) {
            flightTime1 = Consts.AGP_MAD_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.MALAGA) && rtnFlight.equals(Consts.ST_BRIEUC)) {
            flightTime1 = Consts.AGP_SBK_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.MALAGA) && rtnFlight.equals(Consts.JERSEY)) {
            flightTime1 = Consts.AGP_JER_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.MALAGA) && rtnFlight.equals(Consts.PARIS)) {
            flightTime1 = Consts.AGP_CDG_1;
            flightTime2 = null;
        } else if (dptFlight.equals(Consts.MALAGA) && rtnFlight.equals(Consts.STANSTED)) {
            flightTime1 = Consts.AGP_STN_1;
            flightTime2 = Consts.AGP_STN_2;
        }

        return new FlightTimes(flightTime1, flightTime2);

    }


    public String getFlightTimeDepart() {
        return flightTime1;
    }

    public String getFlightTimeReturn() {
        return flightTime2;
    }
}
