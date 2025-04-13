package com.sheikhimtiaz.basicjava;

public enum CustomerType {
    REGULAR {
        @Override
        public double calculateDiscount(double basePrice) {
            return basePrice;
        }
    },
    MEMBER {
        @Override
        public double calculateDiscount(double basePrice) {
            return basePrice * 0.9;
        }
    },
    VIP {
        @Override
        public double calculateDiscount(double basePrice) {
            return basePrice * 0.8;
        }
    };
    public abstract double calculateDiscount(double basePrice);
}



//More Advanced Use Case: Enum Strategy Pattern
//public enum CustomerType {
//    REGULAR(new RegularPricingStrategy()),
//    MEMBER(new MemberPricingStrategy()),
//    VIP(new VIPPricingStrategy());
//    private PricingStrategy pricingStrategy;
//    CustomerType(PricingStrategy pricingStrategy) {
//        this.pricingStrategy = pricingStrategy;
//    }
//    public double calculateDiscount(double basePrice) {
//        return pricingStrategy.calculatePrice(basePrice);
//    }
//}
//public interface PricingStrategy {
//    double calculatePrice(double basePrice);
//}
//public class RegularPricingStrategy implements PricingStrategy {
//    public double calculatePrice(double basePrice) {
//        return basePrice;
//    }
//}
//public class MemberPricingStrategy implements PricingStrategy {
//    public double calculatePrice(double basePrice) {
//        return basePrice * 0.9;
//    }
//}
//public class VIPPricingStrategy implements PricingStrategy {
//    public double calculatePrice(double basePrice) {
//        return basePrice * 0.8;
//    }
//}

