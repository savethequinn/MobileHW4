package jdo589.welcometout;

import android.app.Application;

/**
 * Created by Justin on 4/19/2016.
 */
// this class adds global variables to the entire application context
public class AppContext extends Application {
    private String BuildingName;

    public String getBuildingName(){
        return BuildingName;
    }

    public void setBuildingName(String BuildingName) {
        this.BuildingName = BuildingName;
    }

    private String BuildingAddress;

    public String getBuildingAddress(){
        return BuildingAddress;
    }

    public void setBuildingAddress(String BuildingAddress) {
        this.BuildingAddress = BuildingAddress;
    }


    private String BuildingInformation;

    public String getBuildingInformation(){
        return BuildingInformation;
    }

    public void setBuildingInformation(String BuildingInformation) {
        this.BuildingInformation = BuildingInformation;
    }

    private String BuildingFact;

    public String getBuildingFact(){
        return BuildingFact;
    }

    public void setBuildingFact(String BuildingFact) {
        this.BuildingFact = BuildingFact;
    }

    private String BuildingPic;

    public String getBuildingPic(){
        return BuildingPic;
    }

    public void setBuildingPic(String BuildingPic) {
        this.BuildingPic = BuildingPic;
    }


}
