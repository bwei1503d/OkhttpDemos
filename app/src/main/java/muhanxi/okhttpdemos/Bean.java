package muhanxi.okhttpdemos;

import java.util.List;

/**
 * Created by muhanxi on 17/11/10.
 */

public class Bean {


    /**
     * ret_code : 200
     * ret_msg : ok
     * list : [{"date":"111","id":1,"pic":"http://p1.pstatp.com/large/22c90001cf8b5388ce33","title":" \n他\u201c秘书圈\u201d的人数规模，赶上了周永康","type":1},{"date":"2222","id":2,"pic":"http://p3.pstatp.com/list/190x124/1c19000062675e53b27e|http://p3.pstatp.com/list/190x124/1aa4000a2b8a788b321f|http://p3.pstatp.com/list/190x124/2a3f0000d9a4a6ac884d|http://p1.pstatp.com/list/190x124/2a3c000520bf9b36fdf0","title":"北京的你再忙也要加一下这个投资微信！不然后悔！","type":4},{"date":"333","id":3,"pic":"http://p1.pstatp.com/list/190x124/e580016ab3624f1ed33","title":"家里的一分硬币现在值多少钱？\n家里的一分硬币现在值多少钱？\n家里的一分硬币现在值多少钱？\n家里的一分硬币现在值多少钱？\n家里的一分硬币现在值多少钱","type":1},{"date":"444","id":4,"pic":"http://p1.pstatp.com/origin/26ec0004cc0249b49e7c","title":"世界上\u201c最恐怖\u201d的景点大盘点，中国竟然排在第一！","type":1},{"date":"5555","id":5,"pic":"http://p3.pstatp.com/list/190x124/26ed0005636b714a9f61|http://p1.pstatp.com/list/190x124/26ee000375da57f8b8b1|http://p3.pstatp.com/list/190x124/26ef0000545531df0dfa|http://p3.pstatp.com/list/190x124/26ef00005463b7a8f958","title":" \n袁世凯临终前，在传位名单上写下三个人的名字，众人看了敬佩不已","type":4},{"date":"6666","id":6,"pic":"http://p3.pstatp.com/list/190x124/216d001357929b02f476","title":" \n张爱朋首回应白百何绯闻事件，短短二句话，白百何后悔看错了吧！","type":1},{"date":"8888","id":8,"pic":"http://p1.pstatp.com/list/190x124/191a00048757f6714455","title":"中国又开工这一重大工程：连美国都造不出来 周边国家沉默不语","type":1},{"date":"99","id":9,"pic":"http://p3.pstatp.com/list/190x124/22c700036549c9b5ff07","title":"中国第一黑老大东北王乔四爷 最终也逃不过法网恢恢","type":1},{"date":"111","id":10,"pic":"http://p3.pstatp.com/list/190x124/22c6000628d79850e6d7","title":"号称中国关系最硬的人，奶奶是慈禧，大伯是光绪，哥哥是宣统！","type":1},{"date":"222","id":11,"pic":"http://p3.pstatp.com/list/190x124/22ca00011911b0a8061c","title":" \n\u201c二婚女和剩女，我该娶哪个啊？求救！\u201d","type":1},{"date":"333","id":12,"pic":"http://p3.pstatp.com/list/190x124/26ed0005636b714a9f61|http://p1.pstatp.com/list/190x124/26ee000375da57f8b8b1|http://p3.pstatp.com/list/190x124/26ef0000545531df0dfa|http://p3.pstatp.com/list/190x124/26ef00005463b7a8f958","title":"童星长大以后对比照，有人大红大紫，有人却流落街头","type":4},{"date":"2","id":18,"pic":"http://e.hiphotos.baidu.com/image/pic/item/bd315c6034a85edf392d2be340540923dc547549.jpg","title":"永创佳乐 专业蔬菜大棚/花卉大棚","type":1},{"date":"3","id":19,"pic":"http://c.hiphotos.baidu.com/image/pic/item/d000baa1cd11728ba5e562e2c1fcc3cec2fd2c22.jpg","title":"永创佳乐 专业蔬菜大棚/花卉大棚","type":1},{"date":"4","id":20,"pic":"http://e.hiphotos.baidu.com/image/pic/item/94cad1c8a786c91773f6c1f9c03d70cf3ac7577c.jpg","title":"永创佳乐 专业蔬菜大棚/花卉大棚","type":1},{"date":"5","id":21,"pic":"http://b.hiphotos.baidu.com/image/pic/item/32fa828ba61ea8d39c5a09c49e0a304e241f58f1.jpg","title":"中国又开工这一重大工程：连美国都造不出来 周边国家沉默不语","type":1},{"date":"6","id":22,"pic":"http://a.hiphotos.baidu.com/image/pic/item/359b033b5bb5c9ea1dc17023dc39b6003af3b33b.jpg","title":"中国又开工这一重大工程：连美国都造不出来 周边国家沉默不语","type":1},{"date":"7","id":23,"pic":"http://d.hiphotos.baidu.com/image/pic/item/38dbb6fd5266d0169a58eae99e2bd40734fa35a9.jpg","title":"中国又开工这一重大工程：连美国都造不出来 周边国家沉默不语","type":1},{"date":"8","id":24,"pic":"http://h.hiphotos.baidu.com/image/pic/item/5bafa40f4bfbfbed34f348bf71f0f736aec31f43.jpg","title":"中国又开工这一重大工程：连美国都造不出来 周边国家沉默不语","type":1},{"date":"9","id":25,"pic":"http://imgsrc.baidu.com/imgad/pic/item/9e3df8dcd100baa1706f8e964c10b912c8fc2e58.jpg","title":"中国又开工这一重大工程：连美国都造不出来 周边国家沉默不语","type":1}]
     */

    private int ret_code;
    private String ret_msg;
    private List<ListBean> list;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * date : 111
         * id : 1
         * pic : http://p1.pstatp.com/large/22c90001cf8b5388ce33
         * title :
         他“秘书圈”的人数规模，赶上了周永康
         * type : 1
         */

        private String date;
        private int id;
        private String pic;
        private String title;
        private int type;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
