/**
 Created by Saego on 13.04.2017.
 */
public interface Filter {
    void filterKey(SearchCommand key);
    String commandName();
}
