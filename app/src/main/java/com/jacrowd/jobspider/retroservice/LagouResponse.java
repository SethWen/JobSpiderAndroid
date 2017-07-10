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
     * data : [{"salary":"20k-40k","companySize":"150-500人","companyLogo":"i/image/M00/03/49/CgqKkVazANeAThRmAANQEn9hK_A156.png","positionName":"Python","district":"海淀区","keyWord":"python","financeStage":"成熟型(C轮)","businessZones":"清河","createTime":"2017-07-10 11:28:24","positionId":"2182008","workYear":"不限","education":"本科","companyFullName":"北京春雨天下软件有限公司","id":1205},{"salary":"18k-25k","companySize":"50-150人","companyLogo":"image1/M00/40/49/CgYXBlXDFBSAKntJAABFLOpgtGw274.jpg","positionName":"Python开发","district":"海淀区","keyWord":"python","financeStage":"成长型(B轮)","businessZones":"八里庄,定慧寺,五棵松","createTime":"2017-07-10 10:45:23","positionId":"2765210","workYear":"3-5年","education":"本科","companyFullName":"北京云途腾科技有限责任公司","id":1206},{"salary":"12k-18k","companySize":"15-50人","companyLogo":"i/image/M00/35/E2/CgpEMlk-ZxuAUlUgAACEHyBsv3Q938.jpg","positionName":"Python","district":"海淀区","keyWord":"python","financeStage":"初创型(天使轮)","businessZones":"苏州街","createTime":"2017-07-10 08:39:33","positionId":"3203157","workYear":"1-3年","education":"本科","companyFullName":"北京爱普安信息技术有限公司","id":1207},{"salary":"15k-20k","companySize":"2000人以上","companyLogo":"i/image/M00/00/96/Cgp3O1ZOk2WAF-VNAABfjim7IyU208.jpg","positionName":"Python开发工程师","district":"海淀区","keyWord":"python","financeStage":"上市公司","businessZones":"西二旗","createTime":"2017-07-10 16:26:02","positionId":"3001213","workYear":"3-5年","education":"本科","companyFullName":"北京天融信网络安全","id":1208},{"salary":"15k-25k","companySize":"150-500人","companyLogo":"i/image/M00/12/D1/CgpFT1j1xeCAdtxYAAKhS0QI9IA237.jpg","positionName":"Python工程师","district":"朝阳区","keyWord":"python","financeStage":"成长型(B轮)","businessZones":"NULL","createTime":"2017-07-10 09:16:47","positionId":"3233928","workYear":"3-5年","education":"大专","companyFullName":"江苏曲速教育科技有限公司","id":1209}]
     */

    private String msg;
    private int code;
    /**
     * salary : 20k-40k
     * companySize : 150-500人
     * companyLogo : i/image/M00/03/49/CgqKkVazANeAThRmAANQEn9hK_A156.png
     * positionName : Python
     * district : 海淀区
     * keyWord : python
     * financeStage : 成熟型(C轮)
     * businessZones : 清河
     * createTime : 2017-07-10 11:28:24
     * positionId : 2182008
     * workYear : 不限
     * education : 本科
     * companyFullName : 北京春雨天下软件有限公司
     * id : 1205
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
        private String companyLogo;
        private String positionName;
        private String district;
        private String keyWord;
        private String financeStage;
        private String businessZones;
        private String createTime;
        private String positionId;
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

        public String getCompanyLogo() {
            return companyLogo;
        }

        public void setCompanyLogo(String companyLogo) {
            this.companyLogo = companyLogo;
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

        public String getPositionId() {
            return positionId;
        }

        public void setPositionId(String positionId) {
            this.positionId = positionId;
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
