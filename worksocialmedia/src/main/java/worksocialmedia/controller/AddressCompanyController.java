package worksocialmedia.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import worksocialmedia.exception.AddressCompanyNotFoundException;
import worksocialmedia.model.AddressCompany;
import worksocialmedia.repository.AddressCompanyRepository;
import worksocialmedia.repository.AddressCompanyRepositoryImpl;

@Controller
public class AddressCompanyController {
	private AddressCompanyRepository addressCompanyRepository;

	public AddressCompanyController() {
		this.addressCompanyRepository = new AddressCompanyRepositoryImpl();
	}

	@GetMapping("/caddresses")
	public ModelAndView companies() {
		ModelAndView modelAndView = new ModelAndView();

		Iterable<AddressCompany> addressesCompany = addressCompanyRepository.findAll();

		modelAndView.addObject("caddresses", addressesCompany);
		modelAndView.setViewName("caddresses");

		return modelAndView;
	}

	@GetMapping("/caddresses/{id}")
	public ModelAndView user(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();

		Optional<AddressCompany> addressCompany = addressCompanyRepository.findById(id);
		addressCompany.orElseThrow(AddressCompanyNotFoundException::new);

		modelAndView.addObject("caddress", addressCompany.get());
		modelAndView.setViewName("caddress");

		return modelAndView;
	}

	@GetMapping("deletecaddress{id}")
	public String userAddressDelete(@PathVariable("id") Long id) {

		addressCompanyRepository.deleteCompanyAddressById(id);

		return "redirect:http://localhost:8080/caddresses";

	}

	@PostMapping("addcaddress")
	public String companyAddressAdd(@RequestParam(value = "addStreet") String street,
			@RequestParam(value = "addMunicipality") String municipality,
			@RequestParam(value = "addCivicNumber") String civicNumber,
			@RequestParam(value = "addPostalCode") String postalCode,
			@RequestParam(value = "addNation") String nation) {

		AddressCompany addressCompany = new AddressCompany(street, municipality, civicNumber, postalCode, nation);

		addressCompanyRepository.addCompanyAddress(addressCompany);

		return "redirect:caddresses";
	}

	@PostMapping("caddresses/updatecaddress{id}")
	public String userUpdate(@PathVariable("id") Long id, @RequestParam(value = "updateStreet") String street,
			@RequestParam(value = "updateMunicipality") String municipality,
			@RequestParam(value = "updateCivicNumber") String civicNumber,
			@RequestParam(value = "updatePostalCode") String postalCode,
			@RequestParam(value = "updateNation") String nation) {

		addressCompanyRepository.updateCompanyAddress(id, street, municipality, civicNumber, postalCode, nation);

		return "redirect:http://localhost:8080/caddresses";
	}

	@PostMapping("searchcaddress")
	public ModelAndView userAddressSearch(@RequestParam("jobSearchNameStreet") String jobSearchNameStreet) {

		ModelAndView modelAndView = new ModelAndView();

		AddressCompany addressCompany = addressCompanyRepository.searchCompanyAddress(jobSearchNameStreet);

		if (addressCompany == null)
			throw new AddressCompanyNotFoundException();

		modelAndView.addObject("caddress", addressCompany);
		modelAndView.setViewName("caddress");

		return modelAndView;
	}

}
