import java.util.Objects;

public class Human {
    private String name;
    private Locations location = Locations.IDLE;
    private int x, y;
    private MoveDirecions currentDiricetion=MoveDirecions.IDLEONROOF;

    Human(String name) {
        this.name = name;
    }

    public enum States{
        Frigtened("испугался"),
        HAPPY("счастлив"),
        THING("думает"),
        SMOKING("курит"),
        RUN("бежит"),
        STOP("остановился"),
        LOOK("выглядит"),
        CALL("позвал");
        private String status;
        States(String status){
            this.status=status;
        }
        @Override
        public String toString() {
            return status;
        }
    }
    public String getName() {
        return name;
    }

    public Locations getLocation() {
        return location;
    }

    public int[] getCoordinates() {
        int[] coorarray = new int[2];
        coorarray[0] = x;
        coorarray[1] = y;
        return coorarray;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void move (int x,int y){
        Locations location = this.getLocation();
        setCoordinates(getCoordinates()[0] + x,getCoordinates()[1] + y);
        setLocation();
        if (location != this.getLocation()) {
            System.out.println( this.name + " переместился из локации " + location.getTitle() + " в локацию " + getLocation().getTitle());
        }
        else
            System.out.println(this.name + " перемещается по локации " + getLocation().getTitle());
    }
    public void setSideDirection(MoveDirecions direction) {
        this.currentDiricetion = direction;
        System.out.println(getName()+" ползет по "+getLocation().getTitle()+" "+currentDiricetion.toString());
    }
    public void setLocation() {
        if (getCoordinates()[0] >= Locations.SIDEWALK.getX1() && getCoordinates()[0] <= Locations.SIDEWALK.getX2() && getCoordinates()[1] >= Locations.SIDEWALK.getY1() && getCoordinates()[1] <= Locations.SIDEWALK.getY2()) {
            location = Locations.SIDEWALK;
        }
        if (getCoordinates()[0] >= Locations.CHUTE.getX1() && getCoordinates()[0] <= Locations.CHUTE.getX2() && getCoordinates()[1] >= Locations.CHUTE.getY1() && getCoordinates()[1] <= Locations.CHUTE.getY2()) {
            location = Locations.CHUTE;
        }
        if (getCoordinates()[0] >= Locations.ROOF.getX1() && getCoordinates()[0] <= Locations.ROOF.getX2() && getCoordinates()[1] >= Locations.ROOF.getY1() && getCoordinates()[1] <= Locations.ROOF.getY2()) {
            location = Locations.ROOF;
        }
        if (getCoordinates()[0] >= Locations.ENDROOF.getX1() && getCoordinates()[0] <= Locations.ENDROOF.getX2() && getCoordinates()[1] >= Locations.ENDROOF.getY1() && getCoordinates()[1] <= Locations.ENDROOF.getY2()) {
            location = Locations.ENDROOF;
        }
    }
    public void rush(Things.Bucket bucket,MoveDirecions currentDiricetion)throws WrongMove{
        States currentStates = States.RUN;
        if (currentDiricetion == MoveDirecions.DOWN){
            System.out.println(getName()+" "+currentStates+" "+currentDiricetion+" c "+bucket.getName()+" по "+getLocation().getTitle());
        }
        else {
            throw new WrongMove(getName()+" "+currentStates+" c "+bucket.getName()+" "+currentDiricetion);
        }

    }
    public void think(Human human) {
        States currentStates = States.THING;
        System.out.println(getName()+" "+States.Frigtened.toString()+" "+currentStates+" что "+ human+" не "+States.STOP);
    }

    public void stop(){
        States currentStates = States.RUN;
        System.out.println(getName()+currentStates);
    }
    public void smoke(){
        class Ciggarate{
            States currentStates = States.SMOKING;
            private String name;
            Ciggarate(String name){
                this.name=name;
            }

            public String getName() {
                return name;
            }

            public void print(){
                System.out.println(Human.this.getName()+" "+currentStates +" "+ name);
            }

        }
        Ciggarate ciggarate = new Ciggarate("сигарета");
        ciggarate.print();
    }
    public void shakeoff(){
        States currentStates = States.LOOK;
        System.out.println(getName()+" отряхивался ,он "+currentStates+" "+States.HAPPY.toString());
    }
    public void call(Human human) {
        States currentStates = States.CALL;
        InteractWithPoeple interactWithPoeple=new InteractWithPoeple() {
            @Override
            public void communicate() {
                System.out.println(getName()+" "+currentStates+" "+human);
            }
        };
        interactWithPoeple.communicate();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return x == human.x &&
                y == human.y &&
                name.equals(human.name) &&
                location == human.location &&
                currentDiricetion == human.currentDiricetion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, x, y, currentDiricetion);
    }

    @Override
    public String toString() {
        return name;
    }
}



