package com.courseWork.electomobile.Controllers;

import com.courseWork.electomobile.Models.NewsModel;
import com.courseWork.electomobile.Services.NewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class NewsController {

    private final NewService newService;

    @GetMapping("/news")
    public String newsView(Model model) {
        model.addAttribute("news", newService.newsList());
        return "news";
    }

    @GetMapping("/news/{id}")
    public String newsMoreView(@PathVariable Long id, Model model) {
        NewsModel neww = newService.getNewById(id);
        model.addAttribute("images", neww.getImages());
        model.addAttribute("news", neww);
        return "news-more";
    }
    @PostMapping("/news/add")
    public String newsPostAddView(@RequestParam("file1") MultipartFile file1, NewsModel neww)throws IOException {
        neww.setDate(new Date());
        newService.saveNew(neww, file1);
        return "redirect:/news";
    }

    @GetMapping("/news/add")
    public String newsAddView(Model model) {
        return "news-add";
    }


    @PostMapping("/news/remove/{id}")
    public String newsPostRemoveView(@PathVariable Long id){
        newService.deleteNews(id);
        return "redirect:/news";
    }
}