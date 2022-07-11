package com.flooringMastery;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class Order {
	
	private String Date;
	private int OrderNumber;
	private String CustomerName;
	private String State;
	private BigDecimal TaxRate ;
	private String ProductType;
	private BigDecimal Area;
	private BigDecimal CostPerSquareFoot ;
	private BigDecimal LaborCostPerSquareFoot;
	private BigDecimal MaterialCost;
	private BigDecimal LaborCost;
	private BigDecimal Tax;
	private BigDecimal Total;
	
	public Order(){};
	
	public Order(String date, int orderNumber, String customerName, String state, BigDecimal taxRate,
			String productType, BigDecimal area, BigDecimal costPerSquareFoot, BigDecimal laborCostPerSquareFoot,
			BigDecimal materialCost, BigDecimal laborCost, BigDecimal tax, BigDecimal total) {
		super();
		Date = date;
		OrderNumber = orderNumber;
		CustomerName = customerName;
		State = state;
		TaxRate = taxRate;
		ProductType = productType;
		Area = area;
		CostPerSquareFoot = costPerSquareFoot;
		LaborCostPerSquareFoot = laborCostPerSquareFoot;
		MaterialCost = materialCost;
		LaborCost = laborCost;
		Tax = tax;
		Total = total;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Area, CostPerSquareFoot, CustomerName, Date, LaborCost, LaborCostPerSquareFoot,
				MaterialCost, OrderNumber, ProductType, State, Tax, TaxRate, Total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(Area, other.Area) && Objects.equals(CostPerSquareFoot, other.CostPerSquareFoot)
				&& Objects.equals(CustomerName, other.CustomerName) && Objects.equals(Date, other.Date)
				&& Objects.equals(LaborCost, other.LaborCost)
				&& Objects.equals(LaborCostPerSquareFoot, other.LaborCostPerSquareFoot)
				&& Objects.equals(MaterialCost, other.MaterialCost) && OrderNumber == other.OrderNumber
				&& Objects.equals(ProductType, other.ProductType) && Objects.equals(State, other.State)
				&& Objects.equals(Tax, other.Tax) && Objects.equals(TaxRate, other.TaxRate)
				&& Objects.equals(Total, other.Total);
	}

	@Override
	public String toString() {
		return "Order [Date=" + Date + ", OrderNumber=" + OrderNumber + ", CustomerName=" + CustomerName + ", State="
				+ State + ", TaxRate=" + TaxRate + ", ProductType=" + ProductType + ", Area=" + Area
				+ ", CostPerSquareFoot=" + CostPerSquareFoot + ", LaborCostPerSquareFoot=" + LaborCostPerSquareFoot
				+ ", MaterialCost=" + MaterialCost + ", LaborCost=" + LaborCost + ", Tax=" + Tax + ", Total=" + Total
				+ "]";
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public int getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		OrderNumber = orderNumber;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public BigDecimal getTaxRate() {
		return TaxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		TaxRate = taxRate;
	}

	public String getProductType() {
		return ProductType;
	}

	public void setProductType(String productType) {
		ProductType = productType;
	}

	public BigDecimal getArea() {
		return Area;
	}

	public void setArea(BigDecimal area) {
		Area = area;
	}

	public BigDecimal getCostPerSquareFoot() {
		return CostPerSquareFoot;
	}

	public void setCostPerSquareFoot(BigDecimal costPerSquareFoot) {
		CostPerSquareFoot = costPerSquareFoot;
	}

	public BigDecimal getLaborCostPerSquareFoot() {
		return LaborCostPerSquareFoot;
	}

	public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
		LaborCostPerSquareFoot = laborCostPerSquareFoot;
	}

	public BigDecimal getMaterialCost() {
		return MaterialCost;
	}

	public void setMaterialCost(BigDecimal materialCost) {
		MaterialCost = materialCost;
	}

	public BigDecimal getLaborCost() {
		return LaborCost;
	}

	public void setLaborCost(BigDecimal laborCost) {
		LaborCost = laborCost;
	}

	public BigDecimal getTax() {
		return Tax;
	}

	public void setTax(BigDecimal tax) {
		Tax = tax;
	}

	public BigDecimal getTotal() {
		return Total;
	}

	public void setTotal(BigDecimal total) {
		Total = total;
	}

}
	

	
	