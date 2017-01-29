package model;

import helpers.Consts;

/**
 * Created by brian on 25/01/17.
 */
public enum AirportType implements IAirportType {


    AIRPORT_LOCATION {
        @Override
        public boolean selectedFlightsParisOrStansted(String origin, String destination) {

            if (origin.equals(String.valueOf(Airport.CDG)) && destination.equals(String.valueOf(Airport.STN)) ||
                    origin.equals(String.valueOf(Airport.STN)) && destination.equals(String.valueOf(Airport.CDG))) {
                return true;
            }
            return false;
        }


        @Override
        public boolean selectedFlightsStBrieucOrStansted(String origin, String destination) {

            if (origin.equals(String.valueOf(Airport.SBK)) && destination.equals(String.valueOf(Airport.STN)) ||
                    origin.equals(String.valueOf(Airport.STN)) && destination.equals(String.valueOf(Airport.SBK))) {
                return true;
            }
            return false;
        }

        @Override
        public double flightSelection(String dptFlight, String rtnFlight) {
            double flightPrice = 0;
            if (dptFlight != null && rtnFlight != null) {
                if (dptFlight == String.valueOf(Airport.ORK) && rtnFlight == String.valueOf(Airport.MAD) || dptFlight == String.valueOf(Airport.MAD) && rtnFlight == String.valueOf(Airport.ORK)) {
                    flightPrice = Consts.ONE_HND;
                } else if (dptFlight == String.valueOf(Airport.ORK) && rtnFlight == String.valueOf(Airport.SBK) || dptFlight == String.valueOf(Airport.SBK)  && rtnFlight == String.valueOf(Airport.ORK)) {
                    flightPrice = Consts.ONE_HND;
                } else if (dptFlight == String.valueOf(Airport.ORK) && rtnFlight == String.valueOf(Airport.CDG) || dptFlight == String.valueOf(Airport.CDG) && rtnFlight == String.valueOf(Airport.ORK)) {
                    flightPrice = Consts.EIGHTY;
                } else if (dptFlight == String.valueOf(Airport.ORK) && rtnFlight == String.valueOf(Airport.STN) || dptFlight == String.valueOf(Airport.STN) && rtnFlight == String.valueOf(Airport.ORK)) {
                    flightPrice = Consts.FORTY;
                } else if (dptFlight == String.valueOf(Airport.ORK) && rtnFlight == String.valueOf(Airport.AGP) || dptFlight == String.valueOf(Airport.AGP) && rtnFlight == String.valueOf(Airport.ORK)) {
                    flightPrice = Consts.TWO_HND_FORTY;
                } else if (dptFlight == String.valueOf(Airport.MAD) && rtnFlight == String.valueOf(Airport.SBK) || dptFlight == String.valueOf(Airport.SBK) && rtnFlight == String.valueOf(Airport.MAD)) {
                    flightPrice = Consts.TWO_HND;
                } else if (dptFlight == String.valueOf(Airport.MAD) && rtnFlight == String.valueOf(Airport.JER) || dptFlight == String.valueOf(Airport.JER) && rtnFlight == String.valueOf(Airport.MAD)) {
                    flightPrice = Consts.TWO_HND;
                } else if (dptFlight == String.valueOf(Airport.MAD) && rtnFlight == String.valueOf(Airport.CDG) || dptFlight == String.valueOf(Airport.CDG) && rtnFlight == String.valueOf(Airport.MAD)) {
                    flightPrice = Consts.SIXTY;
                } else if (dptFlight == String.valueOf(Airport.MAD) && rtnFlight == String.valueOf(Airport.STN) || dptFlight == String.valueOf(Airport.STN) && rtnFlight == String.valueOf(Airport.MAD)) {
                    flightPrice = Consts.SIXTY;
                } else if (dptFlight == String.valueOf(Airport.MAD) && rtnFlight == String.valueOf(Airport.AGP) || dptFlight == String.valueOf(Airport.AGP) && rtnFlight == String.valueOf(Airport.MAD)) {
                    flightPrice = Consts.SIXTY;
                } else if (dptFlight == String.valueOf(Airport.SBK) && rtnFlight == String.valueOf(Airport.JER)) {
                    flightPrice = Consts.ZERO;
                } else if (dptFlight == String.valueOf(Airport.SBK) && rtnFlight == String.valueOf(Airport.CDG) || dptFlight == String.valueOf(Airport.CDG) && rtnFlight == String.valueOf(Airport.SBK)) {
                    flightPrice = Consts.ONE_HND_FIFTY;
                } else if (dptFlight == String.valueOf(Airport.SBK) && rtnFlight == String.valueOf(Airport.AGP) || dptFlight == String.valueOf(Airport.AGP) && rtnFlight == String.valueOf(Airport.SBK)) {
                    flightPrice = Consts.ONE_HND_FORTY;
                } else if (dptFlight == String.valueOf(Airport.JER) && rtnFlight == String.valueOf(Airport.CDG) || dptFlight == String.valueOf(Airport.CDG) && rtnFlight == String.valueOf(Airport.JER)) {
                    flightPrice = Consts.TWO_HND_FIFTY;
                } else if (dptFlight == String.valueOf(Airport.JER) && rtnFlight == String.valueOf(Airport.STN) || dptFlight == String.valueOf(Airport.STN) && rtnFlight == String.valueOf(Airport.JER)) {
                    flightPrice = Consts.TWO_HND_FIFTY;
                } else if (dptFlight == String.valueOf(Airport.JER) && rtnFlight == String.valueOf(Airport.AGP) || dptFlight == String.valueOf(Airport.AGP) && rtnFlight == String.valueOf(Airport.JER)) {
                    flightPrice = Consts.TWO_HND_EIGHTY;
                } else if (dptFlight == String.valueOf(Airport.CDG) && rtnFlight == String.valueOf(Airport.AGP) || dptFlight == String.valueOf(Airport.AGP) && rtnFlight == String.valueOf(Airport.CDG)) {
                    flightPrice = Consts.ONE_HND;
                } else if (dptFlight == String.valueOf(Airport.STN) && rtnFlight == String.valueOf(Airport.AGP) || dptFlight == String.valueOf(Airport.AGP) && rtnFlight == String.valueOf(Airport.STN)) {
                    flightPrice = Consts.ONE_HND_TWENTY;
                } else if (dptFlight == String.valueOf(Airport.CDG) && rtnFlight == String.valueOf(Airport.STN) || dptFlight == String.valueOf(Airport.STN) && rtnFlight == String.valueOf(Airport.CDG)) {
                    flightPrice = Consts.SIXTY;
                } else if (dptFlight == String.valueOf(Airport.SBK) && rtnFlight == String.valueOf(Airport.STN) || dptFlight == String.valueOf(Airport.STN) && rtnFlight == String.valueOf(Airport.SBK)) {
                    flightPrice = Consts.EIGHTY;
                }
            }

            return flightPrice;
        }

    },


}



























