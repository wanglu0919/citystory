package com.wanglu.citystory.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/admin")
public class UploadController {

	@RequestMapping("/to_upload")
	public String toUpload() {

		return "uploademo";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(
			MultipartHttpServletRequest multipartHttpServletRequest,
			HttpServletResponse response, HttpSession httpSession) {

		asynupload(multipartHttpServletRequest, response, httpSession);
		return "uploadProgess";

	}

	public void asynupload(
			final MultipartHttpServletRequest multipartHttpServletRequest,
			final HttpServletResponse response, final HttpSession httpSession) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				
				

				for (Iterator<String> it = multipartHttpServletRequest
						.getFileNames(); it.hasNext();) {

					String fileParameName = it.next();

					MultipartFile multipartFile = multipartHttpServletRequest
							.getFile(fileParameName);

					String fileName = multipartFile.getOriginalFilename();

					if (fileName != null && fileName.length() > 0) {

						String uploadFilePath = multipartHttpServletRequest
								.getServletContext().getRealPath("upload");

						try {
							saveFile(multipartFile.getInputStream(), fileName,
									uploadFilePath, httpSession,
									multipartFile.getSize());

						} catch (IOException e) {

							e.printStackTrace();
						}

					}

				}

			}
		}).start();

	}

	@RequestMapping(value = "/upload2", method = RequestMethod.POST)
	public @ResponseBody
	Callable<String> upload2(
			final MultipartHttpServletRequest multipartHttpServletRequest,
			final HttpServletResponse response, final HttpSession httpSession) {

		return new Callable<String>() {

			@Override
			public String call() throws Exception {

				for (Iterator<String> it = multipartHttpServletRequest
						.getFileNames(); it.hasNext();) {

					String fileParameName = it.next();

					MultipartFile multipartFile = multipartHttpServletRequest
							.getFile(fileParameName);

					String fileName = multipartFile.getOriginalFilename();

					if (fileName != null && fileName.length() > 0) {

						String uploadFilePath = multipartHttpServletRequest
								.getServletContext().getRealPath("upload");

						try {
							saveFile(multipartFile.getInputStream(), fileName,
									uploadFilePath, httpSession,
									multipartFile.getSize());

						} catch (IOException e) {

							e.printStackTrace();
						}

					}

				}

				return "uploaddemo";
			}
		};

	}

	/**
	 * 保存文件
	 * 
	 * @throws FileNotFoundException
	 */
	public void saveFile(final InputStream is, final String filename,
			final String filePath, final HttpSession httpSession,
			final long totalSize) {

		File file = new File(filePath + "/" + filename);
		FileOutputStream fs;
		try {
			fs = new FileOutputStream(file);

			byte[] buffer = new byte[1024 * 1024];
			long bytesum = 0;
			int byteread = 0;

			while ((byteread = is.read(buffer)) != -1) {
				bytesum += byteread;

				UploadProgess progess = new UploadProgess();
				progess.fileName = filename;
				progess.progess = Math.round(bytesum / totalSize) * 100;
				httpSession.setAttribute("progess", progess);
				fs.write(buffer, 0, byteread);
				fs.flush();
			}
			fs.close();
			is.close();

			httpSession.removeAttribute("progess");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static final class UploadProgess {

		public String fileName;
		public long progess;

	}

	@RequestMapping(value = "/progess")
	@ResponseBody
	public UploadProgess getUploadPress(HttpSession httpSession) {

		UploadProgess uploadProgess = (UploadProgess) httpSession
				.getAttribute("progess");

		if (uploadProgess == null) {

			uploadProgess = new UploadProgess();
			uploadProgess.fileName = "unknow";
			uploadProgess.progess = -1;
		}

		System.out.println("请求了一次");
		return uploadProgess;

	}

	@RequestMapping(value = "/progess2", method = RequestMethod.GET)
	public void ajaxLogin(HttpServletRequest request,
			HttpServletResponse response, HttpSession httpSession) {

		System.out.println("请求一次");

		UploadProgess uploadProgess = (UploadProgess) httpSession
				.getAttribute("progess");

		if (uploadProgess == null) {

			uploadProgess = new UploadProgess();
			uploadProgess.fileName = "unknow";
			uploadProgess.progess = -1;
		}
		response.setContentType("text/xml;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();

			pw.write("1");
			pw.flush();
			System.out.println("写出了数据");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
