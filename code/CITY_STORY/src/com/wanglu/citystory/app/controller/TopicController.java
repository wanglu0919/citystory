package com.wanglu.citystory.app.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wanglu.citystory.entity.City;
import com.wanglu.citystory.entity.OAuth;
import com.wanglu.citystory.entity.Province;
import com.wanglu.citystory.entity.ThingType;
import com.wanglu.citystory.entity.Topic;
import com.wanglu.citystory.util.WebContans;
import com.wangu.citystory.urls.AppURL;

/**
 * 文章控制类
 * 
 * @author wanglu
 * 
 */
@Controller
@RequestMapping(AppURL.APP_ROOT_URL)
public class TopicController extends BaseController {

	/**
	 * 发布文章
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/topic/publish", method = RequestMethod.POST)
	public String publishTopic(
			MultipartHttpServletRequest multipartHttpServletRequest,
			ModelMap modelMap) {
		OAuth oa = (OAuth) multipartHttpServletRequest
				.getAttribute(WebContans.OAUTH_REQUEST_KEY);

		String provinceId = multipartHttpServletRequest
				.getParameter("provinceId");
		String cityId = multipartHttpServletRequest.getParameter("cityId");
		String thingTyeId = multipartHttpServletRequest
				.getParameter("thingTypeId");
		Province p = new Province();
		p.setId(provinceId);
		City city = new City();
		city.setId(cityId);
		ThingType thingType = new ThingType();
		thingType.setId(thingTyeId);

		Topic topic = new Topic();
		topic.setUserId(oa.getUserId());

		topic.setCity(city);
		topic.setProvince(p);
		topic.setTingType(thingType);

		MultipartFile multipartFile = multipartHttpServletRequest
				.getFile("image");

		String fileName = multipartFile.getOriginalFilename();

		if (fileName != null && fileName.length() > 0) {

			String uploadFilePath = multipartHttpServletRequest
					.getServletContext().getRealPath("upload");

			try {
				saveFile(multipartFile.getInputStream(),
						fileName, uploadFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		putSuccess(modelMap, topic);

		return null;
	}

	/**
	 * 保存文件
	 * 
	 * @throws FileNotFoundException
	 */
	public void saveFile(final InputStream is, final String filename,
			final String filePath) {

		File file = new File(filePath + "/" + filename);
		FileOutputStream fs;
		try {
			fs = new FileOutputStream(file);

			byte[] buffer = new byte[1024 * 1024];

			int byteread = 0;

			while ((byteread = is.read(buffer)) != -1) {

				fs.write(buffer, 0, byteread);
				fs.flush();
			}
			fs.close();
			is.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
