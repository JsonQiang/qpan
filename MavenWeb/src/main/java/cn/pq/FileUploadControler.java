package cn.pq;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.pq.com.JsonResp;

@RestController
public class FileUploadControler {
	private Log log = LogFactory.getLog(this.getClass());

	@RequestMapping(value="/upload")
	public JsonResp fileupload(@RequestParam MultipartFile file,HttpServletRequest request,HttpServletResponse response){
		JsonResp resp = new JsonResp();
		try {
			String filepath = request.getSession().getServletContext().getRealPath("upload");
			String originalFilename = file.getOriginalFilename();
			File targetFile = new File(filepath, originalFilename);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			file.transferTo(targetFile);
			resp.setMessage("正确");
			resp.setStatus(0);
		}catch (Exception e) {
			log.error("上传失败",e);
		}
		return resp;
	}
}
