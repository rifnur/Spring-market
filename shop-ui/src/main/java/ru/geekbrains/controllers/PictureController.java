package ru.geekbrains.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.persist.model.Picture;
import ru.geekbrains.persist.model.PictureData;
import ru.geekbrains.persist.repo.PictureRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@Controller
@RequestMapping("/image")
public class PictureController
{

  private PictureRepository repo;


  @Autowired
  @Qualifier("pictureRepository")
  public void setImageRepository(PictureRepository ir)
  {
	repo = ir;
  }


  @GetMapping("/{id}")
  public void getProductImage(@PathVariable("id") Long id, HttpServletResponse res)
  throws IOException
  {
	Optional<Picture> picture = repo.findById(id);

	if (!picture.isPresent())
	  return;

	res.setContentType(picture.get().getContentType());

      PictureData data = picture.get().getPictureData();
	res.getOutputStream().write(data.getData());
  }


}