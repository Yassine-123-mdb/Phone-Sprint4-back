package com.yassine.phone.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.yassine.phone.entities.Image;
import com.yassine.phone.service.ImageService;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	ImageService imageService;

	@PostMapping(value = "/uplaodImagePhon/{id}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("id") Long id)
			throws IOException {
		return imageService.uplaodImagePhon(file, id);
	}

	@RequestMapping(value = "/getImagesPhon/{id}", method = RequestMethod.GET)
	public List<Image> getImagesPhon(@PathVariable("id") Long id) throws IOException {
		return imageService.getImagesParPhone(id);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);
	}

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}
}
