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

import ro.emanuel.adapost.dao.CainiDAO;
import ro.emanuel.adapost.pojo.Caini;


@Controller
public class CainiController {

	@RequestMapping(value = "/listCaini.htm", method = RequestMethod.GET)
	public ModelAndView listCaini() throws SQLException {
		ModelMap model = new ModelMap();
		ArrayList<Caini> caini = CainiDAO.getCaini();
		model.put("caini", caini);
		return new ModelAndView("/listCaini.jsp", model);
	}
	
	 @RequestMapping(value = "/detaliiCaini.htm", method = RequestMethod.GET)
	    public ModelAndView detailsCaini(@RequestParam Integer id) throws SQLException {
	    	ModelMap model = new ModelMap();
	    	Caini cn = CainiDAO.getCainiByID(id);
	    	model.put("caini", cn);
	    	return new ModelAndView("/detaliiCaini.jsp", model);
	 }

	 @RequestMapping(value = "/adaugare-caini.htm", method = RequestMethod.GET)
	    public ModelAndView showAddMedic(Model model)  {
		 Caini cn = new Caini ();
	    	model.addAttribute("cainiForm", cn);
	    	return new ModelAndView("addCaini.jsp","model", model);
	    }
	 @RequestMapping(value = "/adaugare-caini-save.htm", method = RequestMethod.POST)
	    public ModelAndView addMedic(@ModelAttribute("cainiForm") Caini cn, ModelMap model, BindingResult result)  {
	    	
	    		try {
					CainiDAO.createCaini(cn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		return new ModelAndView("redirect:/listCaini.htm");
	    	}
	 
	 @RequestMapping(value = "/deleteCaini.htm", method = RequestMethod.GET)
	 public ModelAndView deleteCaini(@RequestParam Integer id) throws SQLException {
	 	
	 	CainiDAO.deleteCaini(id);
	 	return new ModelAndView("redirect:/listCaini.htm");
	 }
	 
	 @RequestMapping(value = "/editare-caini.htm", method = RequestMethod.GET)
	 public ModelAndView showEditCaini(@RequestParam Integer id, Model model) throws SQLException  {
	 	Caini cn = CainiDAO.getCainiByID(id);
	 	model.addAttribute("cainiForm", cn);
	 	
	 	return new ModelAndView("/editCaini.jsp","model", model);
	 }
	 @RequestMapping(value = "/editare-caini-save.htm", method = RequestMethod.POST)
	 public ModelAndView editCaini(@ModelAttribute("cainiForm") Caini cn, ModelMap model, BindingResult result)  {
	 	
	 		try {
	 			CainiDAO.updateCaini(cn);
	 		} catch (SQLException e) {
	 			e.printStackTrace();
	 		}
	 		return new ModelAndView("redirect:/listCaini.htm");
	 	}
}
