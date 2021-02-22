import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordTest {

    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        File file = new File("D:\\essay\\question-bank-ssm\\权限.docx");
        HWPFDocument doc = new HWPFDocument(new FileInputStream(file));
        Range range = doc.getRange();
        int paraNum = range.numParagraphs();
        for (int i = 0; i < paraNum; i++) {
            //获取段落
            Paragraph paragraph = range.getParagraph(i);
            if (paragraph.text().indexOf("$") > -1) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    paragraph.replaceText(entry.getKey(), entry.getValue());
                }
            }
        }
    }
}
