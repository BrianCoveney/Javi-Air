package model;

import helpers.Consts;

/**
 * Created by brian on 25/01/17.
 */
public enum AirportType implements IAirportType {

    NOT_OPERATING_ON_DATES {
        @Override
        public boolean selectedFlightsParisOrStansted(String origin, String destination) {

            if(origin.equals(Consts.PARIS) && destination.equals(Consts.STANSTED) ||
                    origin.equals(Consts.STANSTED) && destination.equals(Consts.PARIS)) {
                return true;
            }
            return false;
        }


        @Override
        public boolean selectedFlightsStBrieucOrStansted(String origin, String destination) {

            if(origin.equals(String.valueOf(Airport.SBK)) && destination.equals(String.valueOf(Airport.STN)) ||
                    origin.equals(String.valueOf(Airport.STN)) && destination.equals(String.valueOf(Airport.SBK))) {
                return true;
            }
            return false;
        }
    },



    OPERATING_ON_ALL_DATES {

        // interface methods not called
        @Override
        public boolean selectedFlightsParisOrStansted(String origin, String destination) {
            return false;
        }

        @Override
        public boolean selectedFlightsStBrieucOrStansted(String origin, String destination) {
            return false;
        }
    };

}
