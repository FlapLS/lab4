public class Story {
    public static void main(String[] args) {
    World world = new World("Мир",11,11);
    Human karslon = new Human("Карлсон");
    Human kid = new Human("Малыш");
    Human sir = new Human("Господин");
    Human policeman = new Human("Полицейский");
    Things nuts = new Things("Ореховая скорлупа");
    Things paper = new Things("Скомканая бумага");
    Things cherry = new Things("Вишневые косточки");
    Things.Bucket bucket = new Things.Bucket("Ведро");
    world.addtoWorld(kid,0,0);
    world.addtoWorld(sir,0,0);
    world.addtoWorld(karslon,0,0);
    world.addtoWorld(policeman,0,0);
    world.addtoWorld(bucket,0,0,0,0);
    world.addtoWorld(nuts,0,0,0,0);
    world.addtoWorld(paper,0,0,0,0);
    world.addtoWorld(cherry,0,0,0,0);
    System.out.println("--------------------------------------------------------------");
    kid.move(2,8);
    karslon.move(2,8);
    bucket.move(0,8,2,8);
    karslon.move(0,-2);
    try {
        karslon.rush(bucket,MoveDirecions.DOWN);
        bucket.move(0,-2,0,-2);
        kid.think(karslon);
        karslon.stop();
    }catch (WrongMove ex) {
        System.out.println(ex.getMessage());
    }
    kid.setSideDirection(MoveDirecions.DOWN);
    sir.move(3,3);
    sir.smoke();
    nuts.move(1,0,2,10);
    paper.move(1,0,2,10);
    cherry.move(1,0,2,10);
    nuts.throwAway();
    cherry.throwAway();
    paper.throwAway();
    nuts.onCollision(sir,-1,3,8,-7);
    cherry.onCollision(sir,-1,3,8,-7);
    paper.onCollision(sir,-1,3,8,-7);
    sir.shakeoff();
    policeman.move(3,3);
    sir.call(policeman);
    }
}

