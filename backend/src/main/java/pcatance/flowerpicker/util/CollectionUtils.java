package pcatance.flowerpicker.util;

import java.util.Collection;

public final class CollectionUtils {
    private CollectionUtils() {
        // do not instantiate
    }

    public static <T> boolean isNullOrEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }
}
