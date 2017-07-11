package com.minzou.learn;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // 整数数组
    private String[] twoSame = {"00", "11", "22", "33", "44", "55", "66", "77", "88", "99"};
    private String[] threeSame = {"000", "111", "222", "333", "444", "555", "666", "777", "888", "999"};
    private String[] twoStar1 = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99"};
    private String[] twoStar2 = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "11", "12", "13", "14", "15", "16", "17", "18", "19", "22", "23", "24", "25", "26", "27", "28", "29", "33", "34", "35", "36", "37", "38", "39", "44", "45", "46", "47", "48", "49", "55", "56", "57", "58", "59", "66", "67", "68", "69", "77", "78", "79", "88", "89", "99"};
    private String[] twoStar2_eXX = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "12", "13", "14", "15", "16", "17", "18", "19", "23", "24", "25", "26", "27", "28", "29", "34", "35", "36", "37", "38", "39", "45", "46", "47", "48", "49", "56", "57", "58", "59", "67", "68", "69", "78", "79", "89"};
    private String[] threeStar1 = {"000", "001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011", "012", "013", "014", "015", "016", "017", "018", "019", "020", "021", "022", "023", "024", "025", "026", "027", "028", "029", "030", "031", "032", "033", "034", "035", "036", "037", "038", "039", "040", "041", "042", "043", "044", "045", "046", "047", "048", "049", "050", "051", "052", "053", "054", "055", "056", "057", "058", "059", "060", "061", "062", "063", "064", "065", "066", "067", "068", "069", "070", "071", "072", "073", "074", "075", "076", "077", "078", "079", "080", "081", "082", "083", "084", "085", "086", "087", "088", "089", "090", "091", "092", "093", "094", "095", "096", "097", "098", "099",
            "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199",
            "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232", "233", "234", "235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245", "246", "247", "248", "249", "250", "251", "252", "253", "254", "255", "256", "257", "258", "259", "260", "261", "262", "263", "264", "265", "266", "267", "268", "269", "270", "271", "272", "273", "274", "275", "276", "277", "278", "279", "280", "281", "282", "283", "284", "285", "286", "287", "288", "289", "290", "291", "292", "293", "294", "295", "296", "297", "298", "299",
            "300", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310", "311", "312", "313", "314", "315", "316", "317", "318", "319", "320", "321", "322", "323", "324", "325", "326", "327", "328", "329", "330", "331", "332", "333", "334", "335", "336", "337", "338", "339", "340", "341", "342", "343", "344", "345", "346", "347", "348", "349", "350", "351", "352", "353", "354", "355", "356", "357", "358", "359", "360", "361", "362", "363", "364", "365", "366", "367", "368", "369", "370", "371", "372", "373", "374", "375", "376", "377", "378", "379", "380", "381", "382", "383", "384", "385", "386", "387", "388", "389", "390", "391", "392", "393", "394", "395", "396", "397", "398", "399",
            "400", "401", "402", "403", "404", "405", "406", "407", "408", "409", "410", "411", "412", "413", "414", "415", "416", "417", "418", "419", "420", "421", "422", "423", "424", "425", "426", "427", "428", "429", "430", "431", "432", "433", "434", "435", "436", "437", "438", "439", "440", "441", "442", "443", "444", "445", "446", "447", "448", "449", "450", "451", "452", "453", "454", "455", "456", "457", "458", "459", "460", "461", "462", "463", "464", "465", "466", "467", "468", "469", "470", "471", "472", "473", "474", "475", "476", "477", "478", "479", "480", "481", "482", "483", "484", "485", "486", "487", "488", "489", "490", "491", "492", "493", "494", "495", "496", "497", "498", "499",
            "500", "501", "502", "503", "504", "505", "506", "507", "508", "509", "510", "511", "512", "513", "514", "515", "516", "517", "518", "519", "520", "521", "522", "523", "524", "525", "526", "527", "528", "529", "530", "531", "532", "533", "534", "535", "536", "537", "538", "539", "540", "541", "542", "543", "544", "545", "546", "547", "548", "549", "550", "551", "552", "553", "554", "555", "556", "557", "558", "559", "560", "561", "562", "563", "564", "565", "566", "567", "568", "569", "570", "571", "572", "573", "574", "575", "576", "577", "578", "579", "580", "581", "582", "583", "584", "585", "586", "587", "588", "589", "590", "591", "592", "593", "594", "595", "596", "597", "598", "599",
            "600", "601", "602", "603", "604", "605", "606", "607", "608", "609", "610", "611", "612", "613", "614", "615", "616", "617", "618", "619", "620", "621", "622", "623", "624", "625", "626", "627", "628", "629", "630", "631", "632", "633", "634", "635", "636", "637", "638", "639", "640", "641", "642", "643", "644", "645", "646", "647", "648", "649", "650", "651", "652", "653", "654", "655", "656", "657", "658", "659", "660", "661", "662", "663", "664", "665", "666", "667", "668", "669", "670", "671", "672", "673", "674", "675", "676", "677", "678", "679", "680", "681", "682", "683", "684", "685", "686", "687", "688", "689", "690", "691", "692", "693", "694", "695", "696", "697", "698", "699",
            "700", "701", "702", "703", "704", "705", "706", "707", "708", "709", "710", "711", "712", "713", "714", "715", "716", "717", "718", "719", "720", "721", "722", "723", "724", "725", "726", "727", "728", "729", "730", "731", "732", "733", "734", "735", "736", "737", "738", "739", "740", "741", "742", "743", "744", "745", "746", "747", "748", "749", "750", "751", "752", "753", "754", "755", "756", "757", "758", "759", "760", "761", "762", "763", "764", "765", "766", "767", "768", "769", "770", "771", "772", "773", "774", "775", "776", "777", "778", "779", "780", "781", "782", "783", "784", "785", "786", "787", "788", "789", "790", "791", "792", "793", "794", "795", "796", "797", "798", "799",
            "800", "801", "802", "803", "804", "805", "806", "807", "808", "809", "810", "811", "812", "813", "814", "815", "816", "817", "818", "819", "820", "821", "822", "823", "824", "825", "826", "827", "828", "829", "830", "831", "832", "833", "834", "835", "836", "837", "838", "839", "840", "841", "842", "843", "844", "845", "846", "847", "848", "849", "850", "851", "852", "853", "854", "855", "856", "857", "858", "859", "860", "861", "862", "863", "864", "865", "866", "867", "868", "869", "870", "871", "872", "873", "874", "875", "876", "877", "878", "879", "880", "881", "882", "883", "884", "885", "886", "887", "888", "889", "890", "891", "892", "893", "894", "895", "896", "897", "898", "899",
            "900", "901", "902", "903", "904", "905", "906", "907", "908", "909", "910", "911", "912", "913", "914", "915", "916", "917", "918", "919", "920", "921", "922", "923", "924", "925", "926", "927", "928", "929", "930", "931", "932", "933", "934", "935", "936", "937", "938", "939", "940", "941", "942", "943", "944", "945", "946", "947", "948", "949", "950", "951", "952", "953", "954", "955", "956", "957", "958", "959", "960", "961", "962", "963", "964", "965", "966", "967", "968", "969", "970", "971", "972", "973", "974", "975", "976", "977", "978", "979", "980", "981", "982", "983", "984", "985", "986", "987", "988", "989", "990", "991", "992", "993", "994", "995", "996", "997", "998", "999"};
    private String[] threeStar2 = {"000", "001", "002", "003", "004", "005", "006", "007", "008", "009", "011", "012", "013", "014", "015", "016", "017", "018", "019", "022", "023", "024", "025", "026", "027", "028", "029", "033", "034", "035", "036", "037", "038", "039", "044", "045", "046", "047", "048", "049", "055", "056", "057", "058", "059", "066", "067", "068", "069", "077", "078", "079", "088", "089", "099", "111", "112", "113", "114", "115", "116", "117", "118", "119", "122", "123", "124", "125", "126", "127", "128", "129", "133", "134", "135", "136", "137", "138", "139", "144", "145", "146", "147", "148", "149", "155", "156", "157", "158", "159", "166", "167", "168", "169", "177", "178", "179",
            "188", "189", "199", "222", "223", "224", "225", "226", "227", "228", "229", "233", "234", "235", "236", "237", "238", "239", "244", "245", "246", "247", "248", "249", "255", "256", "257", "258", "259", "266", "267", "268", "269", "277", "278", "279", "288", "289", "299", "333", "334", "335", "336", "337", "338", "339", "344", "345", "346", "347", "348", "349", "355", "356", "357", "358", "359", "366", "367", "368", "369", "377", "378", "379", "388", "389", "399", "444", "445", "446", "447", "448", "449", "455", "456", "457", "458", "459", "466", "467", "468", "469", "477", "478", "479", "488", "489", "499", "555", "556", "557", "558", "559", "566", "567", "568", "569", "577", "578", "579",
            "588", "589", "599", "666", "667", "668", "669", "677", "678", "679", "688", "689", "699", "777", "778", "779", "788", "789", "799", "888", "889", "899", "999"};
    private String[] threeStar2_eXXX = {"001", "002", "003", "004", "005", "006", "007", "008", "009", "011", "012", "013", "014", "015", "016", "017", "018", "019", "022", "023", "024", "025", "026", "027", "028", "029", "033", "034", "035", "036", "037", "038", "039", "044", "045", "046", "047", "048", "049", "055", "056", "057", "058", "059", "066", "067", "068", "069", "077", "078", "079", "088", "089", "099", "112", "113", "114", "115", "116", "117", "118", "119", "122", "123", "124", "125", "126", "127", "128", "129", "133", "134", "135", "136", "137", "138", "139", "144", "145", "146", "147", "148", "149", "155", "156", "157", "158", "159", "166", "167", "168", "169", "177", "178", "179",
            "188", "189", "199", "223", "224", "225", "226", "227", "228", "229", "233", "234", "235", "236", "237", "238", "239", "244", "245", "246", "247", "248", "249", "255", "256", "257", "258", "259", "266", "267", "268", "269", "277", "278", "279", "288", "289", "299", "334", "335", "336", "337", "338", "339", "344", "345", "346", "347", "348", "349", "355", "356", "357", "358", "359", "366", "367", "368", "369", "377", "378", "379", "388", "389", "399", "445", "446", "447", "448", "449", "455", "456", "457", "458", "459", "466", "467", "468", "469", "477", "478", "479", "488", "489", "499", "556", "557", "558", "559", "566", "567", "568", "569", "577", "578", "579",
            "588", "589", "599", "667", "668", "669", "677", "678", "679", "688", "689", "699", "778", "779", "788", "789", "799", "889", "899"};

    private JSONArray array = new JSONArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mTv = (TextView) findViewById(R.id.mTv);
        for (int i = 1; i < 10; i++) {
            //二星直选 出12
            mTv.setText(two_D_Out_12(twoStar1, i, "做号 二星直选"));
        }

        for (int i = 1; i < 10; i++) {
            //二星混选 出12
            mTv.setText(two_D_Out_12(twoStar2_eXX, i, "做号 二星混选"));
        }

        for (int i = 1; i < 10; i++) {
            //三星直选 出123
            mTv.setText(two_D_Out_12(threeStar1, i, "做号 三星直选"));
        }

        for (int i = 1; i < 10; i++) {
            //三星混选 出123
            mTv.setText(two_D_Out_12(threeStar2_eXXX, i, "做号 三星混选"));
        }

    }

    private String result;
    private String allResult;
    private JSONObject object;

    /**
     * @param temNum 出多少个数
     * @return
     */

    private String two_D_Out_12(String[] nums, int temNum, String question) {
        allResult = "";
        List<int[]> list = combination(num, temNum);
        for (int a = 0; a < list.size(); a++) {
            int[] temp = list.get(a);
//                java.text.DecimalFormat df = new java.text.DecimalFormat("00");//将输出格式化
//                System.out.print(df.format(temp[j]) + " ");
            switch (temNum) {
                case 1:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + "--" + result);
                    allResult += result + "\n";
                    break;
                case 2:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "") || nums[j].contains(temp[1] + "")) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + "" + temp[1] + "--" + result);
                    allResult += result + "\n";
                    break;
                case 3:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "") || nums[j].contains(temp[1] + "") || nums[j].contains(temp[2] + "")) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + "" + temp[1] + "" + temp[2] + "--" + result);
                    allResult += result + "\n";
                    break;
                case 4:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")
                                || nums[j].contains(temp[1] + "")
                                || nums[j].contains(temp[2] + "")
                                || nums[j].contains(temp[3] + "")
                                ) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2] + "" + temp[3]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + ""
                            + temp[1] + ""
                            + temp[2] + ""
                            + temp[3] + ""
                            + "--" + result);
                    allResult += result + "\n";
                    break;
                case 5:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")
                                || nums[j].contains(temp[1] + "")
                                || nums[j].contains(temp[2] + "")
                                || nums[j].contains(temp[3] + "")
                                || nums[j].contains(temp[4] + "")
                                ) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2] + "" + temp[3] + "" + temp[4]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + ""
                            + temp[1] + ""
                            + temp[2] + ""
                            + temp[3] + ""
                            + temp[4] + ""
                            + "--" + result);
                    allResult += result + "\n";
                    break;
                case 6:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")
                                || nums[j].contains(temp[1] + "")
                                || nums[j].contains(temp[2] + "")
                                || nums[j].contains(temp[3] + "")
                                || nums[j].contains(temp[4] + "")
                                || nums[j].contains(temp[5] + "")
                                ) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2] + "" + temp[3] + "" + temp[4] + "" + temp[5]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + ""
                            + temp[1] + ""
                            + temp[2] + ""
                            + temp[3] + ""
                            + temp[4] + ""
                            + temp[5] + ""
                            + "--" + result);
                    allResult += result + "\n";
                    break;
                case 7:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")
                                || nums[j].contains(temp[1] + "")
                                || nums[j].contains(temp[2] + "")
                                || nums[j].contains(temp[3] + "")
                                || nums[j].contains(temp[4] + "")
                                || nums[j].contains(temp[5] + "")
                                || nums[j].contains(temp[6] + "")
                                ) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2] + "" + temp[3] + "" + temp[4] + "" + temp[5] + "" + temp[6]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + ""
                            + temp[1] + ""
                            + temp[2] + ""
                            + temp[3] + ""
                            + temp[4] + ""
                            + temp[5] + ""
                            + temp[6] + ""
                            + "--" + result);
                    allResult += result + "\n";
                    break;
                case 8:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")
                                || nums[j].contains(temp[1] + "")
                                || nums[j].contains(temp[2] + "")
                                || nums[j].contains(temp[3] + "")
                                || nums[j].contains(temp[4] + "")
                                || nums[j].contains(temp[5] + "")
                                || nums[j].contains(temp[6] + "")
                                || nums[j].contains(temp[7] + "")
                                ) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2] + "" + temp[3] + "" + temp[4] + "" + temp[5] + "" + temp[6] + "" + temp[7]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + ""
                            + temp[1] + ""
                            + temp[2] + ""
                            + temp[3] + ""
                            + temp[4] + ""
                            + temp[5] + ""
                            + temp[6] + ""
                            + temp[7] + ""
                            + "--" + result);
                    allResult += result + "\n";
                    break;
                case 9:
                    result = "";
                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j].contains(temp[0] + "")
                                || nums[j].contains(temp[1] + "")
                                || nums[j].contains(temp[2] + "")
                                || nums[j].contains(temp[3] + "")
                                || nums[j].contains(temp[4] + "")
                                || nums[j].contains(temp[5] + "")
                                || nums[j].contains(temp[6] + "")
                                || nums[j].contains(temp[7] + "")
                                || nums[j].contains(temp[8] + "")
                                ) {
                            result += nums[j] + " ";
                        }
                    }
                    try {
                        object = new JSONObject();
                        object.put("Answer", result);
                        object.put("Question", question + " " + temp[0] + "" + temp[1] + "" + temp[2] + "" + temp[3] + "" + temp[4] + "" + temp[5] + "" + temp[6] + "" + temp[8]);
                        object.put("IsEnabled", 1);
                        object.put("Mode", 0);
                        object.put("TimeDb", 1499751787);
                        array.put(object);
                    } catch (Exception e) {
                    }
                    System.out.println(temp[0] + ""
                            + temp[1] + ""
                            + temp[2] + ""
                            + temp[3] + ""
                            + temp[4] + ""
                            + temp[5] + ""
                            + temp[6] + ""
                            + temp[7] + ""
                            + temp[8] + ""
                            + "--" + result);
                    allResult += result + "\n";
                    break;
            }
        }
        saveToSDCard(this, "minzou.askdb", array.toString());
        System.out.println(array.toString());

        return allResult;
    }

    /**
     * 三星直选
     * 1码出123
     */
    private String three_D_Out1_123() {
        allResult = "";
        for (int i = 0; i < 10; i++) {
            result = "";
            for (int j = 0; j < threeStar1.length; j++) {
                if (threeStar1[j].contains(i + "")) {
                    result += threeStar1[j] + " ";
                }
            }
            System.out.println(i + "--" + result);
            allResult += result + "\n";
        }

        return allResult;
    }

    /**
     * @param a:组合数组
     * @param m:生成组合长度
     * @return :所有可能的组合数组列表
     */
    private List<int[]> combination(int[] a, int m) {
        List<int[]> list = new ArrayList<int[]>();
        int n = a.length;
        boolean end = false; // 是否是最后一种组合的标记
        // 生成辅助数组。首先初始化，将数组前n个元素置1，表示第一个组合为前n个数。
        int[] tempNum = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < m) {
                tempNum[i] = 1;
            } else {
                tempNum[i] = 0;
            }
        }
