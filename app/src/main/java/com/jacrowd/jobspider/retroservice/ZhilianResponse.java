package com.jacrowd.jobspider.retroservice;

import java.util.List;

/**
 * author: Shawn
 * time  : 2017/7/9 16:40
 * desc  :
 */
public class ZhilianResponse {

    /**
     * msg : success
     * code : 20200
     * data : [{"salary":"22000-30000","pubDate":"前天","keyWord":"python","company":"北京融联世纪信息技术有限公司","detailHref":"http://company.zhaopin.com/CC655671825.htm","address":"北京","position":"python开发工程师","id":1190},{"salary":"8001-10000","pubDate":"前天","keyWord":"python","company":"美因健康科技(北京)有限公司","detailHref":"http://company.zhaopin.com/CC345436682.htm","address":"北京","position":"Python开发工程师","id":1191},{"salary":"10001-15000","pubDate":"前天","keyWord":"python","company":"北京企名片科技有限公司","detailHref":"http://company.zhaopin.com/CZ764708570.htm","address":"北京","position":"python爬虫工程师","id":1192},{"salary":"10001-15000","pubDate":"前天","keyWord":"python","company":"中电科技(北京)有限公司","detailHref":"http://special.zhaopin.com/pagepublish/27679811/index.html","address":"北京","position":"Python开发工程师","id":1193},{"salary":"15000-25000","pubDate":"前天","keyWord":"python","company":"网智天元科技集团股份有限公司","detailHref":"http://company.zhaopin.com/%E5%8C%97%E4%BA%AC%E7%BD%91%E6%99%BA%E5%A4%A9%E5%85%83%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8_CC267406113.htm","address":"北京-海淀区","position":"爬虫开发工程师（java/python）","id":1194},{"salary":"15001-20000","pubDate":"前天","keyWord":"python","company":"网智天元科技集团股份有限公司","detailHref":"http://company.zhaopin.com/%E5%8C%97%E4%BA%AC%E7%BD%91%E6%99%BA%E5%A4%A9%E5%85%83%E7%A7%91%E6%8A%80%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8_CC267406113.htm","address":"北京-西城区","position":"Python开发工程师/机器学习算法方向","id":1195}]
     */

    private String msg;
    private int code;
    /**
     * salary : 22000-30000
     * pubDate : 前天
     * keyWord : python
     * company : 北京融联世纪信息技术有限公司
     * detailHref : http://company.zhaopin.com/CC655671825.htm
     * address : 北京
     * position : python开发工程师
     * id : 1190
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
        private String pubDate;
        private String keyWord;
        private String company;
        private String detailHref;
        private String address;
        private String position;
        private int id;

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public String getKeyWord() {
            return keyWord;
        }

        public void setKeyWord(String keyWord) {
            this.keyWord = keyWord;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getDetailHref() {
            return detailHref;
        }

        public void setDetailHref(String detailHref) {
            this.detailHref = detailHref;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
