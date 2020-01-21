public enum MoveDirecions {
    UP("вверх",1,0),
    DOWN("вниз",0,-1),
    RIGHT("вправо",1,0),
    LEFT("влево",0,-1),
    IDLEONROOF("стоит",0,0);
    private String name;
    private int x,y;
    MoveDirecions(String name,int x,int y){
        this.name=name;
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
