import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String selectTable = "select * from audit_department";
        MyConnection myConnection = new MyConnection();
        Map<String, List<String>> result = myConnection.executeSelect(selectTable);

        List<String> columnsNames = myConnection.selectColumnsNames(selectTable);
        for (String s : columnsNames) {
            System.out.printf("%-20s", s);
        }
        System.out.println();

        for(Map.Entry<String, List<String>> entry : result.entrySet()) {
            String key = entry.getKey();
            System.out.printf("%-20s", key);
            List<String> valueList = entry.getValue();

            for (String s : valueList) {
                System.out.printf("%-20s", s);
            }
            System.out.println();
        }

    }
}