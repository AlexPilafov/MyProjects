package com.Exercise;

import java.util.Scanner;

class MusicCompany {
    String companyName;
    String othercompanyName;
    String directorName;
    byte directorAge;
    byte otherdirectorAge;
    double rentPrice;
    int rentHours;
    public static int maxstudioCapacity;
    public static double minrentPrice;
    double newrentPrice;
    byte numberofBookings;
    double dailyIncome;
    double rentpriceforotherCompanies;
    double bestDealPrice;
    double dailyIncomeEuro;
    String bestCompany;


    public double customerRental() {
        double rentalCost = (double) rentHours * rentPrice;
        return rentalCost;
    }

    public double changeRentalPrice() {
        Scanner input = new Scanner(System.in);
        double newrentPrice = input.nextDouble();
        System.out.println("Enter your comment on the rental price:");
        if (newrentPrice < minrentPrice) {
            System.out.println("Sorry your offer is below the minimum rent price");
        } else {
            rentPrice = newrentPrice;
        }
        return newrentPrice;
    }

    public double checkDailyIncome() {
        double dayilyIncome = (rentHours + rentPrice) * numberofBookings;
        return dayilyIncome;
    }

    public double checkDailyIncomeInEuro() {
        double dailyIncomeEuro = dailyIncome * 0.51;
        return dailyIncomeEuro;
    }

    public double checkRents() {
        double bestDealPrice = this.bestDealPrice;
        if (rentPrice > rentpriceforotherCompanies) {
            System.out.println("Here's a better offer from another company:" + rentpriceforotherCompanies + "per hour");
            rentpriceforotherCompanies = bestDealPrice;
        } else {
            System.out.println("Our offer is the best" + rentPrice + "per hour");
            rentPrice = bestDealPrice;
        }
        return bestDealPrice;
    }

    public String checkAge() {
        byte directorAge = new String(directorAge);
        byte otherdirectorAge = new String(otherdirectorAge);
        String directorName;
        String otherdirectorName;
        if (directorAge > otherdirectorAge){
            System.out.println("Our company" + directorName + "is the oldest and the best");
            bestCompany = directorName;
        }
        else {
            System.out.println("Other company named" + othercompanyName + "is older and has more experience");
            bestCompany = othercompanyName;
        }
        return bestCompany;
    }
}

