package com.ibm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.client.CurrConvClient;
import com.ibm.client.GreetingClient;
import com.test.cloud.bean.ConversionFactor;
import com.test.cloud.bean.StatusBean;
import com.test.cloud.service.ConvertFactService;

@SpringBootApplication(scanBasePackageClasses= {com.test.cloud.service.ConvertFactService.class})
@Configuration
@EnableFeignClients
@EnableJpaRepositories("com.test.cloud.repo")
@EntityScan("com.test.cloud.bean")
@RestController
public class Spring2FeignClientApplication {

	 /*@Autowired
	    private GreetingClient greetingClient;*/
	/* @Autowired
	 private CurrConvClient currConvClient;*/
	 
	public static void main(String[] args) {
		SpringApplication.run(Spring2FeignClientApplication.class, args);
	}
	 @RequestMapping("/get-greeting")
    public String greeting(Model model) {
       // model.addAttribute("greeting", greetingClient.greeting());
        return "Welcome to greeting-view";
    } 
	
	 @Autowired(required=true)
	private ConvertFactService currConvClient;
 
	 

	/** addConvertFact method will add conversion detailsin database
	 * @param conversionFactor
	 * @return status
	 */
	@PostMapping("/api/addconvertfact")
	public StatusBean addConvertFact(ConversionFactor conversionFactor) {
		
		  
		StatusBean statusBean =new StatusBean();
		try {
			System.out.println("#################### "+conversionFactor.getContryCode());
			System.out.println("#################### "+conversionFactor.getConvertFact());
			currConvClient.addConversionFactor(conversionFactor);
			statusBean.setStatus("ok");
		 
		}catch (Exception e) {
			
			statusBean.setError( e.getMessage());		
			e.printStackTrace();
		}
		
		
		return statusBean;
	}

	/**editConvertFact will updated existing conversion details based on contry code
	 * @param conversionFactor
	 * @return
	 */
	@PutMapping("/api/updateconvertfact/{id}")
	public StatusBean editConvertFact( @RequestBody ConversionFactor conversionFactor,
			                        @PathVariable(name="id")Long id) {
		 
		StatusBean statusBean =new StatusBean();
		
			try {
				ConversionFactor conversionFactorl=currConvClient.getConversionfactById(id);
				System.out.println("getContryCode" + conversionFactorl.getContryCode());
				System.out.println("getId" + conversionFactorl.getId());
				System.out.println("getConvertFact" + conversionFactorl.getConvertFact());
				
				conversionFactorl.setContryCode(conversionFactor.getContryCode());
				conversionFactorl.setConvertFact(conversionFactor.getConvertFact());
				conversionFactorl.setId(conversionFactor.getId());
				
				System.out.println("conversionFactor.getContryCode" + conversionFactor.getContryCode());
				System.out.println("conversionFactor.getId" + conversionFactor.getId());
				System.out.println("conversionFactor.getConvertFact" + conversionFactor.getConvertFact());
				
				if(conversionFactorl!=null) {
					currConvClient.updateConversionFactor(conversionFactorl);
				statusBean.setStatus("ok");
				}else {
					statusBean.setError("object is null ");
				}
			}catch (Exception e) {
				
				statusBean.setError( e.getMessage());	
				
			}
			
			return statusBean;
	}
	
	
	/**getContryCode function will retrun conversion details based on contry code
	 * @param mapBody
	 * @return
	 */
	@PostMapping("/api/getbycontrycode")
	public List<ConversionFactor>  getContryCode( @RequestBody Map<String, String> mapBody) {
		 
		 String strcountryCode=mapBody.get("countryCode");
		 System.out.println("strcountryCode --> "+strcountryCode);
		 
				List<ConversionFactor> currList=currConvClient.getbycontrycode(strcountryCode);
				
			return currList;
	}

	/** getConvertAmount this function will convert amount 
	 * @param mapBody
	 * @return
	 */
	@PostMapping("/api/getConvertAmount")
	public StatusBean  getConvertAmount( @RequestBody Map<String, String> mapBody) {
		 
		StatusBean statusBean =new StatusBean();
		 String strcountryCode=mapBody.get("countryCode");
		 double  dblAmount= Double.parseDouble(mapBody.get("amount"));
		 System.out.println("strcountryCode --> "+strcountryCode);
		 
		 
		 List<ConversionFactor> currLis=currConvClient.getbycontrycode(strcountryCode);
		 
		 for(ConversionFactor confact:currLis) {
			 statusBean.setAmount( confact.getConvertFact()*dblAmount);
		 }
		 
		 
		 System.out.println("Converted Amount is  --> "+statusBean.getAmount());
			return statusBean;
	}
	
	/**getConversionFactor funcation will return list of available conversion details
	 * @return
	 */
	@GetMapping("/api/getconvertfactlist")
	public List<ConversionFactor>  getConversionFactor() {
			return currConvClient.getConversionFactorList();
	}
	public void setCurrConvClient(ConvertFactService currConvClient) {
		this.currConvClient = currConvClient;
	}
	
	
}

