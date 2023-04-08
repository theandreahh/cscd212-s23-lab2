package cscd212classes.lab2;

public class Television implements Comparable<Television> {
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String model, final boolean smart,
                      final int screenSize, final int resolution, final String make) throws IllegalArgumentException {
            if (model == null || model.isEmpty() || make == null ||
                    make.isEmpty() || screenSize < 32 || resolution < 720) {
                throw new IllegalArgumentException("Invalid parameter in constructor");
            }
            this.model = model;
            this.smart = smart;
            this.screenSize = screenSize;
            this.resolution = resolution;
            this.make = make;
            this.fourK = (resolution == 2160);
        }

    public Television(final String make, final String model, final boolean smart, final int screenSize,
        final int resolution) throws IllegalArgumentException {
            if (model == null || model.isEmpty() || make == null ||
                    make.isEmpty() || screenSize < 32 || resolution < 720) {
                throw new IllegalArgumentException("Invalid parameter in constructor");
            }
            this.model = model;
            this.smart = smart;
            this.screenSize = screenSize;
            this.resolution = resolution;
            this.make = make;
            this.fourK = (resolution == 2160);
        }

    @Override
    public int compareTo(Television another) throws IllegalArgumentException {
        if (another == null) {
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }

        int makeComparison = this.make.compareTo(another.make);
        if (makeComparison != 0) {
            return makeComparison;
        }

        // If makes are the same, compare based on model
        int modelComparison = this.model.compareTo(another.model);
        if (modelComparison != 0) {
            return modelComparison;
        }

        // If models are the same, compare based on screenSize
        return this.screenSize - another.screenSize;
    }

    @Override
    public boolean equals(final Object o){
        if (o == this) {
            return true;
        } else if (o == null) {
            return false;
        } else if (!(o instanceof Television)) {
            return false;
        }
        Television other = (Television) o;
        return other.fourK == this.fourK && other.resolution == this.resolution && other.smart == this.smart &&
                other.screenSize == this.screenSize && other.make.compareTo(this.make) == 0 &&
                other.model.compareTo(this.model) == 0;
    }

    public String getMake() {
        return this.make;

    }

    public String getModel() {
        return this.model;

    }

    public int getResolution() {
        return this.resolution;
    }

    public int getScreenSize () {
        return this.screenSize;
    }

    @Override
    public int hashCode () {
        return this.make.hashCode() + this.model.hashCode() + this.resolution + Boolean.hashCode(this.smart) +
                Boolean.hashCode(this.fourK);
    }

    @Override
    public String toString() {
        if (this.smart) {
            if (this.fourK) {
                return String.format("%s-%s, %d inch smart tv with 4K resolution", this.make, this.model, this.screenSize);
            }
            return String.format("%s-%s, %d inch smart tv with %d resolution", this.make, this.model, this.screenSize, this.resolution);
        }
        if (this.fourK) {
            return String.format("%s-%s, %d inch tv with 4K resolution", this.make, this.model, this.screenSize);
        }
        return String.format("%s-%s, %d inch tv with %d resolution", this.make, this.model, this.screenSize, this.resolution);
    }

}