package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int pageNumber) {
        int pagesTotal = 0;
        int item = 0;

        if (pageNumber <= 0) {
            throw new IllegalArgumentException("Page number must be positive");
        }

        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                if (catalogItem.numberOfPagesAtOneItem() > pageNumber) {
                    pagesTotal += catalogItem.numberOfPagesAtOneItem();
                    item++;
                }
            }
        }

        if (item == 0) {
            throw new IllegalArgumentException("No page");
        }

        return ((double) (pagesTotal)) / item;
    }

    public void deleteItemByRegistrationNumber(String regNumber) {
        List<CatalogItem> toBeRemoved = new ArrayList<>();

        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.getRegistrationNumber().equals(regNumber)) {
                toBeRemoved.add(catalogItem);
            }
        }
        catalogItems.removeAll(toBeRemoved);
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> items = new ArrayList<>();

        criteriaBoth(searchCriteria, items);
        criteriaContributor(searchCriteria, items);
        criteriaTitle(searchCriteria, items);

        return items;
    }

    public int getAllPageNumber() {
        int pageNumber = 0;

        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                pageNumber += catalogItem.numberOfPagesAtOneItem();
            }
        }
        return pageNumber;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioLibraryItems = new ArrayList<>();

        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                audioLibraryItems.add(catalogItem);
            }
        }
        return audioLibraryItems;
    }

    public int getFullLength() {
        int fullLength = 0;

        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                fullLength += catalogItem.fullLengthAtOneItem();
            }
        }
        return fullLength;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedLibraryItems = new ArrayList<>();

        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                printedLibraryItems.add(catalogItem);
            }
        }
        return printedLibraryItems;
    }

    private List<CatalogItem> criteriaBoth(SearchCriteria searchCriteria, List<CatalogItem> items) {
        if (searchCriteria.hasContributor() && searchCriteria.hasTitle()) {
            List<String> contribs = new ArrayList<>();
            List<String> titles = new ArrayList<>();

            for (CatalogItem catalogItem : catalogItems) {
                contribs = catalogItem.getContributors();
                titles = catalogItem.getTitles();
                if ((contribs.contains(searchCriteria.getContributor()) && titles.contains(searchCriteria.getTitle()))) {
                    items.add(catalogItem);
                }
            }
        }
        return items;
    }

    private List<CatalogItem> criteriaContributor(SearchCriteria searchCriteria, List<CatalogItem> items) {
        if (searchCriteria.hasContributor() && !(searchCriteria.hasTitle())) {
            List<String> contributors;

            for (CatalogItem catalogItem : catalogItems) {
                contributors = catalogItem.getContributors();
                if (contributors.contains(searchCriteria.getContributor())) {
                    items.add(catalogItem);
                }
            }
        }
        return items;
    }

    private List<CatalogItem> criteriaTitle(SearchCriteria searchCriteria, List<CatalogItem> items) {
        if (searchCriteria.hasTitle() && !(searchCriteria.hasContributor())) {
            List<String> titles;

            for (CatalogItem catalogItem : catalogItems) {
                titles = catalogItem.getTitles();
                if (titles.contains(searchCriteria.getTitle())) {
                    items.add(catalogItem);
                }
            }
        }
        return items;
    }
}
