public class Things extends WorldObject implements Collidable {
    private boolean canInteractionWithThing = false;
    Things(String name) {
        super(name);
    }

    public void setCanInteractionWithThing(boolean canInteractionWithThing) {
        this.canInteractionWithThing = canInteractionWithThing;
    }

    public void move(int x1, int y1, int x2, int y2) {
        Locations location = this.getLocation();
        setCoordinates(getCoordinates()[0] + x1, getCoordinates()[1] + y1, getCoordinates()[2] + x2, getCoordinates()[3] + y2);
        setLocation();
        if (location != this.getLocation()) {
            System.out.println(super.getName() + " переместился из локации " + location.getTitle() + " в локацию " + getLocation().getTitle());
        } else System.out.println(super.getName() + " перемещается по локации " + getLocation().getTitle());
    }

    public void throwAway() {
        System.out.println(getName() + " полетел по " + getLocation().getTitle());
    }
    static class Bucket extends Things{
        private static String name;
        private static Locations location = Locations.IDLE;
        private static int x1, y1, x2, y2;
        Bucket(String name){
            super(name);

        }
        @Override
        public void setCoordinates(int x1, int y1, int x2, int y2) {
            super.setCoordinates(x1, y1, x2, y2);
        }

        @Override
        public void setLocation() {
            super.setLocation();
        }

        public static void setLocation(Locations location) {
            Bucket.location = location;
        }

        @Override
        public void move(int x1, int y1, int x2, int y2) {
            super.move(x1, y1, x2, y2);
        }
        @Override
        public String toString() {
            return name;
        }
    }


    @Override
    public void onCollision(Human human, int x1, int y1, int x2, int y2) {
        Locations location = this.getLocation();
        setCoordinates(getCoordinates()[0] + x1, getCoordinates()[1] + y1, getCoordinates()[2] + x2, getCoordinates()[3] + y2);
        setLocation();
        if (location != this.getLocation()) {
            System.out.println(super.getName() + " упали на голову " + human.getName() + ", который идет по  " + getLocation().getTitle());
        } else System.out.println(super.getName() + " перемещается по локации " + getLocation().getTitle());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}