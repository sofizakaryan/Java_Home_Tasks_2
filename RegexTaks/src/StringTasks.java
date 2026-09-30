import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTasks {

    public static void main(String[] args) {

        String log1 =
                "app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient - action=EDIOrderSent originalFilename=Integration_test_Contract customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 poNum=Test_TS5155079515 lineCount=3";

        String log2 =
                "test 2667843 (test_email@griddynamics.com) test 67483 some string";

        String log3 =
                "app=edi_adapter_splitter wingtipsTrace=225debfbe6e5fac7 poiFileName=Integration_test_Contract INFO  LogUtils - POI file name: [Integration_test_Contract], total number of orders successfully processed: [2]";


        System.out.println(containsOrderUUID(log1));
        System.out.println(getOrderUUID(log1));
        System.out.println(getEmail(log2));
        System.out.println(findOrdersCount(log3));
    }


    // 1
    static boolean containsOrderUUID(String text) {
        return text.contains("orderUUID=");
    }


    // 2
    static String getOrderUUID(String text) {
        String key = "orderUUID=";

        int start = text.indexOf(key); //start index (of "o")

        if (start == -1) {
            return null;
        }

        start += key.length();
        int end = text.indexOf(" ", start); // first " " from start index

        if (end == -1) {
            end = text.length();
        }

        return text.substring(start, end);
    }


    // 3
    static String getEmail(String text) {
        Pattern pattern = Pattern.compile(
                "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"
        );

        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(0);
        }

        return null;
    }


    // 4
    static int findOrdersCount(String text) {
        Pattern pattern = Pattern.compile(
                "total number of orders successfully processed: \\[(\\d+)\\]"
        );

        Matcher matcher = pattern.matcher(text); // take whole text

        if (matcher.find()) { // first matched part like [N] | if loop continue searching
            return Integer.parseInt(matcher.group(1)); //group 0 whole part(groups and between chars), group 1,2,.. are parts we search like \\d+
        }

        return -1;
    }
}
