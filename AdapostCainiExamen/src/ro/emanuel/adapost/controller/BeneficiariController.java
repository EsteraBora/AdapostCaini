package ro.emanuel.adapost.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.adapost.dao.BeneficiariDAO;
import ro.emanuel.adapost.dao.CainiDAO;
import ro.emanuel.adapost.pojo.Beneficiari;
import ro.emanuel.adapost.pojo.Caini;



@Controller
public class BeneficiariController {

    @RequestMapping(value = "listb.htm", method = RequestMethod.GET)
    public ModelAndView listBenrficiari() throws SQLException {
        ModelMap model = new ModelMap();

        ArrayList<Beneficiari> beneficiari = BeneficiariDAO.getBeneficiari();
        model.put("beneficiari", beneficiari);
        
        ArrayList<Caini> caini=CainiDAO.getCaini();
    	HashMap<Integer, String> cainiMap=new HashMap<Integer, String>();
    	for(Caini c:caini) {
    		cainiMap.put(c.getId(), c.getNume());}
    	model.put("caini", cainiMap);
    
        return new ModelAndView("listb.jsp", model);
    }
    
    @RequestMapping(value = "detaliib.htm", method = RequestMethod.GET)
    public ModelAndView detailsBeneficiari(@RequestParam Integer id) throws SQLException {
    	ModelMap model = new ModelMap();
    	
    	Beneficiari bn = BeneficiariDAO.getBeneficiariByID(id);
    	model.put("beneficiari", bn);
    	
    	ArrayList<Caini> caini=CainiDAO.getCaini();
    	for(Caini c:caini) {
    		if(c.getId()==bn.getCaineID()) {
    			model.put("numeCaini", c.getNume());
    		}
    	}
    	return new ModelAndView("detaliib.jsp", model);
    }
    @RequestMapping(value = "adaugare-beneficiari.htm", method = RequestMethod.GET)
    public ModelAndView showAddBeneficiari(Model model) throws SQLException{
    	Beneficiari bn = new Beneficiari();
    	model.addAttribute("beneficiariForm", bn);
    	
    	ArrayList<Caini> caini = CainiDAO.getCaini();
    	model.addAttribute("caini", caini);
    	
    	return new ModelAndView("addb.jsp","model", model);

    }
    
    @RequestMapping(value = "adaugare-beneficiari-save.htm", method = RequestMethod.POST)
    public ModelAndView addBeneficiari(@ModelAttribute("beneficiariForm") Beneficiari bn, ModelMap model, BindingResult result) throws SQLException  {
    	
    		try {
				BeneficiariDAO.createBeneficiari(bn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		return new ModelAndView("redirect:/listb.htm");
    	}
    
@RequestMapping(value = "deleteb.htm", method = RequestMethod.GET)
public ModelAndView deleteBeneficiari(@RequestParam Integer id) throws SQLException {
	
	BeneficiariDAO.deleteBeneficiari(id);
	return new ModelAndView("redirect:/listb.htm");
}
@RequestMapping(value = "editare-beneficiari.htm", method = RequestMethod.GET)
public ModelAndView showEditBeneficiari(@RequestParam Integer id, Model model) throws SQLException  {
	Beneficiari bn = BeneficiariDAO.getBeneficiariByID(id);
	model.addAttribute("beneficiariForm", bn);
	
	return new ModelAndView("editb.jsp","model", model);
}
@RequestMapping(value = "editare-beneficiari-save.htm", method = RequestMethod.POST)
public ModelAndView editBeneficiari(@ModelAttribute("beneficiariForm") Beneficiari bn, ModelMap model, BindingResult result)  {
	
		try {
			BeneficiariDAO.updateBeneficiari(bn);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/listb.htm");
	}

}
