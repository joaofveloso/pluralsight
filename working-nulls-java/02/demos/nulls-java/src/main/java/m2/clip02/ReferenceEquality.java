package m2.clip02;

public class ReferenceEquality {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = o2;

        System.out.println( "o1 == o2: " + (o1 == o2) );
        System.out.println( "o2 == o3: " + (o2 == o3) );
        System.out.println( "null == null: " + (null == null) );
    }

}
