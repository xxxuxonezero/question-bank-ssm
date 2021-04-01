package com.onezero.web;

import com.onezero.datastructure.GenericResult;
import com.onezero.utils.ImageUtils;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.bson.internal.Base64;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.Map;

@RestController
@RequestMapping("/Svc")
public class SvcController {
    @GetMapping("/VerifyImage")
    public GenericResult<String> getVerifyImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        GenericResult<String> result = new GenericResult<>();
        Map<String, Object> map = ImageUtils.generateImage();
        BufferedImage img = (BufferedImage) map.get("img");
        if (img == null) {
            throw new Exception("获取验证码失败");
        }
        ByteOutputStream os = new ByteOutputStream();
        ImageIO.write(img, "jpeg", os);
        String base64 = Base64.encode(os.getBytes());
        HttpSession session = request.getSession();
        String id = session.getId();
//        cacheOperation.setAndExpire(id, map.get("code"), 60);
        os.close();

        result.setData(base64);

        return result;
    }
}
