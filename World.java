public class World {
    private String name;
    private int sizex;
    private int sizey;
    static Human[] humarray = new Human[10];
    private int Hcnt = 0;
    Things[] thinarray = new Things[10];
    private int Mcnt = 0;
    World(String name, int sizex, int sizey) {
        this.name = name;
        this.sizex = sizex;
        this.sizey = sizey;
    }

    public void addtoWorld(Human human, int x, int y) {
        humarray[Hcnt] = human;
        Hcnt++;
        try {
            if ((x < 0 || x > getSizex() || y < 0 || y > sizey) && (x != -1 || y != -1))
                throw new OutOfTheWorldException(human.getName() + " не может появится вне этого мира. ");
            human.setCoordinates(x, y);
            human.setLocation();

        } catch (OutOfTheWorldException ex) {
            human.setCoordinates(0, 0);
            human.setLocation();
            System.out.println(ex.getMessage() + human.getName() + " перенесён в локацию " + human.getLocation().getTitle());

        }
        System.out.println(human.getName() + " появился в " + name + " в локации " + human.getLocation().getTitle());
    }

    public void addtoWorld(Things things, int x1, int y1, int x2, int y2) {
        thinarray[Mcnt]= things;
        Mcnt++;
        try {
        if (x1 < 0 || x1 > getSizex() || y1 < 0 || y1 > sizey || x2 < 0 || x2 > getSizex() || y2 < 0 || y2 > sizey)
            throw new OutOfTheWorldException(things.getName() + " не может появится вне этого мира. ");
        things.setCoordinates(x1, y1, x2, y2);
        things.setLocation();
        }
        catch (OutOfTheWorldException ex) {
        System.out.println(ex.getMessage()+things.getName() + " перенесён в локацию " +things.getLocation().getTitle());
        }
        System.out.println(things.getName() + " появился в " + name + " в локации " + things.getLocation().getTitle());
    }
    public void addtoWorld(Things.Bucket bucket, int x1, int y1, int x2, int y2) {
        try {
            if (x1 < 0 || x1 > getSizex() || y1 < 0 || y1 > sizey || x2 < 0 || x2 > getSizex() || y2 < 0 || y2 > sizey)
                throw new OutOfTheWorldException(bucket.getName() + " не может появится вне этого мира. ");
            bucket.setCoordinates(x1, y1, x2, y2);
            bucket.setLocation();
        }
        catch (OutOfTheWorldException ex) {
            System.out.println(ex.getMessage()+bucket.getName() + " перенесён в локацию " +bucket.getLocation().getTitle());
        }
        System.out.println(bucket.getName()+ " появился в " + name +" в локации " + bucket.getLocation().getTitle());
    }

    public String getName() {
        return name;
    }

    public int getHcnt() {
        return Hcnt;
    }

    public int getSizex() {
        return sizex;
    }

    public int getSizey() {
        return sizey;
    }

    public int getMcnt() {
        return Mcnt;
    }

}
