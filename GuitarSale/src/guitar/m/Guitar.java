package guitar.m;

public class Guitar {

		  //¼ªËûÊôÐÔ
	     private String serialNumber;
	     private String price;
         private String builder;
	     private String type;
	     private String backwood;
	     private String topwood;       
	      
	      //set get Method
		  public String getSerialNumber() {
		    return serialNumber;
		  }
		  public void setSerialNumber(String serialNumber) {
			   this.serialNumber=serialNumber;
			  }
		  public String getPrice() {
		    return price;
		  }
		  public void setPrice(String price) {
		    this.price = price;
		  }
		  public String getBuilder() {
		    return builder;
		  }
		  public void setBuilder(String builder) {
				this.builder = builder;
		  }
		
		  public String getType() {
		    return type;
		  }
		  public void setType(String type) {
				this.type = type;
	      }
		  public String getBackWood() {
		    return backwood;
		  }
		  public void setBackwood(String backwood){
			  this.backwood=backwood;
		  }
		  public String getTopWood() {
		    return topwood;
		  }
		  public void setTopwood(String topwood){
			  this.topwood=topwood;
		  }
		
		}


