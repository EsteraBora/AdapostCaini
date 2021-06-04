package ro.emanuel.adapost.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.adapost.dao.VoluntariDAO;
import ro.emanuel.adapost.pojo.Voluntari;


@Controller
public class VoluntariController {
	@RequestMapping(value = "/listv.htm", method = RequestMethod.GET)
	public ModelAndView listVoluntari() throws SQLException  {
		ModelMap model = new ModelMap();
		ArrayList<Voluntari> voluntari = VoluntariDAO.getVoluntari();
		model.put("voluntari", voluntari);
		return new ModelAndView("listv.jsp", model);
	}

	@RequestMapping(value = "detaliiv.htm", method = RequestMethod.GET)
	public ModelAndView detaliiVoluntari(@RequestParam Integer id) throws SQLException {
		ModelMap model = new ModelMap();
		Voluntari vl = VoluntariDAO.getVoluntariByID(id);
		model.put("voluntari", vl);
		return new ModelAndView("detaliiv.jsp", model);
	}
	
	@RequestMapping(value = "adaugare-voluntari.htm", method = RequestMethod.GET)
    public ModelAndView showAddVoluntari(Model model)  {
    	Voluntari vl = new Voluntari();
    	model.addAttribute("voluntariForm", vl);
    	return new ModelAndView("addv.jsp","model", model);
    }
 @RequestMapping(value = "adaugare-voluntari-save.htm", method = RequestMethod.POST)
    public ModelAndView addv(@ModelAttribute("voluntariForm") Voluntari vl, ModelMap model, BindingResult result)  {
    	
    		try {
				VoluntariDAO.createVoluntari(vl);
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		return new ModelAndView("redirect:/listv.htm");
    	}
 @RequestMapping(value = "deletev.htm", method = RequestMethod.GET)
 public ModelAndView deletev(@RequestParam Integer id) throws SQLException {
 	
 	VoluntariDAO.deleteVoluntari(id);
 	return new ModelAndView("redirect:/listv.htm");
 }
 @RequestMapping(value = "editare-voluntari.htm", method = RequestMethod.GET)
    public ModelAndView showEditMedic(@RequestParam Integer id, Model model) throws SQLException{
    	Voluntari vl = VoluntariDAO.getVoluntariByID(id);
    	model.addAttribute("voluntariForm", vl);
    	return new ModelAndView("editv.jsp","model", model);
    }
 @RequestMapping(value = "editare-voluntari-save.htm", method = RequestMethod.POST)
    public ModelAndView editv(@ModelAttribute("voluntariForm") Voluntari vl, ModelMap model, BindingResult result)  {
    	
    		try {
				VoluntariDAO.updateVoluntari(vl);
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		return new ModelAndView("redirect:/listv.htm");
    	}
}