//        printVir(tempNum);// 打印首个辅助数组
        list.add(createResult(a, tempNum, m));// 打印第一种默认组合
        int k = 0;//标记位
        while (!end) {
            boolean findFirst = false;
            boolean swap = false;
            // 然后从左到右扫描数组元素值的"10"组合，找到第一个"10"组合后将其变为"01"
            for (int i = 0; i < n; i++) {
                int l = 0;
                if (!findFirst && tempNum[i] == 1) {
                    k = i;
                    findFirst = true;
                }
                if (tempNum[i] == 1 && tempNum[i + 1] == 0) {
                    tempNum[i] = 0;
                    tempNum[i + 1] = 1;
                    swap = true;
                    for (l = 0; l < i - k; l++) { // 同时将其左边的所有"1"全部移动到数组的最左端。
                        tempNum[l] = tempNum[k + l];
                    }
                    for (l = i - k; l < i; l++) {
                        tempNum[l] = 0;
                    }
                    if (k == i && i + 1 == n - m) {//假如第一个"1"刚刚移动到第n-m+1个位置,则终止整个寻找
                        end = true;
                    }
                }
                if (swap) {
                    break;
                }
            }
//            printVir(tempNum);// 打印辅助数组
            list.add(createResult(a, tempNum, m));// 添加下一种默认组合
        }
        return list;
    }

    // 根据辅助数组和原始数组生成结果数组
    public int[] createResult(int[] a, int[] temp, int m) {
        int[] result = new int[m];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (temp[i] == 1) {
                result[j] = a[i];
//                System.out.println("result[" + j + "]:" + result[j]);
                j++;
            }
        }
        return result;
    }

    // 打印整组数组
    public void print(List<int[]> list) {
        System.out.println("具体组合结果为:");
        for (int i = 0; i < list.size(); i++) {
            int[] temp = (int[]) list.get(i);
            for (int j = 0; j < temp.length; j++) {
//                java.text.DecimalFormat df = new java.text.DecimalFormat("00");//将输出格式化
//                System.out.print(df.format(temp[j]) + " ");
                System.out.print(temp[j] + "");
            }
            System.out.println();
        }
    }

    // 打印辅助数组的方法
    public void printVir(int[] a) {
        System.out.println("生成的辅助数组为：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }


    /**
     * 保存json到本地
     *
     * @param mActivity
     * @param filename
     * @param content
     */

    public static File dir = new File(Environment.getExternalStorageDirectory() + "/json/");


    public static void saveToSDCard(Activity mActivity, String filename, String content) {

        String en = Environment.getExternalStorageState();

        //获取SDCard状态,如果SDCard插入了手机且为非写保护状态

        if (en.equals(Environment.MEDIA_MOUNTED)) {

            try {

                dir.mkdirs(); //create folders where write files

                File file = new File(dir, filename);


                OutputStream out = new FileOutputStream(file);

                out.write(content.getBytes());

                out.close();
                Log.e("111", "保存成功");

            } catch (Exception e) {

                e.printStackTrace();
                Log.e("111", "保存失败");

            }

        } else {

            //提示用户SDCard不存在或者为写保护状态

            Log.e("111", "SDCard不存在或者为写保护状态");

        }

    }
}
