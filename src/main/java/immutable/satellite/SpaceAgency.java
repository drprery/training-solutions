package immutable.satellite;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {
    List<Satellite> satellites=new ArrayList<>();

    public void registerSatellite(Satellite satellite){
        if (satellite == null){
            throw new NullPointerException("A paraméter nem lehet NULL!");
        }
        satellites.add(satellite);
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent){
        for(Satellite satellite:satellites){
            if(satellite.getRegisterIdent().equals(registerIdent)){
                return satellite;
            }
        }
        throw new IllegalArgumentException("A megadott műhold nem található!" + registerIdent);
    }

    public String toString(){
        return satellites.toString();
    }
}
