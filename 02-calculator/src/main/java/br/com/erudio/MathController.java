package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		if(!IsNumeric(numberOne) || !IsNumeric(numberTwo )){
			throw new UnsuportedMathOperationException("Please set numeric value");
		}
		Double sum = ConvertDouble(numberOne) + ConvertDouble(numberTwo);
		return sum;	
	}

	private Double ConvertDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(IsNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean IsNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	
}
