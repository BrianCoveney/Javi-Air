package model;

/**
 * Created by brian on 23/01/17.
 */
public enum DayType {

    WEEKEND {
        @Override
        public double calculateExtraPrice(double price) {
            return price = price + price * 0.2;
        }
    },

    WEEKDAY {
        @Override
        public double calculateExtraPrice(double price) {
            return price;
        }
    };

    public abstract double calculateExtraPrice(double price);

}
