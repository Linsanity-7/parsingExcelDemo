package com.example.excel.demo.entity;

import java.io.Serializable;

/**
 * @apiNote 产品信息Excel记录对象
 * @author 林尚华
 */
public class ProductInformationExcelEntity implements Serializable {
    /**
     * 交易日期
     */
    private String transactionDate;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品编码
     */
    private String productNo;
    /**
     * 单位净值
     */
    private String natValueOfUnit;
    /**
     * 累计净值
     */
    private String accumulatedNetValue;
    /**
     * 基金经理
     */
    private String fundManager;
    /**
     * 参赛机构
     */
    private String companyName;
    /**
     * 产品规模
     */
    private String productSize;
    /**
     * 净值所属周数
     */
    private String netBelongsToWeeks;

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getNatValueOfUnit() {
        return natValueOfUnit;
    }

    public void setNatValueOfUnit(String natValueOfUnit) {
        this.natValueOfUnit = natValueOfUnit;
    }

    public String getAccumulatedNetValue() {
        return accumulatedNetValue;
    }

    public void setAccumulatedNetValue(String accumulatedNetValue) {
        this.accumulatedNetValue = accumulatedNetValue;
    }

    public String getFundManager() {
        return fundManager;
    }

    public void setFundManager(String fundManager) {
        this.fundManager = fundManager;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getNetBelongsToWeeks() {
        return netBelongsToWeeks;
    }

    public void setNetBelongsToWeeks(String netBelongsToWeeks) {
        this.netBelongsToWeeks = netBelongsToWeeks;
    }

    @Override
    public String toString() {
        return "ProductInformationExcelEntity{" +
                "transactionDate='" + transactionDate + '\'' +
                ", productName='" + productName + '\'' +
                ", productNo='" + productNo + '\'' +
                ", natValueOfUnit='" + natValueOfUnit + '\'' +
                ", accumulatedNetValue='" + accumulatedNetValue + '\'' +
                ", fundManager='" + fundManager + '\'' +
                ", companyName='" + companyName + '\'' +
                ", productSize='" + productSize + '\'' +
                ", netBelongsToWeeks='" + netBelongsToWeeks + '\'' +
                '}';
    }
}
