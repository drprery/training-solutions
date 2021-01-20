package week12d02;

import java.util.ArrayList;
import java.util.List;

public class Street {

    List<Site> sites=new ArrayList<>();

    public void sellSite(Site site) {
        sites.add(site);
    }

    public int lastHouseNumber() {
        if (sites.isEmpty()) {
            throw new IllegalArgumentException("Üres a lista!");
        }

        int count=0;
        int last=sites.get(sites.size()-1).getSideOfStreet();
        for (Site s:sites) {
            if (s.getSideOfStreet()==last) {
                count++;
            }
        }
        return last==0 ? count*2:(count*2)-1;
    }

    public List<FenceList> fenceTypesCounter() {
        if (sites.isEmpty()) {
            throw new IllegalArgumentException("Üres a lista!");
        }

        List<FenceList> stats=new ArrayList<>();
        for (Fence fence:Fence.values()) {
            stats.add(new FenceList(fence, getCounter(fence)));
        }
        return stats;
    }

    private int getCounter(Fence fence) {
        int counter=0;
        for (Site site:sites) {
            if (site.getFenceType().equals(fence)) {
                counter++;
            }
        }
        return counter;
    }
}
