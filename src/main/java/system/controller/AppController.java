package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.entity.Detail;
import system.service.AppService;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    public AppService appService;

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/details")
    public String getAllDetails(Model model){
        model.addAttribute("details",appService.findAll());
        return "details";
    }

    @GetMapping("/types")
    public String getTypeOfDetails(Model model){
        model.addAttribute("types",appService.getDetailType());
        model.addAttribute("compNumbers",appService.getNumberOfComputers());
        return "types";
    }
    @GetMapping("/type/{typeName}")
    public String getByType(@PathVariable("typeName") String typeName,Model model){
        model.addAttribute("details",appService.showByType(typeName));
        return "showDetailPage";
    }

    @GetMapping("/addDetail")
    public String createDetailPage(){
        return "createDetail";
    }

    @PostMapping("/addDetail")
    public String addDetail(@ModelAttribute("detail") Detail detail){
        appService.addDetail(detail);
        return "redirect:/details";
    }

    @PostMapping("/updateDetail")
    public String updateDetail(@ModelAttribute("detail") Detail detail){
        appService.updateDetail(detail);
        return "redirect:/details";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,Model model){
        model.addAttribute("detail",appService.getById(id));
        return "updateDetail";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam(value = "detailSearch", required = false) String request, Model model) {
        model.addAttribute("details", appService.findAllByName(request));
        return "detailCard";
    }

    @GetMapping("/delete/{id}")
    public String deleteDetail(@PathVariable("id") Integer id){
        appService.deleteDetail(id);
        return "redirect:/details";
    }
}