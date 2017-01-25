package model;

/**
 * Created by brian on 23/01/17.
 */
public enum DayType implements IDayType {

    WEEKEND {
        @Override
        public double calculateExtraPrice(double price) {
            return price + price * 0.2;
        }
    },

    WEEKDAY {
        @Override
        public double calculateExtraPrice(double price) {
            return price;
        }
    }

}
