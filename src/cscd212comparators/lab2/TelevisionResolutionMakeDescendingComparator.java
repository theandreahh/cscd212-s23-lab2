package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionResolutionMakeDescendingComparator implements Comparator<Television> {

    @Override
    public int compare(final Television o1, final Television o2) {
        if (o1 == null || o2 == null) {
            throw new IllegalArgumentException("null parameter in TelevisionResolutionMakeDescendingComparator");
        }
        int resolutionCompare = o2.getResolution() - o1.getResolution();
        if (resolutionCompare != 0) {
            return resolutionCompare;
        }
        return o2.getMake().compareTo(o1.getMake());
    }

}
