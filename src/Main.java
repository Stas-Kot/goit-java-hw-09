public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> list = new MyHashMap();

//        for (int i = 0; i < 111; i++) {
//            list.add(Integer.toString(i));
//        }
        list.put(0, "0");
        list.put(1, "77");
        list.put(11, "88");
        list.put(1, "17");
        list.put(11, "99");
        list.put(21, "1111");
        list.put(31, "31");
        list.put(21, "2222");


        System.out.println("list.get(31) = " + list.get(31));
        list.put(2, "43");
        list.put(3, "2");
//        list.clear();
        list.remove(31);
        System.out.println("list.get(31) = " + list.get(31));

        System.out.println("list.size() = " + list.size());
    }
}
