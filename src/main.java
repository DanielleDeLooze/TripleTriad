import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class main {
    public static final int A = 10;

    public static void main(String[] arg){
        HashMap<String, Card> cards = genereate_Cards();

        Card[] player1_card = new Card[5];

        player1_card[0] = cards.get("Geezard");
        player1_card[1] = cards.get("Funguar");
        player1_card[2] = (cards.get("Bite Bug"));
        player1_card[3] = (cards.get("Red Bat"));
        player1_card[4] = (cards.get("Blobra"));
        Player player_one = new Player( player1_card, 1);

        Card[] player2_card = new Card[5];
        player2_card[0] = (cards.get("Gayla"));
        player2_card[1] = (cards.get("Gesper"));
        player2_card[2] = (cards.get("Fastitocalon-F"));
        player2_card[3] = (cards.get("Blood Soul"));
        player2_card[4] = (cards.get("Cockatrice"));
        Player player_two = new Player(player2_card, 2);

        Board board = new Board(player_one,player_two);
        board.play_game();

    }

    //method to genereate 5 random cards from all possible cards (repeats allowed)
    public static Card[] getFiveRandomCards(){
        HashMap<String, Card> cards = genereate_Cards();
        Random generator = new Random();
        Card[] random_cards = new Card[5];
        Object[] values = cards.values().toArray();
        for(int i = 0; i < 5; i++){
            random_cards[i] = (Card)values[generator.nextInt(values.length)];
        }
        return random_cards;

    }

    //genereates a HashMap with all of the possible cards. Cards pulled from FFVII Triple Triad Wiki
    public static HashMap<String, Card> genereate_Cards(){
        HashMap<String, Card> cards = new HashMap<>();

        /*
        Format of values: In values {a,b,c,d}
        a = left value
        b = top value
        c = right value
        d = bottom value
         */

        int[] value1 = new int[]{5,1,4,1};
        Card card = new Card("Geezard", value1, 'N', 1);
        cards.put(card.get_name(), card);

        int[] value2 = new int[]{3,5,1,1};
        card = new Card("Funguar", value2, 'N', 1);
        cards.put(card.get_name(), card);

        int[] value3 = new int[]{5,1,3,3};
        card = new Card("Bite Bug", value3, 'N', 1);
        cards.put(card.get_name(), card);

        int[] value4 = new int[]{2,6,1,1};
        card = new Card("Red Bat", value4, 'N', 1);
        cards.put(card.get_name(), card);

        int[] value5 = new int[]{5,2,3,1};
        card = new Card("Blobra", value5, 'N', 1);
        cards.put(card.get_name(), card);

        int[] value6 = new int[]{4,2,1,4};
        card = new Card("Gayla", value6, 'L', 1);
        cards.put(card.get_name(), card);

        int[] value7 = new int[]{1,1,5,4};
        card = new Card("Gesper", value7, 'N', 1);
        cards.put(card.get_name(), card);

        int[] value8 = new int[]{1,3,5,2};
        card = new Card("Fastitocalon-F", value8, 'E', 1);
        cards.put(card.get_name(), card);

        int[] value9 = new int[]{1,2,1,6};
        card = new Card("Blood Soul", value9, 'N', 1);
        cards.put(card.get_name(), card);

        int[] value10 = new int[]{3,4,2,4};
        card = new Card("Caterchipillar", value10, 'N', 1);
        cards.put(card.get_name(), card);

        int[] value11 = new int[]{6,2,1,2};
        card = new Card("Cockatrice", value11, 'L', 1);
        cards.put(card.get_name(), card);

        int[] value12 = new int[]{1,7,1,3};
        card = new Card("Grat", value12, 'N', 2);
        cards.put(card.get_name(), card);

        int[] value13 = new int[]{3,6,2,2};
        card = new Card("Buel", value13, 'N', 2);
        cards.put(card.get_name(), card);

        int[] value14 = new int[]{4,5,3,3};
        card = new Card("Grat", value14, 'N', 2);
        cards.put(card.get_name(), card);

        int[] value15 = new int[]{3,6,1,4};
        card = new Card("Glacial Eye", value15, 'I', 2);
        cards.put(card.get_name(), card);

        int[] value16 = new int[]{3,3,4,5};
        card = new Card("Belhelmel", value16, 'N', 2);
        cards.put(card.get_name(), card);

        int[] value17 = new int[]{5,5,3,2};
        card = new Card("Thrustaevis", value17, 'T', 2);
        cards.put(card.get_name(), card);

        int[] value18 = new int[]{5,5,1,3};
        card = new Card("Anacondaur", value18, 'P', 2);
        cards.put(card.get_name(), card);

        int[] value19 = new int[]{2,5,2,5};
        card = new Card("Creeps", value19, 'L', 2);
        cards.put(card.get_name(), card);

        int[] value20 = new int[]{2,4,4,5};
        card = new Card("Grendel", value20, 'L', 2);
        cards.put(card.get_name(), card);

        int[] value21 = new int[]{7,3,2,1};
        card = new Card("Jelleye", value21, 'N', 2);
        cards.put(card.get_name(), card);

        int[] value22 = new int[]{3,5,2,5};
        card = new Card("Grand Mantis", value22, 'N', 2);
        cards.put(card.get_name(), card);

        int[] value23 = new int[]{2,6,6,3};
        card = new Card("Forbidden", value23, 'N', 3);
        cards.put(card.get_name(), card);

        int[] value24 = new int[]{6,6,3,1};
        card = new Card("Armadodo", value24, 'E', 3);
        cards.put(card.get_name(), card);

        int[] value25 = new int[]{5,3,5,5};
        card = new Card("Tri-Face", value25, 'P', 3);
        cards.put(card.get_name(), card);

        int[] value26 = new int[]{3,7,5,1};
        card = new Card("Fastitocalon", value26, 'E', 3);
        cards.put(card.get_name(), card);

        int[] value27 = new int[]{3,7,1,5};
        card = new Card("Snow Lion", value27, 'I', 3);
        cards.put(card.get_name(), card);

        int[] value28 = new int[]{3,5,6,3};
        card = new Card("Ochu", value28, 'N', 3);
        cards.put(card.get_name(), card);

        int[] value29 = new int[]{4,5,6,2};
        card = new Card("SAM08G", value29, 'F', 3);
        cards.put(card.get_name(), card);

        int[] value30 = new int[]{2,4,4,7};
        card = new Card("Death Claw", value30, 'F', 3);
        cards.put(card.get_name(), card);

        int[] value31 = new int[]{3,6,2,6};
        card = new Card("Cactuar", value31, 'N', 3);
        cards.put(card.get_name(), card);

        int[] value32 = new int[]{4,3,6,4};
        card = new Card("Tonberry", value32, 'N', 3);
        cards.put(card.get_name(), card);

        int[] value33 = new int[]{5,7,2,3};
        card = new Card("Abyss Worm", value33, 'E', 3);
        cards.put(card.get_name(), card);

        int[] value34 = new int[]{7,2,3,6};
        card = new Card("Turtapod", value34, 'N', 4);
        cards.put(card.get_name(), card);

        int[] value35 = new int[]{5,6,5,4};
        card = new Card("Vysage", value35, 'N', 4);
        cards.put(card.get_name(), card);

        int[] value36 = new int[]{7,4,6,2};
        card = new Card("T-Rexaur", value36, 'N', 4);
        cards.put(card.get_name(), card);

        int[] value37 = new int[]{3,2,7,6};
        card = new Card("Bomb", value37, 'F', 4);
        cards.put(card.get_name(), card);

        int[] value38 = new int[]{7,1,6,4};
        card = new Card("Blitz", value38, 'L', 4);
        cards.put(card.get_name(), card);

        int[] value39 = new int[]{6,7,3,1};
        card = new Card("Wendigo", value39, 'N', 4);
        cards.put(card.get_name(), card);

        int[] value40 = new int[]{4,7,4,4};
        card = new Card("Torama", value40, 'N', 4);
        cards.put(card.get_name(), card);

        int[] value41 = new int[]{6,3,7,3};
        card = new Card("Imp", value41, 'N', 4);
        cards.put(card.get_name(), card);

        int[] value42 = new int[]{3,6,2,7};
        card = new Card("Blue Dragon", value42, 'P', 4);
        cards.put(card.get_name(), card);

        int[] value43 = new int[]{6,4,5,5};
        card = new Card("Adamantoise", value43, 'E', 4);
        cards.put(card.get_name(), card);

        int[] value44 = new int[]{3,7,5,4};
        card = new Card("Hexadragon", value44, 'F', 4);
        cards.put(card.get_name(), card);

        int[] value45 = new int[]{5,6,5,6};
        card = new Card("Iron Giant", value45, 'N', 5);
        cards.put(card.get_name(), card);

        int[] value46 = new int[]{7,3,6,5};
        card = new Card("Behemoth", value46, 'N', 5);
        cards.put(card.get_name(), card);

        int[] value47 = new int[]{3,7,6,5};
        card = new Card("Chimera", value47, 'W', 5);
        cards.put(card.get_name(), card);

        int[] value48 = new int[]{1,3,A,2};
        card = new Card("PuPu", value48, 'N', 5);
        cards.put(card.get_name(), card);

        int[] value49 = new int[]{7,6,2,6};
        card = new Card("Elastoid", value49, 'N', 5);
        cards.put(card.get_name(), card);

        int[] value50 = new int[]{4,5,5,7};
        card = new Card("GIM47N", value50, 'N', 5);
        cards.put(card.get_name(), card);

        int[] value51 = new int[]{2,7,7,4};
        card = new Card("Malboro", value51, 'P', 5);
        cards.put(card.get_name(), card);

        int[] value52 = new int[]{4,7,2,7};
        card = new Card("Red Dragon", value52, 'F', 5);
        cards.put(card.get_name(), card);

        int[] value53 = new int[]{6,5,3,7};
        card = new Card("Elnoyle", value53, 'N', 5);
        cards.put(card.get_name(), card);

        int[] value54 = new int[]{4,4,6,7};
        card = new Card("Tonberry King", value54, 'N', 5);
        cards.put(card.get_name(), card);

        int[] value55 = new int[]{7,6,6,2};
        card = new Card("Biggs, Wedge", value55, 'N', 5);
        cards.put(card.get_name(), card);

        int[] value56 = new int[]{4,2,8,8};
        card = new Card("Fujin, Raijin", value56, 'N', 6);
        cards.put(card.get_name(), card);

        int[] value57 = new int[]{4,7,8,3};
        card = new Card("Elvoret", value57, 'T', 6);
        cards.put(card.get_name(), card);

        int[] value58 = new int[]{3,4,8,7};
        card = new Card("X-ATM092", value58, 'N', 6);
        cards.put(card.get_name(), card);

        int[] value59 = new int[]{5,7,2,8};
        card = new Card("Granaldo", value59, 'N', 6);
        cards.put(card.get_name(), card);

        int[] value60 = new int[]{3,1,8,8};
        card = new Card("Gerogero", value60, 'P', 6);
        cards.put(card.get_name(), card);

        int[] value61 = new int[]{2,8,2,8};
        card = new Card("Iguion", value61, 'N', 6);
        cards.put(card.get_name(), card);

        int[] value62 = new int[]{5,6,8,4};
        card = new Card("Abadon", value62, 'N', 6);
        cards.put(card.get_name(), card);

        int[] value63 = new int[]{2,8,2,8};
        card = new Card("Iguion", value63, 'N', 6);
        cards.put(card.get_name(), card);

        int[] value64 = new int[]{6,4,8,5};
        card = new Card("Trauma", value64, 'N', 6);
        cards.put(card.get_name(), card);

        int[] value65 = new int[]{8,1,8,4};
        card = new Card("Oilboyle", value65, 'N', 6);
        cards.put(card.get_name(), card);

        int[] value66 = new int[]{4,6,5,8};
        card = new Card("Shumi Tribe", value66, 'N', 6);
        cards.put(card.get_name(), card);

        int[] value67 = new int[]{1,7,5,8};
        card = new Card("Krysta", value67, 'N', 6);
        cards.put(card.get_name(), card);

        int[] value68 = new int[]{8,8,4,4};
        card = new Card("Propagator", value68, 'N', 7);
        cards.put(card.get_name(), card);

        int[] value69 = new int[]{4,8,8,4};
        card = new Card("Jumbo Cactuar", value69, 'N', 7);
        cards.put(card.get_name(), card);

        int[] value70 = new int[]{8,8,5,2};
        card = new Card("Tri-Point", value70, 'L', 7);
        cards.put(card.get_name(), card);

        int[] value71 = new int[]{8,5,6,6};
        card = new Card("Gargantua", value71, 'N', 7);
        cards.put(card.get_name(), card);

        int[] value72 = new int[]{3,8,6,7};
        card = new Card("Mobile Type 8", value72, 'N', 7);
        cards.put(card.get_name(), card);

        int[] value73 = new int[]{8,8,3,5};
        card = new Card("Sphinxara", value73, 'N', 7);
        cards.put(card.get_name(), card);

        int[] value74 = new int[]{4,8,8,5};
        card = new Card("Tiamat", value74, 'N', 7);
        cards.put(card.get_name(), card);

        int[] value75 = new int[]{5,5,7,8};
        card = new Card("BGH251F2", value75, 'N', 7);
        cards.put(card.get_name(), card);

        int[] value76 = new int[]{7,6,8,4};
        card = new Card("Red Giant", value76, 'N', 7);
        cards.put(card.get_name(), card);

        int[] value77 = new int[]{7,1,8,7};
        card = new Card("Catoblepas", value77, 'N', 7);
        cards.put(card.get_name(), card);

        int[] value78 = new int[]{8,7,7,2};
        card = new Card("Ultima Weapon", value78, 'N', 7);
        cards.put(card.get_name(), card);

        int[] value79 = new int[]{9,4,4,8};
        card = new Card("Chubby Chocobo", value79, 'N', 8);
        cards.put(card.get_name(), card);

        int[] value80 = new int[]{3,9,6,7};
        card = new Card("Angelo", value80, 'N', 8);
        cards.put(card.get_name(), card);

        int[] value81 = new int[]{6,3,7,9};
        card = new Card("Gilgamesh", value81, 'N', 8);
        cards.put(card.get_name(), card);

        int[] value82 = new int[]{2,9,3,9};
        card = new Card("MiniMog", value82, 'N', 8);
        cards.put(card.get_name(), card);

        int[] value83 = new int[]{4,9,4,8};
        card = new Card("Chicobo", value83, 'N', 8);
        cards.put(card.get_name(), card);

        int[] value84 = new int[]{4,2,9,9};
        card = new Card("Quezacotl", value84, 'L', 8);
        cards.put(card.get_name(), card);

        int[] value85 = new int[]{9,6,7,4};
        card = new Card("Shiva", value85, 'I', 8);
        cards.put(card.get_name(), card);

        int[] value86 = new int[]{8,9,6,2};
        card = new Card("Ifrit", value86, 'F', 8);
        cards.put(card.get_name(), card);

        int[] value87 = new int[]{2,8,9,6};
        card = new Card("Siren", value87, 'N', 8);
        cards.put(card.get_name(), card);

        int[] value88 = new int[]{9,5,1,9};
        card = new Card("Sacred", value88, 'E', 8);
        cards.put(card.get_name(), card);

        int[] value89 = new int[]{9,9,5,2};
        card = new Card("Minotaur", value89, 'E', 8);
        cards.put(card.get_name(), card);

        int[] value90 = new int[]{4,9,4,A};
        card = new Card("Carbuncle", value90, 'N', 9);
        cards.put(card.get_name(), card);

        int[] value91 = new int[]{3,5,A,8};
        card = new Card("Diablos", value91, 'N', 9);
        cards.put(card.get_name(), card);

        int[] value92 = new int[]{7,7,A,1};
        card = new Card("Leviathan", value92, 'W', 9);
        cards.put(card.get_name(), card);

        int[] value93 = new int[]{5,8,A,3};
        card = new Card("Odin", value93, 'N', 9);
        cards.put(card.get_name(), card);

        int[] value94 = new int[]{7,A,1,7};
        card = new Card("Pandemona", value94, 'T', 9);
        cards.put(card.get_name(), card);

        int[] value95 = new int[]{A,7,4,6};
        card = new Card("Cerberus", value95, 'N', 9);
        cards.put(card.get_name(), card);

        int[] value96 = new int[]{2,9,A,4};
        card = new Card("Alexander", value96, 'H', 9);
        cards.put(card.get_name(), card);

        int[] value97 = new int[]{A,7,2,7};
        card = new Card("Pheonix", value97, 'F', 9);
        cards.put(card.get_name(), card);

        int[] value98 = new int[]{6,A,8,2};
        card = new Card("Bahamut", value98, 'N', 9);
        cards.put(card.get_name(), card);

        int[] value99 = new int[]{A,3,1,A};
        card = new Card("Doomtrain", value99, 'P', 9);
        cards.put(card.get_name(), card);

        int[] value100 = new int[]{A,4,4,9};
        card = new Card("Eden", value100, 'N', 9);
        cards.put(card.get_name(), card);

        int[] value101 = new int[]{8,A,7,2};
        card = new Card("Ward", value101, 'N', 10);
        cards.put(card.get_name(), card);

        int[] value102 = new int[]{A,6,7,6};
        card = new Card("Kiros", value102, 'N', 10);
        cards.put(card.get_name(), card);

        int[] value103 = new int[]{9,5,A,3};
        card = new Card("Laguna", value103, 'N', 10);
        cards.put(card.get_name(), card);

        int[] value104 = new int[]{4,A,8,6};
        card = new Card("Selphie", value104, 'N', 10);
        cards.put(card.get_name(), card);

        int[] value105 = new int[]{2,9,6,A};
        card = new Card("Quistis", value105, 'N', 10);
        cards.put(card.get_name(), card);

        int[] value106 = new int[]{A,2,6,9};
        card = new Card("Irvine", value106, 'N', 10);
        cards.put(card.get_name(), card);

        int[] value107 = new int[]{6,8,5,A};
        card = new Card("Zell", value107, 'N', 10);
        cards.put(card.get_name(), card);

        int[] value108 = new int[]{A,4,A,2};
        card = new Card("Rinoa", value108, 'N', 10);
        cards.put(card.get_name(), card);

        int[] value109 = new int[]{3,A,A,3};
        card = new Card("Edea", value109, 'N', 10);
        cards.put(card.get_name(), card);

        int[] value110 = new int[]{4,8,9,A};
        card = new Card("Seifer", value110, 'N', 10);
        cards.put(card.get_name(), card);

        int[] value111 = new int[]{9,A,4,6};
        card = new Card("Squall", value111, 'N', 10);
        cards.put(card.get_name(), card);

        return cards;
    }
}
