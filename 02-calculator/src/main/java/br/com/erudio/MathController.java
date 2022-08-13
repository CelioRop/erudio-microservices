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
	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		if(!IsNumeric(numberOne) || !IsNumeric(numberTwo )){
			throw new UnsuportedMathOperationException("Please set numeric value");
		}
		Double sum = ConvertDouble(numberOne) - ConvertDouble(numberTwo);
		return sum;	
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		if(!IsNumeric(numberOne) || !IsNumeric(numberTwo )){
			throw new UnsuportedMathOperationException("Please set numeric value");
		}
		Double sum = ConvertDouble(numberOne) / ConvertDouble(numberTwo);
		return sum;	
	}
	
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		if(!IsNumeric(numberOne) || !IsNumeric(numberTwo )){
			throw new UnsuportedMathOperationException("Please set numeric value");
		}
		Double sum = ConvertDouble(numberOne) * ConvertDouble(numberTwo);
		return sum;	
	}
	
	@RequestMapping(value="/med/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double med (@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		if(!IsNumeric(numberOne) || !IsNumeric(numberTwo )){
			throw new UnsuportedMathOperationException("Please set numeric value");
		}
		Double sum = (ConvertDouble(numberOne) + ConvertDouble(numberTwo))/2;
		return sum;	
	}

	@RequestMapping(value="/squa/{numberOne}", method=RequestMethod.GET)
	public Double squa (@PathVariable("numberOne") String numberOne ) throws Exception {
		if(!IsNumeric(numberOne)){
			throw new UnsuportedMathOperationException("Please set numeric value");
		}
		Double sum = (Double)Math.sqrt(ConvertDouble(numberOne));
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
