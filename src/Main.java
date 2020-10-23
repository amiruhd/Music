import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** @author AmirHossein
 *  2020.10.23
 **/

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicCollection musicCollection = new MusicCollection();
        Boolean flag = true ;
        /**
         *  print menu anytime by switch case :
         *  and get input
         *  else FLAG = FALSE
         * and out form while
         **/
        while (flag){
            System.out.println("1) NEW Music");
            System.out.println("2) DELETE Music");
            System.out.println("3) Show Musics information from a same type");
            System.out.println("4) Show a Music information");
            System.out.println("5) Show all Music");
            System.out.println("6) Exit");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1 :
                    System.out.println("Please enter Music name!");
                    String name = scanner.nextLine();
                    Info info = new Info();
                    System.out.println("Please enter Music Type (rock/pop/jazz/country)??");
                    String type = scanner.nextLine();
                    info.addtypee(type);
                    System.out.println("Please enter Singer name  :");
                    String singer = scanner.nextLine();
                    System.out.println("Please enter out year  :");
                    String year = scanner.nextLine();
                    info.addyear(year);

                    musicCollection.addmusic(name , info);
                    System.out.println("Music saved!");
                    break;
                case 2 :
                    System.out.println("Please enter Music name!");
                    name = scanner.nextLine();
                    if(musicCollection.deletemusic(name))
                        System.out.println("Music deleted!");
                    else
                        System.out.println("unknown name");
                    break;
                case 3 :
                    System.out.println("(rock/pop/jazz/country)?");
                    String group = scanner.nextLine();
                    for(Map.Entry<String, Info> i:musicCollection.findSpecialMusic(group).entrySet()){
                        System.out.println(i.getKey());
                        i.getValue().printInfo();
                    }
                    break;
                case 4 :
                    System.out.println("name?");
                    name = scanner.nextLine();
                    musicCollection.findmusic(name).printInfo();
                    break;
                case 5 :
                    musicCollection.printmusics();
                    break;
                case 6 :
                    flag = false;
                    break;
            }

        }
    }

    /** @author AmirHossein
     *  2020.10.23
     **/
    static class MusicCollection {
        private HashMap<String, Info> Music;
        /**
         * Constructor for  MusicCollectionThis
         * creates a new HashMap
         */
        public MusicCollection() {
            Music = new HashMap<String, Info>();
        }

        /**
         * This method should get music name and info
         */
        public void addmusic(String name, Info info) {
            Music.put(name, info);
        }
        /**
         * This method should music by name
         */
        public Info findmusic(String name) {
            if (Music.containsKey(name))
                return Music.get(name);
            else
                return null;
        }
        /**
         * This method should delete music by name
         */
        public boolean deletemusic(String name) {
            boolean result = Music.containsKey(name);
            if (result)
                Music.remove(name);
            return result;
        }
        /**
         * This method should special music by name -->> pop jazz ...
         */
        public HashMap<String, Info> findSpecialMusic(String type) {
            HashMap<String, Info> tempHashMap = new HashMap<String, Info>();
            for (Map.Entry<String, Info> i : Music.entrySet()) {
                if (i.equals(type))
                    tempHashMap.put(i.getKey(), i.getValue());
            }
            return tempHashMap;
        }
        /**
         * This method should print musics
         */
        public void printmusics(){
            for (String cnt : Music.keySet()){
                System.out.println(cnt);
                Music.get(cnt).printInfo();
            }
        }
    }

    /** @author AmirHossein
     *  2020.10.23
     **/
    static class Info {
        private String Type;
        private String Singer;
        private String year;

        public Info() {

        }
        /**
         * This method should print info
         */
        public void printInfo() {
            System.out.println(Type);
            System.out.println(Singer);
            System.out.println(year);
        }
        /**
         * add -->> type singer and year
         */
        public void addtypee(String type){
            this.Type = type ;
        }

        public void addSinger(String Singer){
            this.Singer = Singer ;
        }

        public void addyear(String year){
            this.year = year ;
        }
    }
}