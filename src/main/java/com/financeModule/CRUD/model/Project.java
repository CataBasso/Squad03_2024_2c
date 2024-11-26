package com.financeModule.CRUD.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import static java.lang.Math.round;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Project {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private String id;

    @Column(name = "nombre")
    @JsonProperty("nombre")
    private String nombre;

    @Column(name = "descripcion", length = 1000)
    @JsonProperty("descripcion")
    private String descripcion;

    private int HoursToComplete;
    private double projectCost;
    private double projectGainings;
    private String client;
    private Boolean projectFinished;
    private Boolean projectOfDeed;
    private int monthsToComplete;

    public static final int WORK_HOURS_ON_MONTH = 160;


    public Project(String clientName, int hoursToComplete, double projectValue){
        if (hoursToComplete <= 0){
            throw new IllegalArgumentException("hours should be bigger than cero");
        }
        if(clientName.isEmpty()){
            throw new IllegalArgumentException("name shouldnt be empty");
        }
        if(projectValue <= 0){
            throw new IllegalArgumentException("project value should be positive");
        }
        this.HoursToComplete = hoursToComplete;
        this.projectCost = projectValue;
        this.client = clientName;
        this.projectFinished = false;
        this.projectOfDeed = false;
        this.monthsToComplete = round((float) hoursToComplete / 160);
    }


    public double calculateBillForHoursWorked(int hoursWorked){
        if (projectOfDeed) {
            return (projectCost /HoursToComplete) * hoursWorked;
        }
        throw new IllegalCallerException();
    }

    public double calculateCostOfProjectForMonths(int monthsToCalculate, int amountOfPeopleWorkingOnProject) {
        return (((projectCost /HoursToComplete) * WORK_HOURS_ON_MONTH) * amountOfPeopleWorkingOnProject) * monthsToCalculate; //assums people have the same salary.
    }

    public double calculateROI() {
        return projectGainings - projectCost;
    }

    public double calculateROIAfterHoursWorked(int hoursWorked) {
        return projectGainings - ((projectCost/HoursToComplete) * hoursWorked);
    }
}





