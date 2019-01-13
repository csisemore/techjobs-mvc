package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

import static org.launchcode.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController<jobResults> {

    private String column;

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results DONE

//    @RequestMapping(value = "results")
//    public String results(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
//        //model.addAttribute("columns", columnChoices);
//        //ArrayList<HashMap<String, String>> jobResults = new ArrayList<>();
//        //ArrayList<HashMap<String, String>> jobResults;
//        if (searchType.equals("all")) {
//            ArrayList<HashMap<String, String>> jobResults = new ArrayList<>();
//            String qtyOfResults = jobResults.size() + " Result(s)";
//            jobResults = JobData.findByValue(searchTerm);
//            model.addAttribute("title", searchTerm); //+ " from all columns");
//            model.addAttribute("listItems", jobResults);
//            model.addAttribute("columns", columnChoices);
//            return "search";
//        } else {
//            ArrayList<HashMap<String, String>> jobResults = JobData.findByColumnAndValue(searchType, searchTerm);
//            String qtyOfResults = jobResults.size() + " Result(s)";
//            jobResults = JobData.findByColumnAndValue(searchType, searchTerm);
//            model.addAttribute("title", searchTerm + " from " + searchType + " columns");
//            model.addAttribute("listItems", jobResults);
//            model.addAttribute("columns", columnChoices);
//            return "search";
//        }
//    }
//

    @RequestMapping(value = "results")
    public String results(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        model.addAttribute("columns", columnChoices);


        ArrayList<HashMap<String, String>> jobResults;

        if ("all".equals(searchType)) {
            jobResults = JobData.findByValue(searchTerm);
        } else {
            jobResults = JobData.findByColumnAndValue(searchType, searchTerm);
        }

        //model.addAttribute("jobs", jobResults.size());
        model.addAttribute("jobs", jobResults);
        model.addAttribute("listItems", jobResults);
        model.addAttribute("title", searchTerm + " from " + searchType + " columns");

        return "search";
    }
}













