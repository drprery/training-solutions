package interfacedefaultmethods.print;

public class Printer {
    public String print(Printable printables){
        StringBuilder pages=new StringBuilder();

        if(printables instanceof NewsPaper){
            for(String page: ((NewsPaper) printables).getPages()){
                pages.append(page).append("\n");
            }
        }
        if(printables instanceof StoryBook){
            for(ColoredPage page: ((StoryBook) printables).getColoredPages()){
                if(page.getColor().equals(Printable.BLACK)){
                    pages.append(page.getPage()).append("\n");
                } else {
                    pages.append("[").append(page.getColor()).append("]").append(page.getPage()).append("\n");
                }
            }
        }
        return pages.toString();
    }
}
