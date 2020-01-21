public enum Locations {
    ROOF("крыша",0,8,2,8),
    ENDROOF("край крыши",0,6,2,6),
    CHUTE("мусоропровод",1,0,2,10),
    SIDEWALK("тротуар",0,3,10,3),
    IDLE("спавн",0,0,0,0);
    private String title;
    private int x1,x2,y1,y2;

    Locations(String title,int x1,int y1,int x2,int y2){
        this.title=title;
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
    }
    public String getTitle() {
        return title;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
}
