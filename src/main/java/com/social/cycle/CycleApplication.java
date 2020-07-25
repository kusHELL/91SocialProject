package com.social.cycle;

import com.social.cycle.service.CalculatePricing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class CycleApplication {

    public static void main(String[] args) throws ParseException {
        SpringApplication.run(CycleApplication.class, args);
        Scanner sc = new Scanner(System.in);

        System.out.println("FRAME ");
        System.out.print("Enter the Date of pricing in format dd/mm/yyyy = ");
        String dateForFrame = sc.nextLine();

        System.out.println("CHAIN ASSEMBLY ");
        System.out.print("Enter the Date of pricing in format dd/mm/yyyy = ");
        String dateForChainAssembly = sc.nextLine();

        System.out.println("HANDLE AND BRAKES ");
        System.out.print("Enter the Date of pricing in format dd/mm/yyyy = ");
        String dateForHandleAndBrakes = sc.nextLine();

        System.out.println("WHEELS ");
        System.out.print("Enter the Date of pricing in format dd/mm/yyyy = ");
        String dateForWheels = sc.nextLine();

        System.out.println("SEATING ");
        System.out.print("Enter the Date of pricing in format dd/mm/yyyy = ");
        String dateForSeating = sc.nextLine();

        CalculatePricing calculatePricing = new CalculatePricing();
        Double totalPrice = calculatePricing.calculate(dateForFrame, dateForChainAssembly, dateForHandleAndBrakes, dateForWheels, dateForSeating);

        System.out.println(totalPrice);
    }

}
