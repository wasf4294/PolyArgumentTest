
class Product {
    int price;
    int bonusPoint;
    Product(int price){
        this.price = price;
        bonusPoint =(int)(price/10.0);
    }
    Product(){}    //기본 생성자(없으면 안됌)
}

class Tv extends Product{
    Tv(){super(100);}
    public String toString(){return "Tv";}
}

class Computer extends Product{
    Computer(){super(100);}
    public String toString(){return "Computer";}
}

class Audio extends Product{
    Audio(){super(100);}
    public String toString(){return "Audio";}
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;
    Product[] item = new Product[10];       //0~9까지 10개의 배열 생성
    int i = 0;

    void buy(Product p){
        if (money < p.price){
            System.out.println("비싸서 못사");
            return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        item[i++]=p;
        System.out.println(p + "을/를 구매하셨습니다.");
    }

    void summary(){
        int sum = 0;
        String itemList ="";

        for(int i=0; i<item.length; i++){
            if (item[i]==null)break;
            sum += item[i].price;
            itemList += item[i] + ", ";
        }
        System.out.println("총" +sum+ "만원");
        System.out.println(itemList);
    }
}
class PolyArgumentTest2{
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Audio());

        b.summary();
    }
}