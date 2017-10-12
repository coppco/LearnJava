import java.io.File;
import java.util.Scanner;

public class Delete {

    public static void main(String[] args) {
        System.out.print("请输入文件夹名称: ");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String fileName = scanner.next();
            File file = new File(fileName);
            if (isExists(file)) {
                delete(file);
                System.out.print("删除成功");
                break;
            }
        }





    }
    private static boolean isExists(File file) {
        return file.exists();
    }

    private static void delete(File file) {
        if (file.isFile()) {
            file.delete();
        } else {
            for (File subFile: file.listFiles()) {
                delete(subFile);
            }
            file.delete();
        }
    }
}
