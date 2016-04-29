package abd.p1;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class Tools {

    public static double calculateDistnaceBetweenPoints(double lat1, double lng1, double lat2, double lng2) {
        final int R = 6371000;

        Double latDistance = Math.toRadians(lat2 - lat1);
        Double lonDistance = Math.toRadians(lng2 - lng1);

        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        Double distance = Math.pow(R * c, 2);

        return Math.sqrt(distance);
    }
}
