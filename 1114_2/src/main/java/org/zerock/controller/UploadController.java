package org.zerock.controller;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.*;
import static org.zerock.util.CheckFileType.checkImgeType;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.dto.AttachDTO;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {

	@GetMapping(value = "/downFile", produces = APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<byte[]> downFile(String fname) {
		File file = new File("C:\\upload", fname);
		byte[] data = null;
	    HttpHeaders headers = new HttpHeaders();

		try {
			headers.add("Content-Disposition",
			          "attachment; filename=" + new String(fname.substring(fname.indexOf("_")+1).getBytes("UTF-8"), "ISO-8859-1"));
			data = FileCopyUtils.copyToByteArray(file);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(data, headers, OK);
	}
	
	@GetMapping("/viewFile")
	@ResponseBody
	public ResponseEntity<byte[]> viewFile(String fname) {
		File file = new File("C:\\upload", fname);
		HttpHeaders header = new HttpHeaders();
		byte[] data = null;

		try {
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			
			data = FileCopyUtils.copyToByteArray(file);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(data,header, OK);
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {

	}

	@PostMapping(value = "/uploadAjaxAction", produces = APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {

		String uploadFolder = "C:\\upload";
		
		List<AttachDTO> attachList = new ArrayList<>();
		
		for (MultipartFile multipartFile : uploadFile) {
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			
			UUID uuid = UUID.randomUUID();
			
			String uploadName = uuid.toString()+"_"+uploadFileName;
			
			File saveFile = new File(uploadFolder, uploadName);
			
			try {
				
				multipartFile.transferTo(saveFile);
				
				boolean isImage = checkImgeType(saveFile);
				
				if(isImage) {
					FileOutputStream thumbnail = 
							new FileOutputStream(new File(uploadFolder, "s_" + uploadName));
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
				
				AttachDTO fileInfo = new AttachDTO(uploadFileName, uploadName, isImage);
				
				attachList.add(fileInfo);
				
				System.out.println("==========="+attachList+"===========");
				
			} catch (Exception e) {
				e.printStackTrace();
			} // end catch
			
		} // end for
		
		return new ResponseEntity<>(attachList, OK);
	}

	@GetMapping("/uploadForm")
	public void uploadByForm() {

	}

//	@PostMapping("/uploadAjaxAction")
//	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
//
//		String uploadFolder = "C:\\upload";
//
//		for (MultipartFile multipartFile : uploadFile) {
//
//			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
//
//			try {
//				multipartFile.transferTo(saveFile);
//			} catch (IllegalStateException | IOException e) {
//				e.printStackTrace();
//			}
//
//			System.out.println("-------------------------------------");
//			System.out.println("Upload File Name: " + multipartFile.getOriginalFilename());
//			System.out.println("Upload File Size: " + multipartFile.getSize());
//			System.out.println("-------------------------------------");
//
//		}
//	}

}
