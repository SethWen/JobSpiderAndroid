package com.jacrowd.jobspider.retroservice;

import java.util.List;

/**
 * author: Shawn
 * time  : 2017/7/9 12:12
 * desc  :
 */
public class LagouResponse {

    /**
     * msg : success
     * code : 20200
     * data : [{"salary":"15k-30k","companySize":"15-50人","positionName":"Python工程师","district":"海淀区","keyWord":"python","financeStage":"成长型(A轮)","businessZones":"上地,西二旗,马连洼","createTime":"2017-07-07 09:13:54","workYear":"3-5年","education":"本科","companyFullName":"北京爱咔咔信息技术有限公司","id":20},{"salary":"15K-30K","companySize":"150-500人","positionName":"python研发工程师","district":"海淀区","keyWord":"python","financeStage":"成长型(B轮)","businessZones":"中关村","createTime":"2017-07-08 09:32:47","workYear":"不限","education":"不限","companyFullName":"成都数联铭品科技有限公司","id":21},{"salary":"15k-30k","companySize":"150-500人","positionName":"Python开发工程师","district":"海淀区","keyWord":"python","financeStage":"成长型(不需要融资)","businessZones":"五道口,清华大学,中关村","createTime":"2017-07-07 10:00:52","workYear":"1-3年","education":"本科","companyFullName":"北京汉迪世纪科技有限公司","id":22},{"salary":"20k-30k","companySize":"50-150人","positionName":"Python","district":"朝阳区","keyWord":"python","financeStage":"成长型(A轮)","businessZones":"NULL","createTime":"2017-07-07 10:22:11","workYear":"1-3年","education":"本科","companyFullName":"北京云英传奇技术有限公司","id":23},{"salary":"15k-30k","companySize":"150-500人","positionName":"Python","district":"朝阳区","keyWord":"python","financeStage":"成长型(B轮)","businessZones":"亮马桥,三元桥,燕莎","createTime":"2017-07-07 09:52:55","workYear":"1-3年","education":"本科","companyFullName":"北京十月逸栈科技有限公司","id":24}]
     */

    private String msg;
    private int code;
    /**
     * salary : 15k-30k
     * companySize : 15-50人
     * positionName : Python工程师
     * district : 海淀区
     * keyWord : python
     * financeStage : 成长型(A轮)
     * businessZones : 上地,西二旗,马连洼
     * createTime : 2017-07-07 09:13:54
     * workYear : 3-5年
     * education : 本科
     * companyFullName : 北京爱咔咔信息技术有限公司
     * id : 20
     */

    private List<DataEntity> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private String salary;
        private String companySize;
        private String positionName;
        private String district;
        private String keyWord;
        private String financeStage;
        private String businessZones;
        private String createTime;
        private String workYear;
        private String education;
        private String companyFullName;
        private int id;

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getCompanySize() {
            return companySize;
        }

        public void setCompanySize(String companySize) {
            this.companySize = companySize;
        }

        public String getPositionName() {
            return positionName;
        }

        public void setPositionName(String positionName) {
            this.positionName = positionName;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getKeyWord() {
            return keyWord;
        }

        public void setKeyWord(String keyWord) {
            this.keyWord = keyWord;
        }

        public String getFinanceStage() {
            return financeStage;
        }

        public void setFinanceStage(String financeStage) {
            this.financeStage = financeStage;
        }

        public String getBusinessZones() {
            return businessZones;
        }

        public void setBusinessZones(String businessZones) {
            this.businessZones = businessZones;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getWorkYear() {
            return workYear;
        }

        public void setWorkYear(String workYear) {
            this.workYear = workYear;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getCompanyFullName() {
            return companyFullName;
        }

        public void setCompanyFullName(String companyFullName) {
            this.companyFullName = companyFullName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
