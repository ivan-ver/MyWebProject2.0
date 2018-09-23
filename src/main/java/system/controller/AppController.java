package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import system.entity.Detail;
import system.service.AppService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class AppController {


    Integer OFFSET;
    @Autowired
    public AppService appService;

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/types")
    public String getTypeOfDetails(Model model){
        model.addAttribute("types",appService.getDetailType());
        model.addAttribute("compNumbers",appService.getNumberOfComputers());
        return "Type list";
    }
    @GetMapping("/type/{typeName}")
    public String getByType(@PathVariable("typeName") String typeName,Model model){
        model.addAttribute("details",appService.showByType(typeName));
        return "Details Info";
    }

    @GetMapping("/addDetail")
    public String createDetailPage(){
        return "Add detail";
    }

    @PostMapping("/addDetail")
    public String addDetail(@ModelAttribute("detail") Detail detail){
        appService.addDetail(detail);
        return "redirect:/";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam(value = "detailSearch", required = false) String request, Model model) {
        model.addAttribute("details", appService.findAllByName(request));
        return "Search result";
    }

    @PostMapping("/updateDetail")
    public String updateDetail(@ModelAttribute("detail") Detail detail){
        appService.updateDetail(detail);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,Model model){
        model.addAttribute("detail",appService.getById(id));
        return "Update detail";
    }


    @GetMapping("/delete/{id}")
    public String deleteDetail(@PathVariable("id") Integer id){
        appService.deleteDetail(id);
        return "redirect:/";
    }


    @GetMapping("/details/{offset}")
    public String getAll(@PathVariable("offset") Integer offset,Model model){
        List<Long> pages = new ArrayList<>();
        OFFSET = offset;
        for (int i = 1; i < appService.count()/10+2; i++) {
            pages.add(Long.valueOf(i));
        }

        model.addAttribute("details", appService.list((offset-1)*10, 10));

        model.addAttribute("pageNumb",pages);
        return "Detail list";
    }



}


