package christmas.domain.menu;

public interface Menu {
    boolean isContain(final String name);

    int getPrice(final String name);
}
