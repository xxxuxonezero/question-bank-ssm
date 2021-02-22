import com.onezero.utils.WordUtils;
import org.apache.poi.hwpf.HWPFDocument;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.onezero.utils.WordUtils.*;

public class WordTest {

    public static void main(String[] args) {//模板文件地址
        String inputUrl = "D:/test1.docx";
        //新生产的模板文件
        String outputUrl = "D:/test2.docx";
        if(inputUrl.endsWith("docx")){
            Map<String, String> testMap = new HashMap<String, String>();
            testMap.put("title", "哈哈");
            testMap.put("name", "张三");
            testMap.put("url", "127.0.0.1");
            changWord(inputUrl, outputUrl, testMap);
        }else if(inputUrl.endsWith("doc")){
            Map<String, String> testMap = new HashMap<String, String>();
            testMap.put("title", "哈哈");
            testMap.put("name", "张三");
            testMap.put("url", "127.0.0.1");
            //获取修改模版后的代码
            try {
                HWPFDocument doc = createTemplateDoc(inputUrl , testMap );
                //保存doc文件
                saveDoc(doc ,outputUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
